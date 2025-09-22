package com.example.demo.controller.AiCv;

import com.example.demo.model.persist.param.ProgressBar;
import com.example.demo.result.JsonOk;
import com.example.demo.service.AiCodeHelperService;
import com.example.demo.utils.AiCodeHelperServiceFactory;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * @author Mr_Zhao
 */
@RestController
public class AiCvController {

    @Resource
    private AiCodeHelperService  aiCodeHelperService;

    // 分析简历
//    @PostMapping("/cv/{id}")
//    public Flux<ServerSentEvent<String>> uploadFileCV(MultipartFile file) throws IOException {
//        String pdfText = AiCodeHelperServiceFactory.PdfFileContent.from(file).extractText();
//        return aiCodeHelperService.chat(pdfText)
//                .map(chunk -> ServerSentEvent.<String>builder().data(chunk).build());
//    }

    @PostMapping("/cv/chat")
    public JsonOk continueChat( @RequestBody  String message) {
        return JsonOk.success(aiCodeHelperService.chat(message));
    }

    // 简历分析
    @PostMapping("analysis")
    public JsonOk analysis(MultipartFile file) throws IOException {
        String pdfText = AiCodeHelperServiceFactory.PdfFileContent.from(file).extractText();
        String chat = aiCodeHelperService.chat(pdfText);
        return JsonOk.success(aiCodeHelperService.parseResume(chat));
    }

    // 进度查询
    @GetMapping("/resumes/{id}/parse-status")
    public JsonOk<ProgressBar> getParseStatus(@PathVariable Long id) {
        return JsonOk.success();
    }

}
