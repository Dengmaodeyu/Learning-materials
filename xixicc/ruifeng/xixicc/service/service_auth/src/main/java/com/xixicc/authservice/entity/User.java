package com.xixicc.authservice.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author pcc
 * @since 2023-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("xixi_user")
@ApiModel(value = "用户实体类")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("用户id")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 用户密码
     */
    @ApiModelProperty("用户密码")
    private String password;

    /**
     * 微信ID
     */
    @ApiModelProperty("微信id")
    private String wxUnionid;

    /**
     * 别名
     */
    @ApiModelProperty("别名")
    private String nickname;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 头像
     */
    @ApiModelProperty("头像地址")
    private String active;

    /**
     * 用户类型
     */
    @ApiModelProperty("用户类型")
    private String utype;

    /**
     * 生日
     */
    @ApiModelProperty("生日日期")
    private LocalDate birthday;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String phone;

    /**
     * QQ号
     */
    @ApiModelProperty("QQ号")
    private String qq;

    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    @TableLogic
    private String status;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createBy;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updateBy;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
