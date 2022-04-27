package com.demo.carlease.common.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * CORS 配置文件
 *
 * @author 李嘉明
 * create time 2021/12/22
 */
@Setter
@Getter
@ConfigurationProperties("cors")
public class CorsProperties {

    private String[] accessControlAllowOrigins = null;

    private String[] accessControlAllowHeaders = null;

    private String[] accessControlAllowMethods = null;

}
