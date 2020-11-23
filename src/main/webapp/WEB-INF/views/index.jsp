<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/public/css/app.css" rel = "stylesheet"/>
<script src="/public/js/app.js" defer></script>
<title>Insert title here</title>

</head>
<body>

<!-- <div id="app" data-page='{
						"component":"home",
						"url":"/",
						"props":{"name":"heydar"}
						}'
>
</div> -->

<div>
	${page}
</div>

<div id="app" data-page='${page}'>

</div>

</body>
</html>