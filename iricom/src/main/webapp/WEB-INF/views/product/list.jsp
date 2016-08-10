<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>또바기</title>
<%@ include file="/WEB-INF/views/include/css.jsp"%>
</head>
<body class="sidebar-mini hold-transition skin-black-light ">
	<div class="wrapper layout-top-nav">
		<%@ include file="/WEB-INF/views/include/header.jsp" %>
	</div>
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/include/side.jsp" %>
		<!-- Full Width Column -->
		<div class="content-wrapper">
			<!-- Main content -->
			<section class="content">
				<c:choose>
					<c:when test="${empty productVoList}">
						<tr>
							<td colspan="5">등록된 상품이 없습니다.</td>
						</tr>
					</c:when>

					<c:otherwise>
						<c:forEach var="list" items="${productVoList}">
							<c:set var="query"
								value="cate=${param.cate}&pno=${list.number }&pname=${list.productName}" />
							<div class="col-md-3">
							<a href="<c:url value="detail?${query}"/> ">
								<img class="img-thumbnail" src="<%=request.getContextPath() %>/resources/image/${list.storedFileName}">
								<p class="text-center"> ${list.brandName}<br> ${list.productName}<br> ₩${list.price }<br> </p>
							</a>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
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
