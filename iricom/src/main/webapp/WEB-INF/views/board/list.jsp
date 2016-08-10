<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/views/include/css.jsp"%>
<title>또바기</title>
</head>
<body class="sidebar-mini hold-transition skin-black-light ">
	<div class="wrapper layout-top-nav">
		<%@ include file="/WEB-INF/views/include/header.jsp"%>
	</div>
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/include/side.jsp" %>
		<!-- Full Width Column -->
		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
			<!--
				<c:if test="${pagingVo.totalPageCount > 0}">
					<tr>
						<td colspan="5">${paging.firstRow}-${paging.endRow}
							[${paging.requestPage}/${paging.totalPageCount}]</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="5">${paging.firstRow}-${paging.endRow}
						[${paging.requestPage}/${paging.totalPageCount}]</td>
				</tr>
			-->
			<h4>게시판</h4>
				<table class="table table-bordered table-hover">
					<tr>
						<th scope="col">NO</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">작성일</th>
						<th scope="col">조회수</th>
					</tr>

					<c:choose>
						<c:when test="${hasItem == false}">
							<tr>
								<td colspan="5">게시글이 없습니다.</td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach var="list" items="${boardVoList}">
								<tr role="row">
									<td>${list.number}</td>
									<td><c:set var="query"
											value="p=${pagingVo.requestPage}&boardName=${list.boardName}" />
										<a href="<c:url value="read?${query}"/> "> ${list.title}
											<span class="label label-success">${list.commentCount}</span> </a></td>
									<td>${list.userId}</td>
									<td><fmt:formatDate value="${list.postingDate}"
											pattern="yyyy-MM-dd" /></td>
									<td>${list.readCount}</td>
								</tr>
							</c:forEach>
							<%-- Paging --%>
							<tr>
								<td colspan="5" align="center"><c:if
										test="${paging.beginPage > 10}">
										<a href="<c:url value="list.do?p=${paging.beginPage-1}"/> ">이전</a>
									</c:if> <c:forEach var="pno" begin="${paging.beginPage}"
										end="${paging.endPage}">
										<a href="<c:url value="list.do?p=${pno}"/> ">[${pno}]</a>
									</c:forEach> <c:if test="${paging.endPage < paging.totalPageCount}">
										<a href="<c:url value="list.do?p=${paging.endPage + 1}"/> ">다음</a>
									</c:if></td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
				<a href="./write?bn=${param.bn }">글 쓰기</a>
			</section>
			<!-- /.content -->

		</div>
	</div>
	<div class="wrapper layout-top-nav">
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
	<%@ include file="/WEB-INF/views/include/js.jsp"%>

</body>
</html>