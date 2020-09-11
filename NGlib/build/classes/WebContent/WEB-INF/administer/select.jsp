<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/Common/head.jsp"/>
<title>NGlib管理ツール</title>
</head>
<body>
<jsp:include page="/Common/header.jsp"/>

<jsp:include page="/Common/body.jsp"/>

<div class="admin_container">
<form action="adminSelect" method="post">

<p>
カテゴリ：
<select name="category" onchange="submit(this.form)">
<option value="pi" <c:if test="${getCategory == 'pi'}">selected="selected"</c:if>>製品情報</option>
<option value="co" <c:if test="${getCategory == 'co'}">selected="selected"</c:if>>会社/グループ</option>
<option value="br" <c:if test="${getCategory == 'br'}">selected="selected"</c:if>>ブランド</option>
<option value="pr" <c:if test="${getCategory == 'pr'}">selected="selected"</c:if>>プロデューサー</option>
<option value="sw" <c:if test="${getCategory == 'sw'}">selected="selected"</c:if>>シナリオライター</option>
<option value="il" <c:if test="${getCategory == 'il'}">selected="selected"</c:if>>イラストレーター</option>
<option value="gc" <c:if test="${getCategory == 'gc'}">selected="selected"</c:if>>グラフィックデザイナー</option>
<option value="sc" <c:if test="${getCategory == 'sc'}">selected="selected"</c:if>>サウンドクリエイター</option>
<option value="va" <c:if test="${getCategory == 'va'}">selected="selected"</c:if>>声優</option>
<option value="av" <c:if test="${getCategory == 'av'}">selected="selected"</c:if>>声優（表）</option>
</select>
検索文字列：
<input type="text" name="name" size="20" value="<c:out value="${getName}" />">
<input type="submit" value="検索">
　　
<input type="button" onclick="location.href='<c:url value="adminInsert"><c:param name="category" value="${getCategory}" /></c:url>'" value="新規作成">
</p>

<table class="list_table">
<c:forEach var="List" items="${List}">
<tr>
<th class="list_column">
<c:choose>
	<c:when test="${getCategory == 'pi'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="pi" /><c:param name="id" value="${List.piId}" /></c:url>"><c:out value="${List.title}" /></a></c:when>
	<c:when test="${getCategory == 'co'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="co" /><c:param name="id" value="${List.coId}" /></c:url>"><c:out value="${List.coName}" /></a></c:when>
	<c:when test="${getCategory == 'br'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="br" /><c:param name="id" value="${List.brId}" /></c:url>"><c:out value="${List.brName}" /></a></c:when>
	<c:when test="${getCategory == 'pr'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="pr" /><c:param name="id" value="${List.crId}" /></c:url>"><c:out value="${List.name}" /></a></c:when>
	<c:when test="${getCategory == 'sw'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="sw" /><c:param name="id" value="${List.crId}" /></c:url>"><c:out value="${List.name}" /></a></c:when>
	<c:when test="${getCategory == 'il'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="il" /><c:param name="id" value="${List.crId}" /></c:url>"><c:out value="${List.name}" /></a></c:when>
	<c:when test="${getCategory == 'gc'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="gc" /><c:param name="id" value="${List.crId}" /></c:url>"><c:out value="${List.name}" /></a></c:when>
	<c:when test="${getCategory == 'sc'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="sc" /><c:param name="id" value="${List.crId}" /></c:url>"><c:out value="${List.name}" /></a></c:when>
	<c:when test="${getCategory == 'va'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="va" /><c:param name="id" value="${List.vaId}" /></c:url>"><c:out value="${List.vaName}" /></a></c:when>
	<c:when test="${getCategory == 'av'}"><a href="<c:url value="adminUpdate"><c:param name="category" value="av" /><c:param name="id" value="${List.avId}" /></c:url>"><c:out value="${List.avName}" /></a></c:when>
</c:choose>
</th>
</tr >
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
</div>

<jsp:include page="/Common/footer.jsp"/>
</body>
</html>