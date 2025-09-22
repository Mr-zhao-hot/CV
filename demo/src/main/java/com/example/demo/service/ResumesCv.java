package com.example.demo.service;


import com.example.demo.model.persist.vo.ResumesCvResultVo;

public interface ResumesCv {

    // 将分析结果插入数据库
    void insert(Long id, String pdfText);

    ResumesCvResultVo getParseResult(Long id);
}
