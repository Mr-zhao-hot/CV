package com.example.demo.model.persist.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 简历解析结果
 * @author Administrator
 * @TableName resumescvresult
 */
@TableName(value ="resumescvresult")
@Data
public class Resumescvresult implements Serializable {
    /**
     * 简历记录唯一标识
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 关联的用户ID，对应users表的id字段
     */
    private Long userId;

    /**
     * 分析结果对话
     */
    private String text;

    /**
     * 记录创建时间
     */
    private Date createdAt;

    /**
     * 记录最后更新时间
     */
    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}