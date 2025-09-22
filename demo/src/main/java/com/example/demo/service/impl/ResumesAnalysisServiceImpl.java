package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.ResumesAnalysisMapper;
import com.example.demo.mapper.ResumesMapper;
import com.example.demo.model.persist.entity.ResumesAnalysis;
import com.example.demo.model.persist.vo.ResumesAnalysisVo;
import com.example.demo.service.AiCodeHelperService;
import com.example.demo.service.ResumesAnalysisService;
import com.example.demo.utils.FileUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
* @author Administrator
* @description 针对表【resumes_analysis(简历解析结果)】的数据库操作Service实现
* @createDate 2025-09-22 21:06:31
*/
@Service
public class ResumesAnalysisServiceImpl extends ServiceImpl<ResumesAnalysisMapper, ResumesAnalysis>
    implements ResumesAnalysisService{


    @Resource
    private AiCodeHelperService aiCodeHelperService;


    @Resource
    private FileUtils fileUtils;

    @Resource
    private ResumesAnalysisMapper resumesAnalysisMapper;


    @Resource
    private ResumesMapper resumesMapper;


    @Override
    public ResumesAnalysisVo selectIdBy(Long id, String file) throws IOException {

        ResumesAnalysis resumesAnalysis1 = new ResumesAnalysis();
        resumesAnalysis1.setUserId(id);
        resumesAnalysisMapper.insert(resumesAnalysis1);

        Long taskId = resumesAnalysis1.getId();
        // ai 解析简历
        CompletableFuture.runAsync(() -> {
            String pdfText;
            try {
                pdfText = fileUtils.pdfFile(file);
                String chat = aiCodeHelperService.chat(id, pdfText);
                ResumesAnalysis resumesAnalysis = new ResumesAnalysis();
                resumesAnalysis.setId(taskId);
                resumesAnalysis.setTextAnalysis(chat);
                resumesAnalysisMapper.updateById(resumesAnalysis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // 返回id
        ResumesAnalysisVo resumesAnalysisVo = new ResumesAnalysisVo();
        BeanUtils.copyProperties(resumesAnalysis1, resumesAnalysisVo);
        return resumesAnalysisVo;
    }
}




