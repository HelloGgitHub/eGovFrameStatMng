package egovframework.com.stat.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserStatService {

    @Autowired
    private UserStatDao mapper;

    //웹로그 목록 조회
    public List<HashMap<Object, Object>> selectUserStatList(Map<Object, Object> param) {
        return mapper.selectUserStatList(param);
    }
    //웹로그 목록 조회
    public List<HashMap<Object, Object>> selectActiveUserList(Map<Object, Object> param) {
        return mapper.selectActiveUserList(param);
    }

    //웹로그 등록
    public int insertUserStat(Map<Object, Object> param) {
        return mapper.insertUserStat(param);
    }
}
