package egovframework.com.stat.dao;

/**
 * @title : 성과지표관리VO
 * @package : egovframework.com.stat.dao
 * @filename : ResultMngVo.java
 * @author : "egov"
 * @since : 2020. 6. 11.
 * @version : 1.0
 * @desc : 성과지표관리VO
 *
 *  ======= 변경이력 =======
 *
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 11.         "egov"           최초 생성(ver 1.0)
 *
 */

public class ResultMngVo {

    private String id;
    private String resultIndexNm;
    private String resultIndexDc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getResultIndexNm() {
		return resultIndexNm;
	}
	public void setResultIndexNm(String resultIndexNm) {
		this.resultIndexNm = resultIndexNm;
	}
	public String getResultIndexDc() {
		return resultIndexDc;
	}
	public void setResultIndexDc(String resultIndexDc) {
		this.resultIndexDc = resultIndexDc;
	}
    
    

}
