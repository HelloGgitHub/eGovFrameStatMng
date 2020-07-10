package egovframework.com.stat.web;


import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.stat.dao.WebLogVo;
import egovframework.com.stat.service.WebLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @title : 화면접근 로그관리
 * @package : egovframework.com.stat.web
 * @filename : WebLogController.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 화면접근 로그관리에 필요한 api를 restful형태로 제공한다.
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */

@RestController
@Api(value = "WebLogController", description = "화면접근 로그관리 REST API")
@RequestMapping("/api/webLog")
public class WebLogController {

    @Autowired
    WebLogService webLogService;

    /**
     * @name : WebLogList( 화면 접근 횟수 목록 조회 )
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 사용자 목록을 조회한다.
     */
    @ApiOperation(value = "화면 접근 횟수 목록 조회")
    @GetMapping(path = "/list")
    public String WebLogList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = webLogService.selectWebLogList(param);
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
     * @name : WebLogCreate( 화면 접근 횟수 측정 )
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 사용자 목록을 조회한다.
     */
    @ApiOperation(value = "화면 접근 횟수 측정", notes = "화면 접근 횟수 측정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/createWebLog")
    public String WebLogCreate(@RequestBody WebLogVo param) throws Exception {

        String rtn = "";
        //String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //sqlInpt.put("ID", param.getId());
        
        if( StringUtils.isEmpty(param.getHostName()) || StringUtils.isBlank(param.getHostName()) ) {
        	rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "HOSTNAME은 필수입력항목입니다.");
            
            rtn = om.writeValueAsString(rtnMap);
            System.out.println(rtnMap);
            return rtn;
        }
        
        if( StringUtils.isEmpty(param.getUrl()) || StringUtils.isBlank(param.getUrl()) ) {
        	rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "URL(url)은 필수입력항목입니다. ");
            
            rtn = om.writeValueAsString(rtnMap);
            System.out.println(rtnMap);
            return rtn;
        }
        
        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("OCCRRNC_DE", param.getOccrrncDe());
        sqlInpt.put("RQESTER_ID", param.getRqesterId());
        sqlInpt.put("RQESTER_IP", param.getRqesterIp());
        sqlInpt.put("URL", param.getUrl());

        int inputCnt = webLogService.insertWebLog(sqlInpt);
        if (inputCnt > 0) {
            rtnMap.put("RESULTCD", "0");
            rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
        } else {
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "화면 접근 횟수 측정 등록에 실패 하였습니다.");
        }


        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }
}
