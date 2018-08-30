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

	<title>削除する商品の確認</title>


</head>

<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>商品削除確認画面</p>
		</div>
		<div>
			<h3>削除する商品は以下で間違いありませんか？</h3>
		<div id="item_detail">
			<div id="left_box">
				<table>
				<tr>
					<th scope="col">商品画像</th>
				</tr>
				<tr>
					<td><div id="item_image_box"> <img id="item_image" src="<s:property value='session.selectImageFilePath'/>/<s:property value='session.selectImageFileName'/>"></div></td>
				</tr>
				</table>
			</div>

			<div id="right_box">
				<h2>～ 商品情報 ～</h2>
				<table id="item_info" border="">
					<tr>
						<th scope="row">商品ID</th>
						<td><s:property value="session.selectId"/></td>
					</tr>
					<tr>
						<th scope="row">商品名</th>
						<td><s:property value="session.selectItemName"/></td>
					</tr>
					<tr>
						<th scope="row">よみがな</th>
						<td><s:property value="session.selectItemNameKana"/></td>
					</tr>
					<tr>
						<th scope="row">値段</th>
						<td><s:property value="session.selectItemPrice"/><span>円</span></td>
					</tr>
					<tr>
						<th scope="row">在庫数</th>
						<td><s:property value="session.selectItemStock"/></td>
					</tr>
					<tr>
						<th scope="row">発売元</th>
						<td><s:property value="session.selectItemReleaseCompany"/></td>
					</tr>
					<tr>
						<th scope="row">商品カテゴリ</th>
						<td>
							<s:if test="#session.selectCategoryId == 1">カテゴリなし</s:if>
							<s:elseif test="#session.selectCategoryId == 2">文房具</s:elseif>
						</td>
					</tr>
					<tr>
						<th scope="row">商品詳細</th>
						<td height="52"><div id="description"><s:property value="session.selectItemDescription"/></div></td>
					</tr>
				</table>
			</div>
		</div>
		<s:form action="MasterDeleteItemCompleteAction"><s:submit value="削除する" /></s:form>
		</div>

			<div>
				<span>選択画面に戻る場合は</span>
				<a href='<s:url action="GoMasterDeleteItemAction"/>'>こちら</a>
			</div>
	</div>
	<jsp:include page="./footer.jsp"/>
</body>
</html>