package egovframework.com.stat.dao;

import lombok.Getter;
import lombok.Setter;

/**
 * @title : 업무시스템VO
 * @package : egovframework.com.stat.dao
 * @filename : ServerInfoVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 업무시스템VO
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
public class ServerInfoVo {

    private String id;
    private String projectId;
    private String hostName;
    private String serverNm;
    private String serverKnd;
    private String rgsDe;
    private String operSysmInfo;
    private String cpuInfo;
    private String moryInfo;
    private String hdDisk;
    private String etcInfo;
    private String chargerNm;
    private String serverDc;
    private String frstRegisterId;
    private String lastUpdusrId;


}
