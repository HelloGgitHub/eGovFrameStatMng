package egovframework.com.stat.service;


import egovframework.com.stat.dao.ServerInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 업무시스템관리
 * @package : egovframework.com.stat.service
 * @filename : ServerInfoService.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 업무시스템관리에 필요한 api를 restful형태로 제공한다.
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
public class ServerInfoService {


    @Autowired
    private ServerInfoDao mapper;

    //시스템정보 목록 조회
    public List<HashMap<Object, Object>> selectServerInfoList(Map<Object, Object> param) {
        return mapper.selectServerInfoList(param);
    }
    //시스템정보 상세조회
    public List<HashMap<Object, Object>> selectServerDetailInfo(Map<Object, Object> param) {
        return mapper.selectServerDetailInfo(param);
    }
    //시스템정보 조회
    public List<HashMap<Object, Object>> selectServerInfo(Map<Object, Object> param) {
        return mapper.selectServerInfo(param);
    }
  //시스템정보 조회
    public List<HashMap<Object, Object>> selectServerDetail(Map<Object, Object> param) {
        return mapper.selectServerDetail(param);
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
