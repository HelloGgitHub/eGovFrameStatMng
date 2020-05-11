package egovframework.com.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserLoginDao {
	
	//상세정보 조회
	HashMap<Object, Object> selectUserDetailMaria(Map<Object, Object> param);
	
	int selectUserPwCkMaria(Map<Object, Object> param);
    
}
