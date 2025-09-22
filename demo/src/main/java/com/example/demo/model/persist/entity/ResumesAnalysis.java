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
 * @TableName resumes_analysis
 */
@TableName(value ="resumes_analysis")
@Data
public class ResumesAnalysis implements Serializable {
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
    private String textAnalysis;

    /**
     * 记录创建时间
     */
    private Date createdAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}