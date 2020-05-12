package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface JobFncDao {

    List<HashMap<Object, Object>> selectJobFncList(Map<Object, Object> param);
}
