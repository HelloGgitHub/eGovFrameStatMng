<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="EUC-KR">
<title>Egov Framework</title>
	<frameset rows="100,*" frameborder="1">
		<frame src="./FrameTop" name="top" />
		<frameset cols="200,*" frameborder="1">
			<frame src="./FrameLeft" name="left" />
			<frame src="./DashBoard" name="body" />
		</frameset>
</frameset>
<script type="text/javascript">
	var loginCk = "8";
</script>
</head>
<body>
	<input type="hidden" id="lngCk" name="lngCk" value="8" />
</body>
</html>




