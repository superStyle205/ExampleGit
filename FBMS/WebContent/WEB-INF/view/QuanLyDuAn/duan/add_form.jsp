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
				<h3 class="content-header-title mb-0">Thêm mới domain</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh
									sách domain</a></li>
							<li class="breadcrumb-item active">Thêm mới domain</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<form:form method="POST" modelAttribute="domain" action="">
					<div class="row">
						<div class="form-group col-sm-12">
							<label>Tên dự án</label>
							<form:input class="form-control" path="nameProject"
								placeholder="Tên dự án*" />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-3 col-sm-12">
							<label>Khách hàng</label> <select>
								<option>Select client name</option>
								<option></option>
							</select>
						</div>
						<div class="form-group col-md-3 col-sm-12">
							<input type="text" data-provide="datepicker" class="form-control"
								placeholder="Start date *">
						</div>
						<div class="form-group col-md-3 col-sm-12">
							<input type="text" data-provide="datepicker" class="form-control"
								placeholder="End date *">
						</div>
						<div class="form-group col-md-3 col-sm-12">
							<label>Chọn phòng dự án</label>
							<select>
								<option> </option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-3">
							<label>Domain</label>
						</div>
						<div class="col-sm-12 col-md-3">
							<label>Framework</label>
						</div>
						<div class="col-sm-12 col-md-3">
							<label>Database</label>
						</div>
						<div class="col-sm-12 col-md-3">
							<label>Programing Language</label>
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông
								tin</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
