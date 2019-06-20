<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.card-block input {
	border: 0;
	border-radius: 0;
}

.card-block .table td {
	padding-left: 0px;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Xem thông tin khách hàng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyDuAn/KhachHang/list-khachHang" />'>Danh
									sách khách hàng</a></li>
							<li class="breadcrumb-item active">Thông tin khách hàng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Thông tin khách hàng</h4>
							<a class="heading-elements-toggle"><i
								class="fa fa-ellipsis-v font-medium-3"></i></a>
							<div class="heading-elements">
								<ul class="list-inline mb-0">
									<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
									<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
									<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
									<li><a data-action="close"><i class="ft-x"></i></a></li>
								</ul>
							</div>
						</div>
						<div class="card-body collapse in">
							<div class="card-block">
								<div class="table-responsive">
									<table class="table">
										<tr>
											<td><label>Tên khách hàng</label> <input
												class="form-control" value="${customer.nameCustomer}"
												placeholder="Tên khách hàng" readonly /></td>
											<td><label>Số điện thoại</label> <input
												class="form-control" value="${customer.contact}"
												placeholder="Mã chức danh" readonly /></td>
										</tr>
										<tr>
											<td><label>Giới tính</label> <c:choose>
													<c:when test="${customer.sex eq 1 }">
														<input class="form-control" value="Nam" readonly>
													</c:when>
													<c:when test="${customer.sex eq 2 }">
														<input class="form-control" value="Nữ" readonly>
													</c:when>
												</c:choose></td>
											<td><label>Địa chỉ</label> <input class="form-control"
												value="${customer.address}" readonly /></td>
										</tr>
										<tr>
											<td><label>Ngày sinh</label> <input class="form-control"
												value="<fmt:formatDate value="${customer.dayOfBirth }"
															pattern="dd-MM-yyyy" />" readonly ></td>
											<td><label>Email</label> <input class="form-control"
												value="${customer.email}" readonly /></td>	
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
