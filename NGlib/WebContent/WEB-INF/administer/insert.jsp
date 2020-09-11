<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/Common/head.jsp"/>
<script type="text/javascript" src="http://localhost:8080/NGlib/js/formController.js"></script>
<title>NGlib管理ツール</title>
</head>
<body>
<jsp:include page="/Common/header.jsp"/>

<jsp:include page="/Common/body.jsp" />

<h1 class="contents_title">新規登録</h1>
<div class="admin_container">
	<form action="adminInsert" method="post">
	<input type="hidden" name="category" value="<c:out value="${getCategory}" />">
		<div class="information_list">
			<table class="contents_info">
				<c:choose>
					<c:when test="${getCategory == 'pi'}">
						<tr>
							<th class="column1" rowspan="15"><input type="file" name="img" accept=".png"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">製品情報</th>
						</tr>
						<tr>
							<th class="column2">タイトル</th>
							<th class="column3">
							<input id="title" type="text" name="title" size="60"><br>
							<div id="exception1"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">ブランド</th>
							<th class="column3">
								<select id="brand" name="brId">
								<option value="null">選択してください。</option>
								<c:forEach var="brandSelectList" items="${brandSelectList}">
									<option value="<c:out value="${brandSelectList.brId}" />"><c:out value="${brandSelectList.brName}" /></option>
								</c:forEach>
							</select>
							<div id="exception2"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">発売日</th>
							<th class="column3">
							<select id="year" name="year">
								<option value="____">----</option>
								<c:forEach var="yearList" begin="1920" end="2020" >
									<option value="<c:out value="${yearList}" />"><c:out value="${yearList}" /></option>
								</c:forEach>
							</select>
							年　
							<select id="month" name="month">
								<option value="__">--</option>
								<c:forEach var="i" begin="01" end="9">
									<option value="0<c:out value="${i}" />"><c:out value="${i}" /></option>
								</c:forEach>
								<c:forEach var="i" begin="10" end="12">
									<option value="<c:out value="${i}" />"><c:out value="${i}" /></option>
								</c:forEach>
							</select>
							月　
							<select id="day" name="day">
								<option value="__">--</option>
								<c:forEach var="i" begin="1" end="9">
									<option value="0<c:out value="${i}" />"><c:out value="${i}" /></option>
								</c:forEach>
								<c:forEach var="i" begin="10" end="31">
									<option value="<c:out value="${i}" />"><c:out value="${i}" /></option>
								</c:forEach>
							</select>
							日
							<div id="exception3"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">シリーズ</th>
							<th class="column3">
							<select name="series" onchange="switchBox(this.value)">
								<option value="null">----</option>
								<option value="new">【新規登録】</option>
								<c:forEach var="seriesSelectList" items="${seriesSelectList}">
									<option value="<c:out value="${seriesSelectList.series}" />" ><c:out value="${seriesSelectList.series}"></c:out></option>
								</c:forEach>
							</select>
							<input id="newSeries" type="text" name="newSeries" size="40" disabled="disabled">
							</th>
						</tr>
						<tr>
							<th class="column2">ゲームエンジン</th>
							<th class="column3">
							<select name="engine">
								<option value="null">----</option>
								<c:forEach var="engineSelectList" items="${engineSelectList}">
									<option value="<c:out value="${engineSelectList.engine}" />"><c:out value="${engineSelectList.engine}" /></option>
								</c:forEach>
							</select>
							</th>
						</tr>
						<tr>
							<th class="column2">コメント</th>
							<th class="column_comment"><textarea name="comment" rows="4" cols="60"></textarea></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">製作スタッフ</th>
						</tr>
						<tr>
							<th class="column2">プロデューサー</th>
							<th class="column3">
								<select id="prSelecter" name="producer0">
								<option value="null">----</option>
							 	<c:forEach var="prSelectList" items="${prSelectList}">
									<option value="<c:out value="${prSelectList.crId}" />"><c:out value="${prSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="pr1"></div>
								<button type="button" onclick="prArea.add();">追加</button>
								<button type="button" onclick="prArea.remove();">削除</button>
								<input id="prlength" type="hidden" name="prlength" value="1">
							</th>
						</tr>
						<tr>
							<th class="column2">シナリオ</th>
							<th class="column3">
								<select id="swSelecter" name="scenariowriter0">
								<option>----</option>
							 	<c:forEach var="swSelectList" items="${swSelectList}">
									<option value="<c:out value="${swSelectList.crId}" />"><c:out value="${swSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="sw1"></div>
								<button type="button" onclick="swArea.add();">追加</button>
								<button type="button" onclick="swArea.remove();">削除</button>
								<input id="swlength" type="hidden" name="swlength" value="1">
							</th>
						</tr>
						<tr>
							<th class="column2">イラスト</th>
							<th class="column3">
								<select id="ilSelecter" name="illustrator0">
								<option>----</option>
							 	<c:forEach var="ilSelectList" items="${ilSelectList}">
									<option value="<c:out value="${ilSelectList.crId}" />"><c:out value="${ilSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="il1"></div>
								<button type="button" onclick="ilArea.add();">追加</button>
								<button type="button" onclick="ilArea.remove();">削除</button>
								<input id="illength" type="hidden" name="illength" value="1">
							</th>
						</tr>
						<tr>
							<th class="column2">グラフィック</th>
							<th class="column3">
								<select id="gcSelecter" name="graphiccreator0">
								<option>----</option>
							 	<c:forEach var="gcSelectList" items="${gcSelectList}">
									<option value="<c:out value="${gcSelectList.crId}" />"><c:out value="${gcSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="gc1"></div>
								<button type="button" onclick="gcArea.add();">追加</button>
								<button type="button" onclick="gcArea.remove();">削除</button>
								<input id="gclength" type="hidden" name="gclength" value="1">
							</th>
						</tr>
						<tr>
							<th class="column2">サウンド</th>
							<th class="column3">
								<select id="scSelecter" name="soundcreator0">
								<option>----</option>
							 	<c:forEach var="scSelectList" items="${scSelectList}">
									<option value="<c:out value="${scSelectList.crId}" />"><c:out value="${scSelectList.name}" /></option>
								</c:forEach>
						 		</select>
								<div id="sc1"></div>
								<button type="button" onclick="scArea.add();">追加</button>
								<button type="button" onclick="scArea.remove();">削除</button>
								<input id="sclength" type="hidden" name="sclength" value="1">
							</th>
						</tr>
						<tr>
							<th class="column2">出演声優</th>
							<th class="column3">
								<select id="vaSelecter" name="voiceactor0">
								<option>----</option>
							 	<c:forEach var="vaSelectList" items="${vaSelectList}">
									<option value="<c:out value="${vaSelectList.vaId}" />"><c:out value="${vaSelectList.vaName}" /></option>
								</c:forEach>
						 		</select>
								<div id="va1"></div>
								<button type="button" onclick="vaArea.add();">追加</button>
								<button type="button" onclick="vaArea.remove();">削除</button>
								<input id="valength" type="hidden" name="valength" value="1">
							</th>
						</tr>
						<tr>
							<th class="column_title" colspan="3">あらすじ</th>
						</tr>
						<tr>
							<th class="column_txt" colspan="3">
							<textarea name="text" rows="6" cols="120"></textarea>
							</th>
						</tr>
						<tr>
							<th colspan="3"><div class="searchPage"><button type="submit" onclick="return checkPi();">内容確定(プレビューへ) >></button></div></th>
						</tr>
					</c:when>




					<c:when test="${getCategory == 'co'}">
						<tr>
							<th class="column1" rowspan="5"><input type="file" name="img" accept=".png"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">企業情報</th>
						</tr>
						<tr>
							<th class="column2">会社名</th>
							<th class="column3">
							<input id="coName" type="text" name="coName" size="60"><br>
							<div id="exception1"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">設立年</th>
							<th class="column3">
								<select name="year">
								<option>----</option>
								<c:forEach var="yearList" begin="1920" end="2020" >
									<option value="<c:out value="${yearList}" />"><c:out value="${yearList}" /></option>
								</c:forEach>
							</select>
							年　
							</th>
						</tr>
						<tr>
							<th class="column2">住所</th>
							<th class="column3"><input type="text" name="coAddress" size="60"></th>
						</tr>
						<tr>
							<th colspan="3"><div class="searchPage"><button type="submit" onclick="return checkCo();">内容確定(プレビューへ) >></button></div></th>
						</tr>
					</c:when>




					<c:when test="${getCategory == 'br'}">
						<tr>
							<th class="column1" rowspan="4"><input type="file" name="img" accept=".png"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">ブランド情報</th>
						</tr>
						<tr>
							<th class="column2">ブランド名</th>
							<th class="column3">
							<input id="brName" type="text" name="brName" size="60"><br>
							<div id="exception1"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">所属</th>
							<th class="column3">
							<select id="company" name="coId">
								<option value="null">----</option>
								<c:forEach var="coSelectList" items="${coSelectList}">
									<option value="<c:out value="${coSelectList.coId}" />"><c:out value="${coSelectList.coName}" /></option>
								</c:forEach>
							</select>
							<div id="exception2"></div>
							</th>
						</tr>
						<tr>
							<th colspan="3"><div class="searchPage"><button type="submit" onclick="return checkBr();">内容確定(プレビューへ) >></button></div></th>
						</tr>
					</c:when>




					<c:when test="${getCategory == 'pr' || getCategory == 'sw' || getCategory == 'il' || getCategory == 'gc' || getCategory == 'sc'}">
						<tr>
							<th class="column1" rowspan="9"><input type="file" name="img" accept=".png"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3">
							苗字：<input type="text" name="fname" size="15"><br>
							名前：<input id="name" type="text" name="name" size="15">（苗字のない名前はこちらに記載してください。）
							<div id="exception1"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="gender" value="男性">男性
								<input type="radio" name="gender" value="女性">女性
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3">
							<select name="place">
							<option value="null">----</option>
							<c:forEach var="prefectures" items="${prefectures}">
								<option value="<c:out value="${prefectures.prefecture}" />"><c:out value="${prefectures.prefecture}" /></option>
							</c:forEach>
							</select>
							</th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select id="month" name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select id="day" name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
								<div id="exception2"></div><div id="exception3"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select name="blood">
								<option value="null">----</option>
								<option value="A">A型</option>
								<option value="B">B型</option>
								<option value="O">O型</option>
								<option value="AB">AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属ブランド</th>
							<th class="column3">
								<select name="brId">
								<option value="null">----</option>
								<c:forEach var="brandSelectList" items="${brandSelectList}">
									<option value="<c:out value="${brandSelectList.brId}" />"><c:out value="${brandSelectList.brName}" /></option>
								</c:forEach>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">所属サークル</th>
							<th class="column3">
								<select name="clId">
								<option value="null">----</option>
								<c:forEach var="clubSelectList" items="${clubSelectList}">
								<option value="<c:out value="${clubSelectList.clId}" />"><c:out value="${clubSelectList.clName}" /></option>
								</c:forEach>
								</select>
							</th>
						</tr>
						<tr>
							<th colspan="3"><div class="searchPage"><button type="submit" onclick="return checkCr();">内容確定(プレビューへ) >></button></div></th>
						</tr>
					</c:when>


					<c:when test="${getCategory == 'va'}">
						<tr>
							<th class="column1" rowspan="10"><input type="file" name="img" accept=".png"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3">
							苗字：<input type="text" name="fname" size="15">　かな：<input type="text" name="fspell" size="15"><br>
							名前：<input id="name" type="text" name="name" size="15">　かな：<input id="spell" type="text" name="ruby" size="15">
							<div id="exception1"></div><div id="exception2"></div>
							<p>（苗字のない名前の場合は、名前の欄に記載してください。）</p>
							</th>
						</tr>
						<tr>
							<th class="column2">全年齢版名義</th>
							<th class="column3">
								<select name="avId">
								<option value="null">----</option>
								<c:forEach var="avSelectList" items="${avSelectList}">
									<option value="<c:out value="${avSelectList.avId}" />"><c:out value="${avSelectList.avName}" /></option>
								</c:forEach>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="gender" value="男性">男性
								<input type="radio" name="gender" value="女性">女性
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3">
							<select name="place">
							<option value="null">----</option>
							<c:forEach var="prefectures" items="${prefectures}">
								<option value="<c:out value="${prefectures.prefecture}" />"><c:out value="${prefectures.prefecture}" /></option>
							</c:forEach>
							</select>
							</th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
								<select id="month" name="month">
									<option value="__">--</option>
									<c:forEach var="i" begin="01" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="12">
										<option value="<c:out value="${i}" />" <c:if test="${i == month}">selected="selected"</c:if>><c:out value="${i}" />月</option>
									</c:forEach>
								</select>
								月　
								<select id="day" name="day">
									<option value="__">--</option>
									<c:forEach var="i" begin="1" end="9">
										<option value="0<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
									<c:forEach var="i" begin="10" end="31">
										<option value="<c:out value="${i}" />" <c:if test="${i == day}">selected="selected"</c:if>><c:out value="${i}" />日</option>
									</c:forEach>
								</select>
								日
								<div id="exception3"></div><div id="exception4"></div>
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select name="blood">
								<option value="null">----</option>
								<option value="A">A型</option>
								<option value="B">B型</option>
								<option value="O">O型</option>
								<option value="AB">AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">デビュー</th>
							<th class="column3">
								<select name="debut">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
							</th>
						</tr>
						<tr>
							<th class="column2">所属事務所</th>
							<th class="column3">
							<select name="aoId">
							<option value="null">----</option>
							<c:forEach var="aoSelectList" items="${aoSelectList}">
								<option value="<c:out value="${aoSelectList.aoId}" />"><c:out value="${aoSelectList.aoName}" /></option>
							</c:forEach>
							</select>
							</th>
						</tr>
						<tr>
							<th colspan="3"><div class="searchPage"><button type="submit" onclick="return checkVA();">内容確定(プレビューへ) >></button></div></th>
						</tr>
					</c:when>



					<c:when test="${getCategory == 'av'}">
						<tr>
							<th class="column1" rowspan="9"><img src="http://localhost:8080/NGlib/img/dummy.jpg" width="350px" height="auto"></th>
						</tr>
						<tr>
							<th class="column_title" colspan="2">人物情報</th>
						</tr>
						<tr>
							<th class="column2">名前</th>
							<th class="column3">
							苗字：<input type="text" name="fname" size="15">　かな：<input type="text" name="fruby" size="15"><br>
							名前：<input id="name" type="text" name="name" size="15">　かな：<input id="ruby" type="text" name="ruby" size="15">
							<div id="exception1"></div><div id="exception2"></div>
							<p>（苗字のない名前の場合は、名前の欄に記載してください。）</p>
							</th>
						</tr>
						<tr>
							<th class="column2">性別</th>
							<th class="column3">
								<input type="radio" name="gender" value="男性">男性
								<input type="radio" name="gender" value="女性">女性
							</th>
						</tr>
						<tr>
							<th class="column2">出生地</th>
							<th class="column3">
							<select name="place">
							<option value="null">----</option>
							<c:forEach var="prefectures" items="${prefectures}">
								<option value="<c:out value="${prefectures.prefecture}" />"><c:out value="${prefectures.prefecture}" /></option>
							</c:forEach>
							</select>
							</th>
						</tr>
						<tr>
							<th class="column2">誕生日</th>
							<th class="column3">
								<select name="year">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
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
							</th>
						</tr>
						<tr>
							<th class="column2">血液型</th>
							<th class="column3">
								<select name="blood">
								<option value="----">----</option>
								<option value="A">A型</option>
								<option value="B">B型</option>
								<option value="O">O型</option>
								<option value="AB">AB型</option>
								</select>
							</th>
						</tr>
						<tr>
							<th class="column2">デビュー</th>
							<th class="column3">
								<select name="debut">
									<option value="____">----</option>
									<c:forEach var="yearList" begin="1920" end="2020" >
										<option value="<c:out value="${yearList}" />" <c:if test="${yearList == year}">selected="selected"</c:if>><c:out value="${yearList}" /></option>
									</c:forEach>
								</select>
								年　
							</th>
						</tr>
						<tr>
							<th class="column2">所属事務所</th>
							<th class="column3">
							<select name="aoId">
							<option value="____">----</option>
							<c:forEach var="aoSelectList" items="${aoSelectList}">
								<option value="<c:out value="${aoSelectList.aoId}" />"><c:out value="${aoSelectList.aoName}" /></option>
							</c:forEach>
							</select>
							</th>
						</tr>
						<tr>
							<th colspan="3"><div class="searchPage"><button type="submit" onclick="return checkVA();">内容確定(プレビューへ) >></button></div></th>
						</tr>
					</c:when>

				</c:choose>
			</table>
		</div>
	</form>
</div>
<jsp:include page="/Common/footer.jsp" />
</body>
</html>