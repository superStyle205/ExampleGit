<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới khách hàng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanLyThoiGian/nhanVien/" />'>Danh sách khách hàng</a></li>
							<li class="breadcrumb-item active">Thêm mới khách hàng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="LogTime" action="">
						<div class="form-group col-sm-6">
						  	<label>Mã nhân viên</label>
						  	<form:input class="form-control" path="idEmployee" placeholder="Mã nhân viên" />
						  	<label>Mã dự án</label>
						  	<form:input class="form-control" path="idProject" placeholder="Mã dự án" />
						  	<label>Vai trò</label> <br>
					 		<form:input class="form-control" path="role" placeholder="Vai trò" />					 		
						</div>
						<div class="form-group col-sm-6">						  	
						  	<label>Mô tả</label>
						  	<form:input class="form-control" path="describes" placeholder="Mô tả" />
						  	<label>Số giờ</label>
						  	<form:input class="form-control" path="time" placeholder="Số giờ" />
						  	<label>Ngày tạo log</label>
						  	<form:input type="date" class="form-control" path="dayLog" placeholder="Ngày tạo log" />
						  	<label>Trạng thái </label>
						  	<form:input class="form-control" path="status" placeholder="Trạng thái" />
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
