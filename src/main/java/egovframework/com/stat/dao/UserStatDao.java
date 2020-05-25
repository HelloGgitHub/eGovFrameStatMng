package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserStatDao {

    List<HashMap<Object, Object>> selectUserStatList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectActiveUserList(Map<Object, Object> param);

    int insertUserStat(Map<Object, Object> param);
}
