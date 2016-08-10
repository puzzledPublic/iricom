<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- 사이드 바가 없는 경우 템플릿 -->
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
				
					<div>회원가입</div>
					<!-- general form elements -->
					<!-- form start -->
					
					<form:form role="form" >
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">이용 약관</h3>
							</div>
							<div class="box-body ">
								<div class="form-group">
									<div class="col-xs-12">
										<textarea class="form-control" readonly rows="10" cols="100">서비스 약관

								</textarea>
									</div>
									<div class="col-xs-12">
										<div class="checkbox pull-right">
											<label for="join_user_agree"> <input type="checkbox"
												name="join_user_agree" id="join_user_agree" value="1" />
												서비스 약관에 동의합니다.
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-12">
										<textarea class="form-control" readonly rows="10" cols="100">개인정보 수집 및 이용 동의
■ 수집하는 개인정보 항목
회사는 회원가입, 상담, 서비스 신청 등등을 위해 아래와 같은 개인정보를 수집하고 있습니다.
ο 수집항목 : 이름 , 생년월일 , 성별 , 로그인ID , 비밀번호  , 자택 전화번호 , 자택 주소 , 휴대전화번호 , 이메일 , 직업 , 회사명 , 부서 , 직책 , 회사전화번호 , 취미 , 결혼여부 , 기념일 , 법정대리인정보 , 서비스 이용기록 , 접속 로그 , 접속 IP 정보 , 결제기록
ο 개인정보 수집방법 : 홈페이지(회원가입) , 서면양식
■ 개인정보의 수집 및 이용목적
회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다.
ο 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산 콘텐츠 제공 , 구매 및 요금 결제 , 물품배송 또는 청구지 등 발송
ο 회원 관리
회원제 서비스 이용에 따른 본인확인 , 개인 식별 , 연령확인 , 만14세 미만 아동 개인정보 수집 시 법정 대리인 동의여부 확인 , 고지사항 전달 ο 마케팅 및 광고에 활용
접속 빈도 파악 또는 회원의 서비스 이용에 대한 통계
■ 개인정보의 보유 및 이용기간
회사는 개인정보 수집 및 이용목적이 달성된 후에는 예외 없이 해당 정보를 지체 없이 파기합니다.
								</textarea>
									</div>
									<div class="col-xs-12">
										<div class="checkbox pull-right">
											<label for="join_user_agree2"> <input type="checkbox"
												name="join_user_agree2" id="join_user_agree2" value="1" />
												개인정보 수집 및 이용 약관에 동의합니다.
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="box box-primary">
							<div class="box-header with-border">
								<h3 class="box-title">기본 정보</h3>
							</div>
							<!-- form start -->

							<div class="box-body ">
								<div class="row">
									<div class="form-group col-xs-3">
										<label for="exampleInputEmail">아이디</label> <input
											type="text" class="form-control" id="userid" name="userid"
											placeholder="아이디">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-xs-3">
										<label for="exampleInputPassword">비밀번호</label> <input
											type="password" class="form-control"
											id="userpw" name="userpw" placeholder="비밀번호">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-xs-3">
										<label for="exampleInputPasswordConfirm">비밀번호 확인</label> <input
											type="password" class="form-control"
											id="userpw_confirm" name="userpw_confirm" placeholder="비밀번호 확인">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-xs-3">
										<label for="exampleInputName">이름</label> <input
											type="text" class="form-control"
											id="username" name="username" placeholder="이름">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-xs-1">
										<label for="exampleInputPassword1">우편번호</label> <input
											type="text" class="form-control" id="postcode" name="postcode"
											placeholder="우편번호">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-xs-5">
										<label for="exampleInputPassword1">주소</label> <input
											type="text" class="form-control"
											id="address" name="address" placeholder="주소">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-xs-4">
										<label for="exampleInputPassword1">이메일</label> <input
											type="text" class="form-control"
											id="email" name="email" placeholder="이메일">
									</div>
								</div>
							</div>
							<!-- /.box-body -->

							<div class="box-footer">
								<button type="submit" class="btn btn-primary center-block">회원가입</button>
							</div>
							

						</div>
					</form:form>
				</section>
				<!-- /.content -->
			</div>
		</div>
		
		<%@ include file="/WEB-INF/views/include/footer.jsp" %>
		
	</div>
	<%@ include file="/WEB-INF/views/include/js.jsp"%>
</body>
</html>