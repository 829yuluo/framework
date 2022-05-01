package indi.yuluo.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * @author: yuluo
 * @createTime: 2022/3/17 21:39
 * @File: MyBatisPlusFastAutoGeneratorTest.java
 * @Software: IntelliJ IDEA
 * @Description:
 */

@SpringBootTest
public class MyBatisPlusFastAutoGeneratorTest {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/mybatis?characterEncoding=utf-8&userSSL=false", "root", "w082916x")
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("yuluo") // 设置作者
                            // .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("F://mybatis-plus"); // 指定输出目录
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("indi.yuluo") // 设置父包名
                            .moduleName("mybatisplus") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "F://mybatis-plus")); // 设置mapperXml生成路径
                })
                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
