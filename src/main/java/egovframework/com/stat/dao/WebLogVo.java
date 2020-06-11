package egovframework.com.stat.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * @title : 웹로그관리VO
 * @package : egovframework.com.stat.dao
 * @filename : WebLogVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 웹로그관리VO
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
public class WebLogVo {

    private String id;
    private String hostName;
    private String occrrncDe;
    private String url;
    private String rqesterId;
    private String rqesterIp;
}
