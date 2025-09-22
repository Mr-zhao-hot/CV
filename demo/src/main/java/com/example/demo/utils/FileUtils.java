package com.example.demo.utils;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 *
 */
public class FileUtils {
    public static String getMultipartFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        int lastDotIndex = fileName.lastIndexOf('.');
        String substring = fileName.substring(lastDotIndex + 1);
        return  "." +substring;
    }
}
