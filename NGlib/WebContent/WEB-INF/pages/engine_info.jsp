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

<h1 class="list_head"> <c:out value="${engineInfo[0].engine}" /> を使用しているタイトル一覧（発売日降順） </h1>
<table class="list_table">
<tr>
<th class="list_column">タイトル</th>
<th class="list_column">ブランド</th>
<th class="list_column">発売日</th>
</tr>

<c:forEach var="engineInfo" items="${engineInfo}">
<tr>
<th class="list_column"><a href="<c:url value="product_information"><c:param name="id" value="${engineInfo.piId}" /></c:url>"><c:out value="${engineInfo.title}" /></a></th>
<th class="list_column"><a href="<c:url value="brand_information"><c:param name="id" value="${engineInfo.brId}" /></c:url>"><c:out value="${engineInfo.brName}" /></a></th>
<th class="list_column"><c:out value="${engineInfo.release}" /></th>
</tr>
</c:forEach>
</table>


<jsp:include page="/Common/footer.jsp"/>
</body>
</html>