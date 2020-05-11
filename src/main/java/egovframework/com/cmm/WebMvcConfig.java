//package egovframework.com.cmm;
//
//import java.util.List;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
////@EnableWebMvc
////@ConditionalOnProperty(name = "test.type", havingValue = "1") // 실제 사용시에는 제거해주세요 (개별 테스트를 위해 사용)
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
////        System.out.println(">>>>>>>>>>>>>>>>>>> [WebMvcConfig1]");
//        converters.add(htmlEscapingConverter());
//    }
//
//    private HttpMessageConverter<?> htmlEscapingConverter() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
//
//        return new MappingJackson2HttpMessageConverter(objectMapper);
//    }
//}
