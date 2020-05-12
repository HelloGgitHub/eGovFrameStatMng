package egovframework.com.stat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class JobFncService {

    @Autowired
    private JobFncDao mapper;
    
    //업무기능 목록 조회
    public List<HashMap<Object, Object>> selectJobFncList(Map<Object, Object> param) {
        return mapper.selectJobFncList(param);
    }

}
