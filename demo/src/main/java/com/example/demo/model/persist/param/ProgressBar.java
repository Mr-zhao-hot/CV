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
@NoArgsConstructor
@AllArgsConstructor
public class ProgressBar implements Serializable {
     /**
      * 总进度
      */
     private Long total;
     /**
      * 进度文本
      */
     private Long currentText;

     @Serial
     @TableField(exist = false)
     private static final long serialVersionUID = 1L;
}
