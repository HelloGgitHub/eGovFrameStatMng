package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface SysLogDao {

    List<HashMap<Object, Object>> selectSysLogList(Map<Object, Object> param);

    int insertSysLog(Map<Object, Object> param);
}
