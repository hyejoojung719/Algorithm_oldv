<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.*,java.util.*"%>
<%
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String curTime = dateFormat.format(new Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재시간</title>
<style type="text/css">
div {
	font-size: 30px;
	color: skyblue;
}
</style>
</head>
<body>
<div>
<%= curTime %>
</div>
</body>
</html>

<script>
	fetch("URL 링크")
	.then((response) => {
		if(!response.ok){
			throw new Error("400 또는 500 에러 발생!!");
		}
		return response.json();
	})
	.then((result) => {
		console.log(result;)
	})
</script>