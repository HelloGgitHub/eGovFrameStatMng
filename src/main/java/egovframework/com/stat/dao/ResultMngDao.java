package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface ResultMngDao {

    int insertSysLogSum(Map<Object, Object> param);

    int insertWebLogSum(Map<Object, Object> param);
}
