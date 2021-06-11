package com.cp.consumersmq.utils;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>
 *
 * </p>
 *
 * @author yang
 * @since 2021/04/16
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(value = {"swagger.enable"}, matchIfMissing = true)
public class SwaggerConfiguration {

    @Bean
    public Docket docket() throws UnknownHostException {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("低版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cp.consumersmq"))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();

        System.out.println("swagger 地址:  http://" + InetAddress.getLocalHost().getHostAddress() + ":8081/doc.html");
        return docket;
    }

    @Bean
    public Docket createActivitiRestApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("高版本22")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cp.consumersmq"))
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui-demo RESTful APIs")
                .description("# swagger-bootstrap-ui-demo RESTful APIs")
                .termsOfServiceUrl("http://localhost:8081/doc.html")
                .version("1.0")
                .build();
    }
}
