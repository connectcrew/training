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

<h1 class="contents_title"><c:out value="${avInfo[0].avName}" /></h1>
<div class="information_list">
	<table class="contents_info">
		<tr>
			<th class="column1" rowspan="10"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
		</tr>
		<tr>
			<th class="column_title" colspan="2">人物情報</th>
		</tr>
		<tr>
			<th class="column2">名前</th>
			<th class="column3"><div class="name"><c:out value="${avInfo[0].avName}" /></div></th>
		</tr>
		<tr>
			<th class="column2">性別</th>
			<th class="column3"><div class="name"><c:out value="${avInfo[0].gender}" /></div></th>
		</tr>
		<tr>
			<th class="column2">出生地</th>
			<th class="column3"><div class="name"><c:out value="${avInfo[0].place}" /></div></th>
		</tr>
		<tr>
			<th class="column2">誕生日</th>
			<th class="column3"><div class="name"><c:out value="${avInfo[0].birthday}" /></div></th>
		</tr>
		<tr>
			<th class="column2">血液型</th>
			<th class="column3"><div class="name"><c:out value="${avInfo[0].blood}" /></div></th>
		</tr>
		<tr>
			<th class="column2">デビュー</th>
			<th class="column3"><div class="name"><c:out value="${avInfo[0].debut}" /></div></th>
		</tr>
		<tr>
			<th class="column2">所属事務所</th>
			<th class="column3"><div class="name"><a href="<c:url value="AffilicationOffice_information"><c:param name="id" value="${avInfo[0].aoId}" /></c:url>"><c:out value="${avInfo[0].aoName}" /></a></div></th>
		</tr>
		<tr>
			<th class="column2">裏名義</th>
			<th class="column3">
			<c:forEach var="avInfo" items="${avInfo}">
				<div class="name"><a href="<c:url value="VoiceActor_information"><c:param name="id" value="${avInfo.vaId}" /></c:url>"><c:out value="${avInfo.vaName}" /></a></div>
			</c:forEach>
			</th>
		</tr>
	</table>
</div>
<jsp:include page="/Common/footer.jsp"/>
</body>
</html>