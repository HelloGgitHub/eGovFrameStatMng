package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface WebLogDao {

    List<HashMap<Object, Object>> selectWebLogList(Map<Object, Object> param);

    int insertWebLog(Map<Object, Object> param);
}
