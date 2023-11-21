package com.boge.core.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author boge
 * @since 2023-08-8 08:36:16
 */
@Configuration
@EnableKnife4j
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket createRestApis() {
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .groupName("沸点咨询后台管理系统接口文档")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .ignoredParameterTypes(CookieValue.class)
                .apiInfo(apiInfo())
                .select()
                //以下拦截配置可以三选一，根据需要进行添加
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("使用swagger生成的接口文档")
                .description("开发测试")
                // 服务条款URL
                // 作者信息
                .contact(new Contact("boge", "", "xxx@136.com"))
                .version("0.0.1")
                .build();
    }

}