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

<h1 class="contents_title"><c:out value="${seriesInfo[0].series}" /> シリーズ</h1>
<div class="information_list">
	<table class="contents_info">
		<tr>
			<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
		</tr>
		<tr>
			<th class="column_title" colspan="3">シリーズ作品一覧</th>
		</tr>

		<tr>
			<th class="column4">タイトル</th>
			<th class="column4">発売日</th>
			<th class="column4">コメント</th>
		</tr>
			<c:forEach var="seriesInfo" items="${seriesInfo}">
			<tr>
				<th class="column4">
					<a href="<c:url value="product_information"><c:param name="id" value="${seriesInfo.piId}" /></c:url>"><c:out value="${seriesInfo.title}" /></a>
				</th>
				<th class="column4">
					<c:out value="${seriesInfo.release}" />
				</th>
				<th class="column4">
					<c:out value="${seriesInfo.comment}" />
				</th>
			</tr>
			</c:forEach>


	</table>
</div>
<jsp:include page="/Common/footer.jsp"/>
</body>
</html>