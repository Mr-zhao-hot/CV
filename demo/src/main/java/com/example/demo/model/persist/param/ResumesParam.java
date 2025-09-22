package com.example.demo.model.persist.param;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumesParam implements Serializable {
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
