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
				<h3 class="content-header-title mb-0">Xem thông tin kinh nghiệm</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhanSu/kinhNghiemDuAn/" />'>Danh
									sách thông tin kinh nghiệm</a></li>
							<li class="breadcrumb-item active">Xem thông tin kinh nghiệm</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="Experience" action="">
						<form:input type="hidden" path="idExperience" id="idExperience" />
						<div class="form-group col-sm-6">
							<label>Nơi làm việc</label>
							<form:input class="form-control" path="workPlace"
								placeholder="Nơi làm việc" disabled="true" />
						</div>
						<div class="form-group col-sm-3">
							<label>Mốc thời gian</label>
							<form:input type="date" class="form-control"
								value="${Experience.timeLine}" path="timeLine" disabled="true" />
						</div>
						<div class="form-group col-sm-3">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="idEmployee"
								placeholder="Nhân viên" disabled="true" />
						</div>
						<div class="form-group col-sm-12">
							<label>Mô tả</label>
							<form:textarea class="form-control" path="describes"
								placeholder="Mô tả" disabled="true" />
						</div>
					</form:form>
				</div>
				<a href="<c:url value = "/QuanLyNhanSu/kinhNghiemDuAn/"/>"
					class="btn btn-primary">Quay lại</a>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
