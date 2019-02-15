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
				<h3 class="content-header-title mb-0">Thêm mới dự án</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh
									sách dự án</a></li>
							<li class="breadcrumb-item active">Thêm mới dự án</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<form:form method="POST" modelAttribute="project" action="">
					<div class="row">
						<div class="form-group col-sm-12">
							<label>Tên dự án</label>
							<form:input class="form-control" path="nameProject"
								placeholder="Tên dự án*" />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-3 col-sm-12">
							<label>Khách hàng</label>
							<div id="list1" class="dropdown-check-list" tabindex="100">
								<button type="button" class="multiselect dropdown-toggle btn btn-default" data-toggle="dropdown" >Khách hàng</button>
								<ul class="multiselect-container dropdown-menu">
									<c:forEach items="${listCustomer}" var="customer">
										<li class="multiselect"><input type="checkbox" />${customer.nameCustomer}</li>
									</c:forEach>
								</ul>
							</div>
						</div>
						<div class="form-group col-md-3 col-sm-12">
							<label>Ngày bắt đầu: </label>
							<input type="date" data-provide="datepicker" class="form-control"
								placeholder="Start date *">
						</div>
						<div class="form-group col-md-3 col-sm-12">
						<label>Ngày kết thúc: </label>
							<input type="date" data-provide="datepicker" class="form-control"
								placeholder="End date *">
						</div>
						<div class="form-group col-md-3 col-sm-12">
							<label>Chọn phòng dự án</label> <select>
								<option></option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-3">
							<label>Domain: </label> <select>
								<c:forEach items="${listDomain}" var="domain">
									<option>${domain.nameDomain}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-12 col-md-3">
							<label>Framework: </label> <select>
								<c:forEach items="${listFramework}" var="framework">
									<option>${framework.technology }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-12 col-md-3">
							<label>Database: </label><select>
								<c:forEach items="${listDatabase}" var="database">
									<option>${database.nameDatabase }</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-12 col-md-3">
							<label>Programing Language</label> <select>
								<c:forEach items="${listLanguage}" var="language">
									<option>${language.nameLanguage }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-md-3"></div>
					</div>
					<div class="col-sm-12 text-center">
						<button type="submit" class="btn btn-success">Lưu thông
							tin</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var checkList = document.getElementById('list1');
	checkList.getElementsByClassName('anchor')[0].onclick = function(evt) {
		if (checkList.classList.contains('visible'))
			checkList.classList.remove('visible');
		else
			checkList.classList.add('visible');
	}

	checkList.onblur = function(evt) {
		checkList.classList.remove('visible');
	}
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
