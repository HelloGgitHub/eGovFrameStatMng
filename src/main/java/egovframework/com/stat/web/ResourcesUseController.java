package egovframework.com.stat.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.service.ResourceUseService;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@Api(value = "ResourcesUseController", description = "자원사용 통계 REST API")
@RequestMapping("/api/ResourcesUse")
public class ResourcesUseController {

    @Autowired
    ResourceUseService resourceUseService;

    //시스템 별 자원 사용률 조회(일평균)
    @ApiOperation(value = "시스템 별 자원 사용률 조회(일)")
    @GetMapping(path = "/dayList")
    public String ResourceUseDayList() {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        lst = resourceUseService.selectResourceUseDayList(param);


        ObjectMapper om = new ObjectMapper();
        try {
            rtn = om.writeValueAsString(lst);
        } catch (JsonProcessingException e) {
            rtn = "json Mapper Error.";
            e.printStackTrace();
        }

        return rtn;
    }

    //시스템 별 자원 사용률 조회(년)
    @ApiOperation(value = "시스템 별 자원 사용률 조회(월)")
    @GetMapping(path = "/monthList")
    public String ResourceUseMonthList() {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        lst = resourceUseService.selectResourceUseMonthList(param);


        ObjectMapper om = new ObjectMapper();
        try {
            rtn = om.writeValueAsString(lst);
        } catch (JsonProcessingException e) {
            rtn = "json Mapper Error.";
            e.printStackTrace();
        }

        return rtn;
    }

    //시스템 별 자원 사용률 조회(년)
    @ApiOperation(value = "시스템 별 자원 사용률 조회(년)")
    @GetMapping(path = "/yearList")
    public String ResourceUseYearList() {

        String rtn = "";
        Map<Object, Object> param = new HashMap<Object, Object>();
        List<HashMap<Object, Object>> lst = new ArrayList<HashMap<Object, Object>>();

        lst = resourceUseService.selectResourceUseYearList(param);


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
