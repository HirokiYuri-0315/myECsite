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
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<script type="text/javascript" src="./footerFixed.js"></script>

<title>商品一覧</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div id="main">
		<div id="top">
			<p>商品一覧</p>
		</div>

		<!-- 商品検索部分 -->
		<div id="item_search">
			<table>
			<tr>
			<s:form action="SearchCategoryKeywordAction" method="execute">
				<td>
				<select name="categoryId">
					<option value="0" selected="selected">カテゴリ選択</option>
					<option value="2">文房具</option>
					<option value="1">未分類</option>
				</select>
				</td>
				<td>
				<input type="text" placeholder="検索したい商品名を入力" name="keyword">
				<input type="submit" value="検索">
				</td>
			</s:form>
			</tr>
			</table>
		</div>

		<!-- 商品一覧部分 -->
		<div id="newItemList">
			<h3>商品の一覧を表示</h3>

			<div id="hit">
				全<s:property value='#session.totalRecordSize'/>件中 <s:property value='#session.startRecordNo'/> ～
						<s:if test="#session.endRecordNo > #session.totalRecordSize">
							<s:property value='#session.totalRecordSize'/>
						</s:if>
						<s:else>
							<s:property value='#session.endRecordNo'/>
						</s:else>
						件目を表示
			</div>

				<s:iterator value="#session.ItemInfoDtoList">
				<div id="hiddenBox">
				<div id="newItemBox">

					<ul>
					<!-- 	<li><input type="radio" name="buyId" value='<s:property value="id"/>'></li>  -->
						<li><div id="item_image_box">
						<a href='<s:url action="SelectItemAction">
							<s:param name="buyOrInfo" value="1"></s:param>
							<s:param name="buyId" value="%{id}"/></s:url>'>

							<img id="item_image" src="<s:property value='imageFilePath'/>/<s:property value='imageFileName'/>">
						</a></div>
						</li>
						<li><s:property value="itemName" /></li>
						<li><s:property value="itemReleaseCompany" /></li>
						<li><s:property value="itemPrice" /><span>円</span></li>
					</ul>

				</div>
				</div>
				</s:iterator>
			<br>

			<!-- ～ページ番号部分～ -->
				<div class="pager">
				<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
					<s:if test="#session.currentPageNo == #pageNo.count">
						<!-- 現在のページを表す数字は、そのまま数字を表記するだけ。 -->
						<s:property value="%{#pageNo.count}"/>
					</s:if>
					<s:else>
						<!-- 他のページを表す数字はリンク付け。ページ番号 pageNo とカテゴリ番号 categoryId をパラメータとして持たせる -->
						<a href="<s:url action='ShiftItemPageAction'>
								<s:param name='pageNo' value='%{#pageNo.count}'/>
								<s:param name='categoryId' value='%{categoryId}'/>
								<s:param name='keyword' value='%{keyword}'/>
								</s:url> ">

							<s:property value="%{#pageNo.count}"/>
						</a>
					</s:else>
				</s:iterator>
				</div>



			<br>
			<div id="error">
				<s:if test='errorMessage != ""'>	<!-- 追加 -->
					<h4><s:property value="errorMessage" escape="false" /></h4>
				</s:if>
			</div>
			<br>
			<br>

		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>