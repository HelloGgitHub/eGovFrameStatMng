package egovframework.com.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserLoginService {
	
	@Autowired
    private UserLoginDao mapper;
	
	//상세정보 조회
	public HashMap<Object, Object> selectUserDetailMaria(Map<Object, Object> param) {
        return mapper.selectUserDetailMaria(param);
    }
 
	//사용자 pw체크
	public int selectUserPwCkMaria(Map<Object, Object> param) {
        return mapper.selectUserPwCkMaria(param);
    }
}
