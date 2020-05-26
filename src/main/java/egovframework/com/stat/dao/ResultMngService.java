package egovframework.com.stat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
