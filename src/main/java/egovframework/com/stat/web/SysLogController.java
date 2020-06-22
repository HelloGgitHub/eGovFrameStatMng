package egovframework.com.stat.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.service.SysLogService;
import egovframework.com.stat.dao.SysLogVo;
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
 * @title : 업무기능로그관리
 * @package : egovframework.com.stat.web
 * @filename : SysLogController.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 업무기능로그관리에 필요한 api를 restful형태로 제공한다.
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */

@RestController
@Api(value = "SysLogController", description = "업무기능로그관리 REST API")
@RequestMapping("/api/sysLog")
public class SysLogController {

    @Autowired
    SysLogService sysLogService;

    /**
     * @name : SysLogList(업무기능 로그 목록조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무기능 로그 목록조회
     */
    @ApiOperation(value = "업무기능 로그 목록조회")
    @GetMapping(path = "/list")
    public String SysLogList() {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        lst = sysLogService.selectSysLogList(param);


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
     * @name : CreateSysLogCreate(입력 기능 호출 횟수 측정(C))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 입력 기능 호출 횟수 측정(C)
     */
    @ApiOperation(value = "입력 기능 호출 횟수 측정(C)", notes = "입력 기능 호출 횟수 측정(C)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/createSysLog")
    public String CreateSysLogCreate(@RequestBody SysLogVo param) throws Exception {

        String rtn = "";
        String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("OCCRRNC_DE", param.getOccrrncDe());
        sqlInpt.put("RQESTER_ID", param.getRqesterId());
        sqlInpt.put("RQESTER_IP", param.getRqesterIp());
        sqlInpt.put("SVC_NM", param.getSvcNm());
        sqlInpt.put("METHOD_NM", param.getMethodNm());
        sqlInpt.put("PROCESS_SE_CODE", "C");
        sqlInpt.put("PROCESS_TIME", param.getProcessTime());

        sqlInpt.put("ERROR_SE", param.getErrorSe());
        sqlInpt.put("ERROR_CO", param.getErrorCo());
        sqlInpt.put("ERROR_CODE", param.getErrorCode());


        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        int inputCnt = sysLogService.insertSysLog(sqlInpt);
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

    /**
     * @name : ReadSysLogCreate(조회 기능 호출 횟수 측정(R))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 조회 기능 호출 횟수 측정(R)
     */
    @ApiOperation(value = "조회 기능 호출 횟수 측정(R)", notes = "조회 기능 호출 횟수 측정(R)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/readSysLog")
    public String ReadSysLogCreate(@RequestBody SysLogVo param) throws Exception {

        String rtn = "";
        String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("OCCRRNC_DE", param.getOccrrncDe());
        sqlInpt.put("RQESTER_ID", param.getRqesterId());
        sqlInpt.put("RQESTER_IP", param.getRqesterIp());
        sqlInpt.put("SVC_NM", param.getSvcNm());
        sqlInpt.put("METHOD_NM", param.getMethodNm());
        sqlInpt.put("PROCESS_SE_CODE", "R");
        sqlInpt.put("PROCESS_TIME", param.getProcessTime());

        sqlInpt.put("ERROR_SE", param.getErrorSe());
        sqlInpt.put("ERROR_CO", param.getErrorCo());
        sqlInpt.put("ERROR_CODE", param.getErrorCode());


        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        int inputCnt = sysLogService.insertSysLog(sqlInpt);
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

    /**
     * @name : UpdateSysLogCreate(업데이트기능 호출 횟수 측정(U))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업데이트기능 호출 횟수 측정(U)
     */
    @ApiOperation(value = "업데이트기능 호출 횟수 측정(U)", notes = "업데이트기능 호출 횟수 측정(U)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/updateSysLog")
    public String UpdateSysLogCreate(@RequestBody SysLogVo param) throws Exception {

        String rtn = "";
        String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("OCCRRNC_DE", param.getOccrrncDe());
        sqlInpt.put("RQESTER_ID", param.getRqesterId());
        sqlInpt.put("RQESTER_IP", param.getRqesterIp());
        sqlInpt.put("SVC_NM", param.getSvcNm());
        sqlInpt.put("METHOD_NM", param.getMethodNm());
        sqlInpt.put("PROCESS_SE_CODE", "U");
        sqlInpt.put("PROCESS_TIME", param.getProcessTime());

        sqlInpt.put("ERROR_SE", param.getErrorSe());
        sqlInpt.put("ERROR_CO", param.getErrorCo());
        sqlInpt.put("ERROR_CODE", param.getErrorCode());


        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        int inputCnt = sysLogService.insertSysLog(sqlInpt);
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

    /**
     * @name : DeleteSysLogCreate(삭제기능 호출 횟수 측정(D))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 삭제기능 호출 횟수 측정(D)
     */
    @ApiOperation(value = "삭제기능 호출 횟수 측정(D)", notes = "삭제기능 호출 횟수 측정(U)")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/deleteSysLog")
    public String DeleteSysLogCreate(@RequestBody SysLogVo param) throws Exception {

        String rtn = "";
        String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("OCCRRNC_DE", param.getOccrrncDe());
        sqlInpt.put("RQESTER_ID", param.getRqesterId());
        sqlInpt.put("RQESTER_IP", param.getRqesterIp());
        sqlInpt.put("SVC_NM", param.getSvcNm());
        sqlInpt.put("METHOD_NM", param.getMethodNm());
        sqlInpt.put("PROCESS_SE_CODE", "D");
        sqlInpt.put("PROCESS_TIME", param.getProcessTime());

        sqlInpt.put("ERROR_SE", param.getErrorSe());
        sqlInpt.put("ERROR_CO", param.getErrorCo());
        sqlInpt.put("ERROR_CODE", param.getErrorCode());


        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        int inputCnt = sysLogService.insertSysLog(sqlInpt);
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

    /**
     * @name : FncReqList(기능별 호출 횟수 목록 조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 기능별 호출 횟수 목록 조회
     */
    @ApiOperation(value = "기능별 호출 횟수 목록 조회")
    @GetMapping(path = "/fncReqlist")
    public String FncReqList() {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        lst = sysLogService.selectFncReqList(param);


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
