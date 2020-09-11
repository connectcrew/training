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

<h1 class="contents_title">管理者メニュー</h1>
<p>ようこそ、<c:out value="${adminName}"/>さん。</p>

<div class="admin_menu">
	<div class="menu_box"><a class="menu_a" href="adminSelect">登録情報の確認/修正</a></div>
	<div class="menu_box"><a class="menu_a" href="adminInsertMenu">新規登録</a></div>
</div>
<jsp:include page="/Common/footer.jsp"/>
</body>
</html>