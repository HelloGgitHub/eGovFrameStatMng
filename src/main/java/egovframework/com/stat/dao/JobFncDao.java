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

    List<HashMap<Object, Object>> selectJobFncDetail(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectJobFncMethod(Map<Object, Object> param);


    int insertJobFncDetail(Map<Object, Object> param);

    int deleteJobFnc(Map<Object, Object> param);

    int updateJobFncDetail(Map<Object, Object> param);


}
