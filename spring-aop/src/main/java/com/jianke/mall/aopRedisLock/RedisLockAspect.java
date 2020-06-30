package com.jianke.mall.aopRedisLock;

import com.jianke.mall.aopTransaction.AfterCommitAnnotationAspect;
import com.jianke.mall.aopTransaction.AfterCommitExecutor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
@Aspect
@Slf4j
public class RedisLockAspect {

    private final AfterCommitExecutor afterCommitExecutor;

    @Autowired
    public RedisLockAspect(AfterCommitExecutor afterCommitExecutor) {
        this.afterCommitExecutor = afterCommitExecutor;
    }

    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Before("@annotation(com.jianke.mall.aopRedisLock.RedisLock)")
    public void lock(JoinPoint jp) throws Exception{
        afterCommitExecutor.execute(() -> {
            try {
                log.info("start run PjpAfterCommitRunnable run... ");
            } catch (Throwable e) {
                log.error("Exception while invoking pjp.proceed()", e);
                throw new RuntimeException(e);
            }
        });

        Object[] args = jp.getArgs();
        String[] parameterNames = discoverer.getParameterNames(((MethodSignature) jp.getSignature()).getMethod());

        // 获取注解配置的锁key值
        Method method = getMethod(jp);
        RedisLock lock = method.getAnnotation(RedisLock.class);

        Object key = lock.key();
        if (parameterNames != null) {
            key = getRequest(lock.key(), parameterNames, args);
        }
        log.info("lockKey= " + key.toString());
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature signature = jp.getSignature();
        MethodSignature ms = (MethodSignature) signature;
        return jp.getTarget().getClass().getMethod(ms.getName(), ms.getParameterTypes());
    }

    /**
     * 通过spring Spel 获取参数
     *
     * @param key            定义的key值 以#开头 例如:#user
     * @param parameterNames 形参
     * @param values         形参值
     * @return
     */
    public Object getRequest(String key, String[] parameterNames, Object[] values) {

        //spel解析器
        ExpressionParser parser = new SpelExpressionParser();
        //spel上下文陪你
        EvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i], values[i]);
        }
        return parser.parseExpression(key).getValue(context);

    }
}
