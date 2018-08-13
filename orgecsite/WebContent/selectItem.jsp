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

	<title>商品選択</title>
</head>

<body>

	<jsp:include page="header.jsp" />

	<div id="main">
		<div id="top">
			<p>selectItem</p>
		</div>
		<div>
			<h3>商品の一覧を表示</h3>
			<s:form action="SelectItemAction" method="execute">
			<table border="1">
				<tr>
					<th>　</th><!--  -->
					<th>商品名</th>
					<th>値段</th>
					<th>在庫数</th>
				</tr>
				<s:iterator value="session.itemList">
					<tr>
						<td><input type="radio" name="buyId" value='<s:property value="id"/>'></td> <!--  -->
						<td><s:property value="itemName" /></td>
						<td><s:property value="itemPrice" /><span>円</span></td>
						<td><s:property value="itemStock" /><span>個</span></td>
					</tr>
				</s:iterator>
			</table>
			<select name="buyOrInfo">
				<option value="1" selected="selected">商品の詳細を見る</option>
				<option value="2">購入画面へ進む</option>
			</select>
			<input type="submit" value="GO">
			</s:form>
			<p class="red_bold">[!] 購入画面へ直接進んだ場合、商品画像が正しく表示されません。<br>
			「商品一覧」もしくは「商品の一覧を見る」を経由することを推奨します。</p>
			<div id="error">
				<s:if test='errorMessage != ""'>	<!-- 追加 -->
					<h4><s:property value="errorMessage" escape="false" /></h4>
				</s:if>
			</div>
			<br>
			<br>
			<div>
				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction2"/>'>こちら</a></p>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>