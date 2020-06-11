package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 성과지표관리DAO
 * @package : egovframework.com.stat.dao
 * @filename : ResultMngDao.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 성과지표관리DAO
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
public interface ResultMngDao {

    List<HashMap<Object, Object>> selectResultIndexList(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectResultIndexDetail(Map<Object, Object> param);

    List<HashMap<Object, Object>> selectResultIndexNm(Map<Object, Object> param);

    int insertResultIndex(Map<Object, Object> param);

    int updateResultIndex(Map<Object, Object> param);

    int deleteResultIndex(Map<Object, Object> param);
}
