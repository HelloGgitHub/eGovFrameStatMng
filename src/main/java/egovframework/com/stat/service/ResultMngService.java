package egovframework.com.stat.service;

import egovframework.com.stat.dao.ResultMngDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 성과지표관리
 * @package : egovframework.com.stat.service
 * @filename : ResultMngService.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 성과지표관리에 필요한 api를 restful형태로 제공한다.
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
public class ResultMngService {

    @Autowired
    private ResultMngDao mapper;

    //성과측정지표 목록 조회
    public List<HashMap<Object, Object>> selectResultIndexList(Map<Object, Object> param) {
        return mapper.selectResultIndexList(param);
    }
    //성과측정지표 상세 조회
    public List<HashMap<Object, Object>> selectResultIndexDetail(Map<Object, Object> param) {
        return mapper.selectResultIndexDetail(param);
    }
    //성과측정지표 상세 조회
    public List<HashMap<Object, Object>> selectResultIndexNm(Map<Object, Object> param) {
        return mapper.selectResultIndexNm(param);
    }
    //성과측정지표 등록
    public int insertResultIndex(Map<Object, Object> param) {
        return mapper.insertResultIndex(param);
    }
    //성과측정지표 수정
    public int updateResultIndex(Map<Object, Object> param) {
        return mapper.updateResultIndex(param);
    }
    //성과측정지표 삭제
    public int deleteResultIndex(Map<Object, Object> param) {
        return mapper.deleteResultIndex(param);
    }

}
