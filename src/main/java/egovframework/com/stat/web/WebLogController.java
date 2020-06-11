package egovframework.com.stat.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.service.WebLogService;
import egovframework.com.stat.dao.WebLogVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 웹로그관리
 * @package : egovframework.com.stat.web
 * @filename : WebLogController.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 웹로그관리에 필요한 api를 restful형태로 제공한다.
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */

@RestController
@Api(value = "WebLogController", description = "웹로그관리 REST API")
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
    public String WebLogList() {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        lst = webLogService.selectWebLogList(param);


        ObjectMapper om = new ObjectMapper();
        try {
            rtn = om.writeValueAsString(lst);
        } catch (JsonProcessingException e) {
            rtn = "json Mapper Error.";
            e.printStackTrace();
        }

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
        String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("OCCRRNC_DE", param.getOccrrncDe());
        sqlInpt.put("RQESTER_ID", param.getRqesterId());
        sqlInpt.put("RQESTER_IP", param.getRqesterIp());
        sqlInpt.put("URL", param.getUrl());


        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        int inputCnt = webLogService.insertWebLog(sqlInpt);
        if (inputCnt > 0) {
            rtnMap.put("RESULTCD", "0");
            rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
        } else {
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "업무기능 등록에 실패 하였습니다.");
        }


        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }
}
