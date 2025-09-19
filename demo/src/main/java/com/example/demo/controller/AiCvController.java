package com.example.demo.controller;
import com.example.demo.result.JsonOk;
import com.example.demo.service.AiCodeHelperService;
import com.example.demo.utils.AiCodeHelperServiceFactory;
import jakarta.annotation.Resource;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import java.io.IOException;


/**
 * @author Mr_Zhao
 */
@RestController
public class AiCvController {

    @Resource
    private AiCodeHelperService  aiCodeHelperService;

    @PostMapping("/cv")
    public Flux<ServerSentEvent<String>> uploadFileCV(MultipartFile file) throws IOException {
        String pdfText = AiCodeHelperServiceFactory.PdfFileContent.from(file).extractText();
        return aiCodeHelperService.chat(pdfText)
                .map(chunk -> ServerSentEvent.<String>builder().data(chunk).build());
    }

    @PostMapping("/cv/chat")
    public JsonOk continueChat( @RequestBody  String message) {
        return JsonOk.success(aiCodeHelperService.chat(message));
    }
}
