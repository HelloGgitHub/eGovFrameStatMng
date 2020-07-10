package egovframework.com.stat.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.service.UserStatService;
import egovframework.com.stat.dao.UserStatVo;
import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 이용자통계 관리
 * @package : egovframework.com.stat.web
 * @filename : UserStatController.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 이용자통계 관리에 필요한 api를 restful형태로 제공한다.
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */

@RestController
@Api(value = "UserStatController", description = "이용자통계 관리 REST API")
@RequestMapping("/api/userStat")
public class UserStatController {

    @Autowired
    UserStatService userStatService;

    /**
     * @name : CreateUserStat( 로그인 횟수 측정)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 로그인 횟수 측정
     */
    @ApiOperation(value = "로그인 횟수 측정", notes = "로그인 횟수 측정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/createUserStat")
    public String CreateUserStat(@RequestBody UserStatVo param) throws Exception {

        String rtn = "";

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();
        
        if( StringUtils.isEmpty(param.getHostName()) || StringUtils.isBlank(param.getHostName()) ) {
        	rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "HOSTNAME은 필수입력항목입니다. 입력값 확인 후 다시 요청하세요.");
            
            rtn = om.writeValueAsString(rtnMap);
            System.out.println(rtnMap);
            return rtn;
        }
        
        if( StringUtils.isEmpty(param.getUsrId()) || StringUtils.isBlank(param.getUsrId()) ) {
        	rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "사용자ID(usrId)는 필수입력항목입니다. 입력값 확인 후 다시 요청하세요.");
            
            rtn = om.writeValueAsString(rtnMap);
            System.out.println(rtnMap);
            return rtn;
        }

        sqlInpt.put("OCCRRNC_DT", param.getOccrrncDt());
        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("USR_ID", param.getUsrId());

        
        int inputCnt = userStatService.insertUserStat(sqlInpt);
        if (inputCnt > 0) {
            rtnMap.put("RESULTCD", "0");
            rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
        } else {
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "로그인 횟수 측정 등록에 실패 하였습니다.");
        }


        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;
    }

    /**
     * @name : UserStatList( 로그인 횟수 목록조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 로그인 횟수 목록조회
     */
    @ApiOperation(value = "로그인 횟수 목록조회")
    @GetMapping(path = "/userStatList")
    public String UserStatList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = userStatService.selectUserStatList(param);
        	rtnMap.put("list", lst);
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");

        }catch (Exception e) {
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
			e.printStackTrace();
		}
        
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtn);

        return rtn;
    }

    /**
     * @name : ActiveUserList( 이용자수 조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 이용자수 조회
     */
    @ApiOperation(value = "이용자수 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDt"	, value = "시작일자"	, required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "endDt"	, value = "종료일자"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @GetMapping(path = "/activeUserList")
    public String ActiveUserList(@RequestParam(value = "startDt") String startDt
            ,@RequestParam(value = "endDt") String endDt) throws Exception {

        String rtn = "";
        String tmpStartDt 		= URLDecoder.decode(startDt		,"UTF-8");
        String tmpEndDt 	= URLDecoder.decode(endDt	,"UTF-8");

        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        param.put("STARTDT",tmpStartDt);
        param.put("ENDDT",tmpEndDt);
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = userStatService.selectActiveUserList(param);
        	rtnMap.put("list", lst);
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");

        }catch (Exception e) {
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
			e.printStackTrace();
		}
        
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtn);

        return rtn;
    }
    
    /**
     * @name : UserMonthStatList( 이용자수 월별 통계)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 이용자수 월별 통계
     */
    @ApiOperation(value = "이용자수 월별 통계")
    @GetMapping(path = "/userMonthStatList")
    public String UserMonthStatList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();   

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = userStatService.selectUserMonthStatList(param);
        	rtnMap.put("list", lst);
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");

        }catch (Exception e) {
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
			e.printStackTrace();
		}
        
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtn);

        return rtn;
    }
    
    /**
     * @name : UserStatDayList( 이용자 통계(일))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 이용자 통계(일)
     
    @ApiOperation(value = "이용자 통계(일)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "hostName", value = "HOSTNAME", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/userStatdayList/{hostName}")
    */
    public String UserStatDayList(@PathVariable("hostName") String hostName) throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();   
        
        param.put("HOSTNAME",URLDecoder.decode(hostName		,"UTF-8"));

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = userStatService.selectUserStatDayList(param);
        	rtnMap.put("list", lst);
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");

        }catch (Exception e) {
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
			e.printStackTrace();
		}
        
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtn);

        return rtn;
    }
    
    /**
     * @name : UserStatDayList( 이용자 통계(월))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 이용자 통계(월)
     
    @ApiOperation(value = "이용자 통계(월)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "hostName", value = "HOSTNAME", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/userStatMonthList/{hostName}")
    */
    public String UserStatMonthList(@PathVariable("hostName") String hostName) throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();   
        
        param.put("HOSTNAME",URLDecoder.decode(hostName		,"UTF-8"));

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = userStatService.selectUserStatMonthList(param);
        	rtnMap.put("list", lst);
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");

        }catch (Exception e) {
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
			e.printStackTrace();
		}
        
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtn);

        return rtn;
    }
    
    /**
     * @name : UserStatDayList( 이용자 통계(년))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 이용자 통계(년)
     
    @ApiOperation(value = "이용자 통계(년)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "hostName", value = "HOSTNAME", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/userStatYearList/{hostName}")
    */
    public String UserStatYearList(@PathVariable("hostName") String hostName) throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();   
        
        param.put("HOSTNAME",URLDecoder.decode(hostName		,"UTF-8"));

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = userStatService.selectUserStatYearList(param);
        	rtnMap.put("list", lst);
			rtnMap.put("RESULTCD", "0");
			rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");

        }catch (Exception e) {
			e.getStackTrace();
			rtnMap.put("RESULTCD", "1");
			rtnMap.put("RESULTMSG", "조회에 실패하였습니다.");
			e.printStackTrace();
		}
        
		rtn = om.writeValueAsString(rtnMap);
		System.out.println(rtn);

        return rtn;
    }
}
