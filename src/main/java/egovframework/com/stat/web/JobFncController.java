package egovframework.com.stat.web;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.com.stat.dao.JobFncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "JobFncController", description = "업무기능관리 REST API")
@RequestMapping("/jobFnc")
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

}
