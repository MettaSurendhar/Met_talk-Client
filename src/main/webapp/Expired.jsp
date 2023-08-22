<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="shortcut icon" type="image/x-icon" href="assets/favicon/plane.ico" />

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/style-sign.css">

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

  <title>Expired</title>
</head>
<body>

	<% 
		if(session.getAttribute("userName")==null){
			response.sendRedirect("SignIn.jsp");
		}
	%>

  <div class="cred-form">
	
    <main class="form-signin w-100 m-auto">
      <h1 style="text-align:center"> Sorry 😞</h1>
      <h2> Session Expired or Not Available</h2>
      
      <center><a href="ClientSession.jsp" class="btn my-3 fw-semibold py-2" > Return </a></center>

        <p class=" mb-3 mt-2 text-body-secondary copy-right">©Met_talk</p>
    </main>
  
  </div>

  <ul class="circles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>
  
</body>
</html>