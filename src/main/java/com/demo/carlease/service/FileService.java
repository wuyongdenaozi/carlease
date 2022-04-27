package com.demo.carlease.service;

import com.demo.carlease.vo.FileVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件相关服务类
 * </p>
 *
 * @author 李嘉明
 * create time 2022/1/11
 */
public interface FileService {

    String upload(MultipartFile upload);

    FileVO download(String fileName);

}
