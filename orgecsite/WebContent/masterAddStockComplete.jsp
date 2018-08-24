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

	<title>変更完了</title>

</head>

<body>

	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>在庫数変更完了画面</p>
		</div>
		<div>
			<br>
			<h3>在庫情報の変更が完了致しました。</h3>
			<br>
			<br>

			<div>
				<a href='<s:url action="GoMasterAction"/>'>管理画面へ</a>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>