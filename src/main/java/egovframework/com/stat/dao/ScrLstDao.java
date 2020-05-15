package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ScrLstDao {

    List<HashMap<Object, Object>> selectScrList(Map<Object, Object> param);
}
