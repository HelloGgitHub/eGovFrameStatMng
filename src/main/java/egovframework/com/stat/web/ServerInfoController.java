package egovframework.com.stat.web;


import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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

import egovframework.com.cmm.ComUtil;
import egovframework.com.stat.dao.ServerInfoVo;
import egovframework.com.stat.service.ServerInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @title : 업무시스템관리
 * @package : egovframework.com.stat.web
 * @filename : ServerInfoController.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 업무시스템관리에 필요한 api를 restful형태로 제공한다.
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */

@RestController
@Api(value = "ServerInfoController", description = "업무시스템관리 REST API")
@RequestMapping("/api/serverInfo")
public class ServerInfoController {

    @Autowired
    ServerInfoService serverInfoService;

    /**
     * @name : ServerInfoList(업무시스템정보 목록조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무시스템정보 목록조회
     */
    @ApiOperation(value = "업무시스템정보 목록조회")
    @GetMapping(path = "/list")
    public String ServerInfoList() throws Exception { 

        String rtn = "";
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();   


        ObjectMapper om = new ObjectMapper();
        
        try {
        	lst = serverInfoService.selectServerInfoList(param);
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
     * @name : ServerDetailInfo(업무시스템정보 상세조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무시스템정보 상세조회
     */
    @ApiOperation(value = "업무시스템정보 상세조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/detailInfo/{id}")
    public String ServerDetailInfo(@PathVariable("id") String id) throws Exception {

    	String rtn = "";
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();  


        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("ID", URLDecoder.decode(id		,"UTF-8"));
        //System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);
       

        ObjectMapper om = new ObjectMapper();
        
        try {
        	 lst = serverInfoService.selectServerDetailInfo(sqlInpt);
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
     * @name : ServerDetailInfo(업무시스템정보 상세조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무시스템정보 상세조회
     */
    @ApiOperation(value = "업무시스템정보 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serverNm", value = "시스템명", required = false, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/serverInfo/{serverNm}")
    public String ServerInfo(@PathVariable("serverNm") String serverNm) throws Exception {

    	String rtn = "";
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();  


        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        
        
        String inputParam  = URLDecoder.decode(serverNm		,"UTF-8");
        if(inputParam.equals("undefined")) {
        	inputParam = "";
        }
        sqlInpt.put("SERVER_NM", inputParam);
        //System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);
       

        ObjectMapper om = new ObjectMapper();
        
        try {
        	 lst = serverInfoService.selectServerInfo(sqlInpt);
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
     * @name : ServerInfoCreate(업무시스템정보 등록)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무시스템정보 등록
     */
    @ApiOperation(value = "업무시스템정보 등록", notes = "업무시스템정보 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/createServerInfo")
    public String ServerInfoCreate(@RequestBody ServerInfoVo param) throws Exception {

        String rtn = "";
        //String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //sqlInpt.put("ID", param.getId());
        
        ObjectMapper om = new ObjectMapper();
        
        
        int cnt = ComUtil.getByteLength(param.getServerKnd());
        if( cnt > 2) {
        	rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "서버종류는 2Byte입니다. 코드(Ex: A or 1)" );
            
            rtn = om.writeValueAsString(rtnMap);
            System.out.println(rtnMap);
            return rtn;
        }
        //System.out.println(rtnMap);
        
        if( StringUtils.isEmpty(param.getProjectId()) || StringUtils.isBlank(param.getProjectId()) ) {
        	rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "프로젝트ID는 필수입력항목입니다.");
            
            rtn = om.writeValueAsString(rtnMap);
            System.out.println(rtnMap);
            return rtn;
        }
        
        sqlInpt.put("PROJECT_ID", param.getProjectId());
        sqlInpt.put("HOSTNAME", param.getHostName());
        
        if( StringUtils.isEmpty(param.getHostName()) || StringUtils.isBlank(param.getHostName()) ) {
        	rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "HOSTNAME은 필수입력항목입니다.");
            
            rtn = om.writeValueAsString(rtnMap);
            System.out.println(rtnMap);
            return rtn;
        }
        
        sqlInpt.put("SERVER_NM", param.getServerNm());
        sqlInpt.put("SERVER_KND", param.getServerKnd());

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
        lst = serverInfoService.selectServerDetail(sqlInpt);
        int usrCnt = lst.size();

        
        
        if(usrCnt == 0) {
            int inputCnt = serverInfoService.insertServerDetailInfo(sqlInpt);
            if (inputCnt > 0) {
                rtnMap.put("RESULTCD", "0");
                rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
            } else {
                rtnMap.put("RESULTCD", "1");
                rtnMap.put("RESULTMSG", "시스템 정보 등록에 실패 하였습니다.");
            }
        }else{
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "동일한 시스템정보가 존재 합니다.");
        }

        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }

    /**
     * @name : ServerChangeInfo(업무시스템 정보수정)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무시스템 정보수정
     */
    @ApiOperation(value = "업무시스템 정보수정")
    @PutMapping(path = "/modifyInfo")
    public String ServerChangeInfo(@RequestBody ServerInfoVo param) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());
        sqlInpt.put("PROJECT_ID", param.getProjectId());
        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("SERVER_NM", param.getServerNm());
        sqlInpt.put("SERVER_KND", param.getServerKnd());
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


        int inputCnt = serverInfoService.updateServerDetailInfo(sqlInpt);
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

    /**
     * @name : ServerDeleteInfo(업무시스템 정보 삭제)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무시스템 정보 삭제
     */
    @ApiOperation(value = "업무시스템 정보 삭제", notes = "업무시스템정보를 삭제한다")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id"	, value = "시스템ID"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @DeleteMapping(path = "/deleteServerInfo")
    public String ServerDeleteInfo(@RequestParam(value = "id") String id) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("ID", URLDecoder.decode(id		,"UTF-8"));

        int inputCnt = serverInfoService.deleteServerInfo(sqlInpt);
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

    //
    /**
     * @name : NonRegServerInfoList(미등록 업무시스템조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 미등록 업무시스템조회
     */
   // @ApiOperation(value = "미등록 업무시스템조회")
   // @GetMapping(path = "/nonReglist")
    public String NonRegServerInfoList() throws Exception{

    	String rtn = "";
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();   
        ObjectMapper om = new ObjectMapper();
       
        try {
        	 lst = serverInfoService.selectNonRegServerInfoList(param);
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
