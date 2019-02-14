<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.tbl_actions a {
	color: #333;
	font-size: 13px;
	display: inline-block;
	padding: 2px 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #FFF;
}

.tbl_actions a i {
	margin-right: 3px;
}

.green {
	color: #5cb85c;
}

.blue {
	color: #337ab7;
}

.red {
	color: #d9534f;
}

#datatable tr td:last-child {
	letter-spacing: 15px;
	min-width: 100px;
	text-align: center !important;
}

#datatable>thead>tr>th:last-child[class*="sort"]::after {
	content: ""
}

#datatable>thead>tr>th:last-child[class*="sort"]::before {
	content: ""
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/QuanLyNhanSu/hoSoNhanVien/add"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span> Thêm
						mới</a>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">

			<!-- Show message -->
			<c:if test="${messageSuccess ne null}">
				<div class="alert alert-success alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSuccess}
				</div>
			</c:if>
			<c:if test="${messageError ne null}">
				<div class="alert alert-danger alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageError}
				</div>
			</c:if>
			<!-- End Show message -->

			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Danh sách chức danh</h4>
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
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<table id="datatable"
										class="table table-striped table-bordered dataex-res-constructor">
										<c:forEach var="tempEmployee" items="${employeeProfiles}">
											<tr>
												<td>${tempEmployee.idEmployee}</td>
												<td>${tempEmployee.name}</td>
												<td>${tempEmployee.sex}</td>
												<td>${tempEmployee.dayOfBirth}</td>
												<td>${tempEmployee.idDepartment}</td>
												<td><a
													href="<c:url value='/viewOne/${tempEmployee.idEmployee}' />"><i
														class="fa fa-eye"></i></a> <a
													href="<c:url value='/QuanLyNhanSu/hoSoNhanVien/edit/${tempEmployee.idEmployee}' />"><i
														class="fa fa-pencil"></i></a> <a
													href="<c:url value='/QuanLyNhanSu/hoSoNhanVien/delete/${tempEmployee.idEmployee}' />"><i
														class="fa fa-trash"></i></a></td>
											</tr>
										</c:forEach>
										<thead>
											<tr style="color: #005500; background-color: #99FFCC;">
												<td><i class="fas fa-sort-numeric-up"></i></td>
												<td>Họ tên</td>
												<td>Giới tính</td>
												<td>Quyền</td>
												<td>Bộ phận</td>
												<td></td>
											</tr>
										</thead>
									</table>

									<ul class="pagination">
										<c:if test="${crPage != 1}">
											<li class="page-item"><a class="page-link"
												href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/1">Trang đầu</a></li>
											<li class="page-item"><a class="page-link"
												href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage-1}">Trang
													trước</a></li>
										</c:if>

										<c:choose>
											<c:when test="${crPage eq 1}">
												<c:choose>
													<c:when test="${totalPage gt 2}">
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage}">${crPage}</a></li>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage+1}">${crPage+1}</a></li>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage+2}">${crPage+2}</a>
													</c:when>
													<c:when test="${totalPage gt 1}">
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage}">${crPage}</a></li>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage+1}">${crPage+1}</a></li>
													</c:when>
													<c:when test="${totalPage gt 0}">
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage}">${crPage}</a></li>
													</c:when>
												</c:choose>
											</c:when>
											<c:when test="${crPage eq totalPage}">
												<c:choose>
													<c:when test="${totalPage gt 2}">
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage-2}">${crPage-2}</a></li>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage-1}">${crPage-1}</a></li>
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage}">${crPage}</a>
													</c:when>
													<c:when test="${totalPage gt 1}">
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage-1}">${crPage-1}</a></li>
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage}">${crPage}</a>
													</c:when>
													<c:when test="${totalPage gt 1}">
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage}">${crPage}</a>
													</c:when>
												</c:choose>
											</c:when>
											<c:otherwise>
												<li class="page-item"><a class="page-link"
													href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage-1}">${crPage-1}</a></li>
												<li class="page-item active"><a class="page-link"
													href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage}">${crPage}</a></li>
												<li class="page-item"><a class="page-link"
													href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage+1}">${crPage+1}</a></li>
											</c:otherwise>
										</c:choose>

										<c:if test="${crPage lt totalPage}">
											<li class="page-item"><a class="page-link"
												href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${crPage+1}">Trang
													sau</a></li>
											<li class="page-item"><a class="page-link"
												href="/FBMS/QuanLyNhanSu/hoSoNhanVien/list/${totalPage}">Trang
													cuối</a></li>
										</c:if>
									</ul>
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