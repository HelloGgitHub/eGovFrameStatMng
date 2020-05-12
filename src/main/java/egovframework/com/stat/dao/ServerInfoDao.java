package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ServerInfoDao {

    List<HashMap<Object, Object>> selectServerInfoList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectServerDetailInfo(Map<Object, Object> param);

    int insertServerDetailInfo(Map<Object, Object> param);

    int updateServerDetailInfo(Map<Object, Object> param);

}
