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

<h1 class="list_head"> 声優事務所一覧（件数降順） </h1>
<table class="list_table">
<tr>
<th class="list_column">事務所名</th>
<th class="list_column">登録製品件数</th>
</tr>

<c:forEach var="aoList" items="${aoList}">
<tr>
<th class="list_column"><a href="<c:url value="AffilicationOffice_information"><c:param name="id" value="${aoList.aoId}" /></c:url>"><c:out value="${aoList.aoName}" /></a></th>
<th class="list_column"><c:out value="${aoList.count}" /></th>
</tr>
</c:forEach>
</table>


<jsp:include page="/Common/footer.jsp"/>
</body>
</html>