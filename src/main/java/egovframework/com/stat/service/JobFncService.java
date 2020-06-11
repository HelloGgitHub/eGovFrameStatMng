package egovframework.com.stat.service;

import egovframework.com.stat.dao.JobFncDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 업무기능관리
 * @package : egovframework.com.stat.service
 * @filename : JobFncService.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 업무기능관리에 필요한 api를 restful형태로 제공한다.
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
    //업무기능목록별 사용량 조회
    public List<HashMap<Object, Object>> selectJobFncStatList(Map<Object, Object> param) {
        return mapper.selectJobFncStatList(param);
    }
    //기능별 사용량 조회(CRUD)
    public List<HashMap<Object, Object>> selectJobFncUseList(Map<Object, Object> param) {
        return mapper.selectJobFncUseList(param);
    }
}
