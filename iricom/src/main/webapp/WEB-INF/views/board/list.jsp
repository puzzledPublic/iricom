<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	<table>
		<tr>
			<th scope="col">글 번호</th>
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
					<tr>
						<td>${list.number}</td>
						<td><c:set var="query"
								value="p=${pagingVo.requestPage}&boardName=${list.boardName}" />
							<a href="<c:url value="read?${query}"/> "> ${list.title}
								(${list.commentCount}) </a></td>
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
</body>
</html>