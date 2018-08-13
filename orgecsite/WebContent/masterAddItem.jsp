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
	<title>MasterAddItem画面</title>


</head>

<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>AddItem</p>
		</div>
		<div>
			<table>
			<s:form action="MasterAddItemConfirmAction">
				<tr>
					<td>
						<label>商品名:</label>
					</td>
					<td>
						<input type="text" name="addItemName" value='<s:property value="addItemName" escape="false" />' />
					</td>
				</tr>
				<tr>
					<td>
						<label>価格:</label>
					</td>
					<td>
						<input type="text" name="addItemPrice" value='<s:property value="addItemPrice" escape="false" />' />
					</td>
				</tr>
				<tr>
					<td>
						<label>在庫数:</label>
					</td>
					<td>
						<input type="text" name="addItemStock" value='<s:property value="addItemStock" escape="false" />' />
					</td>
				</tr>
				<s:submit value="登録" />
			</s:form>
			</table>
			<div id="error">
				<s:if test='errorMessage != ""'>
					<s:property value="errorMessage" escape="false" />
				</s:if>
				<s:if test='errorMessage2 != ""'>
					<s:property value="errorMessage2" escape="false" />
				</s:if>
				<s:if test='errorMessage3 != ""'>
					<s:property value="errorMessage3" escape="false" />
				</s:if>
			</div>
			<br>
			<div>
				<span>前画面に戻る場合は</span>
				<a href='<s:url action="GoMasterAction"/>'>こちら</a>
			</div>
		</div>
	</div>

<jsp:include page="./footer.jsp"/>
</body>
</html>