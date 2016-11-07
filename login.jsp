<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> <title>This is the Login Page</title>
  <link rel="stylesheet" href="login.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>   
 <!--  <script src="js/login.js"></script> -->
 	<!---http://codepen.io/vikasverma93/pen/zplmq -->
</head>
<body>

 <div class="login-box">
    <div class="lb-header">
      <a href="#" class="active" id="login-box-link">Login</a>
      <a href="#" id="signup-box-link">Sign Up</a>
    </div>
    <div class="social-login">
      <a href="#">
        <i class="fa fa-facebook fa-lg"></i>
        Login in with facebook
      </a>
      <a href="#">
        <i class="fa fa-google-plus fa-lg"></i>
        log in with Google
      </a>
    </div>
    <form class="email-login">
      <div class="u-form-group">
        <input type="email" placeholder="Email"/>
      </div>
      <div class="u-form-group">
        <input type="password" placeholder="Password"/>
      </div>
      <div class="u-form-group">
        <button>Log in</button>
      </div>
      <div class="u-form-group">
        <a href="#" class="forgot-password">Forgot password?</a>
      </div>
    </form>
    <form class="email-signup">
      <div class="u-form-group">
        <input type="email" placeholder="Email"/>
      </div>
      <div class="u-form-group">
        <input type="password" placeholder="Password"/>
      </div>
      <div class="u-form-group">
        <input type="password" placeholder="Confirm Password"/>
      </div>
      <div class="u-form-group">
        <button>Sign Up</button>
      </div>
    </form>
  </div>
  <script src="login.js"></script>

</body>
</html>