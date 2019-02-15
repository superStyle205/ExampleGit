<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				<h3 class="content-header-title mb-0">Danh sách tu choi</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách tu choi</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/QuanLyVangNghi/soandonmoi/add"/>"
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

			<form:form action="search" method="POST">

			Tìm kiếm <input  type ="text" name="search"  required  />
 			<input type="submit" value="Tim" />
			</form:form>

			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Danh sách tu choi</h4>

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
										<thead>
											<tr>
												<th>Mã vắng nghĩ</th>
												<th>Mã nhân viên</th>
												<th>Từ ngày</th>
												<th>Đến</th>
												<th>Lý do</th>
												<th>Tổng ngày nghĩ</th>
												<th>Trạng thái</th>
												
											</tr>
											<c:forEach var="danhsach" items="${listRefusedPage}">
												<tr>
													<th>${danhsach.idAbsent}</th>
													<th>${danhsach.idEmployee}</th>
													<th>${danhsach.day}</th>
													<th>${danhsach.toDay}</th>
													<th>${danhsach.typeOfLeave}</th>
													<th>${danhsach.totalDay}</th>
													<th>${danhsach.status}</th>
													
												</tr>
											</c:forEach>
										</thead>
									</table>
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
			Page :
			<c:choose>
				<c:when test="${totalPage==1}">
					<a href="1"> 1 </a>
				</c:when>
				<c:when test="${currentPage==1}">
					<a href="1"> 1 </a>
					<a href="${currentPage + 1}"> ${currentPage + 1} </a>
					<a href="${currentPage + 1}"> &rsaquo; </a>
					<a href="${totalPage}"> &rsaquo;&rsaquo; </a>
				</c:when>
				<c:when test="${currentPage==totalPage}">
					<a href="1">&lsaquo;&lsaquo; </a>
					<a href="${currentPage - 1}"> &lsaquo; </a>
					<a href="${currentPage - 1}"> ${currentPage - 1}</a>
					<a href="${totalPage}"> ${totalPage}</a>
				</c:when>
				<c:otherwise>
					<a href="1"> &lsaquo;&lsaquo;</a>
					<a href="${currentPage - 1}"> &lsaquo;</a>
					<a href="${currentPage - 1}"> ${currentPage - 1}</a>
					<a href="${currentPage}"> ${currentPage}</a>
					<a href="${currentPage + 1}"> ${currentPage + 1}</a>
					<a href="${currentPage + 1}"> &rsaquo;</a>
					<a href="${totalPage}"> &rsaquo;&rsaquo; </a>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />