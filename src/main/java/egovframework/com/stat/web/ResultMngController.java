package egovframework.com.stat.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.service.ResultMngService;
import egovframework.com.stat.dao.ResultMngVo;
import io.swagger.annotations.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 성과지표관리
 * @package : egovframework.com.stat.web
 * @filename : ResultMngController.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 성과지표관리에 필요한 api를 restful형태로 제공한다.
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */

@RestController
@Api(value = "ResultMngController", description = "성과지표관리 REST API")
@RequestMapping("/api/resultMng")
public class ResultMngController {

    @Autowired
    ResultMngService resultMngService;

    /**
     * @name : ResultIndexList(성과지표 목록조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 성과지표 목록조회
     */
    @ApiOperation(value = "성과지표 목록조회")
    @GetMapping(path = "/list")
    public String ResultIndexList() throws Exception {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();    

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = resultMngService.selectResultIndexList(param);
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
     * @name : ResultIndexDetail(성과지표 상세조회)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 성과지표 상세조회
     */
    @ApiOperation(value = "성과지표 상세조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "string", paramType = "path", defaultValue = "")
    })
    @GetMapping(path = "/detail/{id}")
    public String ResultIndexDetail(@PathVariable("id") String id) throws Exception {

        String rtn = "";
        Map<String, Object> rtnMap = new HashMap<String, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("ID", URLDecoder.decode(id		,"UTF-8"));
        //System.out.println("properties Test :: "+serverPort + "\t\t ServerState :: " + serverState);

        ObjectMapper om = new ObjectMapper();

        try {
        	lst = resultMngService.selectResultIndexDetail(sqlInpt);
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
     * @name : ResultIndexCreate(성과지표 등록)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 성과지표 등록
     */
    @ApiOperation(value = "성과지표 등록", notes = "성과지표 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @PostMapping(path = "/creatResultIndex")
    public String ResultIndexCreate(@RequestBody ResultMngVo param) throws Exception {

        String rtn = "";
        String data = URLDecoder.decode(rtn,"UTF-8");

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());
        
        if( StringUtils.isEmpty(param.getResultIndexNm()) || StringUtils.isBlank(param.getResultIndexNm()) ) {
        	rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "성과지표명(resultIndexNm)은 필수입력항목입니다.  입력값 확인 후 다시 요청하세요.");
            
            rtn = om.writeValueAsString(rtnMap);
            System.out.println(rtnMap);
            return rtn;
        }
        
        if( StringUtils.isEmpty(param.getResultIndexDc()) || StringUtils.isBlank(param.getResultIndexDc()) ) {
        	rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "성과지표설명(getResultIndexDc)은 필수입력항목입니다. 입력값 확인 후 다시 요청하세요.");
            
            rtn = om.writeValueAsString(rtnMap);
            System.out.println(rtnMap);
            return rtn;
        }
        
        sqlInpt.put("RESULT_INDEX_NM", param.getResultIndexNm());
        sqlInpt.put("RESULT_INDEX_DC", param.getResultIndexDc());


        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();
        lst = resultMngService.selectResultIndexNm(sqlInpt);
        int tCnt = lst.size();

       
        if(tCnt == 0) {
            int inputCnt = resultMngService.insertResultIndex(sqlInpt);
            if (inputCnt > 0) {
                rtnMap.put("RESULTCD", "0");
                rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
            } else {
                rtnMap.put("RESULTCD", "1");
                rtnMap.put("RESULTMSG", "성과지표 등록에 실패 하였습니다.");
            }
        }else{
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "동일한 성과지표 정보가 존재 합니다.");
        }

        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }

    /**
     * @name : ResultIndexUpdate(성과지표 수정)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 성과지표 수정
     */
    @ApiOperation(value = "성과지표 정보수정")
    @PutMapping(path = "/modifyResultIndex")
    public String ResultIndexUpdate(@RequestBody ResultMngVo param) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();

        sqlInpt.put("ID", param.getId());

        sqlInpt.put("RESULT_INDEX_NM", param.getResultIndexNm());
        sqlInpt.put("RESULT_INDEX_DC", param.getResultIndexDc());


        int inputCnt = resultMngService.updateResultIndex(sqlInpt);
        if(inputCnt > 0) {
            rtnMap.put("RESULTCD", "0");
            rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
        }else {
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "성과지표 정보 변경에 실패 하였습니다.");
        }


        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);

        return rtn;

    }

    /**
     * @name : ResultIndexUpdate(성과지표 삭제)
     * @date : 2020. 6. 11.
     * @author : "egov"
     * @return_type : String
     * @desc : 성과지표 삭제
     */
    @ApiOperation(value = "성과지표 삭제", notes = "성과지표를 삭제한다")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id"	, value = "ID"	, required = true, dataType = "string", paramType = "query", defaultValue = "")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @DeleteMapping(path = "/deleteResultIndex")
    public String ResultIndexDelete(@RequestParam(value = "id") String id) throws Exception {
        String rtn = "";
        ObjectMapper om = new ObjectMapper();
        Map<Object, Object> rtnMap = new HashMap<Object, Object>();

        //입력값 파라미터 정의
        Map<Object, Object> sqlInpt = new HashMap<Object, Object>();
        sqlInpt.put("ID", URLDecoder.decode(id		,"UTF-8"));

        int inputCnt = resultMngService.deleteResultIndex(sqlInpt);
        if(inputCnt > 0) {
            rtnMap.put("RESULTCD", "0");
            rtnMap.put("RESULTMSG", "정상 처리 되었습니다.");
        }else {
            rtnMap.put("RESULTCD", "1");
            rtnMap.put("RESULTMSG", "성과측정지표 삭제에 실패 하였습니다.");
        }

        rtn = om.writeValueAsString(rtnMap);
        System.out.println(rtnMap);
        return rtn;

    }

}
