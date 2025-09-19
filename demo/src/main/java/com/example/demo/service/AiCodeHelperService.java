package com.example.demo.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.util.List;

public interface AiCodeHelperService {


    Flux<String> chat(String message);


//    record Report(String name , List<String> suggestionlist){}
//
//    @SystemMessage("你好 我是小奥 , 你可以教会人写编程  写代码")
//    Report report(String userMessage);
}
