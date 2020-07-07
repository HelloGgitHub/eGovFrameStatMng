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

import egovframework.com.stat.dao.JobFncVo;
import egovframework.com.stat.service.JobFncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @title : 업무기능관리
 * @package : egovframework.com.user.web
 * @filename : JobFncController.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 업무기능관리에 필요한 api를 restful형태로 제공한다.
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */
@RestController
@Api(value = "JobFncController", description = "업무기능관리 REST API")
@RequestMapping("/api/jobFnc")
public class JobFncController {

    @Autowired
    JobFncService jobFncService;

    /**
     * @name : JobFncList(업무기능 목록조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무기능 목록조회
     */
    @ApiOperation(value = "업무기능 목록조회")
    @GetMapping(path = "/list")
    public String JobFncList() throws Exception {

    	String rtn = "";
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();  

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = jobFncService.selectJobFncList(param);
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
     * @name : JobFncDetail(업무기능 상세조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무기능 상세조회
     */
    @ApiOperation(value = "업무기능 상세조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/detail/{id}")
    public String JobFncDetail(@PathVariable("id") String id) throws Exception {

        String rtn = "";

        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("ID", URLDecoder.decode(id		,"UTF-8"));
        //System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);

        

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = jobFncService.selectJobFncDetail(sqlInpt);
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
     * @name : JobFncCreate(업무기능 등록)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무기능 등록
     */
    @ApiOperation(value = "업무기능 등록", notes = "업무기능 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/createJobFnc")
    public String JobFncCreate(@RequestBody JobFncVo param) throws Exception {

        String rtn = "";
        //String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("LFNC_NM", param.getlFncNm());
        sqlInpt.put("MFNC_NM", param.getmFncNm());
        sqlInpt.put("SFNC_NM", param.getsFncNm());
        sqlInpt.put("DETAIL_FNC_NM", param.getDetailFncNm());
        sqlInpt.put("METHOD_NM", param.getMethodNm());
        sqlInpt.put("FRST_REGISTER_ID", param.getFrstRegisterId());
        sqlInpt.put("LAST_UPDUSR_ID", param.getLastUpdusrId());

        System.out.println(sqlInpt);
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        lst = jobFncService.selectJobFncMethod(sqlInpt);
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

    /**
     * @name : JobFncChangeInfo(업무기능 정보수정)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무기능 정보수정
     */
    @ApiOperation(value = "업무기능 정보수정")
    @PutMapping(path = "/modifyJobFnc")
    public String JobFncChangeInfo(@RequestBody JobFncVo param) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("HOSTNAME", param.getHostName());
        sqlInpt.put("LFNC_NM", param.getlFncNm());
        sqlInpt.put("MFNC_NM", param.getmFncNm());
        sqlInpt.put("SFNC_NM", param.getsFncNm());
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
            rtnMap.put("RESULTMSG", "업무기능 정보 변경에 실패 하였습니다.");
        }


        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }

    /**
     * @name : JobFncDelete(업무기능 삭제)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무기능 삭제
     */
    @ApiOperation(value = "업무기능 삭제", notes = "업무기능를 삭제한다")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id"	, value = "ID"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @DeleteMapping(path = "/deleteJobFnc")
    public String JobFncDelete(@RequestParam(value = "id") String id) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("ID", URLDecoder.decode(id		,"UTF-8"));

        int inputCnt = jobFncService.deleteJobFnc(sqlInpt);
        if(inputCnt > 0) {
            rtnMap.put("RESULTCD", "0");
            rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
        }else {
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "업무기능 삭제에 실패 하였습니다.");
        }

        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);
        return rtn;

    }

    //업무기능목록 엑셀 업로드
    //업무기능목록 엑셀다운로드

    /**
     * @name : SelectJobFncStatList(업무기능목록별 사용량 조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 업무기능목록별 사용량 조회
     */
    @ApiOperation(value = "업무기능목록별 사용량 조회")
    @GetMapping(path = "/jobFncStatList")
    public String SelectJobFncStatList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = jobFncService.selectJobFncStatList(param);
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
     * @name : SelectJobFncUseList(기능별 사용량 조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 기능별 사용량 조회
     */
    @ApiOperation(value = "기능별 사용량 조회")
    @GetMapping(path = "/jobFncUseList")
    public String SelectJobFncUseList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();


        ObjectMapper om = new ObjectMapper();

        try {
        	lst = jobFncService.selectJobFncUseList(param);
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
     * @name : SelectJobFncUseList(기능별 사용량 조회(일))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 기능별 사용량 조회
     */
    @ApiOperation(value = "기능별 사용량 조회(일)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "hostName", value = "HOSTNAME", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/jobFncUseDayList/{hostName}")
    public String SelectJobFncUseDayList(@PathVariable("hostName") String hostName) throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        param.put("HOSTNAME",URLDecoder.decode(hostName		,"UTF-8"));
        ObjectMapper om = new ObjectMapper();

        try {
        	lst = jobFncService.selectJobFncUseDayList(param);
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
     * @name : SelectJobFncUseList(기능별 사용량 조회(일))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 기능별 사용량 조회
     */
    @ApiOperation(value = "기능별 사용량 조회(월)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "hostName", value = "HOSTNAME", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/jobFncUseMonthList/{hostName}")
    public String SelectJobFncUseMonthList(@PathVariable("hostName") String hostName) throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        param.put("HOSTNAME",URLDecoder.decode(hostName		,"UTF-8"));
        ObjectMapper om = new ObjectMapper();

        try {
        	lst = jobFncService.selectJobFncUseMonthList(param);
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
     * @name : SelectJobFncUseList(기능별 사용량 조회(일))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 기능별 사용량 조회
     */
    @ApiOperation(value = "기능별 사용량 조회(년)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "hostName", value = "HOSTNAME", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/jobFncUseYearList/{hostName}")
    public String SelectJobFncUseYearList(@PathVariable("hostName") String hostName) throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        param.put("HOSTNAME",URLDecoder.decode(hostName		,"UTF-8"));
        ObjectMapper om = new ObjectMapper();

        try {
        	lst = jobFncService.selectJobFncUseYearList(param);
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
    //미등록업무기능 조회
}
