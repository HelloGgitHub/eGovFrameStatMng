package egovframework.com.stat.service;

import egovframework.com.stat.dao.ResourceUseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 자원사용 통계
 * @package : egovframework.com.stat.service
 * @filename : ResourceUseService.java
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
