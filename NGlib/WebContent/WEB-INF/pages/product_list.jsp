<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<jsp:include page="/Common/head.jsp"/>
<body>
<jsp:include page="/Common/header.jsp"/>

<jsp:include page="/Common/body.jsp"/>


<h1 class="list_head"> タイトル一覧（発売日降順） </h1>

<form action="product_list" method="post">
<div class="formHeader">
<div class="searchBox">
	タイトル：<input type="text" name="name" size="40" value="<c:out value="${getName}" />">
	<input type="submit" value="検索">
</div>
<div class="searchBox">
	ブランド：
	<select name="brand">
		<option value="">----</option>
		<c:forEach var="brandList" items="${brandList}">
			<option value="<c:out value="${brandList.brName}" />" <c:if test="${brandList.brName == brand}">selected="selected"</c:if>><c:out value="${brandList.brName}" /></option>
		</c:forEach>
	</select>
	<input type="submit" value="検索">
</div>
<div class="searchBox">
	検索する発売日：
	<select name="year">
		<option value="____">----</option>
		<c:forEach var="yearList" items="${yearList}">
			<option value="<c:out value="${yearList.year}" />" <c:if test="${yearList.year == year}">selected="selected"</c:if>><c:out value="${yearList.year}" /></option>
		</c:forEach>
	</select>
	年　
	<select name="month">
		<option value="__">--</option>
		<c:forEach var="i" begin="01" end="9">
			<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
		</c:forEach>
		<c:forEach var="i" begin="10" end="12">
			<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
		</c:forEach>
	</select>
	月　
	<select name="day">
		<option value="__">--</option>
		<c:forEach var="i" begin="1" end="9">
			<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
		</c:forEach>
		<c:forEach var="i" begin="10" end="31">
			<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
		</c:forEach>
	</select>
	日
	<input type="submit" value="検索">
</div>
</div>
<div class="clear"></div>


<table class="list_table">
<tr>
	<th class="list_column">タイトル</th>
	<th class="list_column">ブランド</th>
	<th class="list_column">発売日</th>
	<th class="list_column">シリーズ</th>
	<th class="list_column">コメント</th>
</tr>

<c:forEach var="piList" items="${piList}">
	<tr>
		<th class="list_column"><a href="<c:url value="product_information"><c:param name="id" value="${piList.piId}" /></c:url>"><c:out value="${piList.title}" /></a></th>
		<th class="list_column"><a href="<c:url value="brand_information"><c:param name="id" value="${piList.brId}" /></c:url>"><c:out value="${piList.brand}" /></a></th>
		<th class="list_column"><c:out value="${piList.release}" /></th>
		<th class="list_column"><a href="<c:url value="series_information"><c:param name="id" value="${piList.series}" /></c:url>"><c:out value="${piList.series}" /></a></th>
		<th class="list_column"><c:out value="${piList.comment}" /></th>
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