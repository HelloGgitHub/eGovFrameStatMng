package egovframework.com.stat.service;


import egovframework.com.stat.dao.ServerInfoDao;
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

    //시스템정보 목록 조회
    public List<HashMap<Object, Object>> selectServerInfoList(Map<Object, Object> param) {
        return mapper.selectServerInfoList(param);
    }
    //시스템정보 조회
    public List<HashMap<Object, Object>> selectServerDetailInfo(Map<Object, Object> param) {
        return mapper.selectServerDetailInfo(param);
    }
    //시스템정보 등록
    public int insertServerDetailInfo(Map<Object, Object> param) {
        return mapper.insertServerDetailInfo(param);
    }
    //시스템정보 수정
    public int updateServerDetailInfo(Map<Object, Object> param) {
        return mapper.updateServerDetailInfo(param);
    }
    //시스템정보 삭제
    public int deleteServerInfo(Map<Object, Object> param) {
        return mapper.deleteServerInfo(param);
    }

    //미등록 시스템정보 목록 조회
    public List<HashMap<Object, Object>> selectNonRegServerInfoList(Map<Object, Object> param) {
        return mapper.selectNonRegServerInfoList(param);
    }


}
