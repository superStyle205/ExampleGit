<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Xử lý</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyVangNghi/danhsachcho/1" />'>Danh sách chờ
							</a></li>
							<li class="breadcrumb-item active">Sửa </li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">		
					<form:form method="POST" modelAttribute="choDuyet"	id="formChoDuyet" action="">
					<fieldset disabled="disabled">
						<div class="form-group col-sm-6">
							<label>Mã đơn</label>
							<form:input class="form-control" path="idAbsent" 
							value="${choDuyet.idAbsent}" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="idEmployee" 
								value="${choDuyet.idEmployee}" placeholder="Ma nhan vien" />
						</div>
						<div class="form-group col-sm-6">
							<label>Loai nghi phep</label>
							<form:input class="form-control" path="typeOfLeave" 
								value="${choDuyet.typeOfLeave}" placeholder=" Loai nghi phep" />
						</div>
						<div class="form-group col-sm-6">
							<label>Date:</label>
							<form:input class="form-control" type="date" path="day" 
								value="${choDuyet.day}" />
						</div>
						<div class="form-group col-sm-6">
							<label>to date:</label>
							<form:input class="form-control" type="date" path="toDay" 
								value="${choDuyet.day}" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tổng ngày nghĩ</label>
							<form:input class="form-control" path="totalDay" 
								value="${choDuyet.totalDay}" placeholder=" Tổng ngày nghĩ" />
						</div>
						</fieldset>
						<div class="form-group col-sm-6">
							<label>Xử lý</label> 	
									  <input class="form-control" type="radio" name="status" value="Phê Duyệt" checked> Phê Duyệt<br>
									  <input class="form-control" type="radio" name="status" value="Từ Chối"> Từ Chối<br>						
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông
								tin</button>
						</div>
					</form:form>
					
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
