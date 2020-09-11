<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<jsp:include page="/Common/head.jsp"/>
<script type="text/javascript" src="http://localhost:8080/NGlib/js/adminLogin.js"></script>
<body>
<jsp:include page="/Common/header.jsp"/>
<jsp:include page="/Common/body.jsp"/>

<h1 class="contents_title">管理者ログイン</h1>
<form action="adminTop" method="post">
ID:<input id="id" type="text" name="id" size="60">
<div id="exception1"></div>
pass:<input id="pass" type="text" name="pass" size="60">
<div id="exception2"></div>
<c:if test="${loginfalse == 1}"><div id="exception3">IDまたはパスワードが違います。</div></c:if>
<button type="submit" onclick="return checkLogin();">ログイン</button>
</form>

<jsp:include page="/Common/footer.jsp"/>
</body>
</html>