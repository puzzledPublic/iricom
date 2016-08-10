<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>또바기</title>
<%@ include file="/WEB-INF/views/include/css.jsp"%>
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
				<div>
					<div class="col-md-6">
						<img class="img-thumbnail"
							src="<%=request.getContextPath() %>/resources/image/${fileVo.storedFileName}">
					</div>
					<div class="col-md-6">
						<h3>${productVo.productName }</h3>
						<div>
							<table class="table">
								<tbody>
									<tr>
										<th>상품명</th>
										<td>${productVo.productName }</td>
									</tr>
									<tr>
										<th>브랜드</th>
										<td>${productVo.brandName }</td>
									</tr>
									<tr>
										<th>소재</th>
										<td>${productVo.material }</td>
									</tr>
									<tr>
										<th>판매가</th>
										<td>${productVo.price }</td>
									</tr>
									<tr>
										<th>배송비</th>
										<td>2500</td>
									</tr>
									
								</tbody>	
							</table>
							<table class="table">
								<tbody>
									<tr>
										<th>사이즈</th>
										<td>
											<select class="form-control">
												<option>(필수)옵션</option>
												<c:forEach var="size" items="${productVo.sizeAndStock }">
													<option>${size.key }</option>
												</c:forEach>
											</select>
										</td>
									</tr>	
								</tbody>	
							</table>
						</div>
					</div>
				</div>
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