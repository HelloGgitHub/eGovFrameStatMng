package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 업무기능관리DAO
 * @package : egovframework.com.stat.dao
 * @filename : JobFncDao.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 업무기능관리DAO
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
public interface JobFncDao {

    List<HashMap<Object, Object>> selectJobFncList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectJobFncDetail(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectJobFncMethod(Map<Object, Object> param);

    int insertJobFncDetail(Map<Object, Object> param);

    int deleteJobFnc(Map<Object, Object> param);

    int updateJobFncDetail(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectJobFncStatList(Map<Object, Object> param);
    
    List<HashMap<Object, Object>> selectJobFncUseList(Map<Object, Object> param);
    
    List<HashMap<Object, Object>> selectJobFncUseDayList(Map<Object, Object> param);
    
    List<HashMap<Object, Object>> selectJobFncUseMonthList(Map<Object, Object> param);
    
    List<HashMap<Object, Object>> selectJobFncUseYearList(Map<Object, Object> param);
    


}
