package com.liang.config;


import jdk.nashorn.internal.ir.CallNode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(Environment environment){
        //设置要显示的Swagger环境
        Profiles prifiles = Profiles.of("test","dev");
        //通过enviroment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(prifiles);
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .groupName("小李")
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }
    @Bean
    public Docket createRestApi2(Environment environment){
        //设置要显示的Swagger环境
        Profiles prifiles = Profiles.of("test","dev");
        //通过enviroment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(prifiles);
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo2())
                .groupName("小张")
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build();
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("小李 API Doc")
                .description("This is a restful api document of xiaoli.")
                .version("v1.0")
                .build();
    }
    private ApiInfo apiInfo2(){
        return new ApiInfoBuilder()
                .title("小张 API Doc")
                .description("This is a restful api document of xiaozhang.")
                .version("v1.0")
                .build();
    }

}