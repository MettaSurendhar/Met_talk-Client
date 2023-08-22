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
  <title>Met_talk</title>
</head>
<body>

	<% String userName = request.getParameter("userName");%>

  <div class="cred-form">
    <main class="form-signin w-100 m-auto">
      <form action='PersonalDetails' method='post' enctype="multipart/form-data">

        <div class='d-flex justify-content-center align-items-center gap-2 '>
          <h1 class="h3 mb-3 fw-normal fs-2 text-center ">Personal Info</h1> 
          <div class='img-container'>
            <img class="mb-4" src="assets/images/plane.svg" alt="" width="72" height="57">
          </div>
        </div>
        
        <input type="text" name="userName" value="<%= userName %>" hidden="true">
    
        <div class="form-floating mb-4">
          <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required >
          <label for="firstName">First Name</label>
        </div>
        
        <div class="form-floating mb-4">
          <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" >
          <label for="lastName">Last Name</label>
        </div>

        <div class="form-input-file mb-4">
          <label class='form-label text-white ' for='inputImage'>Select a Profile Image</label>
          <input type="file" id="inputImage" class='form-control' name="imageFile" accept="image/x-png,image/jpeg,image/jpg" required>
        </div>

        <div class="form-floating mb-4">
          <textarea class="form-control" style="max-height:100px" name="status" placeholder="Leave a comment here" id="status"></textarea>
          <label for="status">Status</label>
        </div>

        <div class='w-100  mb-4 d-flex justify-content-evenly'>
          <button class="btn btn-reset fw-semibold px-4" type="reset"> Reset </button>
          <button class="btn btn-save fw-semibold px-4" type="submit"> Save</button>
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
  
<!-- <script src="assets/js/style-signUp.js"></script> -->


</body>
</html>