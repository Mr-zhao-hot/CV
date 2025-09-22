package com.example.demo.model.persist.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgressBar implements Serializable {
     private Long total;
     private Long currentText;
}
