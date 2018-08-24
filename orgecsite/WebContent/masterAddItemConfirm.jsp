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

	<title>商品追加内容確認画</title>


</head>

<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>商品追加内容確認画面</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="MasterAddItemCompleteAction">
					<tr id="box">
						<td>
							<label>商品名:</label>
						</td>
						<td>
							<s:property value="addItemName" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>価格:</label>
						</td>
						<td>
							<s:property value="addItemPrice" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>在庫数:</label>
						</td>
						<td>
							<s:property value="addItemStock" escape="false" />
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="完了" />
						</td>
					</tr>
				</s:form>
			</table>
		</div>

			<div>
				<span>入力画面に戻る場合は</span>
				<a href='<s:url action="GoMasterAddItemAction"/>'>こちら</a>
			</div>
	</div>
	<jsp:include page="./footer.jsp"/>
</body>
</html>