<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<link rel="stylesheet" href="./css/style.css">
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<!-- jQueryのやつ。 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript" src="./footerFixed.js"></script>


	<title>てすと2</title>



	<script type="text/javascript">

		$(function(){
			$("#batsu").click(function(){
				$("#testImg").fadeOut();
			});
		});

		$(function(){
			$("#maru").click(function(){
				$("#testImg").fadeIn();
			});
		});



	</script>
</head>

<body>


<jsp:include page="header.jsp" />


	<div id="main">
		<div id="top">
			<p>てすとぺーじ</p>
		</div>

		<img id="maru" alt="test" src="image/img_maru.jpg">
		<img id="batsu" alt="test" src="image/img_batsu.jpg">
		<br>
		<img id="testImg" alt="test" src="image/img_def.jpg">

		<div>

            <select name="age">
            <option value="a">選択してください</option>
            <option>1</option>
            </select>

        </div>

		<div id="text-center">
			<s:form action="TestAction" method="execute">
				<input type="file" name="imageUrl">
				<input type="submit" value="送信してみる">
			</s:form>
			<br>
			<s:if test="#session.id != null">
				<p>ログアウトする場合は
					<a href='<s:url action="LogoutAction" />'>こちら</a></p>
			</s:if>
			<s:if test="#session.id == null">
				<p>ログインは
					<a href='<s:url action="GoLoginAction" />'>こちら</a></p>
			</s:if>
			<br>
			<p>新しい商品一覧ページは
					<a href='<s:url action="GoNewItemListAction" />'>こちら</a></p>
		</div>
	</div>

	<div id="footer">
			<div id="pr">
			</div>
		</div>
</body>
</html>