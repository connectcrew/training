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

<h1 class="list_head"> サウンドクリエイター一覧（件数降順） </h1>

<form action="SoundCreator_list" method="post">
<div class="formHeader">
	<div class="searchBox">
		サウンドクリエイター名：<input type="text" name="name" size="40" value="<c:out value="${getName}" />">
		<input type="submit" value="検索">
	</div>
</div>

<table class="list_table">
<tr>
<th class="list_column">名前</th>
<th class="list_column">所属ブランド</th>
<th class="list_column">所属サークル</th>
<th class="list_column">登録製品件数</th>
</tr>

<c:forEach var="scList" items="${scList}">
<tr>
<th class="list_column"><a href="<c:url value="SoundCreator_information"><c:param name="id" value="${scList.crId}" /></c:url>"><c:out value="${scList.name}" /></a></th>
<th class="list_column"><a href="<c:url value="brand_information"><c:param name="id" value="${scList.brId}" /></c:url>"><c:out value="${scList.brand}" /></a></th>
<th class="list_column"><c:out value="${scList.club}" /></th>
<th class="list_column"><c:out value="${scList.count}" /></th>
</tr>
</c:forEach>
</table>

<c:if test="${1 < page}">
	<div class="searchPage">
		<c:forEach var="i" begin="1" end="${page}">
			<button type="submit" name="searchPage" value="<c:out value="${20 * (i-1)}" />">
				<c:out value="${ i }" />
			</button>
		</c:forEach>
	</div>
</c:if>


</form>
<jsp:include page="/Common/footer.jsp"/>
</body>
</html>