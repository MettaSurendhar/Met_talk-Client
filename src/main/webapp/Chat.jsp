<%@page import="java.util.Map"%>
<%@page import="com.service.dao.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Met_talk</title>
  <link rel="shortcut icon" type="image/x-icon" href="assets/favicon/plane.ico" />
  <link rel="stylesheet" href="assets/css/style-chat.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>

	<% 
		if(session.getAttribute("userName")==null){
			response.sendRedirect("SignIn.jsp");
		}
	
	 	HttpSession sessionObj = request.getSession();
	 	String userName = (String) session.getAttribute("userName");
	 	String imageCode = (String) session.getAttribute("imageCode");
	 	String userCode = (String) session.getAttribute("userCode");
	 	Database db = Database.getInstance();
	 	Map<String,String> info = db.selectPersonalInfo (userCode);
	 	String firstName = info.get("firstName");
	 	String lastName = info.get("lastName");
	 	String status = info.get("status");
	%>
	
	
	<div class="wrapper user-wrap">
			<section class="users">
				<header>
					<div class="content">
						<img
							src="assets/images/user-images/profile-image-fP2WsE.jpg"
							alt="image"
						/>
						<div class="details">
							<span class="main-header">Metta Surendhar</span>
							<p class="main-header-text">status</p>
						</div>
					</div>
					
				</header>
				<div class="users-list">
					<div
						class="incoming-user"
						href="#"
					>
						<div class="content">
							<img
								src="assets/images/user-images/profile-image-fP2WsE.jpg"
								alt="image"
							/>
							<div class="details">
								<span>Surendhar Metta</span>
								<p>you : msg</p>
							</div>
						</div>
						<div class="status-dot '. $offline .'">
							<i class="fas fa-circle"></i>
						</div>
					</div>
				</div>
			</section>
		</div>
  

  <div class="wrapper">
    <section class="chat-area">
      <header>
       
        <a href="ClientSession.jsp" class="back-icon border border-5" data-bs-toggle="tooltip" data-bs-placement="top"r
        data-bs-title="Close the chat"> 
		<svg xmlns="http://www.w3.org/2000/svg" width="22" height="22" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
  			<path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
		</svg>
		</a>
        <img id="profile-img" src="assets/images/user-images/profile-image-<%=imageCode %>.jpg" alt="profile image">
        <div class="details">
          <span class='main-header'> <%= firstName %> <%= lastName %> </span>
          <span class='userName' hidden> <%= userName %> </span>
          <span class='userCode' hidden> <%= userCode %> </span>
          <span class='imageCode' hidden> <%= imageCode %> </span>
          <p class='main-header-text'> <%= status %></p>	
        </div>
      </header>
      <div class="chat-box">

          <div id="filler"  class="text">No messages are available. Once you send message they will appear here.</div>

      </div>
      <form action="#" class="typing-area">
        <input type="text" class="incoming_id" name="incoming_id" value=" user id" hidden>
        <input type="text" name="message" class="input-field" placeholder="Type a message here..." autocomplete="off">
        <button><i class="fab fa-telegram-plane"></i></button>
      </form>
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

  <script src="assets/js/style-chat.js"></script>
  
</body>
</html>