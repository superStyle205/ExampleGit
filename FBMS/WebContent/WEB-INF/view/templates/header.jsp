<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="FastTrackSE Bunisess Management System.">
<meta name="keywords"
	content="human resource, document, project, working log, leave management">
<meta name="author" content="FFSE1704">
<title>FastTrackSE - The Business Management System</title>
<link rel="apple-touch-icon"
	href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/09/fasttrackselogo.png"/>">
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/favicon.png"/>">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet" />
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/feather/style.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/font-awesome/css/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/flag-icon-css/css/flag-icon.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/extensions/pace.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/tables/datatable/dataTables.bootstrap4.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/extensions/unslider.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/weather-icons/climacons.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/meteocons/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/charts/morris.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/calendars/fullcalendar.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/calendars/fullcalendar.min.css"/>">

<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap-extended.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/app.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/colors.css"/>">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/menu/menu-types/vertical-menu.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/menu/menu-types/vertical-overlay-menu.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/colors/palette-gradient.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/colors/palette-callout.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/forms/extended/form-extended.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/simple-line-icons/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/pages/timeline.css"/>">
<!-- END Page Level CSS-->
<style>
.invalid-feedback {
	color: #DC3545;
	padding-top: 10px;
}

.invalid-feedback::before {
	content: "•";
	padding-left: 10px;
	padding-right: 10px;
}
</style>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script>
	$(document).ready(
			function() {
				listClass = [ "phong_ban", "chuc_danh" ];
				url = window.location.href;
				selector = '.'
						+ url.substring(url.lastIndexOf("ffse-fbms") + 10);
				selector = selector.replace(/\//g, '').replace(/[0-9]/g, '');
				$(selector).addClass('active open');

				var i;
				for (i = 0; i < listClass.length; i++) {
					if (selector.includes(listClass[i])) {
						$("." + listClass[i]).addClass('open');
					}
				}
				console.log(selector);
				if (selector.includes('ho_so')
						&& !selector.includes('viewho_so')
						&& !selector.includes('qlnsnv')
						&& !selector.includes('ho_soedit')) {
					$(".pbho_so").addClass('open');
				}
				if (selector.includes('hop_dong')
						&& !selector.includes('viewhop_dong')
						&& !selector.includes('qlnsnv')
						&& !selector.includes('hop_dongedit')) {
					$(".pbhop_dong").addClass('open');
				}
			});
</script>

</head>

<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar">

	<nav
		class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-light bg-gradient-x-grey-blue">
		<div class="continer">

			<!-- Show message -->
			<c:if test="${messageSC ne null}">
				<div class="alert alert-success  btn-min-width mr-1 mb-1"
					role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSC}
				</div>
			</c:if>
			<c:if test="${messageER ne null}">
				<div class="alert alert-danger alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageER}
				</div>
			</c:if>
		</div>
		<div class="navbar-wrapper">
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li class="nav-item mobile-menu hidden-md-up float-xs-left"><a
						href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i
							class="ft-menu font-large-1"></i></a></li>
					<li class="nav-item"><a href="/FBMS/home" class="navbar-brand"><img
							src="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/favicon.png"/>"
							alt="FastTrackSE logo" class="brand-logo" />
							<h2 class="brand-text">FBMS</h2></a></li>
					<li class="nav-item hidden-md-up float-xs-right"><a
						data-toggle="collapse" data-target="#navbar-mobile"
						class="nav-link open-navbar-container"><i
							class="fa fa-ellipsis-v"></i></a></li>
				</ul>
			</div>
			<div class="navbar-container content container-fluid">
				<div id="navbar-mobile" class="collapse navbar-toggleable-sm">
					<ul class="nav navbar-nav">
						<li class="nav-item hidden-sm-down"><a href="#"
							class="nav-link nav-menu-main menu-toggle hidden-xs"><i
								class="ft-menu"></i></a></li>
						<li class="nav-item hidden-sm-down"><a href="#"
							class="nav-link nav-link-expand"><i class="ficon ft-maximize"></i></a></li>
					</ul>
					<ul class="nav navbar-nav float-xs-right">
						<li class="dropdown dropdown-language nav-item"><a
							class="dropdown-toggle nav-link" id="dropdown-flag" href="#"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
								class="flag-icon <spring:message code="label.QuanTriHeThong.NgonNgu" />"></i><span
								class="selected-language"></span></a>
							<div class="dropdown-menu" aria-labelledby="dropdown-flag">
								<a class="dropdown-item" href="?lang=en"><i
									class="flag-icon flag-icon-gb"></i> English</a> <a
									class="dropdown-item" href="?lang=vi"><i
									class="flag-icon flag-icon-vn"></i> Tiếng Việt</a>
							</div></li>
						<li class="dropdown dropdown-user nav-item"><a href="#"
							data-toggle="dropdown"
							class="dropdown-toggle nav-link dropdown-user-link"><span
								class="avatar avatar-online"><img
									src="<c:url value="/resources/images/portrait/small/avatar-s-1.png"/>"
									alt="avatar"><i></i></span><span class="user-name">${pageContext.request.userPrincipal.name}</span></a>
							<div class="dropdown-menu dropdown-menu-right">
								<a href="#" class="dropdown-item"><i class="ft-user"></i> <spring:message
										code="label.QuanTriHeThong.suaHoSo" /></a> <a href="#"
									class="dropdown-item"><i class="ft-mail"></i> <spring:message
										code="label.QuanTriHeThong.hopThu" /></a> <a href="#"
									class="dropdown-item"><i class="ft-check-square"></i> <spring:message
										code="label.QuanTriHeThong.nhiemVu" /></a> <a href="#"
									class="dropdown-item"><i class="ft-message-square"></i> <spring:message
										code="label.QuanTriHeThong.tinNhan" /></a>
								<div class="dropdown-divider"></div>
								<form class="dropdown-item"
									action="<c:url value="/j_spring_security_logout" />"
									method="post">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <a href="#"
										onclick="$(this).closest('form').submit()"><i
										class="ft-power"></i> <spring:message
											code="label.QuanTriHeThong.dangXuat" /></a>
								</form>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<div data-scroll-to-active="true"
		class="main-menu menu-fixed menu-light menu-accordion menu-shadow">
		<div class="main-menu-content">
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<!-- Quản trị hệ thống -->
				<li class=" navigation-header"><span><spring:message
							code="label.QuanTriHeThong" /></span><i data-toggle="tooltip"
					data-placement="right" data-original-title="Apps" class=" ft-minus"></i>
				</li>
				<li class=" nav-item QuanTriHeThongphong_ban"><a
					href="<c:url value = "/QuanTriHeThong/phong_ban/"/>"><i
						class="fa fa-building"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong.PhongBan" /></span></a></li>
				<li class=" nav-item QuanTriHeThongchuc_danh"><a
					href="<c:url value = "/QuanTriHeThong/chuc_danh/"/>"><i
						class="fa fa-id-card-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong.ChucDanh" /></span></a></li>
				<li class=" nav-item QuanTriHeThongtai-khoan"><a
					href="<c:url value = "/QuanTriHeThong/tai-khoan/"/>"><i
						class="fa fa-id-card-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong.TaiKhoan" /></span></a></li>
				<li class=" nav-item QuanTriHeThongphan-quyen"><a
					href="<c:url value = "/QuanTriHeThong/phan-quyen/"/>"><i
						class="fa fa-id-card-o"></i><span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong.PhanQuyen" /></span></a></li>

				<!-- Quản trị nhân sự -->
				<li class="navigation-header"><span>Quản lý nhân sự</span><i
					class=" ft-minus" data-toggle="tooltip" data-placement="right"
					data-original-title="Components"></i></li>
				<li class="nav-item has-sub"><a href="#"><i
						class="fa fa-users"></i><span class="menu-title">Quản lý
							nhân sự</span></a>
					<ul class="menu-content" style="">
						<li class="has-sub is-shown"><a class="menu-item" href="#">Quản
								lý hồ sơ</a>
							<ul class="menu-content">
								<li><a class="menu-item"
									href="<c:url value = "/QuanLyNhanSu/hoSoNhanVien/"/>">Hồ sơ
										nhân viên</a></li>
								<li><a class="menu-item"
									href="<c:url value = "/QuanLyNhanSu/thongTinChungChi/"/>">Thông
										tin chứng chỉ</a></li>
								<li><a class="menu-item"
									href="<c:url value = "/QuanLyNhanSu/thongTinGiaDinh/"/>">Thông
										tin gia đình</a></li>
							</ul></li>
						<li class="is-shown"><a class="menu-item"
							href="<c:url value = "/QuanLyNhanSu/hopDong/"/>">Quản lý hợp
								đồng lao động</a></li>
						<li class="is-shown"><a class="menu-item"
							href="<c:url value = "/QuanLyNhanSu/kinhNghiemDuAn/"/>">Quản lý kinh nghiệm dự án</a></li>
					</ul></li>
				<!--  ------------------ Quản lý Dự Án ----------------------->

				<li class="navigation-header"><span> Quản lý dự án</span><i
					class=" ft-minus" data-toggle="tooltip" data-placement="right"
					data-original-title="Components"></i></li>
				<li class="nav-item has-sub"><a href="#"><i
						class="ft-briefcase"></i><span class="menu-title" data-i18n="">Quản
							Lý Danh Mục</span></a>
					<ul class="menu-content" style="">
						<li class=""><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/KhachHang/list-khachHang" />">Khách
								Hàng</a></li>
						<li class=""><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/Domain/list-domain" />">Domain</a></li>
						<li class=""><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/CongNghe/list-congNghe" />">Công
								Nghệ</a></li>
						<li class=""><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/Framework/list-framework" />">Framework</a></li>
						<li class=""><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/NgonNgu/list-ngonNgu" />">Ngôn
								Ngữ </a></li>
						<li class=""><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/VaiTro/list-vaiTro" />">Vai
								Trò</a></li>
						<li class=""><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/TrangThai/list-trangThai" />">Trạng
								Thái</a></li>
						<li class=""><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/Database/list-database" />">Database</a></li>
					</ul></li>
				<li class="nav-item has-sub"><a href="#"><i class="ft-box"></i><span
						class="menu-title" data-i18n="">Quản lý Dự Án</span></a>
					<ul class="menu-content" style="">
						<li class=""><a class="menu-item"
							href="<c:url value="/QuanLyDuAn/DuAn/" />">Danh Sách Dự Án</a></li>


					</ul></li>

				<!--  ////////////////////////////////////////////// -->
				<!-- Quản trị tài liệu  -->
				<li class=" navigation-header"><span>Quản trị tài liệu</span><i
					data-toggle="tooltip" data-placement="right"
					data-original-title="Apps" class=" ft-minus"></i></li>
				<li class=" nav-item QuanTriTaiLieudanh_muc"><a
					href="<c:url value = "/QuanTriTaiLieu/danh_muc/"/>"><i
						class="fa fa-th-list"></i><span data-i18n="" class="menu-title">Quản
							lý danh mục</span></a></li>
				<li class=" nav-item QuanTriTaiLieui_con"><a
					href="<c:url value = "/QuanTriTaiLieu/i_con/"/>"><i
						class="ft ft-info"></i><span data-i18n="" class="menu-title">Icon
							tài liệu</span></a></li>
				<li class=" nav-item QuanTriTaiLieutai_lieu"><a
					href="<c:url value = "/QuanTriTaiLieu/tai_lieu/"/>"><i
						class="ft ft-info"></i><span data-i18n="" class="menu-title">Quản
							lý tài liệu</span></a></li>
				<li class=" nav-item QuanTriTaiLieutrang_thai"><a
					href="<c:url value = "/QuanTriTaiLieu/trang_thai/"/>"><i
						class="ft ft-info"></i><span data-i18n="" class="menu-title">Quản
							lý trạng thái</span></a></li>



				<!-- Quản lý thời gian -->

				<li class="navigation-header"><span> Quản lý thời gian</span><i
					class=" ft-minus" data-toggle="tooltip" data-placement="right"
					data-original-title="Components"></i></li>
				<li class="nav-item has-sub"><a href="#"><i
						class="ft ft-list"></i><span class="menu-title" data-i18n="">Thống
							kê tình hình</span></a>
					<ul class="menu-content" style="">
						<li class="is-shown"><a class="menu-item"
							href="<c:url value="/QuanLyThoiGian/nhanVien/add"/>"
							class="menu-item">New</a></li>
						<li><a
							href="<c:url value="/QuanLyThoiGian/nhanVien/danhsachchopheduyetlan1"/>"
							class="menu-item">Danh Sách Chờ Phê Duyệt Lần 1</a></li>
						<li><a
							href="<c:url value="/QuanLyThoiGian/nhanVien/danhsachchopheduyetlan2"/>"
							class="menu-item">Danh Sách Chờ Phê Duyệt Lần 2</a></li>
						<li><a
							href="<c:url value="/QuanLyThoiGian/nhanVien/danhsachdapheduyet"/>"
							class="menu-item">Danh Sách Đã Phê Duyệt</a></li>
						<li><a
							href="<c:url value="/QuanLyThoiGian/nhanVien/danhsachbituchoi"/>"
							class="menu-item">Danh Sách Bị Từ Chối</a></li>
						<li><a
							href="<c:url value="/QuanLyThoiGian/nhanVien/danhsachnhap"/>"
							class="menu-item">Danh Sách Nháp</a></li>
					</ul></li>
				<li class="nav-item has-sub"><a href="#"><i class="ft-box"></i><span
						class="menu-title" data-i18n="">Phê duyệt</span></a>
					<ul class="menu-content" style="">
						<li><a
							href="<c:url value="/QuanLyThoiGian/pheDuyet/danhsachchopheduyet"/>"
							class="menu-item">Danh Sách Chờ Phê Duyệt</a></li>
						<li><a
							href="<c:url value="/QuanLyThoiGian/pheDuyet/"/>"
							class="menu-item">Danh Sách Đã Phê Duyệt</a></li>

					</ul></li>

				<!-- Quản lý nhiệm vụ -->
				<li class=" navigation-header"><span><spring:message
							code="label.QuanLyNhiemVu" /></span><i data-toggle="tooltip"
					data-placement="right" data-original-title="Apps" class=" ft-minus"></i></li>
				<li class=" nav-item QuanlyNhiemVu"><a
					href="<c:url value = "/QuanLyNhiemVu/"/>"><i class="ft ft-list"></i><span
						data-i18n="" class="menu-title"><spring:message
								code="label.QuanLyNhiemVu.DanhSachNhiemVu" /></span></a></li>
				<li class=" nav-item QuanLyNhiemVu"><a
					href="<c:url value = "/QuanLyNhiemVu/calender"/>"><i class="fa fa-calendar"></i><span
						data-i18n="" class="menu-title"><spring:message
								code="label.QuanLyNhiemVu.Lich" /></span></a></li>
				<!-- Quản lý vắng nghỉ -->
				<li class="nav-item has-sub open"><a href="#"><i
						class="fa fa-users"></i><span class="menu-title">Quản lý
							vắng nghỉ</span></a>
					<ul class="menu-content" style="">
						<li class="is-shown"><a class="menu-item"
							href="<c:url value="/QuanLyVangNghi/soandonmoi"/>"
							class="menu-item"> Soạn Đơn Mới</a></li>
						<li class="has-sub is-shown"><a class="menu-item" href="#">Thống
								kê tình hình</a>
							<ul class="menu-content">
								<li><a href="<c:url value="/QuanLyVangNghi/danhsachnhap"/>"
									class="menu-item">Danh Sách Nháp</a></li>
								<li><a href="<c:url value="/QuanLyVangNghi/danhsachcho"/>"
									class="menu-item">Danh Sách Chờ Duyệt</a></li>
								<li><a
									href="<c:url value="/QuanLyVangNghi/danhsachduyet"/>"
									class="menu-item">Danh Sách Đã Duyệt</a></li>
								<li><a
									href="<c:url value="/QuanLyVangNghi/danhsachbituchoi"/>"
									class="menu-item">Danh Sách Bị Từ Chối</a></li>
							</ul></li>
						<li class="has-sub is-shown"><a class="menu-item" href="#">Thống
								kê ngày nghỉ</a>
							<ul class="menu-content">
								<li><a
									href="<c:url value="/QuanLyVangNghi/danhsachngaynghi"/>"
									class="menu-item">Danh Sách ngày nghỉ</a></li>
							</ul></li>
						<li class="has-sub is-shown"><a class="menu-item" href="#">Thống
								Kê Trạng Thái</a>
							<ul class="menu-content">
								<li><a
									href="<c:url value="/QuanLyVangNghi/danhsachtrangthai"/>"
									class="menu-item">Danh Sách Trạng Thái</a></li>
							</ul></li>
					</ul></li>
			</ul>
		</div>
	</div>