package egovframework.com.user.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.SecuritySha;
import egovframework.com.user.dao.UserInfoService;
import egovframework.com.user.dao.UserModifyInfoVo;
import egovframework.com.user.dao.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@RestController
//@Api(value = "UserController", description = "사용자 정보 관리 REST API")
//@RequestMapping("/api/user")
public class UserController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@Value("${spring.profiles}")
	private String serverState;
	
	@Autowired
	UserInfoService userService;
	
	@ApiOperation(value = "사용자 목록조회")
	@GetMapping(path = "/list")
	public String UserList() {
		System.out.println("\nUser/List");
		
		String rtn = "";
		Map<Object, Object> param = new HashMap<Object, Object>();
		List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
		
		System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);
		
		if("maria".equals(serverState)) {
			lst = userService.selectDataMaria(param);
		} else {
			lst = userService.selectDataOracle(param);
		}
		System.out.println(lst);
		
		ObjectMapper om = new ObjectMapper();
		try {
			rtn = om.writeValueAsString(lst);
		} catch (JsonProcessingException e) {
			rtn = "json Mapper Error.";
			e.printStackTrace();
		}
		
		return rtn;
	}
	
	@ApiOperation(value = "사용자 조회")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "userId", value = "사용자ID", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
	@GetMapping(path = "/detailInfo/{userId}")
	public String UserDetailInfo(@PathVariable("userId") String userId) throws Exception {
		System.out.println("\nUser/DetailInfo === reqData :: " + userId);
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
		
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		sqlInpt.put("USR_ID", URLDecoder.decode(userId		,"UTF-8"));
		System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);
		
		if("maria".equals(serverState)) {
			lst = userService.selectUserDetailMaria(sqlInpt);
		} else {
			lst = userService.selectUserDetailOracle(sqlInpt);
		}
		System.out.println(lst);
		
		try {
			rtn = om.writeValueAsString(lst);
		} catch (JsonProcessingException e) {
			rtn = "json Mapper Error.";
			e.printStackTrace();
		}
		
		return rtn;
	}
	
	@ApiOperation(value = "사용자 가입요청", notes = "사용자 가입 요청을 합니다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
	@PostMapping(path = "/arovRequest")
	public String UserAprovRequest(@RequestBody UserVo param) throws Exception {
		String rtn = "";
		String data = URLDecoder.decode(rtn,"UTF-8");
		System.out.println("User/AprovRequest\tproperties Test :: "+serverPort + "\t ServerState :: " + serverState +"\n" + data);
		
		ObjectMapper om = new ObjectMapper();
//		Map<String, String> map = om.readValue(data, Map.class);
		
		//입력값 파라미터 정의
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		sqlInpt.put("USR_ID", param.getUsrId());									//회원ID.........................................................
		
		//SHA-256 암호화
		if(null != param.getPassword() && !"".equals(param.getPassword()) && !"null".equals(param.getPassword())) {
			String pw = SecuritySha.SHA256(param.getPassword());			//SHA-256 암호화
			sqlInpt.put("PASSWORD", pw);												//비밀번호.................................................................
		}												//비밀번호.................................................................
		sqlInpt.put("PASSWORD_HINT", param.getPasswordHint());			//비밀번호힌트.................................................................
		sqlInpt.put("PASSWORD_CNSR", param.getPasswordCnsr());			//비밀번호정답.................................................................
		sqlInpt.put("USR_NM", param.getUsrNm());									//회원명.................................................................
		sqlInpt.put("ZIP", param.getZip());											//우편번호.................................................................
		sqlInpt.put("ADRES", param.getAdres());									//주소.................................................................
		sqlInpt.put("AREA_NO", param.getAreaNo());								//지역번호.................................................................
		sqlInpt.put("USR_STTUS", param.getUsrSttus());							//회원상태
		sqlInpt.put("DETAIL_ADRES", param.getDetailAdres());					//상세주소.................................................................
		sqlInpt.put("END_TELNO", param.getEndTelno());							//끝전화번호.................................................................
		sqlInpt.put("MBTLNUM", param.getMoblphonNo());						//이동전화번호.................................................................
		sqlInpt.put("USR_FXNUM", param.getUsrFxnum());        				//회원팩스번호.................................................................
		sqlInpt.put("USR_EMAIL_ADRES", param.getUsrEmailAdres());		//회원이메일주소.................................................................
		sqlInpt.put("MIDDLE_TELNO", param.getMiddleTelno());				//중간전화번호.................................................................
		sqlInpt.put("SEXDSTN_CODE", param.getSexdstnCode());				//성별코드.................................................................
		sqlInpt.put("LOCK_AT", "N");														//잠금여부.................................................................
		sqlInpt.put("LOCK_CNT", 0);														//잠금회수.................................................................
		sqlInpt.put("LOCK_LAST_PNTTM", "");											//잠금최종시점.................................................................

		List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
		lst = userService.selectUserDetailMaria(sqlInpt);
		int usrCnt = lst.size();

		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		if(usrCnt == 0) {
			int inputCnt = userService.insertUserDetailMaria(sqlInpt);
			if (inputCnt > 0) {
				rtnMap.put("RESULTCD", "0");
				rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
			} else {
				rtnMap.put("RESULTCD", "1");
				rtnMap.put("RESULTMSG", "사용자 정보 등록에 실패 하였습니다.");
			}
		}else{
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "동일한 사용자가 존재 합니다.");
		}
		
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}

	
	@ApiOperation(value = "사용자 정보수정")
	@PutMapping(path = "/modifyInfo")
	public String UserChangeInfo(@RequestBody UserModifyInfoVo param) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		System.out.println("User/modifyInfo\tproperties Test :: "+serverPort + "\t ServerState :: " + serverState +"\n" +param);
