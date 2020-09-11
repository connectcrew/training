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

<h1 class="contents_title"> Insert new page Title </h1>
<p>そのタイトル・名前は既に登録されています。</p>
<p>または、スタッフの項目に重複があります。</p>


<jsp:include page="/Common/footer.jsp"/>
</body>
</html>