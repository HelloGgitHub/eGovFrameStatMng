<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="EUC-KR">
<title>업무시스템 목록</title>
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
        type : "GET", //전송방식을 지정한다 (POST,GET)
        url : "http://localhost:9088/api/serverInfo/list",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
        dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
        error : function(){    //error: whenError
            alert("통신실패!!!!");
        },
        success : function(data){    //success: whenSuccess,
        	console.log(data);
        	
        	const obj = JSON.parse(data)
        	var arr = obj.list;

         	var ihtml = '';
         	ihtml = ihtml + '<table class="board_list" summary="일반회원관리의 내역에 대한 목록을 출력합니다.">';
         	ihtml = ihtml + '<colgroup><col style="width: 5%;"><col style="width: 20%;"><col style="width: 20%;"><col style="width: 35%;"><col style="width: 20%;"></colgroup>';
         	ihtml = ihtml + '<thead>';
         	ihtml = ihtml + '<tr>';
         	ihtml = ihtml + '<th>번호</th>';         	
         	ihtml = ihtml + '<th class="board_th_link">업무시스템명</th>';
         	ihtml = ihtml + '<th>HOSTNAME</th>';
         	ihtml = ihtml + '<th>업무시스템 설명</th>';
         	ihtml = ihtml + '<th>등록일자</th>';
         	ihtml = ihtml + '</tr>';
         	ihtml = ihtml + '</thead>';
         	ihtml = ihtml + '<tbody class="ov">';
        	
        	for(var i =0; arr.length > i; i++){
        		
        		if( $("#sbscrbSttus").val() == "0" || $("#sbscrbSttus").val() == arr[i].sttus){	
	        	 	ihtml = ihtml + '<tr>';
	        	 	ihtml = ihtml + '<td>' + (i+1) + '</td>';
// 	        	 	ihtml = ihtml + '<td><button onclick="fn_SelectServer(\''+arr[i].id+'\')">'+arr[i].serverNm+'</button></td>';
	        	 	ihtml = ihtml + '<td><a href="" onClick="fn_SelectServer(\''+arr[i].id+'\')"; title="화면정보 관리" style="font-size: 15px;font-style: inherit;font-weight: bold";>'+arr[i].serverNm+'</a></td>';
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
	        type : "DELETE", //전송방식을 지정한다 (POST,GET)
	        url : "http://localhost:9085/user/deleteUsr?userId="+userId,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
	        dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
	        error : function(){    //error: whenError
	            alert("통신실패!!!!");
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
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>
<div class="board">
	<h1>업무시스템 목록</h1>
	<!-- 검색영역 -->
	<div class="search_box" title="이 레이아웃은 하단 정보를 대한 검색 정보로 구성되어 있습니다.">
		<ul>
			<li><!-- 조건 -->
                업무시스템 명
			</li>
			<!-- 검색키워드 및 조회버튼 -->
			<li>
				<input class="s_input" name="searchKeyword" type="text"  size="35" title="검색어 입력" value=''  maxlength="255" >
				<input type="button" class="s_btn" onClick="fn_Select();" value="조회" title="조회 버튼" />
<!-- 				<input type="button" class="s_btn" onClick="fn_DeleteUser();" value="삭제" title="삭제 버튼" /> -->
				<input type="button" class="s_btn" onClick="fn_ArovUser();" value="등록" title="등록 버튼" />
<!-- 				<span class="btn_b"><a href="/egovframework-all-in-one/uss/umt/EgovMberInsertView.do" onClick="fnAddUserView(); return false;"  title="등록 버튼">등록</a></span> -->
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




