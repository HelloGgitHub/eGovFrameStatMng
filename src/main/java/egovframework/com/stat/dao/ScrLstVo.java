package egovframework.com.stat.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * @title : 화면정보관리VO
 * @package : egovframework.com.stat.dao
 * @filename : ScrLstVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 화면정보관리VO
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
public class ScrLstVo {

    private String id;
    private String hostName;
    private String scrNm;
    private String scrDc;
    private String url;
    private String frstRegisterId;
    private String lastUpdusrId;

}
