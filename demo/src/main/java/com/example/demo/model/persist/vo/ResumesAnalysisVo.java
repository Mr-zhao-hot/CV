package com.example.demo.model.persist.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumesAnalysisVo implements Serializable {

    private Long id;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
