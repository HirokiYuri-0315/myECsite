<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- jQueryのやつ。 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/style.css">
<title>ヘッダー</title>
<script type="text/javascript">

// javascript を用いたボタンの試作。
function goHomeAction(){
	document.getElementById("form").action="GoHomeAction";
}
function goLoginAction(){
	document.getElementById("form").action="GoLoginAction";
}
function goLogoutAction(){
	document.getElementById("form").action="LogoutAction";
}
function goMyPageAction(){
	document.getElementById("form").action="MyPageAction2";
}
function goBuyPageAction(){
	document.getElementById("form").action="HomeAction";
}
function goUserCreateAction(){
	document.getElementById("form").action="UserCreateAction";
}
function goNewItemListAction(){
	document.getElementById("form").action="GoNewItemListAction";
}

function goCartAction(){
	document.getElementById("form").action="GoCartAction";
}


function goHomeAction2(){
	document.getElementById("form2").action="GoHomeAction";
}
function goLoginAction2(){
	document.getElementById("form2").action="GoLoginAction";
}
function goLogoutAction2(){
	document.getElementById("form2").action="LogoutAction";
}
function goMyPageAction2(){
	document.getElementById("form2").action="MyPageAction2";
}
function goBuyPageAction2(){
	document.getElementById("form2").action="HomeAction";
}
function goUserCreateAction2(){
	document.getElementById("form2").action="UserCreateAction";
}
function goNewItemListAction2(){
	document.getElementById("form2").action="GoNewItemListAction";
}

	// jQueryを使用。
	$(function(){
		$("#iMenu").click(function(){
			$("#rightHideBox").animate({right:"5px"}),
			$("#iMenuPlus").animate({right:"5px"}),
			$("#menu_info_right .menu_info_box_right").animate({opacity:"0.00"},{duration:0,queue:false});
		});

		$("#iMenuPlus").click(function(){
			$("#rightHideBox").animate({right:"-250px"}),
			$("#menu_info_batsu .menu_info_box_right").animate({opacity:"0.00"},{duration:0,queue:false});
		});

		$("#iMenuPlus").click(function(){
			$(this).animate({right:"-200px"});
		});

		$("#iMenu").hover(
				function(){
					$(this).animate({width:"50px",height:"50px",top:"0px",right:"0px"},{duration:200});
					$("#menu_info_right .menu_info_box_right").fadeIn(400).animate({right:"0px"},{duration:0,queue:false});
				},
				function(){
					$(this).animate({width:"40px",height:"40px",top:"5px",right:"5px"},{duration:200});
					$("#menu_info_right .menu_info_box_right").fadeOut(00);
				});

		$("#home_btn").hover(
				function(){
					$("#menu_info_home .menu_info_box").fadeIn(400).animate({left:"200px"},{duration:0,queue:false});
				},
				function(){
					$("#menu_info_home .menu_info_box").fadeOut(00);
				});
		$("#logout_btn").hover(
				function(){
					$("#menu_info_logout .menu_info_box").fadeIn(400).animate({left:"310px"},{duration:0,queue:false});
				},
				function(){
					$("#menu_info_logout .menu_info_box").fadeOut(00);
				});
		$("#login_btn").hover(
				function(){
					$("#menu_info_login .menu_info_box").fadeIn(400).animate({left:"310px"},{duration:0,queue:false});
				},
				function(){
					$("#menu_info_login .menu_info_box").fadeOut(00);
				});
		$("#myPage_btn").hover(
				function(){
					$("#menu_info_myPage .menu_info_box").fadeIn(400).animate({left:"530px"},{duration:0,queue:false});
				},
				function(){
					$("#menu_info_myPage .menu_info_box").fadeOut(00);
				});
		$("#buy_btn").hover(
				function(){
					$("#menu_info_buy .menu_info_box").fadeIn(400).animate({left:"640px"},{duration:0,queue:false});
				},
				function(){
					$("#menu_info_buy .menu_info_box").fadeOut(00);
				});
		$("#userCreate_btn").hover(
				function(){
					$("#menu_info_userCreate .menu_info_box").fadeIn(400).animate({left:"530px"},{duration:0,queue:false});
				},
				function(){
					$("#menu_info_userCreate .menu_info_box").fadeOut(00);
				});
		$("#itemList_btn").hover(
				function(){
					$("#menu_info_itemList .menu_info_box").fadeIn(400).animate({left:"420px"},{duration:0,queue:false});
				},
				function(){
					$("#menu_info_itemList .menu_info_box").fadeOut(00);
				});
		$("#iMenuPlus").hover(
				function(){
					$("#menu_info_batsu .menu_info_box_right").fadeIn(100).animate({right:"28px"},{duration:0,queue:false});
				},
				function(){
					$("#menu_info_batsu .menu_info_box_right").fadeOut(00);
				});
	});


