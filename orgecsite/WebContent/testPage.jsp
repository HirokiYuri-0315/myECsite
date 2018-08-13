<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<!-- jQueryのやつ。 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


	<title>てすと1</title>

	<style type="text/css">
	/* ========TAG LAYOUT======== */
		body {
			margin: 0;
			padding: 0;
			line-height: 1.6;
			letter-spacing: 1px;
			font-family: Verdana, Helvatica, sans-serif;
			font-size: 12px;
			color: #333;
			background: #fff;
		}
		table {
			text-align: center;
			margin: 0 auto;
		}



	/* ========ID LAYOUT======== */
		#top {
			width: 780px;
			margin: 30px auto;
			border: 1px solid #333;
		}
		#header {
			width: 100%;
			height:60px;
			background-color: black;
		}
		#main {
			width: 100%;
			height: auto;
			text-align: center;
		}
		#footer {
			width: 100%;
			height: 80px;
			background-color: black;
			clear: both;
		}
		#text-center {
			display: inline-block;
			text-align: center;
		}


		#header ul li{
		    float: left;
		    width: 150px;
		    list-style-type: none;
		    padding-left: 15px;
		}
		#menubar {

		}
		#menu {
			padding-right: 10px;
		    color: white;
		    background-color: black;
		    line-height:60px;
		    font-size: 16px;
		}
		#imenu {

		}
		#rightSet {
			text-align: right;
			float: right;
		}

img {
 max-width: 100%;
 max-height: 100%;
 width: auto;
 height: auto;
}
.img-container--table-cell {
 position: relative;
 width: 350px;
 height: 350px;
 display: table-cell;
 vertical-align: middle;
 text-align: center;
 border: 1px solid darkgray;
}

	</style>


	<script type="text/javascript">
		ages = function pullSelect() {
			for(var i = 18; i <= 65; i++){
				document.write("<option value='z'>");
				document.write(i);
				document.write("</option>");
			}
		}

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
		$(function(){
			$("#iMenu").hover(
					function(){
						$(this).animate({width:"60px",height:"60px"});
					},
					function(){
						$(this).animate({width:"40px",height:"40px"});
					});
		});
	</script>
</head>

<body>

	<div id="header">
		<div id="pr">
		</div>
        <div id="menubar">
            <ul>
            <li id="menu">HOME</li>
            <li id="menu">商品購入</li>
            <li id="menu">マイページ</li>
            <li id="menu"><a href='<s:url action="GoHomeAction" />'>HOME</a></li>
            <li id="menu"></li>
            </ul>

            <div id="rightSet">
            <img id="iMenu" src="image/img_menu.jpg" width="40px" >
            <div id="iMenuPlus">やっほー</div>
            </div>
        </div>
	</div>

	<div id="main">
		<div id="top">
			<p>てすとぺーじ</p>
		</div>

		<img id="maru" alt="test" src="image/img_maru.jpg">
		<img id="batsu" alt="test" src="image/img_batsu.jpg">
		<br>
		<img id="testImg" alt="test" src="image/img_def.jpg">

<section>
  <h1>table-cell</h1>
  <div class="img-container--table-cell">
    <img src="image/img_marunaga.jpg" />
  </div>
</section>

<section>
  <h1>table-cell</h1>
  <div class="img-container--table-cell">
    <img src="image/img_maruyoko.jpg" />
  </div>
</section>

		<div>

            <select name="age">
            <option value="a">選択してください</option>
            <option>1</option>
            </select>

        </div>

		<div id="text-center">
			<s:form action="HomeAction">
				<s:submit value="商品購入" />
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
		</div>
	</div>


	<div id="footer">
			<div id="pr">
			</div>
		</div>
</body>
</html>