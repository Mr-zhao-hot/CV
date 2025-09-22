package com.example.demo.mapper;

import com.example.demo.model.persist.entity.Resumes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【resumes】的数据库操作Mapper
* @createDate 2025-09-21 11:09:37
* @Entity com.example.demo.model.persist.entity.Resumes
*/
@Mapper
public interface ResumesMapper extends BaseMapper<Resumes> {

}




