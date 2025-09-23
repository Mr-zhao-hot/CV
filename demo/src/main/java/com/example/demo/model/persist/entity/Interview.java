package com.example.demo.model.persist.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 面试对话记录
 * @TableName interview
 */
@TableName(value ="interview")
@Data
public class Interview implements Serializable {
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
     * 用户输入的对话
     */
    private String userMessage;

    /**
     * 面试官的回复
     */
    private String interviewMessage;

    /**
     * 记录创建时间
     */
    private Date createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}