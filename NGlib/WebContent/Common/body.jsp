<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- ここからbody部分です。 -->
<div class="countainer">
	<!-- サイドバーとコンテンツ部分をFloatを使わずに分割するためにTable属性を使います。 -->
	<table class="workbreak_countainer">
		<tr class="workbreak_countainer">
			<!-- left table にてサイドバーを作ります。 -->
			<td class="ltable">
				<div class="side_bar">
					<h1 class="side_topic1">一覧ページ</h1>
					<ul class="side_ul">
						<li><a href="product_list">タイトル</a></li>
						<li><a href="series_list">シリーズ</a></li>
						<li><a href="company_list">会社/グループ</a></li>
						<li><a href="brand_list">ブランド</a></li>
						<li><a href="producer_list">プロデューサー</a></li>
						<li><a href="ScenarioWriter_list">シナリオライター</a></li>
						<li><a href="illustrator_list">イラストレーター</a></li>
						<li><a href="GraphicCreator_list">グラフィッククリエイター</a></li>
						<li><a href="SoundCreator_list">サウンドクリエイター</a></li>
						<li><a href="VoiceActor_list">声優</a></li>
						<li><a href="AnimationVA_list">声優(表名義)</a></li>
						<li><a href="engine_list">ゲームエンジン</a></li>
					</ul>
					<h1 class="side_topic1">新着</h1>
					<ul class="side_ul">
					<c:forEach var="newerBox" items="${newerBox}">
						<li><a href="<c:url value="product_information"><c:param name="id" value="${newerBox.id}" /></c:url>"><c:out value="${newerBox.name}" /></a> - <c:out value="${newerBox.count}" />更新</li>
					</c:forEach>
					</ul>
				</div>
			</td>
			<td class="rtable">
				<div class="contents">
