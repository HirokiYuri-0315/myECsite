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

	<title>編集内容の確認</title>

</head>

<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>編集内容確認画面</p>
		</div>

	<!-- プレビューを表示したい -->
		<h3>～ プレビュー ～</h3>
		<div id="item_detail">
			<div id="left_box">
				<table>
				<tr>
					<th scope="col">商品画像</th>
				</tr>
				<tr>
					<td><div id="item_image_box"> <img id="item_image" src="<s:property value='session.updateImageInfo'/>"> </div></td>
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
						<td><s:property value="session.updateItemName"/></td>
					</tr>
					<tr>
						<th scope="row">よみがな</th>
						<td><s:property value="session.updateItemNameKana"/></td>
					</tr>
					<tr>
						<th scope="row">値段</th>
						<td><s:property value="session.updateItemPrice"/><span>円</span></td>
					</tr>
					<tr>
						<th scope="row">在庫数</th>
						<td><s:property value="session.selectItemStock"/></td>
					</tr>
					<tr>
						<th scope="row">発売元</th>
						<td><s:property value="session.updateItemReleaseCompany"/></td>
					</tr>
					<tr>
						<th scope="row">商品カテゴリ</th>
						<td>
							<s:if test="#session.updateCategoryId == 1">カテゴリなし</s:if>
							<s:elseif test="#session.updateCategoryId == 2">文房具</s:elseif>
						</td>
					</tr>
					<tr>
						<th scope="row">商品詳細</th>
						<td height="52"><div id="description"><s:property value="session.updateItemDescription"/></div></td>
					</tr>
				</table>
			</div>
		</div>

	<br>
	<div>
		<h4>以上のように更新します。よろしいでしょうか？</h4>
		<br><s:form action="MasterUpdateItemInfoConfirmAction" method="execute"><input type="submit" value="更新する"></s:form>
		<br><s:form action="MasterUpdateItemInfoSelectAction" method="execute"><input type="submit" value="やり直す"></s:form>
	</div>


			<br><br>
		<div>
			<span>管理画面TOPに戻る場合は</span>
			<a href='<s:url action="GoMasterAction"/>'>こちら</a>
		</div>
	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>