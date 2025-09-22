package com.example.demo.utils;


import com.example.demo.service.AiCodeHelperService;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Configuration
public class AiCodeHelperServiceFactory {

    @Resource
    private StreamingChatModel  streamingChatModel;

    @Resource
    private ChatModel  qwenchatModel;

    public static class PdfFileContent {
        private MultipartFile file;
        public static PdfFileContent from(MultipartFile file) {
            PdfFileContent content = new PdfFileContent();
            content.file = file;
            return content;
        }
        public String extractText() throws IOException {
            return "PDF内容: " + file.getOriginalFilename() + " 的内容...";
        }
    }

    @Bean
    public AiCodeHelperService aiCodeHelper() {
        return AiServices.builder(AiCodeHelperService.class)
                .chatModel(qwenchatModel)
                .streamingChatModel(streamingChatModel)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }
}
