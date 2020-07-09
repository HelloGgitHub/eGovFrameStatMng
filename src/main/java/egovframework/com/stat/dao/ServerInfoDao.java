package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 업무시스템VO
 * @package : egovframework.com.stat.dao
 * @filename : ServerInfoVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 업무시스템VO
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */
@Repository
@Mapper
public interface ServerInfoDao {

    List<HashMap<Object, Object>> selectServerInfoList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectServerDetailInfo(Map<Object, Object> param);
    
    List<HashMap<Object, Object>> selectServerInfo(Map<Object, Object> param);
    
    List<HashMap<Object, Object>> selectServerDetail(Map<Object, Object> param);    

    int insertServerDetailInfo(Map<Object, Object> param);

    int updateServerDetailInfo(Map<Object, Object> param);

    int deleteServerInfo(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectNonRegServerInfoList(Map<Object, Object> param);


}
