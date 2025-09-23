package com.example.demo.service;

import com.example.demo.model.persist.param.ResultResumesParam.ResumesData;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import reactor.core.publisher.Flux;

public interface AiCodeHelperService {

    // Ai对话
    @SystemMessage("根据简历的内容帮我分析简历")
    Flux<String> chatMessage(@MemoryId Long id , @UserMessage  String message);

    @SystemMessage("根据简历的内容帮我分析简历")
    String chats(@MemoryId Long id , @UserMessage  String message);


    // 改为返回结构化的Resume对象
    @SystemMessage("""
            你是简历结构化解析助手，需将传入的「预处理后简历文本」（已按模块分类），严格按照 `ResumesData` 类的字段要求，提取并填充数据，规则如下：
            
            一、字段解析规则
            1. resumeId：生成唯一标识（格式：UUID，示例："resume_123e4567-e89b-12d3-a456-426614174000"）；
            2. filename：从 PDF 原始文本中提取文件名（如“极简专业简历模板 (3).pdf”，若未找到则填“未知简历.pdf”）；
            3. parseStatus：固定填充为 "completed"（表示解析完成）；
            4. candidateName：从【个人信息】模块提取姓名，若为“[待填写]”则填“待填写”；
            5. contactEmail：从【个人信息】模块提取邮箱，格式需符合“xxx@xxx.xxx”，无则填“待填写”；
            6. contactPhone：从【个人信息】模块提取手机号（11位数字，如“138****8888”），无则填“待填写”；
            7. yearsExperience：计算工作年限（按【工作/实习经历】的时间段总和，无经历则填 0，待填写则填 0）；
            8. skills：从【技能专长】模块提取专业技能（数组格式，如 ["React", "Vue.js"]，无则填 ["待填写专业技能"]）；
            9. workExperiences：从【工作/实习经历】模块提取，每个经历含 4 个字段：
               - company：公司名称（无则填“待填写公司”）；
               - position：职位名称（无则填“待填写职位”）；
               - duration：时间段（格式：“YYYY-YYYY”或“YYYY.MM-YYYY.MM”，无则填“待填写时间段”）；
               - description：核心职责/成果（提炼关键内容，无则填“待填写工作内容”）；
            10. educationSummary：从【教育背景】模块提取，每个教育经历含 3 个字段：
                - school：学校名称（无则填“待填写学校”）；
                - degree：学位+专业（如“计算机科学与技术学士”，无则填“待填写学位专业”）；
                - duration：学习时间段（格式：“YYYY-YYYY”，无则填“待填写时间段”）；
            11. parsedContent：直接填充传入文本中的【原始文本备份】模块内容（保留完整原始文本）；
            12. createdAt：填充当前 UTC 时间（格式：“YYYY-MM-DDTHH:MM:SSZ”，示例：“2024-01-01T00:00:00Z”）。
            
            二、输出要求
            1. 严格匹配 `ResumesData` 类的字段结构，不新增/删除字段，数据类型正确（字符串用双引号，数字无引号，数组用方括号）；
            2. 若某字段无数据，需填“待填写”或默认值（如 yearsExperience 填 0），不允许留空或 null；
            3. 仅返回结构化的 `ResumesData` 对象数据，不添加任何额外解释文本。
            """)
    String chat(@MemoryId Long id , @UserMessage  String message);

    // 添加专门的简历解析方法
    ResumesData parseResume(String pdfContent);


    // 面试题
    @SystemMessage("")
    Flux<String> chatInterview(@MemoryId Long id , @UserMessage  String message);
}
