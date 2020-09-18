package com.xkcoding.docker.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import static com.baomidou.mybatisplus.annotation.FieldFill.INSERT;

/**
 * <p>
 * 用户实体类
 * </p>
 *
 * @package: com.xkcoding.orm.mybatis.entity
 * @description: 用户实体类
 * @author: yangkai.shen
 * @date: Created in 2018/11/8 10:58
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("message")
public class Message implements Serializable {
    private static final long serialVersionUID = -184234586851699943L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String userId;
    /**
     * 内容
     */
    private String content;

    /**
     * 状态，-1：逻辑删除，0：禁用，1：启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

}