</script>
</head>


<body>

<header>

<!-- ========ページ上部に表示するもの======== -->
<div id="header-all">
	<div id="memo"></div>

<div id="header-menu">
	<div id="logo_space"></div>
	<div id="memo">menu</div>

	<s:form id="form" name="form" theme="simple" method="execute">
		<s:submit value="ホーム" class="submit_btn" id="home_btn" onclick="goHomeAction();"/>

		<!-- セッションの login_user_id の有無によってログイン状態を判定。 -->
		<s:if test="#session.login_user_id != null">
			<s:submit value="ログアウト" class="submit_btn" id="logout_btn" onclick="goLogoutAction();"/>
		</s:if>
		<s:else>
			<s:submit value="ログイン" class="submit_btn" id="login_btn" onclick="goLoginAction();"/>
		</s:else>

		<s:submit value="商品一覧" class="submit_btn" id="itemList_btn" onclick="goNewItemListAction();"/>

		<s:if test="#session.login_user_id != null">
			<s:submit value="マイページ" class="submit_btn" id="myPage_btn" onclick="goMyPageAction();"/>
		</s:if>

		<s:if test="#session.login_user_id != null">
<%-- 			<s:submit value="商品購入" class="submit_btn" id="buy_btn" onclick="goBuyPageAction();"/> --%>
			<s:submit value="カート" class="submit_btn" id="buy_btn" onclick="goCartAction();"/>
		</s:if>
		<s:else>
			<s:submit value="新規登録" class="submit_btn" id="userCreate_btn" onclick="goUserCreateAction();"/>
		</s:else>

	</s:form>

</div>	<!-- header-menu -->

</div>	<!-- header-all -->


<!-- ========hoverで表示するもの======== -->
<div id="menu_info_home">
	<div class="menu_info_box">
		<a id="menu_info_sent">ホーム画面に移動します</a>
	</div>
</div>

<div id="menu_info_logout">
	<div class="menu_info_box">
		<a id="menu_info_sent">ログアウトします<br>（※セッションもクリアされます）</a>
	</div>
</div>

<div id="menu_info_login">
	<div class="menu_info_box">
		<a id="menu_info_sent">ログイン画面に移動します</a>
	</div>
</div>

<div id="menu_info_myPage">
	<div class="menu_info_box">
		<a id="menu_info_sent">マイページへ移動します<br>（商品履歴の閲覧ができます）</a>
	</div>
</div>

<div id="menu_info_buy">
	<div class="menu_info_box">
		<a id="menu_info_sent">旧･商品選択画面へ移動します</a>
	</div>
</div>

<div id="menu_info_userCreate">
	<div class="menu_info_box">
		<a id="menu_info_sent">新規ユーザー登録画面へ移動します</a>
	</div>
</div>

<div id="menu_info_itemList">
	<div class="menu_info_box">
		<a id="menu_info_sent">商品一覧を見ることができます<br>（購入にはログインが必要です）</a>
	</div>
</div>


<!-- ========サイドメニュー======== -->
<div id="rightMenu">
	<img id="iMenu" src="./image/img_menu.jpg" width="40px" >
	<div id="iMenuPlus">×</div>
</div>

<div id="menu_info_right">
	<div class="menu_info_box_right">
		<a id="menu_info_sent">クリックでメニューを表示します</a>
	</div>
</div>


<div id="rightHideBox">
	<div id="memo">side MENU</div>

	<s:form id="form2" name="form2" theme="simple">
		<s:submit value="ホーム" class="submit_btn_side" onclick="goHomeAction2();"/>

		<s:if test="#session.login_user_id != null">
			<s:submit value="ログアウト" class="submit_btn_side" onclick="goLogoutAction2();"/>
		</s:if>
		<s:else>
			<s:submit value="ログイン" class="submit_btn_side" onclick="goLoginAction2();"/>
		</s:else>

		<s:if test="#session.login_user_id != null">
			<s:submit value="マイページ" class="submit_btn_side" onclick="goMyPageAction2();"/>
		</s:if>

		<s:if test="#session.login_user_id != null">
			<s:submit value="商品購入" class="submit_btn_side" onclick="goBuyPageAction2();"/>
		</s:if>
		<s:else>
			<s:submit value="新規登録" class="submit_btn_side" onclick="goUserCreateAction2();"/>
		</s:else>

		<s:submit value="商品一覧" class="submit_btn_side" onclick="goNewItemListAction2();"/>
	</s:form>
</div>

<div id="menu_info_batsu">
	<div class="menu_info_box_right">
		<a id="menu_info_sent">閉じる</a>
	</div>
</div>

</header>

</body>
</html>