<%@page import="com.service.dao.Database"%>
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

  <title>SignIn</title>
</head>
<body>

<div class="cred-form">
	
    <main class="form-signin w-100 m-auto">
      <form action="SignIn" method='post'>
      
         <div class='d-flex justify-content-center align-items-center gap-2 '>
          <h1 class="h3 mb-3 fw-normal fs-2 text-center ">Sign In</h1> 
          <div class='img-container'>
            <img class="mb-4" src="assets/images/plane.svg" alt="" width="72" height="57">
          </div>
        </div>
    
        <div class="form-floating mb-4">
          <input type="text" class="form-control" id="userName" placeholder="username" name="userName" required >
          <label for="userName">User Name</label>
          <div id="userNameFeedback" class="invalid-feedback">
            Please enter a valid user name !!!
          </div>
        </div>
        
        <div class="form-floating mb-4">
          <input type="password" class="form-control" id="actualPassword" placeholder="password" name="actualPassword" required >
          <label for="actualPassword">Password</label>
          <div id="actualPasswordFeedback" class="invalid-feedback">
            Please enter a valid password !!!
          </div>
        </div>

        <button class="btn fw-semibold w-100 py-2" type="submit">Sign Me In!</button>

        <div class='text-center my-4'>
          <a>Don't have an account ? </a><a href="SignUp.jsp" id="link">Sign Up</a>
        </div>

        <p class=" mb-3 text-body-secondary copy-right">©Met_talk</p>
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

<script src="assets/js/style-signIn.js"></script>

</body>
</html>