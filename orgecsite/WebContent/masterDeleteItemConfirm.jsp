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

	<title>MasterDeleteItemConfirm画面</title>


</head>

<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>MasterAddItemConfirm</p>
		</div>
		<div>
			<h3>削除する商品は以下で間違いありませんか。</h3>
			<table>
				<s:form action="MasterDeleteItemCompleteAction">
					<tr id="box">
						<td>
							<label>商品ID:</label>
						</td>
						<td>
							<s:property value="session.deleteId" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>商品名:</label>
						</td>
						<td>
							<s:property value="session.deleteItemName" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>価格:</label>
						</td>
						<td>
							<s:property value="session.deleteItemPrice" escape="false" /><span>円</span>
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="削除する" />
						</td>
					</tr>
				</s:form>
			</table>
		</div>

			<div>
				<span>選択画面に戻る場合は</span>
				<a href='<s:url action="GoMasterDeleteItemAction"/>'>こちら</a>
			</div>
	</div>
	<jsp:include page="./footer.jsp"/>
</body>
</html>