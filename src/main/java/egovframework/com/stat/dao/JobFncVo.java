package egovframework.com.stat.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * @title : 업무기능관리VO
 * @package : egovframework.com.stat.dao
 * @filename : JobFncVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 업무기능관리VO
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */
@Setter
@Getter
public class JobFncVo {

    private String id;
    private String hostName;
    private String lFncNm;
    private String mFncNm;
    private String sFncNm;
    private String detailFncNm;
    private String methodNm;
    private String frstRegisterId;
    private String lastUpdusrId;
}
