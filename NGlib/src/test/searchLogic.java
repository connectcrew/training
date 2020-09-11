<form action="product_list" method="post">
<div class="formHeader">
	<div class="searchBox">
		タイトル：<input type="text" name="name" size="40" value="<c:out value="${getName}" />">
		<input type="submit" value="検索">
	</div>
</div>


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