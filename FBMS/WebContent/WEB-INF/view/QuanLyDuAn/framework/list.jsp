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
				<h3 class="content-header-title mb-0">Danh sách framework</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách framework</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a
						href="<c:url value = "/QuanLyDuAn/Framework/list-framework/add"/>"
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
							<h4 class="card-title">Danh sách framework</h4>
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
										<thead>
											<tr>
												<th>Mã framework</th>
												<th>Tên framework</th>
												<th>Mô tả</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listFramework}" var="framework">
												<tr>
													<td>${framework.idFramework }</td>
													<td>${framework.technology }</td>
													<td>${framework.describes }</td>
													<td><a
														href="<c:url value='/QuanLyDuAn/Framework/list-framework/edit/${framework.idFramework}' />"><i
															class='fa fa-pencil'></i></a> <a
														href="<c:url value='/QuanLyDuAn/Framework/list-framework/delete/${framework.idFramework}' />"><i
															class='fa fa-trash'></i></a></td>
												</tr>
											</c:forEach>
											<div class="modal fade" id="confirm-delete" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">

														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">&times;</button>
															<h4 class="modal-title" id="myModalLabel">Bạn có
																chắc muốn xóa</h4>
														</div>

														<div class="modal-body">
															<p>Bạn có chắc muốn xóa</p>
															<p class="debug-url"></p>
														</div>

														<div class="modal-footer">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Quay lại</button>
															<a class="btn btn-danger btn-ok">Xóa</a>
														</div>
													</div>
												</div>
											</div>
										</tbody>
									</table>
									<ul class="pagination" style="margin-left: 65%;">
										<c:if test="${pageid != 1}">
											<li class="page-item"><a class="page-link"
												href="/FBMS/QuanLyDuAn/Framework/list-framework/1">Fisrt
													page</a></li>
											<li class="page-item"><a class="page-link"
												href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid -1 }">Previous
													page</a></li>
										</c:if>
										<c:choose>
											<c:when test="${noOfPages eq 1}">
												<li class="page-item active"><a class="page-link"
													href="#">1</a></li>
											</c:when>
											<c:when test="${noOfPages eq 2}">
												<c:choose>
													<c:when test="${pageid eq 1}">
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid}">1</a></li>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid+1}">2</a></li>
													</c:when>
													<c:when test="${pageid eq 2}">
														<li class="page-item "><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid-1}">1</a></li>
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid} ">2</a></li>
													</c:when>
												</c:choose>

											</c:when>
											<c:otherwise>
												<c:choose>
													<c:when test="${pageid eq 1}">
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid} ">${pageid}</a></li>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid+1} ">${pageid+1}</a></li>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid+2} ">${pageid+2}</a>
													</c:when>
													<c:when test="${pageid eq noOfPages}">
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid-2} ">${pageid-2}</a></li>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid-1} ">${pageid-1}</a></li>
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid} ">${pageid}</a>
													</c:when>
													<c:otherwise>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid-1} ">${pageid-1}</a></li>
														<li class="page-item active"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid} ">${pageid}</a></li>
														<li class="page-item"><a class="page-link"
															href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid+1} ">${pageid+1}</a></li>
													</c:otherwise>
												</c:choose>
											</c:otherwise>
										</c:choose>
										<c:if test="${pageid lt noOfPages}">
											<li class="page-item"><a class="page-link"
												href="/FBMS/QuanLyDuAn/Framework/list-framework/${pageid+1}">Next
													page</a></li>
											<li class="page-item"><a class="page-link"
												href="/FBMS/QuanLyDuAn/Framework/list-framework/${noOfPages} ">Last
													page</a></li>
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
<script type="text/javascript">
	window.setTimeout(function() {
		$(".alert").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 2500);
</script>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />