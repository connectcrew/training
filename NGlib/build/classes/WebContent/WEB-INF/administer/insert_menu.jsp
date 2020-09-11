<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/Common/head.jsp"/>
<title>NGlib管理ツール</title>
</head>
<body>
<jsp:include page="/Common/header.jsp"/>
<jsp:include page="/Common/body.jsp"/>

<h1 class="contents_title">新規登録＞カテゴリ選択</h1>
<div class="admin_menu">
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="pi" /><c:param name="id" value="${List.piId}" /></c:url>">製品情報</a></div>
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="co" /><c:param name="id" value="${List.coId}" /></c:url>">会社/組織</a></div>
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="br" /><c:param name="id" value="${List.brId}" /></c:url>">ブランド</a></div>
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="pr" /><c:param name="id" value="${List.crId}" /></c:url>">プロデューサー</a></div>
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="sw" /><c:param name="id" value="${List.crId}" /></c:url>">シナリオライター</a></div>
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="il" /><c:param name="id" value="${List.crId}" /></c:url>">イラストレーター</a></div>
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="gc" /><c:param name="id" value="${List.crId}" /></c:url>">グラフィッククリエイター</a></div>
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="sc" /><c:param name="id" value="${List.crId}" /></c:url>">サウンドクリエイター</a></div>
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="va" /><c:param name="id" value="${List.vaId}" /></c:url>">声優</a></div>
	<div class="menu_box"><a class="menu_a" href="<c:url value="adminInsert"><c:param name="category" value="av" /><c:param name="id" value="${List.avId}" /></c:url>">声優（全年齢版）</a></div>
	<div class="clear"></div>
</div>

<jsp:include page="/Common/footer.jsp"/>
</body>
</html>