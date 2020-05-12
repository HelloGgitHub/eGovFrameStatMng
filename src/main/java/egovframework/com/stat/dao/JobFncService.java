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
    //업무기능 조회
    public List<HashMap<Object, Object>> selectJobFncDetail(Map<Object, Object> param) {
        return mapper.selectJobFncDetail(param);
    }
    //업무기능 메소드 조회
    public List<HashMap<Object, Object>> selectJobFncMethod(Map<Object, Object> param) {
        return mapper.selectJobFncMethod(param);
    }
    //업무기능 등록
    public int insertJobFncDetail(Map<Object, Object> param) {
        return mapper.insertJobFncDetail(param);
    }
    //업무기능 수정
    public int updateJobFncDetail(Map<Object, Object> param) {
        return mapper.updateJobFncDetail(param);
    }
    
    //업무기능 삭제
    public int deleteJobFnc(Map<Object, Object> param) {
        return mapper.deleteJobFnc(param);
    }

    



}
