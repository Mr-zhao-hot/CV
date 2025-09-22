package com.example.demo.controller.AiCv;

import com.example.demo.model.persist.param.ProgressBar;
import com.example.demo.result.JsonOk;
import com.example.demo.service.AiCodeHelperService;
import com.example.demo.utils.AiCodeHelperServiceFactory;
import com.example.demo.utils.FileUtils;
import jakarta.annotation.Resource;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.IOException;


/**
 * @author Mr_Zhao
 */
@RestController
public class AiCvController {

    @Resource
    private AiCodeHelperService  aiCodeHelperService;


    @Resource
    private FileUtils fileUtils;

    // 分析简历
    @PostMapping("/cv/{id}")
    public Flux<ServerSentEvent<String>> uploadFileCV(@PathVariable Long id , @RequestBody String file) throws IOException {
        File file1 = new File(file);
        String pdfText = fileUtils.pdfFile(file1);
        return aiCodeHelperService.chatMessage(id , pdfText)
                .map(chunk -> ServerSentEvent.<String>builder().data(chunk).build());
    }

//    @PostMapping("/cv/chat")
//    public JsonOk continueChat(@RequestBody  String message) {
//        return JsonOk.success(aiCodeHelperService.chat(message));
//    }

    // 简历分析结果
    @PostMapping("resumes/{id}")
    public JsonOk analysis(MultipartFile file,@PathVariable Long id) throws IOException {
        String pdfText = AiCodeHelperServiceFactory.PdfFileContent.from(file).extractText();
        String chat = aiCodeHelperService.chat(id,pdfText);
        return JsonOk.success(aiCodeHelperService.parseResume(chat));
    }




    // 进度查询
    @GetMapping("/resumes/{id}/parse-status")
    public JsonOk<ProgressBar> getParseStatus(@PathVariable Long id) {
        return JsonOk.success();
    }

}
