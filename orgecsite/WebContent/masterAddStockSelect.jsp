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

<title>在庫数変更</title>
</head>
<body>


	<div id="main">
		<div id="top">
			<p>在庫数変更選択画面</p>
		</div>
		<div>
			<h3>在庫数の修正を行う商品を選択してください</h3>

			<s:form action="MasterAddStockConfirmAction" method="execute">
			<table id="pre_list" border="1">
				<tr>
					<th>　</th><!--  -->
					<th>商品画像</th>
					<th>商品名</th>
					<th>値段</th>
					<th>在庫数</th>
				</tr>
				<s:iterator value="session.itemList">
					<tr>
						<td><input type="radio" name="addId" value='<s:property value="id"/>'></td> <!--  -->
						<td><img id="list_item_image" src="<s:property value='imageFilePath'/>/<s:property value='imageFileName'/>"></td>
						<td><s:property value="itemName" /></td>
						<td><s:property value="itemPrice" /><span>円</span></td>
						<td><s:property value="itemStock" /><span>個</span></td>
					</tr>
				</s:iterator>
			</table>
<br>
			<div>追加する在庫数を半角数字で入力してください<br>
			（減らしたい場合は -5 のように入力してください）</div>
<br>
				<tr>
					<td>
						<label>追加する在庫数:</label>
					</td>
					<td>
						<input type="text" size="3" name="addStockCount" value='<s:property value="addItemStock" escape="false" />' />
					</td>
				</tr>
			<input type="submit" value="追加">
			</s:form>

			<div id="error">
				<s:if test='errorMessage != ""'>	<!-- 追加 -->
					<h4><s:property value="errorMessage" escape="false" /></h4>
				</s:if>
			</div>
		</div>
	</div>
	<jsp:include page="./footer.jsp"/>
</body>
</html>