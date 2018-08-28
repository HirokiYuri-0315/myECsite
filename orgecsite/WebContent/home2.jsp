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

	<title>Home画面2</title>


</head>

<body>
	<jsp:include page="./header.jsp"/>

	<div id="main">
		<div id="top">
			<p>Home</p>
		</div>
		<div id="text-center">
<%-- 			<s:form action="HomeAction"> --%>
<%-- 				<s:submit value="商品購入" /> --%>
<%-- 			</s:form> --%>
			<s:if test="#session.login_user_id != null">
				<h3>こんにちは、<s:property value="#session.login_user_name"/>さん。</h3><br>
			<br>
				<p>ログアウトする場合は
					<a href='<s:url action="LogoutAction" />'>こちら</a></p>
			</s:if>
			<s:if test="#session.login_user_id == null">
				<h3>こんにちは、ゲストさん。</h3><br>
				<br>
				<p>ログインは
					<a href='<s:url action="GoLoginAction" />'>こちら</a></p>
			</s:if>
		</div>
	</div>

	<jsp:include page="./footer.jsp"/>

</body>
</html>