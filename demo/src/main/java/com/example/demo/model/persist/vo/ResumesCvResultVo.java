package com.example.demo.model.persist.vo;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ResumesCvResultVo implements Serializable {

    /**
     * 分析结果对话
     */
    private String text;

    /**
     * 总进度
     */
    private Long total;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}
