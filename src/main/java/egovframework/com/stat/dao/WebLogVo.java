package egovframework.com.stat.dao;

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

public class WebLogVo {

    private String id;
    private String hostName;
    private String occrrncDe;
    private String url;
    private String rqesterId;
    private String rqesterIp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getOccrrncDe() {
		return occrrncDe;
	}
	public void setOccrrncDe(String occrrncDe) {
		this.occrrncDe = occrrncDe;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRqesterId() {
		return rqesterId;
	}
	public void setRqesterId(String rqesterId) {
		this.rqesterId = rqesterId;
	}
	public String getRqesterIp() {
		return rqesterIp;
	}
	public void setRqesterIp(String rqesterIp) {
		this.rqesterIp = rqesterIp;
	}
    
    
}
