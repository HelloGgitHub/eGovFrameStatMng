package egovframework.com.stat.dao;

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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getServerNm() {
		return serverNm;
	}
	public void setServerNm(String serverNm) {
		this.serverNm = serverNm;
	}
	public String getServerKnd() {
		return serverKnd;
	}
	public void setServerKnd(String serverKnd) {
		this.serverKnd = serverKnd;
	}
	public String getRgsDe() {
		return rgsDe;
	}
	public void setRgsDe(String rgsDe) {
		this.rgsDe = rgsDe;
	}
	public String getOperSysmInfo() {
		return operSysmInfo;
	}
	public void setOperSysmInfo(String operSysmInfo) {
		this.operSysmInfo = operSysmInfo;
	}
	public String getCpuInfo() {
		return cpuInfo;
	}
	public void setCpuInfo(String cpuInfo) {
		this.cpuInfo = cpuInfo;
	}
	public String getMoryInfo() {
		return moryInfo;
	}
	public void setMoryInfo(String moryInfo) {
		this.moryInfo = moryInfo;
	}
	public String getHdDisk() {
		return hdDisk;
	}
	public void setHdDisk(String hdDisk) {
		this.hdDisk = hdDisk;
	}
	public String getEtcInfo() {
		return etcInfo;
	}
	public void setEtcInfo(String etcInfo) {
		this.etcInfo = etcInfo;
	}
	public String getChargerNm() {
		return chargerNm;
	}
	public void setChargerNm(String chargerNm) {
		this.chargerNm = chargerNm;
	}
	public String getServerDc() {
		return serverDc;
	}
	public void setServerDc(String serverDc) {
		this.serverDc = serverDc;
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
