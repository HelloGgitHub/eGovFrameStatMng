package egovframework.com.stat.web;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "WebLogController", description = "웹로그관리 REST API")
@RequestMapping("/api/webLog")
public class WebLogController {
}
