package egovframework.com.stat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title : 화면정보관리DAO
 * @package : egovframework.com.stat.dao
 * @filename : ScrLstDao.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 화면정보관리DAO
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
