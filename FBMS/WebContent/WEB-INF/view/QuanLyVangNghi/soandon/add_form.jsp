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
				<h3 class="content-header-title mb-0">Dang ky vang nghi</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyVangNghi/soandonmoi/" />'>Danh
									sách vang nghi</a></li>
							<li class="breadcrumb-item active">Soan don moi</li>
						</ol>
					</div>
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
			
			<div class="main-content">
				<div class="row">
				
					<form:form method="POST" modelAttribute="registrationLeave" 
						id="formVangNghi" action="">
						<div class="form-group col-sm-6">
							<label>Ma nhan vien</label>
							<form:input class="form-control" path="idEmployee"
								placeholder="Mã nhan vien" />
						</div>
					
						<div class="form-group col-sm-6">
							<label>So ngày còn lại</label>
							<input class="form-control"  value = "${laborContract.dayOfRest}" name = "dayOfRest"/>
						</div>
						<div>
							<input type="hidden"  value = "${laborContract.idContract}" name = "idContract"/>
						</div>
						<div class="form-group col-sm-6">
							<label>Loai nghi phep</label>
							<form:input class="form-control" path="typeOfLeave"
								placeholder="Loai nghi phep" />
						</div>
						<div class="form-group col-sm-6">
							<label>Date:</label>
<p onchange="myFunction()">
							<form:input class="form-control" type="date" path="day" id="day1" />
</p>
						</div>
						<div class="form-group col-sm-6">
							<label>to date:</label>
							<p onchange="myFunction()">
								<form:input class="form-control" type="date" path="toDay"
									id="day2" />
							</p>
						</div>
						<div class="form-group col-sm-6">
							<label>Tổng ngày nghĩ</label>
							<form:input class="form-control" path="totalDay"
								placeholder="Tổng ngày nghĩ" id="demo2" />
						</div>
						
						<div class="form-group col-sm-6">
							<label>Trạng thái</label> <select class="form-control"
								name="status" id="formVangNghi">
								<option value="Nháp">Nháp</option>
								<option value="Chờ Duyệt">Chờ Duyệt</option>
							</select>
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
</div>
<script>
  function myFunction() {
	
	var date1 = document.getElementById("day1").value ;
	var date11 = new Date(date1);
	var date2 = document.getElementById("day2").value ;
	var date22 = new Date(date2); 
	
	
	
	 var offset = date22.getTime() - date11.getTime();
	 var totalDays = Math.round(offset/1000/60/60/24)  + 1; 
	 var weekEndDays = countWeekendDays(date11, date22);
  // Assume d0 <= d1
 	totalDays -= weekEndDays;
 	document.getElementById("demo2").value = totalDays;

 


    

}   

  function countWeekendDays( d0, d1 )
  {
      var ndays = 1 + Math.round((d1.getTime()-d0.getTime())/(24*3600*1000));
      var nsaturdays = Math.floor((d0.getDay() + ndays) / 7);
      return 2*nsaturdays + (d0.getDay()==0) - (d1.getDay()==6);
  }

</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
