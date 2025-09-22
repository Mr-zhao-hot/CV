package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.persist.entity.Resumes;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
* @author Administrator
* @description 针对表【resumes】的数据库操作Service
* @createDate 2025-09-21 11:09:37
*/
public interface ResumesService extends IService<Resumes> {
    Resumes upload(MultipartFile file, String filename) throws IOException;
}
