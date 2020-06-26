package egovframework.com.stat.dao;

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

public class UserStatVo {

    private String id;
    private String occrrncDt;
    private String hostName;
    private String usrId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOccrrncDt() {
		return occrrncDt;
	}
	public void setOccrrncDt(String occrrncDt) {
		this.occrrncDt = occrrncDt;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
    
    

}
