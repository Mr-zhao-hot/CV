package com.example.demo.controller.filecontroller;


import com.example.demo.model.persist.entity.Resumes;
import com.example.demo.result.JsonOk;
import com.example.demo.service.ResumesService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Administrator
 */
@RestController
public class fileController {



    @Resource
    private ResumesService resumesService;

    // 上传简历
    @PostMapping("/upload")
    public JsonOk<Resumes> upload(MultipartFile file , String filename) throws IOException {
        Resumes res = resumesService.upload(file,filename);
        return JsonOk.success(res);
    }

}
