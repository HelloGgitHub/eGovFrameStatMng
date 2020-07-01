<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="/css/egovframework/com/com.css">
	<script src="/js/egovframework/com/cmm/jquery-1.4.2.min.js"></script>
</head>

<script type="text/javascript">
	function fn_leftMenu(cd){
// 		alert(cd);
		var url="";
		if(cd == 1){
			url="DashBoard";
		}else if(cd == 2){

			if(parent.top.document.getElementById("lngCk") == ""){
				
			}
			url="ServerInfoList";
		}else if(cd == 3){
			url="JobFncList";
		}else if(cd == 4){
			url="ScrInfoList";
		}else if(cd == 5){
			url="ScrStatList";
		}else if(cd == 6){
			url="ResultIndexList";
		}else if(cd == 7){
			url="ActiveUserList";
		}else if(cd == 8){
			url="UserMonthStatList";
		}else if(cd == 9){
			url="ResourceUseStatList";
		}
		
		parent.body.location.href="./"+url;
			
	}

</script>

<body>
	<input type="hidden" id="" name="lngCk" value="9"/>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(1);"  title="대시보드" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 대시보드 </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(2);"  title="업무시스템  관리" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 업무시스템 관리 </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(3);"  title="업무기능 관리" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 업무기능 관리 </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(4);"  title="화면정보 관리" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 화면정보 관리 </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(5);"  title="화면 조회 통계" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 화면 조회 통계 </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(6);"  title="성과 지표 관리" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 성과 지표 관리 </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(7);"  title="이용자 수 조회" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 이용자 수 조회  </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(8);"  title="이용자 월별 통계 조회" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 이용자 월별 통계 조회</a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(9);"  title="자원사용통계 조회" style="font-size: 15px;font-style: inherit;font-weight: bold;">- 자원사용통계 조회</a></span>
	
</body>
</html>