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

<h1 class="contents_title">Welcome to Novelgame Library！</h1>

<div class="box_index">
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">新着</h1>
			<ol class="count_result">
			<c:forEach var="newerBox" items="${newerBox}">
				<li><a href="<c:url value="product_information"><c:param name="id" value="${newerBox.id}" /></c:url>"><c:out value="${newerBox.name}" /></a> - <c:out value="${newerBox.count}" />更新</li>
			</c:forEach>
			</ol>
	</div>
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">会社/グループ</h1>
			<ol class="count_result">
			<c:forEach var="coBox" items="${coBox}">
				<li><a href="<c:url value="company_information"><c:param name="id" value="${coBox.id}" /></c:url>"><c:out value="${coBox.name}" /></a> - <c:out value="${coBox.count}" />作品</li>
			</c:forEach>
			</ol>
	</div>
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">ブランド</h1>
			<ol class="count_result">
			<c:forEach var="brBox" items="${brBox}">
				<li><a href="<c:url value="brand_information"><c:param name="id" value="${brBox.id}" /></c:url>"><c:out value="${brBox.name}" /></a> - <c:out value="${brBox.count}" />作品</li>
			</c:forEach>
			</ol>
	</div>
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">プロデューサー</h1>
			<ol class="count_result">
			<c:forEach var="prBox" items="${prBox}">
				<li><a href="<c:url value="producer_information"><c:param name="id" value="${prBox.id}" /></c:url>"><c:out value="${prBox.name}" /></a> - <c:out value="${prBox.count}" />作品</li>
			</c:forEach>
			</ol>
	</div>
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">シナリオライター</h1>
			<ol class="count_result">
			<c:forEach var="swBox" items="${swBox}">
				<li><a href="<c:url value="ScenarioWriter_information"><c:param name="id" value="${swBox.id}" /></c:url>"><c:out value="${swBox.name}" /></a> - <c:out value="${swBox.count}" />作品</li>
			</c:forEach>
			</ol>
	</div>
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">イラストレーター</h1>
			<ol class="count_result">
			<c:forEach var="ilBox" items="${ilBox}">
				<li><a href="<c:url value="illustrator_information"><c:param name="id" value="${ilBox.id}" /></c:url>"><c:out value="${ilBox.name}" /></a> - <c:out value="${ilBox.count}" />作品</li>
			</c:forEach>
			</ol>
	</div>
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">グラフィッククリエイター</h1>
			<ol class="count_result">
			<c:forEach var="gcBox" items="${gcBox}">
				<li><a href="<c:url value="GraphicCreator_information"><c:param name="id" value="${gcBox.id}" /></c:url>"><c:out value="${gcBox.name}" /></a> - <c:out value="${gcBox.count}" />作品</li>
			</c:forEach>
			</ol>
	</div>
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">サウンドクリエイター</h1>
			<ol class="count_result">
			<c:forEach var="scBox" items="${scBox}">
				<li><a href="<c:url value="SoundCreator_information"><c:param name="id" value="${scBox.id}" /></c:url>"><c:out value="${scBox.name}" /></a> - <c:out value="${scBox.count}" />作品</li>
			</c:forEach>
			</ol>
	</div>
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">声優</h1>
			<ol class="count_result">
			<c:forEach var="vaBox" items="${vaBox}">
				<li><a href="<c:url value="VoiceActor_information"><c:param name="id" value="${vaBox.id}" /></c:url>"><c:out value="${vaBox.name}" /></a> - <c:out value="${vaBox.count}" />作品</li>
			</c:forEach>
			</ol>
	</div>
	<div class="box">
		<!-- jsp count data and make ranking -->
		<h1 class="box_title">声優（表）</h1>
			<ol class="count_result">
			<c:forEach var="avBox" items="${avBox}">
				<li><a href="<c:url value="AnimationVA_information"><c:param name="id" value="${avBox.id}" /></c:url>"><c:out value="${avBox.name}" /></a> - <c:out value="${avBox.count}" />作品</li>
			</c:forEach>
			</ol>
	</div>
	<div class="clear"></div>
</div>
<jsp:include page="/Common/footer.jsp"/>
</body>
</html>