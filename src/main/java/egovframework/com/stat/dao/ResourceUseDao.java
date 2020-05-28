package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ResourceUseDao {

    List<HashMap<Object, Object>> selectResourceUseDayList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectResourceUseMonthList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectResourceUseYearList(Map<Object, Object> param);


}
