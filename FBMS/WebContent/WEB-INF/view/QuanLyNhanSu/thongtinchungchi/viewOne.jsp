<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Xóa chứng chỉ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanLyNhanSu/thongTinChungChi/" />'>Danh sách chứng chỉ</a></li>
							<li class="breadcrumb-item active">Xóa chứng chỉ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="Certificate" action="">
					<form:input type="hidden" path="idCertificate" id="idCertificate"/>
						<div class="form-group col-sm-3">
							<label>Loại chứng chỉ</label>
							<form:input class="form-control" path="typeOfCertificate"
								placeholder="Loại chứng chỉ" disabled="true"/>
						</div>

						<div class="form-group col-sm-3">
							<label>Ngày cấp</label>
							<form:input type="date" class="form-control"
								value="${Certificate.duration}" path="duration" disabled="true"/>
						</div>
						<div class="form-group col-sm-3">
							<label>Được cấp bởi</label>
							<form:input class="form-control" path="issuedBy"
								placeholder="Được cấp bởi" disabled="true"/>
						</div>
						<div class="form-group col-sm-3">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="idEmployee" placeholder="Nhân viên" disabled="true"/>
						</div>
						<div class="form-group col-sm-12">
							<label>Ghi chú</label>
							<form:textarea class="form-control" path="note"
								placeholder="Ghi chú" disabled="true"/>
						</div>
					</form:form>
				</div>
				<a href="<c:url value = "/QuanLyNhanSu/thongTinChungChi/"/>"
						class="btn btn-primary">Quay lại</a>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
