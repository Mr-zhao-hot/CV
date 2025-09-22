package com.example.demo.model.persist.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 
 * @author Administrator
 * @TableName resumes
 */
@TableName(value ="resumes")
@Data
public class Resumes implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private String originalFilename;

    /**
     * 
     */
    private String filePath;

    /**
     * 
     */
    private Long fileSize;

    /**
     * 
     */
    private String fileHash;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}