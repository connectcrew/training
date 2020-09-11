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

<h1 class="contents_title"><c:out value="${coInfo[0].coName}" /></h1>
<div class="information_list">
	<table class="contents_info">
		<tr>
			<!-- ここに所持ブランドの画像出します。 -->
			<th class="column1" rowspan="6"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
		</tr>
		<tr>
			<th class="column_title" colspan="2">企業情報</th>
		</tr>
		<tr>
			<th class="column2">会社名</th>
			<th class="column3"><div class="name"><c:out value="${coInfo[0].coName}" /></div></th>
		</tr>
		<tr>
			<th class="column2">設立年</th>
			<th class="column3"><div class="name"><c:out value="${coInfo[0].year}" /></div></th>
		</tr>
		<tr>
			<th class="column2">住所</th>
			<th class="column3"><div class="name"><c:out value="${coInfo[0].address}" /></div></th>
		</tr>
		<tr>
			<th class="column2">所属ブランド</th>
			<th class="column3">
			<c:forEach var="coInfo" items="${coInfo}">
				<div class="name"><a href="<c:url value="brand_information"><c:param name="id" value="${coInfo.brId}" /></c:url>"><c:out value="${coInfo.brName}" /></a></div>
			</c:forEach>
			</th>
		</tr>
	</table>
</div>
<jsp:include page="/Common/footer.jsp"/>
</body>
</html>