package egovframework.com.stat.dao;


import lombok.Getter;
import lombok.Setter;

/**
 * @title : 시스템로그VO
 * @package : egovframework.com.stat.dao
 * @filename : SysLogVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 시스템로그VO
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
public class SysLogVo {

    private String id;
    private String hostName;
    private String occrrncDe;
    private String rqesterId;
    private String rqesterIp;
    private String svcNm;
    private String methodNm;
    private String processSeCode;
    private String processTime;
    private String errorSe;
    private int errorCo;
    private String errorCode;


}
