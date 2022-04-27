package com.demo.carlease.service.impl;

import com.demo.carlease.common.property.FileProperties;
import com.demo.carlease.exception.FileException;
import com.demo.carlease.service.FileService;
import com.demo.carlease.vo.FileVO;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

/**
 * <p>
 * 文件服务 实现类
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/11
 */
@Service
@EnableConfigurationProperties(FileProperties.class)
public class FileServiceImpl implements FileService {

    private final FileProperties fileProperties;

    public FileServiceImpl(FileProperties fileProperties) {
        this.fileProperties = fileProperties;
    }

    @Override
    public String upload(MultipartFile upload) {
        // 验证文件夹是否存在 若不存在将进行创建
        File file = new File(fileProperties.getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        // 获取原始文件扩展名
        String originalFileName = upload.getOriginalFilename();
        String newFileName = UUID.randomUUID() + originalFileName;
        String newFilePath = fileProperties.getPath() + newFileName;
        try {
            upload.transferTo(Paths.get(newFilePath));
            return newFileName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FileVO download(String fileName) {
        // 获取文件详细地址
        String filePath = fileProperties.getPath() + fileName;
        // 获取文件类型
        String fileType = fileName.substring(fileName.lastIndexOf('.') + 1);
        // JPEG 格式处理
        if ("jpg".equals(fileType)) {
            fileType = "jpeg";
        }
        // 验证文件是否存在
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileException("文件不存在！");
        }
        try {
            InputStream input = new FileInputStream(file);
            String base64 = "data:image/" + fileType + ";base64," +
                    Base64.getEncoder().encodeToString(input.readAllBytes());
            return FileVO.builder().fileName(base64).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
