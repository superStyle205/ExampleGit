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
					<form:form method="POST" enctype="multipart/form-data"  modelAttribute="employeeProfile" action="">
					<form:input type="hidden" path="idEmployee" id="idEmployee"/>
						<div class="form-group col-sm-4">
						  	<label>Tên nhân viên</label>
						  	<form:input class="form-control" path="name" placeholder="Họ và tên" />
						</div>
						
						<div class="form-group col-sm-4">
						  	<label>Ngày sinh</label>
						  	<form:input type="date" class="form-control" value="${employeeProfile.dayOfBirth}" path="dayOfBirth" placeholder="Ngày sinh" />						  	
						</div>
						<div class="form-group col-sm-3">
						  	<label>Số điện thoại</label>
						  	<form:input class="form-control" path="contact" placeholder="Liên hệ" />						  	
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
						  	<label>Email</label>
						  	<form:input class="form-control" path="email" placeholder="Email" />						  	
						</div>						
		
						<div class="form-group col-sm-3">
						  	<label>Ngày nghỉ</label>
						  	<form:input class="form-control" path="dayOfRest" placeholder="Ngày nghỉ" />						  	
						</div>
						<div class="form-group col-sm-5">
						  	<label>Địa chỉ</label>
						  	<form:input class="form-control" path="address" placeholder="Địa chỉ" />						  	
						</div>
						
						<div class="form-group col-sm-4">
						  	<label style="margin-right: 10px;">Giới tính: </label>
						  	<form:radiobutton path="sex" value="1" />
							Nam 
							<form:radiobutton path="sex" value="2" />
							Nữ 
						  	<form:radiobutton path="sex" value="3" />
							Khác 
						</div>
						<div class="form-group col-sm-4">
						  	<label>Bộ phận</label>
						  	<select id="phongBan" name="phongBan">
								<c:forEach var="tempPhongBan" items="${listPhongBan}">
									<option value="${tempPhongBan.maPhongBan}${tempPhongBan.maPhongBan == documentManagements.idDepartMent ? 'selected' : ''}">${tempPhongBan.tenPhongBan}</option>
								</c:forEach>
							</select>
						  							  	
						</div>
						<div class="form-group col-sm-4">
						  	<label>Quyền hạn</label>
						  	<select id="chucDanh" name="chucDanh">
								<c:forEach var="tempChucDanh" items="${listChucDanh}">
									<option value="${tempChucDanh.maChucDanh}${tempChucDanh.maChucDanh == documentManagements.idRights ? 'selected' : ''}">${tempChucDanh.tenChucDanh}</option>
								</c:forEach>
							</select>						  	
						</div>
						<div class="form-group col-sm-4">
						  	<label>Avatar</label>
						  	<input type="file" name="file" id="stuClass" class="btn btn-primary"/>
							<form:errors path="avatar" cssClass="error" />					  	
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
