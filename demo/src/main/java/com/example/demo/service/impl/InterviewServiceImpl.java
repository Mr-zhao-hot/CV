package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.model.persist.entity.Interview;
import com.example.demo.service.InterviewService;
import com.example.demo.mapper.InterviewMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【interview(面试对话记录)】的数据库操作Service实现
* @createDate 2025-09-23 12:14:07
*/
@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, Interview>
    implements InterviewService{

}




