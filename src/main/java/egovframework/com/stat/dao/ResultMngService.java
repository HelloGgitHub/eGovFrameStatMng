package egovframework.com.stat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class ResultMngService {

    @Autowired
    private ResultMngDao mapper;


    public int insertSysLogSum(Map<Object, Object> param) {
        return mapper.insertSysLogSum(param);
    }

}
