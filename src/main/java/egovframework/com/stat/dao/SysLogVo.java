package egovframework.com.stat.dao;

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
	public String getSvcNm() {
		return svcNm;
	}
	public void setSvcNm(String svcNm) {
		this.svcNm = svcNm;
	}
	public String getMethodNm() {
		return methodNm;
	}
	public void setMethodNm(String methodNm) {
		this.methodNm = methodNm;
	}
	public String getProcessSeCode() {
		return processSeCode;
	}
	public void setProcessSeCode(String processSeCode) {
		this.processSeCode = processSeCode;
	}
	public String getProcessTime() {
		return processTime;
	}
	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}
	public String getErrorSe() {
		return errorSe;
	}
	public void setErrorSe(String errorSe) {
		this.errorSe = errorSe;
	}
	public int getErrorCo() {
		return errorCo;
	}
	public void setErrorCo(int errorCo) {
		this.errorCo = errorCo;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
    
    


}
