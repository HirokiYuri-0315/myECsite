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

	<title>商品情報の編集</title>

</head>

<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>

	<div id="main">
		<div id="top">
			<p>商品情報編集画面</p>
		</div>
		<h3>現在の商品詳細情報がこちらです</h3>
	<!-- 現在の商品情報を表示したい -->
		<div id="item_detail">
			<div id="left_box">
				<table>
				<tr>
					<th scope="col">商品画像</th>
				</tr>
				<tr>
					<td><div id="item_image_box"> <img id="item_image" src="<s:property value='session.selectImageInfo'/>"> </div></td>
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
						<td height="52"><s:property value="session.selectItemDescription"/></td>
					</tr>
				</table>
			</div>
		</div>

	<br>

	<!-- ここから新しい情報を入力させたい -->
		<div>
			<div>
				<h4>更新する商品情報を編集し、送信してください</h4>
				[！]変更しない項目は編集せずにそのまま送信してください。<br><br>
			</div>
			<s:form action="MasterUpdateItemInfoAction" method="execute">
			<table id="item_info" border="">
				<tr>
					<th scope="row">商品名</th>
					<td><input type="text" name="updateItemName" value='<s:property value="session.selectItemName"/>'></td>
				</tr>
				<tr>
					<th scope="row">よみがな</th>
					<td><input type="text" name="updateItemNameKana" value='<s:property value="session.selectItemNameKana"/>'></td>
				</tr>
				<tr>
					<th scope="row">値段</th>
					<td><input type="text" name="updateItemPrice" value='<s:property value="session.selectItemPrice"/>'></td>
				</tr>
				<tr>
					<th scope="row">発売元</th>
					<td><input type="text" name="updateItemReleaseCompany" value='<s:property value="session.selectItemReleaseCompany"/>'></td>
				</tr>
				<tr>
					<th scope="row">商品カテゴリ</th>
					<td>
						<select name="checkCategoryId" >
							<option value="0">変更なし</option>	<!-- うまいやり方がわからないので誤魔化し -->
							<option value="1">カテゴリなし</option>
							<option value="2">文房具</option>
						</select>
					</td>
				</tr>
				<tr>
					<th scope="row">商品詳細</th>
					<td><textarea name="updateItemDescription" rows="3" cols="30"><s:property value="session.selectItemDescription"/></textarea></td>
				</tr>
				<tr>
					<th scope="row">商品画像</th>
					<td><input type="file" name="imageUrl"></td>
				</tr>
			</table>
			<div id="error">
				<s:if test='errorMessage != ""'>	<!-- 追加 -->
					<h4><s:property value="errorMessage" escape="false" /></h4>
				</s:if>
			</div>
			<br>
			<input type="submit" value="送信する">
			</s:form>
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