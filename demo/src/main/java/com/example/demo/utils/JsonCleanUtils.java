package com.example.demo.utils;
import org.apache.commons.lang3.StringUtils;


public class JsonCleanUtils {
    /**
     * 清理 JSON 字符串中的非法控制字符（保留常见合法字符）
     * 允许的字符范围：可打印 ASCII 字符（32-126）、常见换行/制表符（\n \r \t）
     */
    public static String cleanIllegalChars(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return jsonStr;
        }
        // 正则替换：移除所有非允许的控制字符
        // [^\x20-\x7E\n\r\t] 表示：排除 可打印ASCII(32-126)、\n、\r、\t 之外的所有字符
        return jsonStr.replaceAll("[^\\x20-\\x7E\\n\\r\\t]", "");
    }
}
