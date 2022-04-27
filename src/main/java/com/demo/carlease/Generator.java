package com.demo.carlease;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.demo.carlease.entity.BaseEntity;

import java.util.Collections;

/**
 * @author 李嘉明
 * create time 2021/12/19
 */
public class Generator {

    /** 数据源配置 */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://127.0.0.1:3306/carlease", "john", "123456");

    /** 自动生成方法 */
    public static void main(String[] args) {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig(builder -> builder
                        // 作者名
                        .author("李嘉明")
                        // 导出路径
                        .outputDir("src/main/java")
                        // 覆盖生成
                        .fileOverride())
                // 包配置
                .packageConfig(builder -> builder
                        // 父包名
                        .parent("com.demo.carlease")
                        // mapper 包名
                        .mapper("repository"))
                // 策略配置
                .strategyConfig(builder -> builder.addInclude(Collections.emptyList())
                        // controller 策略配置
                        .controllerBuilder()
                        .enableRestStyle()
                        .enableHyphenStyle()
                        // service 策略配置
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
                        // mapper 策略配置
                        .mapperBuilder()
                        .formatMapperFileName("%sRepository")
                        // entity 策略配置
                        .entityBuilder()
                        .superClass(BaseEntity.class)
                        .enableLombok()
                        .enableTableFieldAnnotation()
                        .logicDeleteColumnName("delete_datetime")
                        .logicDeletePropertyName("deleteDatetime")
                        .addSuperEntityColumns("id", "create_datetime", "update_datetime", "delete_datetime")
                        .build())
                // 模版引擎设置
                .templateEngine(new FreemarkerTemplateEngine())
                // 执行生成
                .execute();
    }
}
