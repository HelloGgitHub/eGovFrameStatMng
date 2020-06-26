package egovframework.com.stat.dao;

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
	public String getlFncNm() {
		return lFncNm;
	}
	public void setlFncNm(String lFncNm) {
		this.lFncNm = lFncNm;
	}
	public String getmFncNm() {
		return mFncNm;
	}
	public void setmFncNm(String mFncNm) {
		this.mFncNm = mFncNm;
	}
	public String getsFncNm() {
		return sFncNm;
	}
	public void setsFncNm(String sFncNm) {
		this.sFncNm = sFncNm;
	}
	public String getDetailFncNm() {
		return detailFncNm;
	}
	public void setDetailFncNm(String detailFncNm) {
		this.detailFncNm = detailFncNm;
	}
	public String getMethodNm() {
		return methodNm;
	}
	public void setMethodNm(String methodNm) {
		this.methodNm = methodNm;
	}
	public String getFrstRegisterId() {
		return frstRegisterId;
	}
	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}
    
    
}
