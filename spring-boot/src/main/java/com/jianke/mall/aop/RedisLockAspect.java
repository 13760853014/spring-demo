package com.jianke.mall.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
@Aspect
public class RedisLockAspect {

    private LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    @Before("@annotation(redisLock)")
    public void lock(JoinPoint jp, RedisLock redisLock) throws Exception{
        Object[] args = jp.getArgs();
        String[] parameterNames = discoverer.getParameterNames(((MethodSignature) jp.getSignature()).getMethod());

        // 获取注解配置的锁key值
        Signature signature = jp.getSignature();
        Method method = jp.getTarget().getClass().getMethod(signature.getName(),((MethodSignature) signature).getParameterTypes());
        RedisLock lock = method.getAnnotation(RedisLock.class);

        Object key = lock.key();
        if (parameterNames != null) {
            key = getRequest(lock.key(), parameterNames, args);
        }
        System.out.println("lockKey=" + key.toString());
    }

    @After("@annotation(redisLock)")
    public void doAfter(JoinPoint jp, RedisLock redisLock) throws Exception{
        Object[] args = jp.getArgs();
        String[] parameterNames = discoverer.getParameterNames(((MethodSignature) jp.getSignature()).getMethod());

        // 获取注解配置的锁key值
        Signature signature = jp.getSignature();
        Method method = jp.getTarget().getClass().getMethod(signature.getName(),((MethodSignature) signature).getParameterTypes());
        RedisLock lock = method.getAnnotation(RedisLock.class);

        System.out.println("注解式拦截" + lock.key());

        Object key = lock.key();
        if (parameterNames != null) {
            key = getRequest(lock.key(), parameterNames, args);
        }
        System.out.println("lockKey=" + key.toString());
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
        //spel上下文配置
        EvaluationContext context = new StandardEvaluationContext();
        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i], values[i]);
        }
        return parser.parseExpression(key).getValue(context);
    }

    public static void main(String[] args) {

        
    }
}
