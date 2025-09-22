package com.example.demo.controller.AiCv;

import com.example.demo.model.persist.param.ProgressBar;
import com.example.demo.model.persist.vo.ResumesAnalysisVo;
import com.example.demo.model.persist.vo.ResumesCvResultVo;
import com.example.demo.result.JsonOk;
import com.example.demo.service.AiCodeHelperService;
import com.example.demo.service.impl.ResmesCvImpl;
import com.example.demo.service.impl.ResumesAnalysisServiceImpl;
import com.example.demo.utils.FileUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;


/**
 * @author Mr_Zhao
 */
@RestController
@Slf4j
public class AiCvController {

    @Resource
    private AiCodeHelperService  aiCodeHelperService;


    @Resource
    private FileUtils fileUtils;

    @Resource
    private ResumesAnalysisServiceImpl resumesAnalysisService;


    @Resource
    private ResmesCvImpl resmesCv;

//    // 创建分析对话
//    @PostMapping("/cv/{id}")
//    public Flux<ServerSentEvent<String>> uploadFileCV(@PathVariable Long id , @RequestBody String file) throws IOException {
//        String pdfText = fileUtils.pdfFile(file);
//        return aiCodeHelperService.chatMessage(id , pdfText)
//                .map(chunk -> ServerSentEvent.<String>builder().data(chunk).build());
//    }

    // todo 后续转到service层

    @PostMapping("/resumes/{id}/parse-status")
    public JsonOk<String> uploadFileCV(@PathVariable Long id, @RequestBody String file) throws IOException {
        // 1. 先解析PDF（如果这步很快可以同步执行）
        String pdfText = fileUtils.pdfFile(file);

        // 2. 初始化进度条，准备返回
        ProgressBar progressBar = new ProgressBar();
        progressBar.setTotal(60L);

        // 3. 立即返回结果（不等待后续处理）
        String result = progressBar.getTotal() + "%";

        // 4. 将耗时操作放到异步线程中执行
        CompletableFuture.runAsync(() -> {
            // Ai分析简历（耗时操作）
            String stringFlux = aiCodeHelperService.chats(id, pdfText);
            // 数据插入（耗时操作）
            resmesCv.insert(id, stringFlux);
        });

        return JsonOk.success(result);
    }

    // 获取分析对话结果
    @PostMapping("resumes/{id}")
    public JsonOk<ResumesCvResultVo> getParseResult(@PathVariable Long id) {
        ResumesCvResultVo parseResult = resmesCv.getParseResult(id);
        return JsonOk.success(parseResult);
    }

    // 简历分析结果
    @PostMapping("/api/analysis/{id}")
    public JsonOk<ResumesAnalysisVo> analysis(@RequestBody String file,@PathVariable Long id) throws IOException {
        ResumesAnalysisVo resumesAnalysisVo = resumesAnalysisService.selectIdBy(id , file);
        return JsonOk.success(resumesAnalysisVo);
    }



}
