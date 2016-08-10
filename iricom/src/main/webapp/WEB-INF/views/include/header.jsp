<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<header class="main-header">
	<nav class="navbar navbar-static-top">
		<div class="container">


			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse pull-left" id="navbar-collapse">

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
						data-toggle="dropdown"> <i class="fa fa-tripadvisor"></i> HELP
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
									<a href="<%=request.getContextPath() %>/user/login"> <!-- The user image in the navbar--> <i
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
		<a style="color: black" href="<%=request.getContextPath() %>/main">또바기</a>
	</h1>
	<div>
		<a style="width: 100px; margin-left: 20px; color: black;" id="link_01"
			class="menu_links " href="<%=request.getContextPath() %>/product/list?cate=3">OUTER</a> <a
			style="width: 85px; margin-left: 20px; color: black" id="link_02"
			class="menu_links " href="<%=request.getContextPath() %>/product/list?cate=0">TOP</a> <a
			style="width: 99px; margin-left: 20px; color: black" id="link_03"
			class="menu_links " href="<%=request.getContextPath() %>/product/list?cate=1">PANTS</a> <a
			style="width: 102px; margin-left: 20px; color: black" id="link_04"
			class="menu_links " href="<%=request.getContextPath() %>/product/list?cate=2">SHOES</a> <a
			style="width: 109px; margin-left: 20px; color: black" id="link_05"
			class="menu_links " href="<%=request.getContextPath() %>/brands.html">또바기 소개</a> <a
			style="width: 148px; margin-left: 20px; color: black" id="link_06"
			class="menu_links " href="<%=request.getContextPath() %>/list?bn=free">COMMUNITY</a>
	</div>
</div>