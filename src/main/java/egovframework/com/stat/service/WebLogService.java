package egovframework.com.stat.service;

import egovframework.com.stat.dao.WebLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WebLogService {

    @Autowired
    private WebLogDao mapper;

    //웹로그 목록 조회
    public List<HashMap<Object, Object>> selectWebLogList(Map<Object, Object> param) {
        return mapper.selectWebLogList(param);
    }
    //웹로그 등록
    public int insertWebLog(Map<Object, Object> param) {
        return mapper.insertWebLog(param);
    }
}
