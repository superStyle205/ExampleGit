<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<h3 class="content-header-title mb-0">Sửa chức danh</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh
									sách chức danh</a></li>
							<li class="breadcrumb-item active">Thông tin chức danh</li>
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
							<h4 class="card-title">Thông tin dự án</h4>
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
											<td><label>Mã dự án</label>
											<input class="form-control" value="${project.idProject}" readonly /></td>
											<td><label>Tên dự án</label> <input
												class="form-control" value="${project.tenProject}"
												placeholder="Tên chức danh" readonly /></td>
											<td><label>Mã khách hàng</label> <input
												class="form-control" value="${project.idCustomer}" readonly /></td>
											<td><label>Mô tả</label>
											<input class="form-control" value="${project.describes }" readonly /></td>
											<td><label>Phòng dự án</label>
											<input class="form-control" value="${project.projectDivision }" readonly /></td>
											<td><label>Quản lý dự án</label>
											<input class="form-control" value="${project.projectManager }" readonly /></td>
											<td><label>Ngày bắt đầu</label>
											<input class="form-control" value="${project.startDate }" readonly /></td>
											<td><label>Ngày kết thúc</label>
											<input class="form-control" value="${project.endDate }" readonly /></td>
											<td><label>Domain</label>
											<input class="form-control" value="${project.domain }" readonly /></td>
											<td><label>Status</label>
											<input class="form-control" value="${project.status }" readonly /></td>
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
