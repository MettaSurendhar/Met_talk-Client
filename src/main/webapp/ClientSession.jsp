<%@page import="com.service.dao.Database"%>
<%@page import="com.service.main.ChatHandler"%>
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

  <title>Session</title>
</head>
<body>

	<% 
		if(session.getAttribute("userName")==null){
			response.sendRedirect("SignIn.jsp");
		}
	String strUserName = (String) session.getAttribute("userName");
	Database db = Database.getInstance();
	String logInfo = db.selectLoginInfo(strUserName);
	
	if(logInfo == "true"){
		response.sendRedirect("SignIn");
	}
		
		
	ChatHandler.clearIncomingMessages();
	
	%>
  <div class="cred-form">
	
    <main class="form-signin w-100 m-auto">
      <form action="ClientSession" method='get'>
        
        <div class='d-flex justify-content-center align-items-center gap-2 '>
          <h1 class="h3 mb-3 fw-normal fs-2 text-center ">Session</h1> 
          <div class='img-container'>
            <img class="mb-4" src="assets/images/plane.svg" alt="" width="72" height="57">
          </div>
        </div>
        
        <div class="form-floating mb-4">
          <input type="text" class="form-control" id="sessionID" placeholder="sessionID" name="sessionID" required >
          <label for="sessionID">Enter session ID</label>
        </div>

        <button class="btn fw-semibold w-100 py-2" type="submit"> Connect </button>
        <a  href="SignIn" class="btn my-3 fw-semibold py-2 logout" > Logout </a>

        <p class=" mb-3 mt-3 text-body-secondary copy-right">©Met_talk</p>
      </form>
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