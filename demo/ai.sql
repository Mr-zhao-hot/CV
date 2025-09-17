create database CV;
use CV;
CREATE TABLE `CV` (
    id int(11) NOT NULL AUTO_INCREMENT comment '主键',
    name varchar(255) comment '姓名',
    age int(11) comment '年龄',
    sex varchar(255) comment '性别',
    education varchar(255) comment '学历',
    work_experience varchar(255) comment '工作经历',
    project_experience varchar(255) comment '项目经历',
    skills varchar(255) comment '技能',
    self_evaluation varchar(255) comment '自我评价',
    created_at timestamp default current_timestamp comment '创建时间',
    updated_at timestamp default current_timestamp on update current_timestamp comment '更新时间'
);