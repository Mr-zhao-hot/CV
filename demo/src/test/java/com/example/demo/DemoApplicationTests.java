package com.example.demo;

import com.example.demo.service.AiCodeHelperService;
import com.example.demo.service.ResumesService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoApplicationTests {



    @Resource
    private ResumesService resumesService;

    @Resource
    private AiCodeHelperService aiCodeHelperService;


    @Test
    void testChats(){

    }

}
