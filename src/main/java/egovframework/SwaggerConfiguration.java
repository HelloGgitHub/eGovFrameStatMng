package egovframework;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    private String version;
    private String title;

	@Bean
    public Docket api() {
	    version = "V1";
	    title = "전자정부 클라우드 플랫폼 업무시스템 이용통계 API " + version;
		
        return new Docket(DocumentationType.SWAGGER_2)
        		.useDefaultResponseMessages(false)
                .groupName(version)
                .select()
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("egovframework.com"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo(title, version))
               .pathMapping("/");
    }
	

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title,
                "Base URL + API path 결합이 API서비스 호출 경로입니다. ex) Base URL(localhost:8080)+API path(/api/jobFnc/list)",
                version,
                null,
                null,
                null,
                null,
                new ArrayList<>());
    }
}
