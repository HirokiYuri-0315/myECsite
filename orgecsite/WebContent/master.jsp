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
	<title>管理画面</title>

</head>

<body>

	<div id="main">
		<div id="top">
			<p>管理画面</p>
		</div>
		<div>


			<div id="pr">
				<p>商品の追加は<a href='<s:url action="GoMasterAddItemAction"/>'>こちら。</a></p>
				<br>
				<p>在庫の追加は<a href='<s:url action="GoMasterAddStockAction"/>'>こちら。</a></p>
				<br>
				<p>商品情報の編集は<a href='<s:url action="GoMasterUpdateItemInfoAction"/>'>こちら。</a></p>
				<br>
				<p>商品の削除は<a href='<s:url action="GoMasterDeleteItemAction"/>'>こちら。</a></p>
				<br>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>ここ。</a></p>
			</div>
		</div>
	</div>

	<jsp:include page="./footer.jsp"/>
</body>
</html>