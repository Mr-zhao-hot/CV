package com.example.demo.exception;
import com.example.demo.result.ServiceCode;

import lombok.Getter;

/**
 * @author Mr_Zhao
 */
@Getter
public class BusinessException extends RuntimeException {
    private final ServiceCode serviceCode;
    private final String description;

    public BusinessException(ServiceCode serviceCode, String description) {
        super(description);
        this.serviceCode = serviceCode;
        this.description = description;
    }

}