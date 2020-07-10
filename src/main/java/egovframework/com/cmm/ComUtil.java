package egovframework.com.cmm;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @title : [공통] Util
 * @package : egovframework.com.cmm
 * @filename : ComUtil.java
 * @author : "egov"
 * @since : 2020. 6. 12.
 * @version : 1.0
 * 
 *  ======= 변경이력 =======
 * 
 * 날자                       변경자                  설명
 * ----------         -------           ------------------------------------
 * 2020. 6. 12.         "egov"           최초 생성(ver 1.0)
 * 
 */
public class ComUtil {

	/**
	 * @name : listforPaging
	 * @date : 2020. 6. 12.
	 * @author : "egov"
	 * @return_type : List<Object>
	 * @desc : List값을 받아서 페이지 표기 항목 갯수만큼 페이징 처리
	 */
	public List<Object> listforPaging(Object pLst, int page, int pageSize){
		List<Object> reLst = new ArrayList<Object>();
		List<Object> pArrayList = (ArrayList<Object>)pLst;  
		
		if((pArrayList.size()/pageSize)+1 < page) {
			return reLst;
		}
		
		int getPage = 0;
		if(page == 1) {
			getPage = 0;
		}else {
			getPage = (page-1)*pageSize;
		}
		
		for(int i = 0; pageSize > i; i++) {
			if(getPage == pArrayList.size()) {break;}
			reLst.add(i, pArrayList.get(getPage));
			
			getPage++;
		}
		
		return reLst;
	}
	
	
	public static String getTime(String param) {
		String rtn = "";
		SimpleDateFormat sdf = new SimpleDateFormat(param);
        long timeInMillis =System.currentTimeMillis();

        Date timeInDate = new Date(timeInMillis);
        rtn = sdf.format(timeInDate);
        
        return rtn;
	}
	
	public static boolean isEmpty(Object obj) {
			
			if(obj instanceof String) return obj == null || "".equals(obj.toString().trim());
			else if(obj instanceof List) return obj == null || ((List)obj).isEmpty();
			else if(obj instanceof Map) return obj == null || ((Map)obj).isEmpty();
			else if(obj instanceof Object[]) return obj == null || Array.getLength(obj) == 0;
			else return obj == null;
	
	}
	
	/**
	 * <pre>
	 * 입력문자열이 숫자형인지 체크한다.
	 * </pre>
	 * @param str 체크문자열
	 * @return 숫자형:TRUE, 그외:FALSE
	 */
	public static boolean isNumeric(String str) {
		return str.matches("[-+]?\\d*\\.?\\d+");
	}
	
	
	public static int getByteLength(String str) {

		int strLength = 0;
		char tempChar[] = new char[str.length()];

		for (int i = 0; i < tempChar.length; i++) {
			tempChar[i] = str.charAt(i);
			if (tempChar[i] < 128) {
				strLength++;
			} else {
				strLength += 2;
			}
		}
		
		return strLength;

	}
	
}
