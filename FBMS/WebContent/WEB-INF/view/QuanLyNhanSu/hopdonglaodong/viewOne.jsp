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
				<h3 class="content-header-title mb-0">Xem hợp đồng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhanSu/hopDong/" />'>Danh sách
									hợp đồng</a></li>
							<li class="breadcrumb-item active">Xem hợp đồng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="LaborContract" action="">
						<form:input type="hidden" path="idContract" id="idContract" />
						<div class="form-group col-sm-6">
							<label>Lương tháng 13</label>
							<form:input class="form-control" path="monthlySalary13"
								placeholder="Lương tháng 13" disabled="true" />
						</div>
						<div class="form-group col-sm-5">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="idEmployee"
								placeholder="Nhân viên" disabled="true" />
						</div>
						<div class="form-group col-sm-3">
							<label>Loại hợp đồng</label>
							<form:select path="typeOfContract">
								<form:options items="${listLoai}" disabled="true" />
							</form:select>
						</div>
						<div class="form-group col-sm-3">
							<label>Số ngày nghĩ</label>
							<form:select path="dayOfRest">
								<form:options items="${listNgay}" disabled="true" />
							</form:select>
						</div>
					</form:form>
				</div>
				<a href="<c:url value = "/QuanLyNhanSu/thongTinGiaDinh/"/>"
					class="btn btn-primary">Quay lại</a>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />