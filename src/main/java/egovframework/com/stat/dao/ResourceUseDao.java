package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 자원사용 통계DAO
 * @package : egovframework.com.stat.dao
 * @filename : ResourceUseDao.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 자원사용 통계DAO
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
public interface ResourceUseDao {

    List<HashMap<Object, Object>> selectResourceUseDayList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectResourceUseMonthList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectResourceUseYearList(Map<Object, Object> param);


}
