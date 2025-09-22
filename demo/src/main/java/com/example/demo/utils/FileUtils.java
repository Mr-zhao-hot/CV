package com.example.demo.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Administrator
 *
 */
@Configuration
public class FileUtils {

    // 获取文件后缀
    public String getMultipartFileExtension(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        int lastDotIndex = fileName.lastIndexOf('.');
        String substring = fileName.substring(lastDotIndex + 1);
        return "." + substring;
    }


    // 解析PDF的实际文本内容（而非元数据标题）
    public String pdfFile(String file) throws IOException {
        String realFilePath = file.trim().replaceAll("^\"|\"$", "");
        File file1 = new File(realFilePath);
        try (PDDocument document = PDDocument.load(file1)) {
            if (document.isEncrypted()) {
                throw new IOException("PDF文档已加密，无法提取内容");
            }

            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
}