package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 통계배치DAO
 * @package : egovframework.com.stat.dao
 * @filename : SysLogDao.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 통계배치DAO
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
public interface SummaryDao {

    int insertSysLogSummary();

    int insertWebLogSummary();

    int insertBatchHistory(Map<Object, Object> param);

    int updateBatchHistory(Map<Object, Object> param);

}
