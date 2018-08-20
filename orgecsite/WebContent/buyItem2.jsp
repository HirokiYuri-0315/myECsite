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

	<title>購入画面</title>


</head>

<body>

	<jsp:include page="header.jsp" />


	<div id="main">
		<div id="top">
			<p>購入画面</p>
		</div>
		<div>
			<div id="error">
				<s:if test='errorMessage != ""'>	<!-- 追加 -->
					<h4><s:property value="errorMessage" escape="false" /></h4>
				</s:if>
			</div>

			<div id="form-frame">
			<s:form action="BuyItemAction">
				<table id="buy_item">
					<tr>
						<td colspan="2" align="center">
							<div id="buy_item_box"><img id="buy_item_image" src="<s:property value='#session.buyImageFilePath'/>/<s:property value='#session.buyImageFileName'/>"></div>
						</td>
					</tr>
					<tr>
						<td>
							<span>商品名</span>
						</td>
						<td>
							<s:property value="session.buyItemName" /><br>
						</td>
					</tr>
					<tr>
						<td>
							<span>値段</span>
						</td>
						<td>
							<s:property value="session.buyItemPrice"/><span>円</span>
						</td>
					</tr>
					<tr>
						<td>
							<span>購入個数</span>
						</td>
						<td>
							<select name="count">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<span>支払い方法</span>
						</td>
						<td>
							<input type="radio" name="pay" value="1" checked="checked">現金払い
							<input type="radio" name="pay" value="2">クレジットカード
						</td>
					</tr>
				</table>
				<div id="common_btn_box">
					<s:submit value="購入"/>
				</div>
			</s:form>
			</div>

			<div>
<%-- 				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p> --%>
				<p>マイページは<a href='<s:url action="MyPageAction2"/>'>こちら</a></p>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>