<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/Common/head.jsp"/>
<script type="text/javascript" src="http://localhost:8080/NGlib/js/formController.js"></script>
<script type="text/javascript" src="http://localhost:8080/NGlib/js/newDataQry.js"></script>
<title>NGlib管理ツール</title>
</head>
<body>
<jsp:include page="/Common/header.jsp"/>

<jsp:include page="/Common/body.jsp" />

<h1 class="contents_title">登録内容変更</h1>
<div class="admin_container">
	<form action="adminUpdate" method="post">
	<input type="hidden" name="category" value="<c:out value="${getCategory}" />">
		<div class="information_list">
			<table class="contents_info">
				<c:choose>
					<c:when test="${getCategory == 'pi'}">
						<input type="hidden" name="piId" value="<c:out value="${piInfo.piId}" />">
						<tr>
							<th class="column1" rowspan="15"><input type="file" name="img" accept=".png">  </th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">製品情報</th>
						</tr>
						<tr>
							<th class="column2">タイトル</th>
							<th class="column3">
							<input type="text" name="title" size="60" value="<c:out value="${piInfo.title}" />">
							<div id="exception1"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">ブランド</th>
							<th class="column3">
								<select id="brand" name="brId">
								<option value="null">選択してください。</option>
								<c:forEach var="brandSelectList" items="${brandSelectList}">
									<option value="<c:out value="${brandSelectList.brId}" />" <c:if test="${piInfo.brand == brandSelectList.brName}">selected="selected"</c:if>><c:out value="${brandSelectList.brName}" /></option>
								</c:forEach>
							</select>
							<div id="exception2"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">発売日</th>
							<th class="column3">
							<select id="year" name="year">
								<option value="____">----</option>
								<c:forEach var="yearList" begin="1920" end="2020" >
									<option value="<c:out value="${yearList}" />" <c:if test="${yearList == Date[0]}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
								</c:forEach>
							</select>
							年　
							<select id="month" name="month">
								<option value="__">--</option>
								<c:forEach var="i" begin="01" end="9">
									<option value="0<c:out value="${i}" />" <c:if test="${i == Date[1]}">selected="selected"</c:if>><c:out value="${i}" /></option>
								</c:forEach>
								<c:forEach var="i" begin="10" end="12">
									<option value="<c:out value="${i}" />" <c:if test="${i == Date[1]}">selected="selected"</c:if>><c:out value="${i}" /></option>
								</c:forEach>
							</select>
							月　
							<select id="day" name="day">
								<option value="__">--</option>
								<c:forEach var="i" begin="1" end="9">
									<option value="0<c:out value="${i}" />" <c:if test="${i == Date[2]}">selected="selected"</c:if>><c:out value="${i}" /></option>
								</c:forEach>
								<c:forEach var="i" begin="10" end="31">
									<option value="<c:out value="${i}" />" <c:if test="${i == Date[2]}">selected="selected"</c:if>><c:out value="${i}" /></option>
								</c:forEach>
							</select>
							日
							<div id="exception3"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">シリーズ</th>
							<th class="column3">
							<select name="series" onchange="switchBox(this.value)">
								<option value="null">----</option>
								<option value="new">【新規登録】</option>
								<c:forEach var="seriesSelectList" items="${seriesSelectList}">
									<option value="<c:out value="${seriesSelectList.series}" />" <c:if test="${seriesSelectList.series == piInfo.series}">selected="selected"</c:if>><c:out value="${seriesSelectList.series}"></c:out></option>
								</c:forEach>
							</select>
							<input id="newSeries" type="text" name="newSeries" size="40" disabled="disabled">
							</th>
						</tr>
						<tr>
							<th class="column2">ゲームエンジン</th>
							<th class="column3">
							<select name="engine">
								<option value="nill">----</option>
								<c:forEach var="engineSelectList" items="${engineSelectList}">
									<option value="<c:out value="${engineSelectList.engine}" />" <c:if test="${engineSelectList.engine == piInfo.engine}">selected="selected"</c:if>><c:out value="${engineSelectList.engine}" /></option>
								</c:forEach>
							</select>
							</th>
						</tr>
						<tr>
							<th class="column2">コメント</th>
							<th class="column_comment"><textarea name="comment" rows="4" cols="60"><c:out value="${piInfo.comment}" /></textarea></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">製作スタッフ</th>
						</tr>
						<tr>
							<th class="column2">プロデューサー</th>
							<th class="column3">
								<!-- 既存のスタッフをここですべて出力 -->
								<c:forEach var="i" begin="1" end="${fn:length(partPr)}">
								<select name="<c:out value="originPr${i-1}" />">
								<option value="null">----</option>
									<c:forEach var="prSelectList" items="${prSelectList}">
										<option value="<c:out value="${prSelectList.crId}" />" <c:if test="${partPr[i-1].name == prSelectList.name}">selected="selected"</c:if>><c:out value="${prSelectList.name}" /></option>
									</c:forEach>
								</select>
								</c:forEach>
								<!-- 追加分 -->
								<select id="prSelecter" name="producer0">
								<option>----</option>
							 	<c:forEach var="prSelectList" items="${prSelectList}">
									<option value="<c:out value="${prSelectList.crId}" />"><c:out value="${prSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="pr1"></div>
								<button type="button" onclick="prArea.add();">追加</button>
								<button type="button" onclick="prArea.remove();">削除</button>
								<input id="prlength" type="hidden" name="prlength" value="1">
							</th>
						</tr>
						<tr>
							<th class="column2">シナリオ</th>
							<th class="column3">
								<!-- 既存のスタッフをここですべて出力 -->
								<c:forEach var="i" begin="1" end="${fn:length(partSW)}">
								<select name="<c:out value="originSW${i-1}" />">
								<option>----</option>
								<c:forEach var="swSelectList" items="${swSelectList}">
									<option value="<c:out value="${swSelectList.crId}" />" <c:if test="${partSW[i-1].name == swSelectList.name}">selected="selected"</c:if>><c:out value="${swSelectList.name}" /></option>
								</c:forEach>
								</select>
								</c:forEach>
								<!-- 追加分 -->
								<select id="swSelecter" name="scenariowriter0">
								<option>----</option>
							 	<c:forEach var="swSelectList" items="${swSelectList}">
									<option value="<c:out value="${swSelectList.crId}" />"><c:out value="${swSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="sw1"></div>
								<button type="button" onclick="swArea.add();">追加</button>
								<button type="button" onclick="swArea.remove();">削除</button>
							</th>
						</tr>
						<tr>
							<th class="column2">イラスト</th>
							<th class="column3">
								<!-- 既存のスタッフをここですべて出力 -->
								<c:forEach var="i" begin="1" end="${fn:length(partIl)}">
								<select name="<c:out value="originIl${i-1}" />">
								<option>----</option>
								<c:forEach var="ilSelectList" items="${ilSelectList}">
									<option value="<c:out value="${ilSelectList.crId}" />" <c:if test="${partIl[i-1].name == ilSelectList.name}">selected="selected"</c:if>><c:out value="${ilSelectList.name}" /></option>
								</c:forEach>
								</select>
								</c:forEach>
								<!-- 追加分 -->
								<select id="ilSelecter" name="illustrator0">
								<option>----</option>
							 	<c:forEach var="ilSelectList" items="${ilSelectList}">
									<option value="<c:out value="${ilSelectList.crId}" />"><c:out value="${ilSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="il1"></div>
								<button type="button" onclick="ilArea.add();">追加</button>
								<button type="button" onclick="ilArea.remove();">削除</button>
							</th>
						</tr>
						<tr>
							<th class="column2">グラフィック</th>
							<th class="column3">
								<!-- 既存のスタッフをここですべて出力 -->
								<c:forEach var="i" begin="1" end="${fn:length(partGC)}">
								<select name="<c:out value="originGC${i-1}" />">
								<option>----</option>
								<c:forEach var="gcSelectList" items="${gcSelectList}">
									<option value="<c:out value="${gcSelectList.crId}" />" <c:if test="${partGC[i-1].name == gcSelectList.name}">selected="selected"</c:if>><c:out value="${gcSelectList.name}" /></option>
								</c:forEach>
								</select>
								</c:forEach>
								<!-- 追加分 -->
								<select id="gcSelecter" name="graphiccreator0">
								<option>----</option>
							 	<c:forEach var="gcSelectList" items="${gcSelectList}">
									<option  value="<c:out value="${gcSelectList.crId}" />"><c:out value="${gcSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="gc1"></div>
								<button type="button" onclick="gcArea.add();">追加</button>
								<button type="button" onclick="gcArea.remove();">削除</button>
							</th>
						</tr>
						<tr>
							<th class="column2">サウンド</th>
							<th class="column3">
								<!-- 既存のスタッフをここですべて出力 -->
								<c:forEach var="i" begin="1" end="${fn:length(partSC)}">
								<select name="<c:out value="originSC${i-1}" />">
								<option>----</option>
								<c:forEach var="scSelectList" items="${scSelectList}">
									<option value="<c:out value="${scSelectList.crId}" />" <c:if test="${partSC[i-1].name == scSelectList.name}">selected="selected"</c:if>><c:out value="${scSelectList.name}" /></option>
								</c:forEach>
								</select>
								</c:forEach>
								<!-- 追加分 -->
								<select id="scSelecter" name="soundcreator0">
								<option>----</option>
							 	<c:forEach var="scSelectList" items="${scSelectList}">
									<option value="<c:out value="${scSelectList.crId}" />"><c:out value="${scSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="sc1"></div>
								<button type="button" onclick="scArea.add();">追加</button>
								<button type="button" onclick="scArea.remove();">削除</button>
							</th>
						</tr>
						<tr>
							<th class="column2">出演声優</th>
							<th class="column3">
								<!-- 既存のスタッフをここですべて出力 -->
								<c:forEach var="i" begin="1" end="${fn:length(partVA)}">
								<select name="<c:out value="originVA${i-1}" />">
								<option>----</option>
								<c:forEach var="vaSelectList" items="${vaSelectList}">
									<option value="<c:out value="${vaSelectList.vaId}" />" <c:if test="${partVA[i-1].name == vaSelectList.vaName}">selected="selected"</c:if>><c:out value="${vaSelectList.vaName}" /></option>
								</c:forEach>
								</select>
								</c:forEach>
								<!-- 追加分 -->
								<select id="vaSelecter" name="voiceactor0">
								<option>----</option>
							 	<c:forEach var="vaSelectList" items="${vaSelectList}">
									<option value="<c:out value="${vaSelectList.vaId}" />"><c:out value="${vaSelectList.vaName}" /></option>
								</c:forEach>
						 		</select>
								<div id="va1"></div>
								<button type="button" onclick="vaArea.add();">追加</button>
								<button type="button" onclick="vaArea.remove();">削除</button>
							</th>
						</tr>
						<tr>
							<th class="column_title" colspan="3">あらすじ</th>
						</tr>
						<tr>
							<th class="column_txt" colspan="3">
							<textarea name="text" rows="6" cols="120"><c:out value="${piInfo.text}" /></textarea>
							</th>
						</tr>
					</c:when>

					<c:when test="${getCategory == 'co'}">
						<tr>
							<th class="column1" rowspan="6"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">企業情報</th>
						</tr>
						<tr>
							<th class="column2">会社名</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">設立年</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">住所</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
					</c:when>

					<c:when test="${getCategory == 'br'}">
						<tr>
							<th class="column1" rowspan="5"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">ブランド情報</th>
						</tr>
						<tr>
							<th class="column2">ブランド名</th>
							<th class="column3"><div class="name"><c:out value="${brInfo[0].brName}" /></div></th>
						</tr>
						<tr>
							<th class="column2">所有会社</th>
							<th class="column3"><div class="name"><a href="<c:url value="company_information"><c:param name="id" value="${brInfo[0].coId}" /></c:url>"><c:out value="${brInfo[0].coName}" /></a></div></th>
						</tr>
						<tr>
							<th class="column2">会社名</th>
							<th class="column3">
							<select name="choiceCo">
							<option>----</option>
							<c:forEach var="coList" items="${coList}">
								<option><c:out value="${coList.coName}" /></option>
							</c:forEach>
							<option>新規作成</option>
							</select>
							</th>
						</tr>
					</c:when>

					<c:when test="${getCategory == 'pr'}">
						<tr>
							<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="sex" value="male">男
								<input type="radio" name="sex" value="female">女
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select>
								<option>----</option>
								<option>A型</option>
								<option>B型</option>
								<option>O型</option>
								<option>AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属ブランド</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属サークル</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>

					</c:when>

					<c:when test="${getCategory == 'sw'}">
						<tr>
							<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="sex" value="male">男
								<input type="radio" name="sex" value="female">女
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select>
								<option>----</option>
								<option>A型</option>
								<option>B型</option>
								<option>O型</option>
								<option>AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属ブランド</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属サークル</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
					</c:when>

					<c:when test="${getCategory == 'il'}">
						<tr>
							<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="sex" value="male">男
								<input type="radio" name="sex" value="female">女
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select>
								<option>----</option>
								<option>A型</option>
								<option>B型</option>
								<option>O型</option>
								<option>AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属ブランド</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属サークル</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
					</c:when>

					<c:when test="${getCategory == 'gc'}">
						<tr>
							<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="sex" value="male">男
								<input type="radio" name="sex" value="female">女
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select>
								<option>----</option>
								<option>A型</option>
								<option>B型</option>
								<option>O型</option>
								<option>AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属ブランド</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属サークル</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
					</c:when>

					<c:when test="${getCategory == 'sc'}">
						<tr>
							<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="sex" value="male">男
								<input type="radio" name="sex" value="female">女
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3"><input type="text" name="title" size="60"></th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select>
								<option>----</option>
								<option>A型</option>
								<option>B型</option>
								<option>O型</option>
								<option>AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属ブランド</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属サークル</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="brand" items="${brList}">
								<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
					</c:when>

					<c:when test="${getCategory == 'va'}">
						<tr>
							<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3"><input type="text" name="" size="60"></th>
						</tr>
						<tr>
							<th class="column2">表名義</th>
							<th class="column3">
								<select>
								<option>----</option>
								<c:forEach var="avList" items="${avList}">
									<option></option>
								</c:forEach>
								<option>新規登録</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="sex" value="male">男
								<input type="radio" name="sex" value="female">女
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3"><!-- 都道府県リスト --></th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select>
								<option>----</option>
								<option>A型</option>
								<option>B型</option>
								<option>O型</option>
								<option>AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">デビュー</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
							</th>
						</tr>
						<tr>
							<th class="column2">所属事務所</th>
							<th class="column3">
							<c:forEach var="vaInfo" items="${vaInfo}">
								<div class="name"><a href="<c:url value="product_information"><c:param name="id" value="${vaInfo.piId}" /></c:url>"><c:out value="${vaInfo.title}" /></a></div>
							</c:forEach>
							</th>
						</tr>
					</c:when>

					<c:when test="${getCategory == 'av'}">
						<tr>
							<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3"><input type="text" name="" size="60"></th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="sex" value="male">男
								<input type="radio" name="sex" value="female">女
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3"><!-- 都道府県リスト --></th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select>
								<option>----</option>
								<option>A型</option>
								<option>B型</option>
								<option>O型</option>
								<option>AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">デビュー</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
							</th>
						</tr>
						<tr>
							<th class="column2">所属事務所</th>
							<th class="column3">
							<c:forEach var="vaInfo" items="${vaInfo}">
								<div class="name"><a href="<c:url value="product_information"><c:param name="id" value="${vaInfo.piId}" /></c:url>"><c:out value="${vaInfo.title}" /></a></div>
							</c:forEach>
							</th>
						</tr>


					</c:when>

				</c:choose>
			</table>
		</div>

	<div class="searchPage"><input type="submit" value="内容確定(プレビューへ) >>"></div>

	</form>
</div>
<jsp:include page="/Common/footer.jsp" />
</body>
</html>