<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="EUC-KR">
<title>�����ý��� ���</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="/css/egovframework/com/com.css">

<script src="/js/egovframework/com/cmm/jquery-1.4.2.min.js"></script>
<script type="text/javaScript" language="javascript" defer="defer">
var grdVal;

$(document).ready(function(){
	fn_Select();
});

function fn_Select(){
	
	$("#grd").empty();
	
    $.ajax({
        type : "GET", //���۹���� �����Ѵ� (POST,GET)
        url : "http://localhost:9088/api/serverInfo/list",//ȣ�� URL�� �����Ѵ�. GET����ϰ�� �ڿ� �Ķ�Ƽ�͸� �ٿ��� ����ص��ȴ�.
        dataType : "text",//ȣ���� �������� �����̴�. xml,json,html,text���� ���� ����� ����� �� �ִ�.
        error : function(){    //error: whenError
            alert("��Ž���!!!!");
        },
        success : function(data){    //success: whenSuccess,
        	console.log(data);
        	
        	const obj = JSON.parse(data)
        	var arr = obj.list;

         	var ihtml = '';
         	ihtml = ihtml + '<table class="board_list" summary="�Ϲ�ȸ�������� ������ ���� ����� ����մϴ�.">';
         	ihtml = ihtml + '<colgroup><col style="width: 5%;"><col style="width: 20%;"><col style="width: 20%;"><col style="width: 35%;"><col style="width: 20%;"></colgroup>';
         	ihtml = ihtml + '<thead>';
         	ihtml = ihtml + '<tr>';
         	ihtml = ihtml + '<th>��ȣ</th>';         	
         	ihtml = ihtml + '<th class="board_th_link">�����ý��۸�</th>';
         	ihtml = ihtml + '<th>HOSTNAME</th>';
         	ihtml = ihtml + '<th>�����ý��� ����</th>';
         	ihtml = ihtml + '<th>�������</th>';
         	ihtml = ihtml + '</tr>';
         	ihtml = ihtml + '</thead>';
         	ihtml = ihtml + '<tbody class="ov">';
        	
        	for(var i =0; arr.length > i; i++){
        		
        		if( $("#sbscrbSttus").val() == "0" || $("#sbscrbSttus").val() == arr[i].sttus){	
	        	 	ihtml = ihtml + '<tr>';
	        	 	ihtml = ihtml + '<td>' + (i+1) + '</td>';
// 	        	 	ihtml = ihtml + '<td><button onclick="fn_SelectServer(\''+arr[i].id+'\')">'+arr[i].serverNm+'</button></td>';
	        	 	ihtml = ihtml + '<td><a href="" onClick="fn_SelectServer(\''+arr[i].id+'\')"; title="ȭ������ ����" style="font-size: 15px;font-style: inherit;font-weight: bold";>'+arr[i].serverNm+'</a></td>';
	        	 	ihtml = ihtml + '<td id="hostName">'+arr[i].hostName+'</td>';
	        	 	ihtml = ihtml + '<td id="serverDc">'+arr[i].serverDc+'</td>';
	        	 	ihtml = ihtml + '<td>'+arr[i].rgsDe+'</td>';

	        	 	ihtml = ihtml + '</tr>';
        		}
            }

         	ihtml = ihtml + '</tbody>';
         	ihtml = ihtml + '</table>';
         	
        	var grd = document.getElementById("grd");
        	grd.innerHTML = ihtml;
        }
    });
}

function fn_SelectServer(id){
	alert(id);
	//location.href="http://localhost:9085/UserInfo?callType=r&userId="+userId;
}


function fn_DeleteUser(){
	var ckId = new Array();
	ckId = checkFieldck();
	
	for(var i=0; ckId.length > i; i++){
		var userId = ckId[i];
		console.log(ckId.length + "===" +ckId[i] );
	    $.ajax({
	        type : "DELETE", //���۹���� �����Ѵ� (POST,GET)
	        url : "http://localhost:9085/user/deleteUsr?userId="+userId,//ȣ�� URL�� �����Ѵ�. GET����ϰ�� �ڿ� �Ķ�Ƽ�͸� �ٿ��� ����ص��ȴ�.
	        dataType : "text",//ȣ���� �������� �����̴�. xml,json,html,text���� ���� ����� ����� �� �ִ�.
	        error : function(){    //error: whenError
	            alert("��Ž���!!!!");
	        },
	        success : function(data){    //success: whenSuccess,
	        	console.log("delete Data::"+data);
	        	fn_Select();
	        }
	    });
	}
}

function checkFieldck(){
	var rowData = new Array();
	var checkbox = $("input[name=checkField]:checked");
	
	checkbox.each(function(i) {
		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();
		var id = td.eq(2).text();
		rowData.push(id);
	});
	console.log("rowData : " + rowData);
	
	return rowData;
}

function fn_ArovUser(){
	location.href="http://localhost:9085/UserInfo?callType=c&userId=";
}
</script>
</head>
<body>
<!-- javascript warning tag  -->
<noscript class="noScriptTitle">�ڹٽ�ũ��Ʈ�� �������� �ʴ� ������������ �Ϻ� ����� ����Ͻ� �� �����ϴ�.</noscript>
<div class="board">
	<h1>�����ý��� ���</h1>
	<!-- �˻����� -->
	<div class="search_box" title="�� ���̾ƿ��� �ϴ� ������ ���� �˻� ������ �����Ǿ� �ֽ��ϴ�.">
		<ul>
			<li><!-- ���� -->
                �����ý��� ��
			</li>
			<!-- �˻�Ű���� �� ��ȸ��ư -->
			<li>
				<input class="s_input" name="searchKeyword" type="text"  size="35" title="�˻��� �Է�" value=''  maxlength="255" >
				<input type="button" class="s_btn" onClick="fn_Select();" value="��ȸ" title="��ȸ ��ư" />
<!-- 				<input type="button" class="s_btn" onClick="fn_DeleteUser();" value="����" title="���� ��ư" /> -->
				<input type="button" class="s_btn" onClick="fn_ArovUser();" value="���" title="��� ��ư" />
<!-- 				<span class="btn_b"><a href="/egovframework-all-in-one/uss/umt/EgovMberInsertView.do" onClick="fnAddUserView(); return false;"  title="��� ��ư">���</a></span> -->
			</li>
		</ul>
	</div>

	<div id="grd"></div>
	<!-- paging navigation -->
	<div class="pagination">
		<ul>
			<li class="current"><a onClick="return false;">1</a></li>
		</ul>
	</div>
</div>
<input name="selectedId" type="hidden" />
<input name="checkedIdForDel" type="hidden" />
<input name="pageIndex" type="hidden" value="1"/>
</body>
</html>




