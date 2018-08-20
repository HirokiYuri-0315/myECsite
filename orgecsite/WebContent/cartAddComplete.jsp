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
	<script type="text/javascript" src="./footerFixed.js"></script>

<title>カート処理完了</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div id="main">
		<div id="top">
			<p>カート追加完了画面</p>
		</div>
		<h3>商品がカートに追加されました。</h3>
		<br>
		<br>
		<a href='<s:url action="GoCartAction" />'>カートの中身を確認する</a>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>