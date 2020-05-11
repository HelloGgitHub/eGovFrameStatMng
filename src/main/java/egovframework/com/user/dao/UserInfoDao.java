package egovframework.com.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserInfoDao {
	
	//회원목록 조회
	List<HashMap<Object, Object>> selectUserListMaria(Map<Object, Object> param);
	List<HashMap<Object, Object>> selectUserListOracle(Map<Object, Object> param);
	
	//상세정보 조회
	List<HashMap<Object, Object>> selectUserDetailMaria(Map<Object, Object> param);
	List<HashMap<Object, Object>> selectUserDetailOracle(Map<Object, Object> param);
	
	//회원가입 신청
	int insertUserDetailMaria(Map<Object, Object> param);
	int insertUserDetailOracle(Map<Object, Object> param);
	
	//회원정보 변경
	int updateUserDetailMaria(Map<Object, Object> param);
	int updateUserDetailOracle(Map<Object, Object> param);
	
	//회원정보 삭제
	int deleteUserMaria(Map<Object, Object> param);
	int deleteUserOracle(Map<Object, Object> param);

	//회원가입 상태 변경
	int updateUserStateMaria(Map<Object, Object> param);
	int updateUserStateOracle(Map<Object, Object> param);

	
	
	int deleteData(HashMap<Object, Object> param) throws Exception;
    int updateData(HashMap<Object, Object> param) throws Exception;
    int insertData(HashMap<Object, Object> param) throws Exception;
    
}
