package com.example.demo.service;

import com.example.demo.model.persist.entity.ResumesAnalysis;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.persist.vo.ResumesAnalysisVo;

import java.io.IOException;

/**
* @author Administrator
* @description 针对表【resumes_analysis(简历解析结果)】的数据库操作Service
* @createDate 2025-09-22 21:06:31
*/
public interface ResumesAnalysisService extends IService<ResumesAnalysis> {

    ResumesAnalysisVo selectIdBy(Long id, String file) throws IOException;

    ResumesAnalysisVo selectIdBytext(Long id);
}
