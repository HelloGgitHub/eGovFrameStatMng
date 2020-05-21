package egovframework.com.stat.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.dao.JobFncListVo;
import egovframework.com.stat.dao.ScrLstService;
import egovframework.com.stat.dao.ScrLstVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "JobFncController", description = "화면정보관리 REST API")
@RequestMapping("/api/scrLst")
public class ScrLstController {

    @Autowired
    ScrLstService scrLstService;

    @ApiOperation(value = "화면정보 목록조회")
    @GetMapping(path = "/list")
    public String ScrList() {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        lst = scrLstService.selectScrList(param);


        ObjectMapper om = new ObjectMapper();
        try {
            rtn = om.writeValueAsString(lst);
        } catch (JsonProcessingException e) {
            rtn = "json Mapper Error.";
            e.printStackTrace();
        }

        return rtn;
    }

    @ApiOperation(value = "화면정보 상세조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/detail/{id}")
    public String JobFncDetail(@PathVariable("id") String id) throws Exception {

        String rtn = "";

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();


        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("ID", URLDecoder.decode(id		,"UTF-8"));
        //System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);

        lst = scrLstService.selectScrDetail(sqlInpt);

        ObjectMapper om = new ObjectMapper();
        try {
            rtn = om.writeValueAsString(lst);
        } catch (JsonProcessingException e) {
            rtn = "json Mapper Error.";
            e.printStackTrace();
        }

        return rtn;
    }

    @ApiOperation(value = "화면정보 등록", notes = "화면정보 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/createSrc")
    public String SrcCreate(@RequestBody ScrLstVo param) throws Exception {

        String rtn = "";
        String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("SCR_NM", param.getScrNm());
        sqlInpt.put("SCR_DC", param.getScrDc());
        sqlInpt.put("URL", param.getUrl());
        sqlInpt.put("FRST_REGISTER_ID", param.getFrstRegisterId());
        sqlInpt.put("LAST_UPDUSR_ID", param.getLastUpdusrId());

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        lst = scrLstService.selectScrUrl(sqlInpt);
        int tCnt = lst.size();

        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();
        if(tCnt == 0) {
            int inputCnt = scrLstService.insertScrDetail(sqlInpt);
            if (inputCnt > 0) {
                rtnMap.put("RESULTCD", "0");
                rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
            } else {
                rtnMap.put("RESULTCD", "1");
                rtnMap.put("RESULTMSG", "화면정보 등록에 실패 하였습니다.");
            }
        }else{
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "동일한 화면 정보가 존재 합니다.");
        }

        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }

    @ApiOperation(value = "화면정보 수정")
    @PutMapping(path = "/modifySrc")
    public String SrcChangeInfo(@RequestBody ScrLstVo param) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("SCR_NM", param.getScrNm());
        sqlInpt.put("SCR_DC", param.getScrDc());
        sqlInpt.put("URL", param.getUrl());
        sqlInpt.put("FRST_REGISTER_ID", param.getFrstRegisterId());
        sqlInpt.put("LAST_UPDUSR_ID", param.getLastUpdusrId());


        int inputCnt = scrLstService.updateScrDetail(sqlInpt);
        if(inputCnt > 0) {
            rtnMap.put("RESULTCD", "0");
            rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
        }else {
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "화면정보 변경에 실패 하였습니다.");
        }


        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }

    @ApiOperation(value = "화면정보 삭제", notes = "화면정보를 삭제한다")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id"	, value = "ID"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @DeleteMapping(path = "/deleteSrc")
    public String SrcDelete(@RequestParam(value = "id") String id) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("ID", URLDecoder.decode(id		,"UTF-8"));

        int inputCnt = scrLstService.deleteScrDetail(sqlInpt);
        if(inputCnt > 0) {
            rtnMap.put("RESULTCD", "0");
            rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
        }else {
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "화면정보 삭제에 실패 하였습니다.");
        }

        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);
        return rtn;

    }


    //화면 조회 통계(기간별)
}
