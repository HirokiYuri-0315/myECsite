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
<!--
	<script type="text/javascript" src="./footerFixed.js"></script>
 -->
	<title>購入内容確認</title>
	<script type="text/javascript">		/* 戻るボタンと完了ボタンで使う */
		function submitAction(url) {
			$('form').attr('action', url);
			$('form').submit();
		}
	</script>
</head>

<body>

	<jsp:include page="header.jsp" />

	<div id="main">
		<div id="top">
			<p>BuyItemConfirm</p>
		</div>
		<div>
			<s:form>
				<tr>
					<td>商品名</td>
					<td><s:property value="session.buyItemName"/></td>
				</tr>
				<tr>
					<td>値段</td>
					<td><s:property value="session.total_price"/><span>円</span></td>
				</tr>
				<tr>
					<td>購入個数</td>
					<td><s:property value="session.count"/><span>個</span></td>
				</tr>
				<tr>
					<td>支払い方法</td>
					<td><s:property value="session.pay"/></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><input type="button" value="戻る" onclick="submitAction('HomeAction')"/></td>	<!-- HomeAction => GoHomeAction -->
					<td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/></td>
				</tr>
			</s:form>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>