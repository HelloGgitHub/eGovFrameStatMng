package egovframework.com.stat.service;

import egovframework.com.stat.dao.SysLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 시스템로그관리
 * @package : egovframework.com.stat.service
 * @filename : SysLogService.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 시스템로그관리에 필요한 api를 restful형태로 제공한다.
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
public class SysLogService {

    @Autowired
    private SysLogDao mapper;

    
    //시스템로그 목록 조회
    public List<HashMap<Object, Object>> selectSysLogList(Map<Object, Object> param) {
        return mapper.selectSysLogList(param);
    }
    //시스템로그 등록
    public int insertSysLog(Map<Object, Object> param) {
        return mapper.insertSysLog(param);
    }
    //기능별 호출 횟수 목록 조회
    public List<HashMap<Object, Object>> selectFncReqList(Map<Object, Object> param) {
        return mapper.selectFncReqList(param);
    }


}
