package egovframework.com.stat.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.service.ResourceUseService;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 자원사용 통계
 * @package : egovframework.com.stat.web
 * @filename : ResourcesUseController.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 자원사용 통계에 필요한 api를 restful형태로 제공한다.
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */

@RestController
@Api(value = "ResourcesUseController", description = "자원사용 통계 REST API")
@RequestMapping("/api/ResourcesUse")
public class ResourcesUseController {

    @Autowired
    ResourceUseService resourceUseService;

    /**
     * @name : ResourceUseDayList(시스템 별 자원 사용률 조회(일))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 시스템 별 자원 사용률 조회(일평균)
     */
    @ApiOperation(value = "시스템 별 자원 사용률 조회(일)")
    @GetMapping(path = "/dayList")
    public String ResourceUseDayList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        
        param.put("HOSTNAME","");

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = resourceUseService.selectResourceUseDayList(param);
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
     * @name : ResourceUseDayHostList(시스템 별 자원 사용률 조회(일))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 시스템 별 자원 사용률 조회(일평균)
     */
    @ApiOperation(value = "시스템 별 자원 사용률 조회(일)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "hostName", value = "HOSTNAME", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/dayList/{hostName}")
    public String ResourceUseDayHostList(@PathVariable("hostName") String hostName) throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        
        param.put("HOSTNAME",URLDecoder.decode(hostName		,"UTF-8"));

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = resourceUseService.selectResourceUseDayList(param);
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
     * @name : ResourceUseMonthList(시스템 별 자원 사용률 조회(월))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 시스템 별 자원 사용률 조회(월)
     */
    @ApiOperation(value = "시스템 별 자원 사용률 조회(월)")
    @GetMapping(path = "/monthList")
    public String ResourceUseMonthList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        
        param.put("HOSTNAME","");
        ObjectMapper om = new ObjectMapper();

        try {
        	lst = resourceUseService.selectResourceUseMonthList(param);
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
     * @name : ResourceUseMonthHostList(시스템 별 자원 사용률 조회(월))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 시스템 별 자원 사용률 조회(월)
     */
    @ApiOperation(value = "시스템 별 자원 사용률 조회(월)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "hostName", value = "HOSTNAME", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/monthList/{hostName}")
    public String ResourceUseMonthHostList(@PathVariable("hostName") String hostName) throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        
        param.put("HOSTNAME",URLDecoder.decode(hostName		,"UTF-8"));
        ObjectMapper om = new ObjectMapper();

        try {
        	lst = resourceUseService.selectResourceUseMonthList(param);
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
     * @name : ResourceUseYearList(시스템 별 자원 사용률 조회(년))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 시스템 별 자원 사용률 조회(년)
     */
    @ApiOperation(value = "시스템 별 자원 사용률 조회(년)")
    @GetMapping(path = "/yearList")
    public String ResourceUseYearList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        
        param.put("HOSTNAME","");
        ObjectMapper om = new ObjectMapper();

        try {
        	lst = resourceUseService.selectResourceUseYearList(param);
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
     * @name : ResourceUseYearHostList(시스템 별 자원 사용률 조회(년))
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 시스템 별 자원 사용률 조회(년)
     */
    @ApiOperation(value = "시스템 별 자원 사용률 조회(년)")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "hostName", value = "HOSTNAME", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/yearList/{hostName}")
    public String ResourceUseYearHostList(@PathVariable("hostName") String hostName) throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();        
        
        param.put("HOSTNAME",URLDecoder.decode(hostName		,"UTF-8"));
        ObjectMapper om = new ObjectMapper();

        try {
        	lst = resourceUseService.selectResourceUseYearList(param);
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
