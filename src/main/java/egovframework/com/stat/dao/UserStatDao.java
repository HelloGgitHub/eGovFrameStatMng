package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 이용자통계DAO
 * @package : egovframework.com.stat.dao
 * @filename : UserStatVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 이용자통계DAO
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
public interface UserStatDao {

    List<HashMap<Object, Object>> selectUserStatList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectActiveUserList(Map<Object, Object> param);

    int insertUserStat(Map<Object, Object> param);
}
