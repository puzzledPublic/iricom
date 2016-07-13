<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = pageContext.getServletContext().getContextPath();%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>또바기</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="<%= path %>/resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%= path %>/resources/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<%= path %>/resources/dist/css/skins/_all-skins.min.css">
</head>
<body class="sidebar-mini hold-transition skin-black-light ">
	<div class="wrapper layout-top-nav">

		<header class="main-header">
			<nav class="navbar navbar-static-top">
				<div class="container">


					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse pull-left"
						id="navbar-collapse">

						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" class="form-control" id="navbar-search-input"
									placeholder="Search" style="border-color: silver;">
							</div>
						</form>
					</div>
					<!-- /.navbar-collapse -->
					<!-- Navbar Right Menu -->
					<div class="navbar-custom-menu">
						<ul class="nav navbar-nav">
							<!-- MY CART -->
							<li class="dropdown messages-menu">
								<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa  fa-shopping-cart"></i>
									MY CART
							</a>
							</li>

							<!-- MY ORDER -->
							<li class="dropdown notifications-menu">
								<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-truck"></i> MY ORDER
							</a>
							</li>

							<!-- Tasks Menu -->
							<li class="dropdown tasks-menu">
								<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-tripadvisor"></i>
									HELP
							</a>
							</li>
							<!-- User Account Menu -->
							<li class="dropdown user user-menu"><c:if
									test="${not empty userVo}">
									<a href="#" class="dropdown-toggle" data-toggle="dropdown">
										<span class="hidden-xs"><i class="fa fa-user"></i>${userVo.userId }님</span>
									</a>
									<ul class="dropdown-menu">
										<li class="user-body">
											<div class="pull-left">
												<a class="btn btn-default btn-flat" href="#">정보수정</a>
											</div>
											<div class="pull-right">
												<!-- csrf 방지를 위한 토큰을 위해 -->
												<form:form id="logout" action="./logout"></form:form>
												<a class="btn btn-default btn-flat"
													href="javascript:document.getElementById('logout').submit()">로그아웃</a>
											</div>
										</li>
									</ul>

								</c:if> <c:if test="${empty userVo }">
									<!-- Menu Toggle Button -->
									<a href="./login"> <!-- The user image in the navbar--> <i
										class="fa fa-user"></i> <!-- hidden-xs hides the username on small devices so only the image appears. -->
										<span class="hidden-xs">Login <i
											class="fa fa-user-plus"></i> Register
									</span>
									</a>
								</c:if></li>
						</ul>
					</div>
					<!-- /.navbar-custom-menu -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</header>
		<div class="text-center">
			<h1>
				<a style="color: black" href="./main">또바기</a>
			</h1>
			<div>
				<a style="width: 100px; margin-left: 20px; color: black"
					id="link_01" class="menu_links "
					href="../product/list?cate=2">OUTER</a> <a
					style="width: 85px; margin-left: 20px; color: black" id="link_02"
					class="menu_links " href="../product/list?cate=0">TOP</a> <a
					style="width: 99px; margin-left: 20px; color: black" id="link_03"
					class="menu_links " href="../product/list?cate=1">PANTS</a>
				<a style="width: 102px; margin-left: 20px; color: black"
					id="link_04" class="menu_links "
					href="../product/list?cate=3">SHOES</a> <a
					style="width: 109px; margin-left: 20px; color: black" id="link_05"
					class="menu_links " href="./brands">또바기 소개</a> <a
					style="width: 148px; margin-left: 20px; color: black" id="link_06"
					class="menu_links " href="./../list?bn=free">COMMUNITY</a>
			</div>
		</div>
	</div>
	<div class="wrapper">
		<aside class="main-sidebar">
			<section class="sidebar">
				<ul class="sidebar-menu">
					<li class="header">MAIN NAVIGATION</li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Dashboard</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="../../index.html"><i class="fa fa-circle-o"></i>
									Dashboard v1</a></li>
							<li><a href="../../index2.html"><i
									class="fa fa-circle-o"></i> Dashboard v2</a></li>
						</ul>
				</ul>
			</section>
		</aside>
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
								value="cate=${param.cate}&pno=${list.number }&productName=${list.productName}" />
							<a href="<c:url value="detail?${query}"/> ">
								${list.brandName}<br> ${list.productName}<br>(${list.price })<br>
							</a>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</section>
			<!-- /.content -->

		</div>
	</div>
	<div class="wrapper layout-top-nav">
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="container">
				<div class="pull-right hidden-xs">
					<b>Version</b> 2.3.3
				</div>
				<strong>Copyright &copy; 2016 <a
					href="http://almsaeedstudio.com">또바기</a>.
				</strong> All rights reserved.
			</div>
			<!-- /.container -->
		</footer>
	</div>
	<!-- jQuery 2.2.0 -->
	<script src="<%= path %>/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="<%= path %>/resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- SlimScroll -->
	<script
		src="<%= path %>/resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="<%= path %>/resources/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="<%= path %>/resources/dist/js/app.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<%= path %>/resources/dist/js/demo.js"></script>
</body>
</html>
