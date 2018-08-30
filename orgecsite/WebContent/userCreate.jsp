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

	<title>新規ユーザー登録</title>

</head>

<body>

	<jsp:include page="header.jsp" />


	<div id="main">
		<div id="top">
			<p>新規ユーザー登録</p>
		</div>
		<div id="form-frame">
			登録情報を入力してください。<br><br>
			<div id="error">
				<s:if test='errorMessage != ""'>
					<s:property value="errorMessage" escape="false" />
				</s:if>
			</div>
			<table>
			<s:form action="UserCreateConfirmAction">
				<tr>
					<td>
						<s:textfield name="loginUserId" value="%{loginUserId}" label="ログインID"/>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="loginPassword" value="%{loginPassword}" label="ログインPASS"/>
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="userName" value="%{userName}" label="ユーザー名"/>
					</td>
				</tr>
				<s:submit value="登録" />
			</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span>
				<a href='<s:url action="HomeAction"/>'>こちら</a>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>