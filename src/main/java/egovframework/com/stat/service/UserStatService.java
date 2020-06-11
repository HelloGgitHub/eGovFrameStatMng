package egovframework.com.stat.service;

import egovframework.com.stat.dao.UserStatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 이용자통계 관리
 * @package : egovframework.com.stat.service
 * @filename : UserStatService.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 이용자통계 관리에 필요한 api를 restful형태로 제공한다.
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
