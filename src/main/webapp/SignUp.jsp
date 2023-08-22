<%@page import="com.service.tools.RandomNum"%>
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

  <title>SignUp</title>
</head>
<body>

  <div class="cred-form">
  
    <main class="form-signin w-100 m-auto">
    
      <form action='SignUp' method='post'>
      
        <div class='d-flex justify-content-center align-items-center gap-2'>
          <h1 class="h3 mb-3 fw-normal fs-2 text-center ">Sign Up</h1> 
          <div class='img-container'>
            <img class="mb-4" src="assets/images/plane.svg" alt="" width="72" height="57">
          </div>
        </div>
          
      
        <div class="form-floating mb-4" >
              <div class="input-group mb-3">
              	<div class="form-floating rounded-end mb-4">
              		<input type="email" class="form-control rounded-end" id="emailAddress" placeholder="name@host.com" name="emailAddress" required>
              		<label for="emailAddress">Email Address</label>
              		<div id="emailAddressFeedback" class="invalid-feedback">
		                Please enter a valid email address name !!!
		            </div>
              	</div>
             
                <a type="button" class="mx-2 pb-4 d-flex justify-content-center align-items-center" id="send-btn"> 
	                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-send-fill" viewBox="0 0 16 16">
	                	<path d="M15.964.686a.5.5 0 0 0-.65-.65L.767 5.855H.766l-.452.18a.5.5 0 0 0-.082.887l.41.26.001.002 4.995 3.178 3.178 4.995.002.002.26.41a.5.5 0 0 0 .886-.083l6-15Zm-1.833 1.89L6.637 10.07l-.215-.338a.5.5 0 0 0-.154-.154l-.338-.215 7.494-7.494 1.178-.471-.47 1.178Z"/>
	                </svg> 
                </a>
              </div>
          </div>
          
          
          <div class="form-floating mb-4">
              <input type="number" class="form-control" id="otpEntered" placeholder="otpEntered" name="otpEntered" required >
              <label for="otpEntered">OTP</label>
              <div id="otpEnteredFeedback" class="invalid-feedback">
                Please enter valid OTP !!!
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
    
            <div class="form-floating mb-4 red-box">
              <input type="password" class="form-control " id="confirmPassword" placeholder="password" name="confirmPassword" required >
              <label for="confirmPassword">Confirm Password</label>
              <div id="confirmPasswordFeedback" class="invalid-feedback">
                Please enter the same password !!!
              </div>          
            </div>

        <button class="btn fw-semibold w-100 py-2" type="submit">Sign Me Up!</button>

        <div class='text-center my-4'>
          <a>Already have an account ? </a><a href="SignIn.jsp" id="link">Sign In</a>
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
  
<script src="assets/js/style-signUp.js"></script>

</body>
</html>