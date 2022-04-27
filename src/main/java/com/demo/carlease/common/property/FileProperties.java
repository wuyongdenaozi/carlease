package com.demo.carlease.common.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * File 配置文件
 *
 * @author 李嘉明
 * create time 2022/1/11
 */
@Setter
@Getter
@ConfigurationProperties("file")
public class FileProperties {

    private String path;

}
