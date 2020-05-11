package egovframework.com.stat.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.dao.ServerInfoService;

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
@Api(value = "ServerInfoController", description = "업무시스템관리 REST API")
@RequestMapping("/serverInfo")
public class ServerInfoController {

    @Autowired
    ServerInfoService serverInfoService;

    @ApiOperation(value = "서버정보 목록조회")
    @GetMapping(path = "/list")
    public String ServerLnfoList() {

        String rtn = "";

        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        lst = serverInfoService.selectServerInfoList(param);


        ObjectMapper om = new ObjectMapper();
        try {
            rtn = om.writeValueAsString(lst);
        } catch (JsonProcessingException e) {
            rtn = "json Mapper Error.";
            e.printStackTrace();
        }

        return rtn;
    }

    @ApiOperation(value = "서버정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serverId", value = "서버ID", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/detailInfo/{serverId}")
    public String ServerDetailInfo(@PathVariable("serverId") String serverId) throws Exception {

        String rtn = "";

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();


        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("SERVER_ID", URLDecoder.decode(serverId		,"UTF-8"));
        //System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);

        lst = serverInfoService.selectServerDetailInfo(sqlInpt);

        ObjectMapper om = new ObjectMapper();
        try {
            rtn = om.writeValueAsString(lst);
        } catch (JsonProcessingException e) {
            rtn = "json Mapper Error.";
            e.printStackTrace();
        }

        return rtn;
    }

    @ApiOperation(value = "서버정보 등록", notes = "서버정보 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/arovRequest")
    public String UserAprovRequest(@RequestBody ServerInfoVo param) throws Exception {

        String rtn = "";
        String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("SERVER_ID", param.getServerId());
        sqlInpt.put("SERVER_NM", param.getServerNm());
        sqlInpt.put("SERVER_KND", param.getServerKnd());
        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("RGSDE", param.getRgsDe());
        sqlInpt.put("OPERSYSM_INFO", param.getOperSysmInfo());

        sqlInpt.put("CPU_INFO", param.getCpuInfo());
        sqlInpt.put("MORY_INFO", param.getMoryInfo());
        sqlInpt.put("HDDISK", param.getHdDisk());
        sqlInpt.put("ETC_INFO", param.getEtcInfo());
        sqlInpt.put("CHARGER_NM", param.getChargerNm());
        sqlInpt.put("SERVER_DC", param.getServerDc());

        sqlInpt.put("FRST_REGISTER_ID", param.getFrstRegisterId());
        sqlInpt.put("LAST_UPDUSR_ID", param.getLastUpdusrId());


        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        lst = serverInfoService.selectServerDetailInfo(sqlInpt);
        int usrCnt = lst.size();

        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();
        if(usrCnt == 0) {
            int inputCnt = serverInfoService.insertServerDetailInfo(sqlInpt);
            if (inputCnt > 0) {
                rtnMap.put("RESULTCD", "0");
                rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
            } else {
                rtnMap.put("RESULTCD", "1");
                rtnMap.put("RESULTMSG", "서버 정보 등록에 실패 하였습니다.");
            }
        }else{
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "동일한 서버정보가 존재 합니다.");
        }

        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }

}
