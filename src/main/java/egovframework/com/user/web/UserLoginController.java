package egovframework.com.user.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.SecuritySha;
import egovframework.com.user.dao.UserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "UserLoginController", description = "사용자 로그인 REST API")
@RequestMapping("/api/login")
public class UserLoginController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@Value("${spring.profiles}")
	private String serverState;
	
	@Autowired
	UserLoginService userLoginService;
	
	 
	
	@ApiOperation(value = "사용자 로그인", notes = "사용자 ID/PW를 입력받아 사용자 정보를 반환합니다.")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "userId", value = "사용자ID", required = true, dataType = "string", paramType = "query", defaultValue = "")
    	,@ApiImplicitParam(name = "password", value = "패스워드", required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 500, message = "Internal Server Error !!"),
        @ApiResponse(code = 404, message = "Not Found !!")
    })
	@PostMapping(path = "/idpw")
	public String UserLogin(
			@RequestParam(value = "userId") String userId,
			@RequestParam(value = "password") String password) 
		throws UnsupportedEncodingException {
		
		String rtn = "";
		System.out.println("**********login accept*********" + userId + password);
		String pUserId 		= URLDecoder.decode(userId		,"UTF-8");
		String pPassWord 	= URLDecoder.decode(password	,"UTF-8");
		
		//SHA-256 암호화
		String pw = SecuritySha.SHA256(pPassWord);
		System.out.println("Login pw : " + pw);
		
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		sqlInpt.put("USRID", 		pUserId);
		sqlInpt.put("USRPW", 		pw);

		int pwck = 0;
		pwck = userLoginService.selectUserPwCkMaria(sqlInpt);
		
		Map<Object, Object> lst = new HashMap<Object, Object>();
		if(pwck > 0) {
			System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);
			lst = userLoginService.selectUserDetailMaria(sqlInpt);
			lst.put("RESULTCD", "0");
			lst.put("RESULTMSG", "정상 처리 되었습니다.");
			System.out.println(lst);
		}else {
			lst.put("RESULTCD", "1");
			lst.put("RESULTMSG", "일치하는 사용자 정보가 없습니다.");
		}
		
		ObjectMapper om = new ObjectMapper();
		try {
			rtn = om.writeValueAsString(lst);
		} catch (JsonProcessingException e) {
			rtn = "json Mapper Error.";
			e.printStackTrace();
		}
		
		return rtn;
	}

}
