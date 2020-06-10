package egovframework.com.stat.service;

import egovframework.com.stat.dao.ResourceUseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ResourceUseService {

    @Autowired
    private ResourceUseDao mapper;

    //시스템 별 자원 사용률 조회(일)
    public List<HashMap<Object, Object>> selectResourceUseDayList(Map<Object, Object> param) {
        return mapper.selectResourceUseDayList(param);
    }

    //시스템 별 자원 사용률 조회(년)
    public List<HashMap<Object, Object>> selectResourceUseMonthList(Map<Object, Object> param) {
        return mapper.selectResourceUseMonthList(param);
    }
    //시스템 별 자원 사용률 조회(년)
    public List<HashMap<Object, Object>> selectResourceUseYearList(Map<Object, Object> param) {
        return mapper.selectResourceUseYearList(param);
    }


}
