<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link rel="stylesheet" href="./css/style.css">
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<!-- jQueryのやつ。 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="./js/footerFixed.js"></script>
<meta http-equiv="refresh" content="1;URL='LogoutAction'"/>
<title>index</title>
</head>
<body>

<div id="full_box">

	<div id="text-center">
		<h3>セッション情報をリセットしています</h3><br>
		<br>
		<h3>少々お待ちください･･･</h3>
		（自動的にページが切り替わります）
		<br>
		<p>切り替わらない場合は
					<a href='<s:url action="LogoutAction" />'>こちら</a></p>
	</div>

</div>
<div id="footer">
	<s:include value="footer.jsp"/>
</div>
</body>
</html>