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
				<h3 class="content-header-title mb-0">Thêm mới ngôn ngữ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyDuAn/NgonNgu/list-ngonNgu" />'>Danh
									sách ngôn ngữ</a></li>
							<c:choose>
								<c:when test="${edit}">
									<li class="breadcrumb-item active">Sửa thông tin</li>
								</c:when>
								<c:when test="${delete}">
									<li class="breadcrumb-item active">Xóa ngôn ngữ</li>
								</c:when>
								<c:otherwise>
									<li class="breadcrumb-item active">Thêm ngôn ngữ mới</li>
								</c:otherwise>
							</c:choose>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="language" action="">
						<c:choose>
							<c:when test="${edit}">
								<div class="form-group col-sm-6">
									<label>ID ngôn ngữ</label>
									<form:input class="form-control" path="idLanguage"
										placeholder="Mã ngôn ngữ" readonly="true" />
								</div>
							</c:when>
							<c:when test="${delete}">
								<div class="form-group col-sm-6">
									<label>ID ngôn ngữ</label>
									<form:input class="form-control" path="idLanguage"
										placeholder="Mã ngôn ngữ" readonly="true" />
								</div>
							</c:when>
							<c:otherwise>

							</c:otherwise>
						</c:choose>

						<div class="form-group col-sm-6">
							<label>Tên ngôn ngữ</label>
							<form:input class="form-control" path="nameLanguage"
								placeholder="Tên ngôn ngữ" />
						</div>
						<div class="col-sm-12 text-center">
							<c:choose>
								<c:when test="${edit}">
									<button type="submit" class="btn btn-success">Lưu
										thông tin</button>
									<a href="/FBMS/QuanLyDuAn/NgonNgu/list-ngonNgu/1"
										class="btn btn-success">Hủy</a>
								</c:when>
								<c:when test="${delete}">
									<button type="submit" class="btn btn-success">Xóa
										thông tin</button>
									<a href="/FBMS/QuanLyDuAn/NgonNgu/list-ngonNgu/1"
										class="btn btn-success">Hủy</a>
								</c:when>
								<c:otherwise>
									<button type="submit" class="btn btn-success">Lưu
										thông tin</button>
									<a href="/FBMS/QuanLyDuAn/NgonNgu/list-ngonNgu/1"
										class="btn btn-success">Hủy</a>
								</c:otherwise>
							</c:choose>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
