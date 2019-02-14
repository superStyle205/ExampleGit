<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới chức danh</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh sách chức danh</a></li>
							<li class="breadcrumb-item active">Thêm mới chức danh</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST"  modelAttribute="employeeProfile" action="">
					<form:input type="hidden" path="idEmployee" id="idEmployee"/>
						<div class="form-group col-sm-4">
						  	<label>Tên nhân viên</label>
						  	<form:input class="form-control" path="name" placeholder="Họ và tên" />
						</div>
						<div class="form-group col-sm-2">
						  	<label>Giới tính</label>
						  	<form:input class="form-control" path="sex" placeholder="Giới tính" />
						  	
						</div>
						<div class="form-group col-sm-4">
						  	<label>Ngày sinh</label>
						  	<form:input type="date" class="form-control" value="${employeeProfile.dayOfBirth}" path="dayOfBirth" placeholder="Ngày sinh" />						  	
						</div>
						<div class="form-group col-sm-6">
						  	<label>Địa chỉ</label>
						  	<form:input class="form-control" path="address" placeholder="Địa chỉ" />						  	
						</div>
						<div class="form-group col-sm-4">
						  	<label>Số điện thoại</label>
						  	<form:input class="form-control" path="contact" placeholder="Liên hệ" />						  	
						</div>
						<div class="form-group col-sm-4">
						  	<label>Email</label>
						  	<form:input class="form-control" path="email" placeholder="Email" />						  	
						</div>						
						<div class="form-group col-sm-4">
						  	<label>Bộ phận</label>
						  	<form:input class="form-control" path="idDepartment" placeholder="Bộ phận" />						  	
						</div>
						<div class="form-group col-sm-4">
						  	<label>Ngày nghỉ</label>
						  	<form:input class="form-control" path="dayOfRest" placeholder="Ngày nghỉ" />						  	
						</div>
						<div class="form-group col-sm-6">
						  	<label>Giới thiệu</label>
						  	<form:textarea class="form-control"  path="introduction" placeholder="Giới thiệu" />						  	
						</div>
						<div class="form-group col-sm-6">
						  	<label>Ghi chú</label>
						  	<form:textarea class="form-control" path="note" placeholder="Ghi chú" />						  	
						</div>
						<div class="form-group col-sm-4">
						  	<label>Quyền hạn</label>
						  	<form:input class="form-control" path="idRights" placeholder="Quyền" />						  	
						</div>
						<div class="form-group col-sm-4">
						  	<label>Avatar</label>
						  	<form:input class="form-control" path="avatar" placeholder="Avatar" />						  	
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
