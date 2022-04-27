package com.demo.carlease.controller;

import com.demo.carlease.service.FileService;
import com.demo.carlease.vo.FileVO;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件相关控制器
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/11
 */
@RestController
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * 文件上传接口
     *
     * @param file 后端接收的文件
     * @return
     */
    @PostMapping("/upload")
    public FileVO uploadFile(@RequestParam MultipartFile file) {
        String fileName = fileService.upload(file);
        return FileVO.builder().fileName(fileName).build();
    }

    /**
     * 文件下载方法
     *
     * @param fileName 待下载文件名
     * @return
     */
    @GetMapping("/download/{fileName}")
    public FileVO downloadFile(@PathVariable("fileName") String fileName) {
        return fileService.download(fileName);
    }

}
