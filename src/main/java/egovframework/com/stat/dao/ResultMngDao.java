package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ResultMngDao {

    List<HashMap<Object, Object>> selectResultIndexList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectResultIndexDetail(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectResultIndexNm(Map<Object, Object> param);

    int insertResultIndex(Map<Object, Object> param);

    int updateResultIndex(Map<Object, Object> param);

    int deleteResultIndex(Map<Object, Object> param);
}
