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
	<span class="btn_b"><a href="" onClick="fn_leftMenu(1);"  title="��ú���" style="font-size: 15px;font-style: inherit;font-weight: bold;">- ��ú��� </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(2);"  title="�����ý���  ����" style="font-size: 15px;font-style: inherit;font-weight: bold;">- �����ý��� ���� </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(3);"  title="������� ����" style="font-size: 15px;font-style: inherit;font-weight: bold;">- ������� ���� </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(4);"  title="ȭ������ ����" style="font-size: 15px;font-style: inherit;font-weight: bold;">- ȭ������ ���� </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(5);"  title="ȭ�� ��ȸ ���" style="font-size: 15px;font-style: inherit;font-weight: bold;">- ȭ�� ��ȸ ��� </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(6);"  title="���� ��ǥ ����" style="font-size: 15px;font-style: inherit;font-weight: bold;">- ���� ��ǥ ���� </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(7);"  title="�̿��� �� ��ȸ" style="font-size: 15px;font-style: inherit;font-weight: bold;">- �̿��� �� ��ȸ  </a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(8);"  title="�̿��� ���� ��� ��ȸ" style="font-size: 15px;font-style: inherit;font-weight: bold;">- �̿��� ���� ��� ��ȸ</a></span>
	<br>
	<span class="btn_b"><a href="" onClick="fn_leftMenu(9);"  title="�ڿ������� ��ȸ" style="font-size: 15px;font-style: inherit;font-weight: bold;">- �ڿ������� ��ȸ</a></span>
	
</body>
</html>