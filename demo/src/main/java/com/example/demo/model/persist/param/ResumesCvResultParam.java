package com.example.demo.model.persist.param;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class ResumesCvResultParam  implements Serializable {

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

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
