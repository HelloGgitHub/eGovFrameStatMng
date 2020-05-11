package egovframework.com.stat.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ServerInfoService {


    @Autowired
    private ServerInfoDao mapper;

    //회원목록 조회
    public List<HashMap<Object, Object>> selectServerInfoList(Map<Object, Object> param) {
        return mapper.selectServerInfoList(param);
    }
}
