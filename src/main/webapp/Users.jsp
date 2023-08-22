<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Met_talk</title>
  <link rel="shortcut icon" type="image/x-icon" href="assets/favicon/plane.ico" />
  <link rel="stylesheet" href="assets/css/style-users.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>

	<% 
		if(session.getAttribute("userName")==null){
			response.sendRedirect("SignIn.jsp");
		}
	%>

	<div class="wrapper">
    <section class="users">
      <header>
        <div class="content">
          <!-- selecting unique user id -->
          <img src="assets/images/user-images/img1.jpg" alt="image">
          <div class="details">
            <span class='main-header'>Metta Surendhar</span>
            <p class='main-header-text'>status</p>
          </div>
        </div>
        <a href="" class="logout">Logout</a>
      </header>
      <div class="search">
        <span class="text">Select an user to start chat</span>
        <input type="text" placeholder="Enter name to search...">
        <button><i class="fas fa-search"></i></button>
      </div>
      <div class="users-list">

        <!-- No users are available to chat -->

        <a href='#'>
          <div class="content">
            <img src="assets/images/user-images/img1.jpg" alt="image">
            <div class="details">
                <span>Surendhar Metta</span>
                <p>you : msg</p>
            </div>
          </div>
          <div class="status-dot"><i class="fas fa-circle"></i></div>
       </a>

      </div>
    </section>
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

  <script src="assets/js/style-users.js"></script>
	

</body>
</html>