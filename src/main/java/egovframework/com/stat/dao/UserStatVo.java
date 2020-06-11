package egovframework.com.stat.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * @title : 이용자통계VO
 * @package : egovframework.com.stat.dao
 * @filename : UserStatVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 이용자통계VO
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
public class UserStatVo {

    private String id;
    private String occrrncDt;
    private String hostName;
    private String usrId;

}
