package com.example.demo.result;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ServiceCode {
    // 成功状态码
    SUCCESS_CODE(200000, "接口访问成功"),
    SUCCESS_CREATED(201000, "资源创建成功"),
    SUCCESS_UPDATED(202000, "资源更新成功"),
    SUCCESS_DELETED(203000, "资源删除成功"),
    SUCCESS_NO_CONTENT(204000, "请求成功但无返回内容"),

    // 客户端错误
    FAIL_CODE(400000, "接口参数错误"),
    UNAUTHORIZED(401000, "未认证或token过期"),
    FORBIDDEN(403000, "权限不足，无法访问"),
    NOT_FOUND(404000, "请求的资源不存在"),
    METHOD_NOT_ALLOWED(405000, "不支持的请求方法"),
    CONFLICT(409000, "资源冲突，如已存在重复数据"),
    REQUEST_TOO_LARGE(413000, "请求体过大"),
    UNSUPPORTED_MEDIA_TYPE(415000, "不支持的媒体类型"),
    REQUEST_TIMEOUT(408000, "请求超时"),
    TOO_MANY_REQUESTS(429000, "请求频率限制，超出调用次数"),

    // 服务器错误
    SERVICE_ERROR(500000, "服务器内部异常"),
    SERVICE_UNAVAILABLE(503000, "服务暂时不可用"),
    GATEWAY_ERROR(504000, "网关超时"),
    DATABASE_ERROR(505000, "数据库操作异常"),
    EXTERNAL_SERVICE_ERROR(506000, "第三方服务调用失败"),

    // 业务特定错误
    USER_NOT_FOUND(601000, "用户不存在"),
    USER_ALREADY_EXISTS(601001, "用户已存在"),
    PASSWORD_INCORRECT(601002, "密码不正确"),
    SUBSCRIPTION_EXPIRED(602000, "订阅已过期"),
    RESOURCE_OUT_OF_LIMIT(603000, "资源已超出限制");


    private int code;
    private String message;



}