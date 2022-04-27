package com.demo.carlease.common.configuration;

import com.demo.carlease.common.filter.CorsFilter;
import com.demo.carlease.common.property.CorsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * CORS 配置注入
 *
 * @author 李嘉明
 * create time 2021/12/22
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties({CorsProperties.class})
public class WebConfiguration implements WebMvcConfigurer {

    private final CorsProperties corsProperties;

    public WebConfiguration(CorsProperties corsProperties) {
        this.corsProperties = corsProperties;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new CorsFilter(
                corsProperties.getAccessControlAllowHeaders(),
                corsProperties.getAccessControlAllowMethods(),
                corsProperties.getAccessControlAllowOrigins()
        ));
        bean.setOrder(1);
        return bean;
    }
}