//		Map<String, String> map = om.readValue(data, Map.class);
		
		//입력값 파라미터 정의
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		sqlInpt.put("USR_ID", param.getUsrId());								//회원ID.........................................................
		
		if(null != param.getPassword() && !"".equals(param.getPassword()) && !"null".equals(param.getPassword())) {
			String pw = SecuritySha.SHA256(param.getPassword());			//SHA-256 암호화
			sqlInpt.put("PASSWORD", pw);												//비밀번호.................................................................
		}
		sqlInpt.put("PASSWORD_HINT", param.getPasswordHint());		//비밀번호힌트.................................................................
		sqlInpt.put("PASSWORD_CNSR", param.getPasswordCnsr());		//비밀번호정답.................................................................
		sqlInpt.put("USR_NM", param.getUsrNm());								//회원명.................................................................
		sqlInpt.put("ZIP", param.getZip());										//우편번호.................................................................
		sqlInpt.put("ADRES", param.getAdres());								//주소.................................................................
		sqlInpt.put("AREA_NO", param.getAreaNo());							//지역번호.................................................................
		sqlInpt.put("DETAIL_ADRES", param.getDetailAdres());				//상세주소.................................................................
		sqlInpt.put("END_TELNO", param.getEndTelno());						//끝전화번호.................................................................
		sqlInpt.put("MBTLNUM", param.getMoblphonNo());					//이동전화번호.................................................................
		sqlInpt.put("USR_FXNUM", param.getUsrFxnum());        			//회원팩스번호.................................................................
		sqlInpt.put("USR_EMAIL_ADRES", param.getUsrEmailAdres());	//회원이메일주소.................................................................
		sqlInpt.put("MIDDLE_TELNO", param.getMiddleTelno());			//중간전화번호.................................................................
		sqlInpt.put("SEXDSTN_CODE", param.getSexdstnCode());			//성별코드.................................................................
		sqlInpt.put("LOCK_AT", param.getLockAt());							//잠금여부.................................................................
		sqlInpt.put("LOCK_CNT", param.getLockCnt());						//잠금회수.................................................................
		sqlInpt.put("LOCK_LAST_PNTTM", param.getLockLastPnttm());	//잠금최종시점.................................................................
		
		int inputCnt = userService.updateUserDetailMaria(sqlInpt);
		if(inputCnt > 0) {
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		}else {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "사용자 정보 변경에 실패 하였습니다.");
		}
		
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}
	
	@ApiOperation(value = "사용자 정보 삭제", notes = "가입 요청한 사용자정보를 삭제한다")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "userId"	, value = "사용자ID"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 500, message = "Internal Server Error !!"),
        @ApiResponse(code = 404, message = "Not Found !!")
    })
	@DeleteMapping(path = "/deleteUsr")
	public String UserDeleteInfo(@RequestParam(value = "userId") String usrId) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		String pUsrId = URLDecoder.decode(usrId,"UTF-8");
		System.out.println("User/deleteMbrInfo\tproperties Test :: "+serverPort + "\t ServerState :: " + serverState +"\n" + pUsrId);
		
		//입력값 파라미터 정의
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		sqlInpt.put("USR_ID", pUsrId);								//회원ID.........................................................
		
		int inputCnt = userService.deleteUserMaria(sqlInpt);
		if(inputCnt > 0) {
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		}else {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "삭제에 실패 하였습니다.");
		}
		
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}
	
	@ApiOperation(value = "사용자 가입승인 상태변경", notes = "가입 요청한 사용자의 승인상태를 변경한다")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "userId"	, value = "사용자ID"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
       ,@ApiImplicitParam(name = "usrSttus", value = "사용자상태"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK !!"),
        @ApiResponse(code = 500, message = "Internal Server Error !!"),
        @ApiResponse(code = 404, message = "Not Found !!")
    })
	@PutMapping(path = "/updateUsrState")
	public String UserChangeState(
			@RequestParam(value = "userId") String usrId,
			@RequestParam(value = "usrSttus") String usrSttus) throws Exception {
		String rtn = "";
		ObjectMapper om = new ObjectMapper();
		Map<Object, Object> rtnMap = new HashMap<Object, Object>();
		
		String pUserId 		= URLDecoder.decode(usrId		,"UTF-8");
		String pUsrSttus 		= URLDecoder.decode(usrSttus	,"UTF-8");
		System.out.println("User/changeMbrState\tproperties Test :: "+serverPort + "\t ServerState :: " + serverState +"\n" + pUserId + pUsrSttus);
		
		//입력값 파라미터 정의
		Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
		sqlInpt.put("USR_ID", pUserId);							//회원ID
		sqlInpt.put("USR_STTUS", pUsrSttus);					//회원상태
		
		int inputCnt = userService.updateUserStateMaria(sqlInpt);
		if(inputCnt > 0) {
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
		}else {
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "사용자 상태변경에 실패 하였습니다.");
		}
		
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtnMap);
		return rtn;
	}
	
}
