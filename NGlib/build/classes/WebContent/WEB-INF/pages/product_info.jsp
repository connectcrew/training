<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/Common/head.jsp"/>
<body>
<jsp:include page="/Common/header.jsp"/>

<jsp:include page="/Common/body.jsp"/>

<h1 class="contents_title"><c:out value="${piInfo.title}" /></h1>
<div class="information_list">
	<table class="contents_info">
		<tr>
			<th class="column1" rowspan="15"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
		</tr>
		<tr>
			<th class="column_title" colspan="2">製品情報</th>
		</tr>
		<tr>
			<th class="column2">タイトル</th>
			<th class="column3"><div class="name"><c:out value="${piInfo.title}" /></div></th>
		</tr>
		<tr>
			<th class="column2">ブランド</th>
			<th class="column3"><div class="name"><a href="<c:url value="brand_information"><c:param name="id" value="${piInfo.brId}" /></c:url>"><c:out value="${piInfo.brand}" /></a></div></th>
		</tr>
		<tr>
			<th class="column2">発売日</th>
			<th class="column3"><div class="name"><c:out value="${piInfo.release}" /></div></th>
		</tr>
		<tr>
			<th class="column2">シリーズ</th>
			<th class="column3"><div class="name"><a href="<c:url value="series_information"><c:param name="id" value="${piInfo.series}" /></c:url>"><c:out value="${piInfo.series}" /></a></div></th>
		</tr>
		<tr>
			<th class="column2">ゲームエンジン</th>
			<th class="column3"><div class="name"><c:out value="${piInfo.engine}" /></div></th>
		</tr>
		<tr>
			<th class="column2">コメント</th>
			<th class="column_comment"><div class="name"><c:out value="${piInfo.comment}" /></div></th>
		</tr>
		<tr>
			<th class="column_title" colspan="2">製作スタッフ</th>
		</tr>
		<tr>
			<th class="column2">プロデューサー</th>
			<th class="column3">
				<c:forEach var="partPr" items="${partPr}">
					<div class="name"><a href="<c:url value="producer_information"><c:param name="id" value="${partPr.id}" /></c:url>"><c:out value="${partPr.name}" /></a></div>
				</c:forEach>
			</th>
		</tr>
		<tr>
			<th class="column2">シナリオ</th>
			<th class="column3">
				<c:forEach var="partSW" items="${partSW}">
					<div class="name"><a href="<c:url value="ScenarioWriter_information"><c:param name="id" value="${partSW.id}" /></c:url>"><c:out value="${partSW.name}" /></a></div>
				</c:forEach>
			</th>
		</tr>
		<tr>
			<th class="column2">イラスト</th>
			<th class="column3">
				<c:forEach var="partIl" items="${partIl}">
					<div class="name"><a href="<c:url value="illustrator_information"><c:param name="id" value="${partIl.id}" /></c:url>"><c:out value="${partIl.name}" /></a></div>
				</c:forEach>
			</th>
		</tr>
		<tr>
			<th class="column2">グラフィック</th>
			<th class="column3">
				<c:forEach var="partGC" items="${partGC}">
					<div class="name"><a href="<c:url value="GraphicCreator_information"><c:param name="id" value="${partGC.id}" /></c:url>"><c:out value="${partGC.name}" /></a></div>
				</c:forEach>
			</th>
		</tr>
		<tr>
			<th class="column2">サウンド</th>
			<th class="column3">
				<c:forEach var="partSC" items="${partSC}">
					<div class="name"><a href="<c:url value="SoundCreator_information"><c:param name="id" value="${oartSC.id}" /></c:url>"><c:out value="${partSC.name}" /></a></div>
				</c:forEach>
			</th>
		</tr>
		<tr>
			<th class="column2">出演声優</th>
			<th class="column3">
				<c:forEach var="partVA" items="${partVA}">
					<div class="name"><a href="<c:url value="VoiceActor_information"><c:param name="id" value="${partVA.id}" /></c:url>"><c:out value="${partVA.name}" /></a></div>
				</c:forEach>
			</th>
		</tr>
		<tr>
			<th class="column_title" colspan="3">あらすじ</th>
		</tr>
		<tr>
			<th class="column_txt" colspan="3">
			<div class="name"><c:out value="${product_info.text}" /></div>
			</th>
		</tr>
	</table>
</div>

<jsp:include page="/Common/footer.jsp"/>
</body>
</html>