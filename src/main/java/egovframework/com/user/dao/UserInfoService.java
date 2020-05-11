package egovframework.com.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoService {
	
	@Autowired
    private UserInfoDao mapper;
	
	//회원목록 조회
	public List<HashMap<Object, Object>> selectDataMaria(Map<Object, Object> param) {
        return mapper.selectUserListMaria(param);
    }
	public List<HashMap<Object, Object>> selectDataOracle(Map<Object, Object> param) {
        return mapper.selectUserListOracle(param);
    }
	
	//상세정보 조회
	public List<HashMap<Object, Object>> selectUserDetailMaria(Map<Object, Object> param) {
        return mapper.selectUserDetailMaria(param);
    }
	public List<HashMap<Object, Object>> selectUserDetailOracle(Map<Object, Object> param) {
        return mapper.selectUserDetailOracle(param);
    }

	//회원가입신청
	public int insertUserDetailMaria(Map<Object, Object> param) {
        return mapper.insertUserDetailMaria(param);
    }
	public int insertUserDetailOracle(Map<Object, Object> param) {
        return mapper.insertUserDetailOracle(param);
    }
 
	//회원정보 변경
	public int updateUserDetailMaria(Map<Object, Object> param) {
        return mapper.updateUserDetailMaria(param);
    }
	public int updateUserDetailOracle(Map<Object, Object> param) {
        return mapper.updateUserDetailOracle(param);
    }
	
	//회원정보 삭제
	public int deleteUserMaria(Map<Object, Object> param) {
        return mapper.deleteUserMaria(param);
    }
	public int deleteUserOracle(Map<Object, Object> param) {
        return mapper.deleteUserOracle(param);
    }

	//회원가입 상태 변경
	public int updateUserStateMaria(Map<Object, Object> param) {
        return mapper.updateUserStateMaria(param);
    }
	public int updateUserStateOracle(Map<Object, Object> param) {
        return mapper.updateUserStateOracle(param);
    }

	
    public int deleteData(HashMap<Object, Object> param) throws Exception {
        return mapper.deleteData(param);
    }

    public int insertData(HashMap<Object, Object> param) throws Exception {
        return mapper.insertData(param);
    }

    public int updateData(HashMap<Object, Object> param) throws Exception {
        return mapper.updateData(param);
    }
}
