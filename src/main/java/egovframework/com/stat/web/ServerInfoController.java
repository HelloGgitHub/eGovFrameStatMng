package egovframework.com.stat.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.dao.ServerInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
