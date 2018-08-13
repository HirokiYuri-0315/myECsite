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

<title>決済確認画面</title>
</head>
<body>

	<jsp:include page="header.jsp" />


	<div id="main">
		<div id="top">
			<p><s:property value="#session.login_user_name"/>さんのカート情報</p>
		</div>
		<div>

			<s:if test='checkEmpty=="true"'>
				<h3>カート情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>カートの中身を確認してください。</h3>
				<table border="1" id="mypage_table">
					<tr>
						<th>商品画像</th>
						<th>商品名</th>
						<th>発売元</th>
						<th>購入個数</th>
						<th>小計金額</th>
						<th>支払い方法</th>
						<th>カートに入れた日時</th>
					</tr>
					<s:iterator value="cartInfoDTOList">
						<tr>
							<td><div id="mypage_item_image_box">
							<a href='<s:url action="SelectItemAction">
								<s:param name="buyOrInfo" value="1"></s:param>
								<s:param name="buyId" value="%{itemId}"/></s:url>'>
								<img id="mypage_item_image" src="<s:property value='imageFilePath'/>/<s:property value='imageFileName'/>">
							</a>
							</div></td>
							<td><s:property value="itemName" /></td>
							<td><s:property value="itemReleaseCompany" /></td>
							<td><s:property value="subtotalCount" /><span>個</span></td>
							<td><s:property value="subtotalPrice" /><span>円</span></td>
							<td><s:property value="payment" /></td>
							<td><s:property value="insertDate" /></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="CartSettleConfirmAction">
					<s:submit value="決済を完了する" method="execute" />		<!-- 変更済み -->
				</s:form>
			</s:elseif>

			<s:if test="message != null">
				<h3><s:property value="message"/></h3>
			</s:if>
<!-- 			<div id="text-right"> -->
<%-- 				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p> --%>
<%-- 				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a></p> --%>
<!-- 			</div> -->
		</div>
	</div>


	<jsp:include page="footer.jsp" />

</body>
</html>