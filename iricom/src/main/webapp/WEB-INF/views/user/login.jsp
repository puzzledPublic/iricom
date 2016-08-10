<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>

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

		<!-- Full Width Column -->
		<div class="content-wrapper">
			<div class="container">
				<!-- Main content -->
				<section class="content">
					<div class="login-box">
						<div class="login-logo">회원 로그인</div>
						<!-- /.login-logo -->
						<div class="login-box-body">
							<form:form id="loginfirm" action="./login" method="post">
								<div class="form-group has-feedback">
									<input type="text" id="loginid" name="loginid" class="form-control" placeholder="아이디">
									<span class="glyphicon glyphicon-user form-control-feedback"></span>
								</div>
								<div class="form-group has-feedback">
									<input type="password" id="loginpw" name="loginpw" class="form-control" placeholder="비밀번호">
									<span class="glyphicon glyphicon-lock form-control-feedback"></span>
								</div>
								<input type="hidden" name="lognRedirect" value="">
								<div class="row">
									<div class="col-xs-8">
										<a href="#">아이디 찾기</a><br> <a href="#">비밀번호 찾기</a>
									</div>
									<!-- /.col -->
									<div class="col-xs-4">
										<button type="submit" id="loginbtn"
											class="btn btn-primary btn-block btn-flat">로그인</button>
									</div>
									<!-- /.col -->
								</div>
							</form:form>
							<hr>
							<div class="row">
								<div class="col-xs-8">아이디가 없다면 회원가입을 해주세요.</div>
								<div class="col-xs-4">
									<a class="btn btn-primary btn-block btn-flat "
										href="./join" class="text-center">회원가입</a>
								</div>
							</div>
							<!-- /.login-box-body -->
						</div>
					</div>
				</section>
				<!-- /.content -->
			</div>

			<!-- /.content-wrapper -->
			<%@ include file="/WEB-INF/views/include/footer.jsp" %>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/include/js.jsp"%>
</body>
</html>