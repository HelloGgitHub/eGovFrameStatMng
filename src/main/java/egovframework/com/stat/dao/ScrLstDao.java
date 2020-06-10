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

    List<HashMap<Object, Object>> selectScrDetail(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectScrUrl(Map<Object, Object> param);

    int insertScrDetail(Map<Object, Object> param);

    int updateScrDetail(Map<Object, Object> param);

    int deleteScrDetail(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectScrStatlist(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectNonRegScrlist(Map<Object, Object> param);
}
