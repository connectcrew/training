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

<h1 class="contents_title"><c:out value="${aoInfo[0].aoName}" /></h1>
<div class="information_list">
	<table class="contents_info">
		<tr>
			<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
		</tr>
		<tr>
			<th class="column_title" colspan="2">Information</th>
		</tr>
		<tr>
			<th class="column2">名前</th>
			<th class="column3"><div class="name"><c:out value="${aoInfo[0].aoName}" /></div></th>
		</tr>
		<tr>
			<th class="column2">所属声優</th>
			<th class="column3">
			<c:forEach var="aoInfo" items="${aoInfo}">
				<div class="name"><a href="<c:url value="AnimationVA_information"><c:param name="id" value="${aoInfo.avId}" /></c:url>"><c:out value="${aoInfo.avName}" /></a></div>
			</c:forEach>
			</th>
		</tr>
	</table>
</div>
<jsp:include page="/Common/footer.jsp"/>
</body>
</html>