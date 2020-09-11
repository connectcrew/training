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

<h1 class="contents_title"><c:out value="${brInfo[0].brName}" /></h1>
<div class="information_list">
	<table class="contents_info">
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
			<th class="column2">最新3タイトル</th>
			<th class="column3">
			<c:forEach var="brInfo" items="${brInfo}">
				<div class="name"><a href="<c:url value="product_information"><c:param name="id" value="${brInfo.piId}" /></c:url>"><c:out value="${brInfo.title}" /></a></div>
			</c:forEach>
			</th>
		</tr>
	</table>
</div>
<jsp:include page="/Common/footer.jsp"/>
</body>
</html>