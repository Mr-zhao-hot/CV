package com.example.demo.service.impl;


import com.example.demo.mapper.ResumescvresultMapper;
import com.example.demo.model.persist.entity.Resumescvresult;
import com.example.demo.model.persist.param.ResumesCvResultParam;
import com.example.demo.model.persist.vo.ResumesCvResultVo;
import com.example.demo.service.ResumesCv;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ResmesCvImpl implements ResumesCv {

    @Resource
    private ResumescvresultMapper resumescvresultMapper;

    @Override
    public void insert(Long id, String pdfText) {
        Resumescvresult resumescvresult = new Resumescvresult();
        ResumesCvResultParam resumesCvResultParam = new ResumesCvResultParam();
        resumesCvResultParam.setText(pdfText);
        resumesCvResultParam.setUserId(id);
        BeanUtils.copyProperties(resumesCvResultParam,resumescvresult);
        resumescvresultMapper.insert(resumescvresult);
    }

    @Override
    public ResumesCvResultVo getParseResult(Long id) {
        Resumescvresult resumescvresult = resumescvresultMapper.selectById(id);
        ResumesCvResultVo resumesCvResultvo = new ResumesCvResultVo();
        resumesCvResultvo.setTotal(100L);
        BeanUtils.copyProperties(resumescvresult,resumesCvResultvo);
        return resumesCvResultvo;
    }
}
