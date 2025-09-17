package com.example.demo.exception;


import com.example.demo.result.JsonOk;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandel {

    @ExceptionHandler
    public JsonOk exceptionHandler(BusinessException e) {
        return JsonOk.error(e.getMessage() , e.getServiceCode().getCode());
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body("请求参数错误: " + ex.getMessage());
    }

}
