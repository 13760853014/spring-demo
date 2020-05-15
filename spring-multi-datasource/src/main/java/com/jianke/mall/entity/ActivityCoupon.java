package com.jianke.mall.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 商城活动优惠券
 *
 * @author huhua
 * @since 2019/3/8
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("activity_coupon")
public class ActivityCoupon implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	private Long couponId;

	private String couponName;

	private Long couponValue;

	private Long minConsume;

	private Integer type;

	private Integer amount;

	private Date startDrawDate;

	private Date endDrawDate;

	private Byte relativeFlag;

	private Integer relativeDays;

	@TableField(fill = FieldFill.INSERT)
	private String createdBy;

	@TableField(fill = FieldFill.INSERT)
	private Date createdDate;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String lastModifiedBy;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date lastModifiedDate;

	@Version
	private Integer recordVersion;

	@TableLogic
	private Integer deleteFlag;

}
