<%@page import="com.wpl.commons.ParameterConstants"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="users" class="edu.utdallas.cs6314.jsp.servlet.mvc.rest.UserBean" scope ="request"/>  
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>MyAccount</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' media="all" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Google Fonts -->
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/sticky-navigation.css" />
<link href="css/demo.css" rel="stylesheet" type="text/css" />
<script>
$(function() {

	// grab the initial top offset of the navigation 
	var sticky_navigation_offset_top = $('#sticky_navigation').offset().top;
	
	// our function that decides weather the navigation bar should have "fixed" css position or not.
	var sticky_navigation = function(){
		var scroll_top = $(window).scrollTop(); // our current vertical position from the top
		
		// if we've scrolled more than the navigation, change its position to fixed to stick to top, otherwise change it back to relative
		if (scroll_top > sticky_navigation_offset_top) { 
			$('#sticky_navigation').css({ 'position': 'fixed', 'top':0, 'left':0 });
		} else {
			$('#sticky_navigation').css({ 'position': 'relative' }); 
		}   
	};
	
	// run our function on load
	sticky_navigation();
	
	// and run it again every time you scroll
	$(window).scroll(function() {
		 sticky_navigation();
	});
	
	// NOT required:
	// for this demo disable all links that point to "#"
	$('a[href="#"]').click(function(event){ 
		event.preventDefault(); 
	});
	
});
</script>
</head>
<body>
	<!-- Header Part Starts Here -->
<div class="header">
	<div class="container">
	<div id="demo_top_wrapper">
	<div id="sticky_navigation_wrapper">
		<div id="sticky_navigation">
			<div class="demo_container navigation-bar">
				<div class="navigation">
					<div class="logo"><a href="Dashboard.html">BID</a></div>
					<span class="menu"></span>
					<script>
						$( "span.menu" ).click(function() {
						  $( ".navig" ).slideToggle( "slow", function() {
						    // Animation complete.
						  });
						});
					</script>
					<div class="navig">
						<ul>
							<li><a href="MyAccount.jsp">MyAccount</a></li>
							<li><a href="PostBid.jsp">Create Bid</a></li>
							<li><a href="ShowItem">Show Items to Bid</a></li>
							<li><a href="BidServlet">Show Bids</a></li>
							<li><a href="#">Search Bids</a></li>
							<li><a href="about.html">Contact Us</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="navigation-right">
					<ul class="user">
						<li>
							<span></span><a href="login.html">Log In</a>
						</li>
						<li>
							<span class="bascket"></span><a href="bascket.html">Basket(0)</a>
						</li>
						<li>
							<button class="search"></button>
						</li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<div class="serch">
								<span>
									<input type="text" placeholder="Search" required="">
									<input type="submit" value="" />
								</span>
				</div>
				<script>
					$( "button.search" ).click(function() {
					  $( ".serch" ).slideToggle( "slow", function() {
					    // Animation complete.
					  });
					});
				</script>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<div class="container">
<section id="main">
	<div class="content">
		<div class="pag-nav">
			<ul class="p-list">
				<li><a href="index.html">Home</a></li> &nbsp;&nbsp;/&nbsp;
				<li class="act">&nbsp;Register</li>
			</ul>
		</div>
		<div class="coats">
			<h3 class="c-head">My Account</h3>
			<p>Details</p>
		</div>
		<div class="register">
	  	  <form> 
			 <div class="register-top-grid">
				<h3>PERSONAL INFORMATION</h3>
				 <div>
					<span>First Name</span>
					<%= session.getAttribute(ParameterConstants.FIRST_NAME) %>
				
				 </div>
				  <div>
					<span>Last Name</span>
					<%= session.getAttribute(ParameterConstants.LAST_NAME) %>
				 </div>
				  <div>
					<span>Email</span>
					<%= session.getAttribute(ParameterConstants.EMAIL) %>
				 </div>
				  <div>
					<span>Username</span>
					<%= session.getAttribute(ParameterConstants.USERNAME) %>
				 </div>
				 
			     
			</form>
			<div class="clearfix"> </div>
			<div class="register-but">
			   <form>
				   <input type="submit" value="submit">
				   <div class="clearfix"> </div>
			   </form>
			</div>
	   </div>
	   <div class="look">
			<h3>You May Also Like</h3>
		</div>
		<!-- Partners Starts Here --->
		<div class="partner">
				<ul id="flexiselDemo3">
				   <li><img src="web/images/ss1.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="web/images/ss2.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="web/images/ss3.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="web/images/ss4.jpg" class="img-responsive" alt=""/></li>
				   <li><img src="web/images/ss5.png" class="img-responsive" alt=""/></li>
				</ul>
				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo3").flexisel({
							visibleItems: 5,
							animationSpeed: 1000,
							autoPlay: true,
							autoPlaySpeed: 3000,    		
							pauseOnHover: true,
							enableResponsiveBreakpoints: true,
					    	responsiveBreakpoints: { 
					    		portrait: { 
					    			changePoint:480,
					    			visibleItems: 1
					    		}, 
					    		landscape: { 
					    			changePoint:640,
					    			visibleItems: 2
					    		},
					    		tablet: { 
					    			changePoint:768,
					    			visibleItems: 3
					    		}
					    	}
					    });
					    
					});
			 </script>
	         <script type="text/javascript" src="web/js/jquery.flexisel.js"></script>
		</div>
		<!-- Partners Ends Here --->
		<!-- Footer Menu Starts here --->
		<div class="footer">
				<div class="col-md-3 footer-col">
					<h3 class="ft-title">Post Bid</h3>
					<ul class="ft-list list-h">
						<li><a href="#">Search</a></li>
						<li><a href="contact.html">Contact</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- Footer Menu Ends here --->	
	</div>
</section>
</body>
</html>