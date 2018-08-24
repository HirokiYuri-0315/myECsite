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

	<title>変更内容確認</title>

</head>

<body>


	<div id="main">
		<div id="top">
			<p>在庫数変更内容確認画面</p>
		</div>
		<div>
			<table>
				<tr>
					<td>商品名</td>
					<td><s:property value="session.selectItemName"/></td>
				</tr>
				<tr>
					<td>値段</td>
					<td><s:property value="session.selectItemPrice"/><span>円</span></td>
				</tr>
				<tr>
					<td>現在の在庫数</td>
					<td><s:property value="session.selectItemStock"/><span>個</span></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
			</table>

			<div>
				在庫を
				<s:if test="(session.addStock) <= 0"><s:property value="session.addStockInv"/><span>個</span> 減らして、</s:if>
				<s:else><s:property value="session.addStock"/><span>個</span> 追加して、</s:else>
				合わせて
					<a class="red_bold"><s:property value="session.newStock"/><span>個</span></a>
				に変更します。<br><br>
				よろしいですか？<br><br>
			</div>

				<div class="buttunLine">
				<ul>
					<li><s:form id="do" action="GoMasterAction"><s:submit class="doButton" value="戻る"/></s:form></li>
					<li><s:form id="do" action="MasterAddStockCompleteAction"><s:submit class="doButton" value="変更する"/></s:form></li>
				</ul>
				</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>