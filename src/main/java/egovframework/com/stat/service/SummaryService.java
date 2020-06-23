package egovframework.com.stat.service;

import egovframework.com.stat.dao.SummaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @title : 통계배치 서비스
 * @package : egovframework.com.stat.service
 * @filename : SummaryService.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 통계배치 서비스
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
public class SummaryService {

    @Autowired
    private SummaryDao mapper;

    //시스템로그 요약
    public int insertSysLogSummary(){        return  mapper.insertSysLogSummary();    }
    //웹로그 요약
    public int insertWebLogSummary(){        return  mapper.insertWebLogSummary();    }

    //배치시작
    public int insertBatchHistory(Map<Object, Object> param){        return  mapper.insertBatchHistory(param);    }
    //배치종료
    public int updateBatchHistory(Map<Object, Object> param){        return  mapper.updateBatchHistory(param);    }
}
