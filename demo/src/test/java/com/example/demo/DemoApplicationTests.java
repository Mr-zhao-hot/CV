package com.example.demo;

import com.example.demo.service.AiCodeHelperService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;


@SpringBootTest
class DemoApplicationTests {



    @Resource
    private AiCodeHelperService aiCodeHelperService;

//    @Test
//    void testChat(){
//        String result = aiCodeHelperService.chat("你好");
//        System.out.println(result);
//        String result1 = aiCodeHelperService.chat("你叫什么名字呀 刚才我跟你说了什么");
//        System.out.println(result1);
//    }


    @Test
    void testChats(){

    }

}
