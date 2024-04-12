<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.11.6/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>

</body>
<style>
body {
	margin-top: 20px;
	background: #f6f9fc;
}

.account-block {
	padding: 0;
	background-image: url(https://bootdey.com/img/Content/bg1.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	height: 100%;
	position: relative;
}

.account-block .overlay {
	-webkit-box-flex: 1;
	-ms-flex: 1;
	flex: 1;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-color: rgba(0, 0, 0, 0.4);
}

.account-block .account-testimonial {
	text-align: center;
	color: #fff;
	position: absolute;
	margin: 0 auto;
	padding: 0 1.75rem;
	bottom: 3rem;
	left: 0;
	right: 0;
}

.text-theme {
	color: #5369f8 !important;
}

.btn-theme {
	background-color: #5369f8;
	border-color: #5369f8;
	color: #fff;
}
</style>
</head>

<body>




	<div id="main-wrapper" class="container">
		<div class="row justify-content-center">
			<div class="col-xl-10">
				<div class="card border-0">
					<div class="card-body p-0">
						<div class="row no-gutters">
							<div class="col-lg-6">
								<div class="p-5">
									<div class="mb-5">

										<%
										try {
											if (session.getAttribute("registerSuccess") != null && (Boolean) session.getAttribute("registerSuccess")) {
										%>
										<div class="alert alert-success alert-dismissible fade show"
											role="alert">
											<strong>Great!</strong> Register Successfully..You can login
											now..
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<%
										session.removeAttribute("registerSuccess"); // Remove session attribute after displaying message
										%>
										<%
										}
										} catch (Exception e) {
										}
										%>


										

										<%
										try {
											if (session.getAttribute("loginFail") != null && (Boolean) session.getAttribute("loginFail")) {
										%>
										<div class="alert alert-warning alert-dismissible fade show"
											role="alert">
											<strong>Oops!</strong> Invalid Credentials..
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<%
										session.removeAttribute("loginFail"); // Remove session attribute after displaying message
										%>
										<%
										}
										} catch (Exception e) {
										}
										%>



										<h3 class="h4 font-weight-bold text-theme">Login</h3>
									</div>

									<h6 class="h5 mb-0">Welcome back!</h6>
									<p class="text-muted mt-2 mb-5">Enter your email address
										and password to access admin panel.</p>

									<form action="login" method="post">
										<div class="form-group">
											<label for="exampleInputEmail1">Email address</label> <input
												type="email" name="email" class="form-control" id="exampleInputEmail1">
										</div>
										<div class="form-group mb-5">
											<label for="exampleInputPassword1">Password</label> <input
												type="password" name="password" class="form-control"
												id="exampleInputPassword1">
										</div>
										<button type="submit" class="btn btn-theme">Login</button>
										<a href="#l" class="forgot-link float-right text-primary">Forgot
											password?</a>
									</form>
								</div>
							</div>

							<div class="col-lg-6 d-none d-lg-inline-block">
								<div class="account-block rounded-right">
									<div class="overlay rounded-right"></div>
									<div class="account-testimonial">
										<h4 class="text-white mb-4">This beautiful theme yours!</h4>
										<p class="lead text-white">"Best investment i made for a
											long time. Can only recommend it for other users."</p>
										<p>- Admin User</p>
									</div>
								</div>
							</div>
						</div>

					</div>
					<!-- end card-body -->
				</div>
				<!-- end card -->

				<p class="text-muted text-center mt-3 mb-0">
					Don't have an account? <a href="" class="text-primary ml-1">register</a>
				</p>

				<!-- end row -->

			</div>
			<!-- end col -->
		</div>
		<!-- Row -->
	</div>
	<script>
		// Show toast when the page loads
		window.addEventListener('DOMContentLoaded', function() {
			var toastElement = document.getElementById('toast');
			var toast = new bootstrap.Toast(toastElement);
			toast.show();
		});
	</script>
</body>
</html>