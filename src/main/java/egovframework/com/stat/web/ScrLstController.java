package egovframework.com.stat.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.stat.dao.ScrLstVo;
import egovframework.com.stat.service.ScrLstService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @title : 화면정보관리
 * @package : egovframework.com.stat.web
 * @filename : ScrLstController.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 화면정보관리에 필요한 api를 restful형태로 제공한다.
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */

@RestController
@Api(value = "ScrLstController", description = "화면정보관리 REST API")
@RequestMapping("/api/scrLst")
public class ScrLstController {

    @Autowired
    ScrLstService scrLstService;

    /**
     * @name : ScrList(화면정보 목록조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 화면정보 목록조회
     */
    @ApiOperation(value = "화면정보 목록조회")
    @GetMapping(path = "/list")
    public String ScrList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = scrLstService.selectScrList(param);
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
     * @name : ScrDetail(화면정보 상세조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 화면정보 상세조회
     */
    @ApiOperation(value = "화면정보 상세조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/detail/{id}")
    public String ScrDetail(@PathVariable("id") String id) throws Exception {

        String rtn = "";
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("ID", URLDecoder.decode(id		,"UTF-8"));
        //System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = scrLstService.selectScrDetail(sqlInpt);
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
     * @name : ScrCreate(화면정보 등록)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 화면정보 등록
     */
    @ApiOperation(value = "화면정보 등록", notes = "화면정보 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/createScr")
    public String ScrCreate(@RequestBody ScrLstVo param) throws Exception {

        String rtn = "";
        //String data = URLDecoder.decode(rtn,"UTF-8");

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

    /**
     * @name : ScrChangeInfo(화면정보 수정)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 화면정보 수정
     */
    @ApiOperation(value = "화면정보 수정")
    @PutMapping(path = "/modifyScr")
    public String ScrChangeInfo(@RequestBody ScrLstVo param) throws Exception {
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

    /**
     * @name : ScrDelete(화면정보 삭제)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 화면정보 삭제
     */
    @ApiOperation(value = "화면정보 삭제", notes = "화면정보를 삭제한다")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id"	, value = "ID"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @DeleteMapping(path = "/deleteScr")
    public String ScrDelete(@RequestParam(value = "id") String id) throws Exception {
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


    /**
     * @name : ScrStatList(화면 조회 통계(기간별))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 화면 조회 통계(기간별)
     */
    @ApiOperation(value = "화면 조회 통계(기간별)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDt"	, value = "STARTDT"	, required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "endDt"	, value = "ENDDT"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @GetMapping(path = "/scrStatlist")
    public String ScrStatList(@RequestParam(value = "startDt") String startDt
                            ,@RequestParam(value = "endDt") String endDt) throws Exception {

        String rtn = "";

        String tmpStartDt 		= URLDecoder.decode(startDt		,"UTF-8");
        String tmpEndDt 	= URLDecoder.decode(endDt	,"UTF-8");
        
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<Object, Object> param = new HashMap<Object, Object>();
        param.put("STARTDT",tmpStartDt);
        param.put("ENDDT",tmpEndDt);

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	 lst = scrLstService.selectScrStatlist(param);
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
     * @name : NonRegScrlist(미등록 화면 조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 미등록 화면 조회
     */
    @ApiOperation(value = "미등록 화면 조회 ")
    @GetMapping(path = "/nonReglist")
    public String NonRegScrlist() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = scrLstService.selectNonRegScrlist(param);
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
     * @name : ScrStatList(화면 조회 통계(일별그래프))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 화면 조회 통계(일별그래프)
     */
    @ApiOperation(value = "화면 조회 통계(일별그래프)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hostName"	, value = "HOSTNAME"	, required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "url"	, value = "URL"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @GetMapping(path = "/scrStatDaylist")
    public String ScrStatDayList(@RequestParam(value = "hostName") String hostName
                            ,@RequestParam(value = "url") String url) throws Exception {

        String rtn = "";

        String tmpHostName 		= URLDecoder.decode(hostName		,"UTF-8");
        String tmpUrl 	= URLDecoder.decode(url	,"UTF-8");
        
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<Object, Object> param = new HashMap<Object, Object>();
        param.put("HOSTNAME",tmpHostName);
        param.put("URL",tmpUrl);

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	 lst = scrLstService.selectScrStatDaylist(param);
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
     * @name : ScrStatList(화면 조회 통계(월별그래프))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 화면 조회 통계(월별그래프)
     */
    @ApiOperation(value = "화면 조회 통계(월별그래프)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hostName"	, value = "HOSTNAME"	, required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "url"	, value = "URL"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @GetMapping(path = "/scrStatMonthlist")
    public String ScrStatMonthList(@RequestParam(value = "hostName") String hostName
                            ,@RequestParam(value = "url") String url) throws Exception {

        String rtn = "";

        String tmpHostName 		= URLDecoder.decode(hostName		,"UTF-8");
        String tmpUrl 	= URLDecoder.decode(url	,"UTF-8");
        
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<Object, Object> param = new HashMap<Object, Object>();
        param.put("HOSTNAME",tmpHostName);
        param.put("URL",tmpUrl);

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	 lst = scrLstService.selectScrStatMonthlist(param);
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
     * @name : ScrStatList(화면 조회 통계(년별그래프))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 화면 조회 통계(월별그래프)
     */
    @ApiOperation(value = "화면 조회 통계(년별그래프)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hostName"	, value = "HOSTNAME"	, required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "url"	, value = "URL"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @GetMapping(path = "/scrStatYearlist")
    public String ScrStatYearList(@RequestParam(value = "hostName") String hostName
                            ,@RequestParam(value = "url") String url) throws Exception {

        String rtn = "";

        String tmpHostName 		= URLDecoder.decode(hostName		,"UTF-8");
        String tmpUrl 	= URLDecoder.decode(url	,"UTF-8");
        
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<Object, Object> param = new HashMap<Object, Object>();
        param.put("HOSTNAME",tmpHostName);
        param.put("URL",tmpUrl);

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	 lst = scrLstService.selectScrStatYearlist(param);
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
