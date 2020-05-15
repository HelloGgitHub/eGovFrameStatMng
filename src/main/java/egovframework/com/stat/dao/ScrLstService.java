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
}
