package egovframework.com.stat.dao;

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

    //화면 목록 조회
    public List<HashMap<Object, Object>> selectScrList(Map<Object, Object> param) {
        return mapper.selectScrList(param);
    }
    //화면 조회
    public List<HashMap<Object, Object>> selectScrDetail(Map<Object, Object> param) {
        return mapper.selectScrDetail(param);
    }
    //화면중복 조회
    public List<HashMap<Object, Object>> selectScrUrl(Map<Object, Object> param) {
        return mapper.selectScrUrl(param);
    }
    //화면 등록
    public int insertScrDetail(Map<Object, Object> param) {
        return mapper.insertScrDetail(param);
    }
    //업무기능 수정
    public int updateScrDetail(Map<Object, Object> param) {
        return mapper.updateScrDetail(param);
    }
    //업무기능 삭제
    public int deleteScrDetail(Map<Object, Object> param) {
        return mapper.deleteScrDetail(param);
    }
}
