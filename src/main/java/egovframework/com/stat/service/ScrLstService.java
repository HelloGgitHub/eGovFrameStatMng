package egovframework.com.stat.service;

import egovframework.com.stat.dao.ScrLstDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ScrLstService {

    @Autowired
    private ScrLstDao mapper;

    //화면정보 목록 조회
    public List<HashMap<Object, Object>> selectScrList(Map<Object, Object> param) {
        return mapper.selectScrList(param);
    }
    //화면정보  조회
    public List<HashMap<Object, Object>> selectScrDetail(Map<Object, Object> param) {
        return mapper.selectScrDetail(param);
    }
    //화면정보  중복 조회
    public List<HashMap<Object, Object>> selectScrUrl(Map<Object, Object> param) {
        return mapper.selectScrUrl(param);
    }
    //화면정보  등록
    public int insertScrDetail(Map<Object, Object> param) {
        return mapper.insertScrDetail(param);
    }
    //화면정보  수정
    public int updateScrDetail(Map<Object, Object> param) {
        return mapper.updateScrDetail(param);
    }
    //화면정보 삭제
    public int deleteScrDetail(Map<Object, Object> param) {
        return mapper.deleteScrDetail(param);
    }
    //화면 조회 통계(기간별)
    public List<HashMap<Object, Object>> selectScrStatlist(Map<Object, Object> param) {
        return mapper.selectScrStatlist(param);
    }
    //미등록 화면 조회
    public List<HashMap<Object, Object>> selectNonRegScrlist(Map<Object, Object> param) {
        return mapper.selectNonRegScrlist(param);
    }

}
