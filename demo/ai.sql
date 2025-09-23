create database CV;
use CV;
-- 用户表
-- 创建用户表
CREATE TABLE users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户唯一标识',
                       email VARCHAR(255) UNIQUE NOT NULL COMMENT '用户邮箱，作为登录账号',
                       password_hash VARCHAR(255) NOT NULL COMMENT '密码哈希值，存储加密后的密码',
                       name VARCHAR(100) COMMENT '用户姓名',
                       avatar_url VARCHAR(500) COMMENT '用户头像图片的URL地址',
                       subscription_type ENUM('free', 'pro', 'enterprise') DEFAULT 'free' COMMENT '订阅类型：免费、专业版、企业版',
                       subscription_expires_at TIMESTAMP NULL COMMENT '订阅到期时间，NULL表示永久有效',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
                       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
                       INDEX idx_email (email) COMMENT '邮箱索引，加速登录查询',
                       INDEX idx_subscription (subscription_type, subscription_expires_at) COMMENT '订阅信息索引，用于查询订阅状态'
);

-- 创建用户会话表
CREATE TABLE user_sessions (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '会话记录唯一标识',
                       user_id BIGINT NOT NULL COMMENT '关联的用户ID，对应users表的id字段',
                       session_token VARCHAR(255) UNIQUE NOT NULL COMMENT '会话令牌，用于验证用户身份',
                       expires_at TIMESTAMP NOT NULL COMMENT '会话过期时间',
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '会话创建时间',
                       INDEX idx_token (session_token) COMMENT '会话令牌索引，加速身份验证',
                       INDEX idx_user_expires (user_id, expires_at) COMMENT '用户会话索引，用于查询用户的有效会话'
);

CREATE TABLE `resumes` (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '简历记录唯一标识',
                           `user_id` bigint NOT NULL COMMENT '关联的用户ID，对应users表的id字段',
                           `original_filename` varchar(255) NOT NULL COMMENT '简历文件的原始名称（用户上传时的文件名）' ,
                           `file_path` varchar(500) NOT NULL COMMENT '简历文件在服务器中的存储路径',
                           `file_size` bigint NOT NULL COMMENT '简历文件的大小（单位：字节）',
                           `file_hash` varchar(64) DEFAULT NULL COMMENT '简历文件的哈希值（用于文件唯一性校验）' ,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `file_hash` (`file_hash`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='简历存储表';

-- 简历解析结果
CREATE TABLE `resumesCvResult` (
                                   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '简历记录唯一标识',
                                   `user_id` bigint NOT NULL COMMENT '关联的用户ID，对应users表的id字段',
                                   `text` text NOT NULL COMMENT '分析结果对话',
                                   `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
                                   `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录最后更新时间',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='简历解析结果';

-- 简历分析
CREATE TABLE `resumes_analysis` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '简历记录唯一标识',
                             `user_id` bigint NOT NULL COMMENT '关联的用户ID，对应users表的id字段',
                             `text_analysis` text NOT NULL COMMENT '分析结果对话',
                             `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='简历解析结果';


CREATE TABLE `interview` (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '简历记录唯一标识',
                             `user_id` bigint NOT NULL COMMENT '关联的用户ID，对应users表的id字段',
                             `user_message` text NOT NULL COMMENT '用户输入的对话',
                             `interview_message` text NOT NULL COMMENT '面试官的回复',
                             `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT '面试对话记录';

