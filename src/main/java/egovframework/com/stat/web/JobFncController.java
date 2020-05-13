package egovframework.com.stat.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.dao.JobFncListVo;
import egovframework.com.stat.dao.JobFncService;
import egovframework.com.stat.dao.ServerInfoVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "JobFncController", description = "업무기능관리 REST API")
@RequestMapping("/api/jobFnc")
public class JobFncController {

    @Autowired
    JobFncService jobFncService;

    @ApiOperation(value = "업무기능 목록조회")
    @GetMapping(path = "/list")
    public String ServerInfoList() {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        lst = jobFncService.selectJobFncList(param);


        ObjectMapper om = new ObjectMapper();
        try {
            rtn = om.writeValueAsString(lst);
        } catch (JsonProcessingException e) {
            rtn = "json Mapper Error.";
            e.printStackTrace();
        }

        return rtn;
    }

    @ApiOperation(value = "업무기능 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serverId", value = "서버ID", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/detail/{serverId}")
    public String JobFncDetail(@PathVariable("serverId") String serverId) throws Exception {

        String rtn = "";

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();


        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("SERVER_ID", URLDecoder.decode(serverId		,"UTF-8"));
        //System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);

        lst = jobFncService.selectJobFncDetail(sqlInpt);

        ObjectMapper om = new ObjectMapper();
        try {
            rtn = om.writeValueAsString(lst);
        } catch (JsonProcessingException e) {
            rtn = "json Mapper Error.";
            e.printStackTrace();
        }

        return rtn;
    }

    @ApiOperation(value = "업무기능 등록", notes = "업무기능 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/createJobFnc")
    public String JobFncCreate(@RequestBody JobFncListVo param) throws Exception {

        String rtn = "";
        String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("SERVER_ID", param.getServerId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("LFNC_NM", param.getLFncNm());
        sqlInpt.put("MFNC_NM", param.getMFncNm());
        sqlInpt.put("SFNC_NM", param.getSFncNm());
        sqlInpt.put("DETAIL_FNC_NM", param.getDetailFncNm());
        sqlInpt.put("METHOD_NM", param.getMethodNm());
        sqlInpt.put("FRST_REGISTER_ID", param.getFrstRegisterId());
        sqlInpt.put("LAST_UPDUSR_ID", param.getLastUpdusrId());

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        lst = jobFncService.selectJobFncDetail(sqlInpt);
        int tCnt = lst.size();

        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();
        if(tCnt == 0) {
            int inputCnt = jobFncService.insertJobFncDetail(sqlInpt);
            if (inputCnt > 0) {
                rtnMap.put("RESULTCD", "0");
                rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
            } else {
                rtnMap.put("RESULTCD", "1");
                rtnMap.put("RESULTMSG", "업무기능 등록에 실패 하였습니다.");
            }
        }else{
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "동일한 업무기능 정보가 존재 합니다.");
        }

        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }

    @ApiOperation(value = "업무기능 정보수정")
    @PutMapping(path = "/modifyJobFnc")
    public String ServerChangeInfo(@RequestBody JobFncListVo param) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("SERVER_ID", param.getServerId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("LFNC_NM", param.getLFncNm());
        sqlInpt.put("MFNC_NM", param.getMFncNm());
        sqlInpt.put("SFNC_NM", param.getSFncNm());
        sqlInpt.put("DETAIL_FNC_NM", param.getDetailFncNm());
        sqlInpt.put("METHOD_NM", param.getMethodNm());
        sqlInpt.put("FRST_REGISTER_ID", param.getFrstRegisterId());
        sqlInpt.put("LAST_UPDUSR_ID", param.getLastUpdusrId());


        int inputCnt = jobFncService.updateJobFncDetail(sqlInpt);
        if(inputCnt > 0) {
            rtnMap.put("RESULTCD", "0");
            rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
        }else {
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "시스템 정보 변경에 실패 하였습니다.");
        }


        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }

    @ApiOperation(value = "업무기능 삭제", notes = "업무기능를 삭제한다")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serverId"	, value = "서버ID"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @DeleteMapping(path = "/deleteJobFnc")
    public String JobFncDelete(@RequestParam(value = "serverId") String serverId) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("SERVER_ID", URLDecoder.decode(serverId		,"UTF-8"));

        int inputCnt = jobFncService.deleteJobFnc(sqlInpt);
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

}
