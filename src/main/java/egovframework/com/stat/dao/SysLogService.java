package egovframework.com.stat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}