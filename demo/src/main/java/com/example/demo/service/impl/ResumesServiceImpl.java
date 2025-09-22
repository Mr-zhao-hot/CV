package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.exception.BusinessException;
import com.example.demo.mapper.ResumesMapper;
import com.example.demo.model.persist.entity.Resumes;
import com.example.demo.model.persist.param.ResumesParam;
import com.example.demo.result.ServiceCode;
import com.example.demo.service.ResumesService;
import com.example.demo.utils.FileUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
* @author Administrator
* @description 针对表【resumes】的数据库操作Service实现
* @createDate 2025-09-21 11:09:37
*/
@Service
@Slf4j
public class ResumesServiceImpl extends ServiceImpl<ResumesMapper, Resumes>
    implements ResumesService{


    @Value("${spring.servlet.multipart.location}")
    private String uploadLocation;

    @Resource
    private ResumesMapper resumesMapper;

    // TODO 后续加上用户关联
    // 上传文件
    @Override
    @Transactional
    public Resumes upload(MultipartFile file, String filename) throws IOException {
        if (file.isEmpty()){
            throw new BusinessException(ServiceCode.FAIL_CODE,"文件为空");
        }

        String fileName = file.getOriginalFilename();
        // 获取文件后缀名
        String multipartFileExtension = FileUtils.getMultipartFileExtension(file);
        // 确定最终使用的文件名
        String finalFilename = filename != null ? filename + multipartFileExtension : fileName;

        // 定义文件保存目录
        String parentDir = "C:\\Users\\Administrator\\Desktop\\AI简历\\demo\\src\\main\\resources\\static\\img";
        File destFile = new File(parentDir, finalFilename);

        // 获取文件信息
        long originalFileSize = file.getSize();
        String originalFileHash = "1234567890";
        // 实际应用中应该计算真实的文件哈希
        String filepath = destFile.getAbsolutePath();


        log.info("文件路径：{}", filepath);
        log.info("文件名：{}", finalFilename);
        log.info("文件大小：{}", originalFileSize);
        log.info("文件Hash：{}", originalFileHash);

        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }

        file.transferTo(destFile);


        // 存入到数据库中
        ResumesParam resumesParam = new ResumesParam();
        resumesParam.setUserId(1L);
        resumesParam.setOriginalFilename(finalFilename);
        resumesParam.setFilePath(filepath);
        resumesParam.setFileHash(originalFileHash);
        resumesParam.setFileSize(originalFileSize);
        Resumes resumes = new Resumes();
        BeanUtils.copyProperties(resumesParam,resumes);
        resumesMapper.insert(resumes);
        return resumes;
    }
}




