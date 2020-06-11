package egovframework.com.stat.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * @title : 성과지표관리VO
 * @package : egovframework.com.stat.dao
 * @filename : ResultMngVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 성과지표관리VO
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */
@Getter
@Setter
public class ResultMngVo {

    private String id;
    private String resultIndexNm;
    private String resultIndexDc;

}
