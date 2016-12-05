<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

  <meta charset="UTF-8">

  <title>Dining Cart</title>

  <meta charset=utf-8 />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <style>
html{font-family:sans-serif;-ms-text-size-adjust:100%;-webkit-text-size-adjust:100%}body{margin:0}article,aside,details,figcaption,figure,footer,header,hgroup,main,nav,section,summary{display:block}audio,canvas,progress,video{display:inline-block;vertical-align:baseline}audio:not([controls]){display:none;height:0}[hidden],template{display:none}a{background:transparent}a:active,a:hover{outline:0}abbr[title]{border-bottom:1px dotted}b,strong{font-weight:bold}dfn{font-style:italic}h1{font-size:2em;margin:0.67em 0}mark{background:#ff0;color:#000}small{font-size:80%}sub,sup{font-size:75%;line-height:0;position:relative;vertical-align:baseline}sup{top:-0.5em}sub{bottom:-0.25em}img{border:0}svg:not(:root){overflow:hidden}figure{margin:1em 40px}hr{-moz-box-sizing:content-box;box-sizing:content-box;height:0}pre{overflow:auto}code,kbd,pre,samp{font-family:monospace, monospace;font-size:1em}button,input,optgroup,select,textarea{color:inherit;font:inherit;margin:0}button{overflow:visible}button,select{text-transform:none}button,html input[type="button"],input[type="reset"],input[type="submit"]{-webkit-appearance:button;cursor:pointer}button[disabled],html input[disabled]{cursor:default}button::-moz-focus-inner,input::-moz-focus-inner{border:0;padding:0}input{line-height:normal}input[type="checkbox"],input[type="radio"]{-moz-box-sizing:border-box;box-sizing:border-box;padding:0}input[type="number"]::-webkit-inner-spin-button,input[type="number"]::-webkit-outer-spin-button{height:auto}input[type="search"]{-webkit-appearance:textfield;-moz-box-sizing:content-box;box-sizing:content-box}input[type="search"]::-webkit-search-cancel-button,input[type="search"]::-webkit-search-decoration{-webkit-appearance:none}fieldset{border:1px solid #c0c0c0;margin:0 2px;padding:0.35em 0.625em 0.75em}legend{border:0;padding:0}textarea{overflow:auto}optgroup{font-weight:bold}table{border-collapse:collapse;border-spacing:0}td,th{padding:0}

</style>

    <style>
@import url(https://fonts.googleapis.com/css?family=Lato:400,700);
/* Iconfonts
 * ============================ */
@import url(https://weloveiconfonts.com/api/?family=fontawesome);
@import url(https://weloveiconfonts.com/api/?family=brandico);
[class*="fontawesome-"]:before {
  font-family: "FontAwesome", sans-serif;
}

[class*="brandico-"]:before {
  font-family: "brandico", sans-serif;
}

/* Variables
 * ============================ */
/* Body
 * ============================ */
body {
  position: relative;
  font-family: "Lato", sans-serif;
  font-weight: 300;
  font-size: 1em;
  color: #cccccc;
}

/* Header
 * ============================ */
header {
  width: 100%;
  border-bottom: 1px solid #7cbae6;
  background: #1e1e1e;
  /* Logo */
  /* Cart link */
  /* Quantity Notification */
  /* Quantity Notification hidden when no items */
  /* Back button hidden by default */
  /* State changes when cart is active */
}
header a.logo {
  margin-left: 1em;
  text-transform: uppercase;
  text-decoration: none;
  color: #7cbae6;
  line-height: 4em;
}
header a.logo span {
  margin: 0 3px 0 3px;
  color: #9cdaf0;
}
header a.cart-link {
  float: right;
  padding-left: 1em;
  margin-right: 1em;
  border-left: 1px dotted #515151;
  line-height: 4em;
  text-decoration: none;
  color: white;
  transition: color 150ms ease-out;
}
header a.cart-link:hover {
  color: #7cbae6;
}
header a.cart-link:active, header a.cart-link .active {
  color: #9cdaf0;
}
header span.cart-text:before {
  margin: 5px;
}
header span.cart-text:before > span {
  display: block;
}
header span.cart-quantity {
  position: relative;
  top: -2px;
  left: 5px;
  display: inline-block;
  width: 22px;
  height: 22px;
  border-radius: 50%;
  background: #ff6633;
  font-size: 0.6em;
  line-height: 20px;
  text-align: center;
  color: white;
}
header .cart-quantity.empty {
  display: none;
}
header .returnToShop {
  display: none;
}
header a.cart-link.active {
  border: 0;
  /* Cart link gets hidden */
  /* Back button is displayed */
}
header a.cart-link.active span.cart-text {
  display: none;
}
header a.cart-link.active span.cart-quantity {
  display: none;
}
header a.cart-link.active span.returnToShop {
  position: absolute;
  right: -75px;
  display: block;
  padding: 0 10px;
  background: #1e1e1e;
  border-right: 1px dotted #444444;
}

/* Sliding Cart
 * ============================ */
.wrap {
  position: relative;
  box-shadow: 10px -10px 20px -10px rgba(0, 0, 0, 0.8);
  transition: all 200ms ease-out;
}

.wrap.active {
  right: 18em;
}

#cart {
  clear: both;
  overflow: hidden;
}

.js #cart {
  position: absolute;
  top: 0;
  right: 0;
  width: 18em;
  height: 100%;
}

/* Footer
 * ============================ */
footer {
  background: #111111;
  font-size: 0.85em;
  color: white;
}
footer p {
  margin: 0 1em;
  line-height: 3em;
  color: #515151;
}

/* Shop & Product Items
 * ============================ */
.product {
  position: relative;
  z-index: 1;
  float: left;
  width: 50%;
  height: 300px;
  overflow: hidden;
  background-position: center center;
  background-size: cover;
  /* Hide product descriptions */
  /* On hover, adds overlay on top of product image */
  /* On hover, fade in product descriptions */
  /* Styles for each shop item */
  /* "Add to Cart" Buttom with 3D transforms and keyframe animation (Works best in Chrome) */
}
.product > * {
  margin: 20px 25px;
  opacity: 0;
  transition: opacity 200ms ease-out;
}
.product:hover:before {
  position: absolute;
  z-index: -1;
  top: 0;
  display: inline-block;
  width: 100%;
  height: 300px;
  background: rgba(0, 0, 0, 0.8);
  content: "";
}
.product > * {
  margin: 20px 25px;
  opacity: 0;
  transition: opacity 200ms ease-out;
}
.product:hover > *, .product .active {
  opacity: 1;
}
.product h1 {
  padding: 15px 0;
  border-bottom: 1px dotted gray;
  font-weight: normal;
  font-size: 1.6em;
  color: #7cbae6;
}
.product p {
  margin-bottom: 30px;
  line-height: 1.5em;
}
.product .button {
  position: relative;
  display: block;
  width: 150px;
  height: 50px;
  text-align: center;
  perspective: 1000px;
  /* Button magic */
}
.product .button .price {
  position: absolute;
  z-index: 1;
  top: 2px;
  display: block;
  width: 50px;
  height: 46px;
  border-right: 1px solid #9cdaf0;
  border-radius: 2px 0 0 2px;
  background: white;
  line-height: 45px;
  color: #515151;
  transform: rotateY(0deg) translateZ(25px);
}
.product .button .addtocart {
  position: absolute;
  left: 48px;
  width: 100%;
  height: 100%;
  transform-style: preserve-3d;
  transform: translateZ(-100px);
  transition: transform 300ms;
  cursor: pointer;
}
.product .button .addtocart > div {
  position: absolute;
  display: block;
  width: 150px;
  height: 50px;
  border-radius: 0 2px 2px 0;
  line-height: 50px;
}
.product .button .addtocart > .add {
  background: white;
  color: #7cbae6;
  transform: rotateY(0deg) translateZ(25px);
  transition: background 150ms ease-out;
}
.product .button .addtocart > .add:hover {
  background: #7cbae6;
  color: white;
}
.product .button .addtocart > .added {
  background: #ff6633;
  color: white;
  transform: rotateX(90deg) translateZ(25px);
}
.product .button .addtocart.active {
  animation-name: rotate;
  animation-duration: 1s;
}

/* Cart & Cart Items
 * ============================ */
#cart {
  background: #222222;
}

#cart > h2 {
  height: 64px;
  padding-right: 1em;
  border-left: 1px dotted #515151;
  border-bottom: 1px solid #7cbae6;
  margin: 0;
  background: #2d2d2d;
  font-weight: normal;
  font-size: 1.2em;
  text-align: right;
  line-height: 64px;
}

/* Styles for each cart item */
.cart-items {
  padding: 0;
}

.cart-items > li {
  margin: 30px 20px 30px;
  border: 1px solid #333333;
  background: #202020;
  list-style: none;
}

.cart-product {
  position: relative;
  display: inline-block;
  height: 75px;
  width: 75px;
  background-image: url("http://cdn.shopify.com/s/files/1/0051/4802/products/MG_1785_1024x1024.jpg");
  background-size: cover;
  vertical-align: top;
}
.cart-product input.quantity {
  width: 75px;
  height: 75px;
  padding: 0;
  border: 0;
  border-right: 1px solid #333333;
  background: rgba(0, 0, 0, 0.5);
  font-size: 2.5em;
  line-height: 75px;
  text-align: center;
  color: white;
}

.cart-description {
  display: inline-block;
  height: 75px;
  width: 160px;
  margin-left: 10px;
  text-align: right;
  vertical-align: top;
}
.cart-description h3 {
  margin: 8px;
  font-size: 1em;
  color: #7cbae6;
}
.cart-description .subtotal {
  position: relative;
  display: inline-block;
  margin: 8px;
  font-size: 0.8em;
}

/* Styling for Total Costs */
.total {
  margin-top: 50px;
}

.total > * {
  display: block;
  padding-bottom: 10px;
  margin: 0 20px 10px 20px;
  font-size: 0.8em;
  text-align: left;
}

.total span {
  float: right;
  text-align: right;
}

.subtotalTotal {
  border-bottom: 1px dotted #515151;
}

.shipping {
  border-bottom: 1px dotted #515151;
}

.finalTotal {
  font-size: 1em;
  color: #7cbae6;
}

a.checkout {
  height: 35px;
  padding: 0;
  margin-top: 30px;
  border-radius: 3px;
  background: #247ebe;
  font-size: 1em;
  text-align: center;
  text-transform: uppercase;
  line-height: 35px;
  transition: background 150ms ease-out;
  cursor: pointer;
}
a.checkout:hover {
  background: #3c98da;
}
a.checkout.active {
  animation-name: shake;
  animation-duration: 800ms;
}

.error {
  display: none;
  text-align: center;
}

.error:after {
  display: block;
  font-size: 0.9em;
  text-transform: none;
  content: "Sorry, the Octocat is busy!";
}

/* Media Queries
 * ============================ */
@media (max-width: 720px) {
  .product {
    width: 100%;
  }
}
@media (max-width: 420px) {
  /* Hide text in the cart link to save room */
  .cart-text > span {
    display: none;
  }
}
/* Keyframe Animations
 * ============================ */
@keyframes rotate {
  35% {
    transform: translateZ(-100px) rotateX(-90deg);
  }

  72% {
    transform: translateZ(-100px) rotateX(-90deg);
  }

  100% {
    transform: translateZ(-100px);
  }
}
@keyframes shake {
  0%, 100% {
    transform: translateX(0);
  }

  10%, 30%, 50%, 70%, 90% {
    transform: translateX(-5px);
  }

  20%, 40%, 60%, 80% {
    transform: translateX(5px);
  }
}

</style>

    <script src="js/prefixfree.min.js"></script>

    <script src="js/modernizr.js"></script>

</head>

<body>

  <div id='cart'>
  <h2>Your Shopping Cart</h2>
  <ul class='cart-items'></ul>
  <div class='total'>
    <div class='subtotalTotal'>
      Subtotal
      <span>$0.00</span>
    </div>
    <div class='taxes'>
      Tax
      <span>$0.00</span>
    </div>
    <div class='shipping'>
      Shipping
      <span>$0.00</span>
    </div>
    <div class='finalTotal'>
      Total
      <span>$0.00</span>
    </div>
    <button class='checkout' id="checkout">
     
 checkout</button>
    <p class='error'></p>
  </div>
</div>
<div class='wrap' id='wrap'>
  <header>
    <a class='logo' href='index.html'>
      HOME
    </a>
    <a class='cart-link' href='#menu'>
      <span class='cart-text fontawesome-shopping-cart'>
        <span>Cart</span>
      </span>
      <span class='returnToShop'>&larr; Back</span>
      <span class='cart-quantity empty'>0</span>
    </a>
  </header>
  <section class='shop'></section>
  <footer>
    <p>The UTD Dining services</p>
  </footer>
</div>
<!-- / Product Templates for Shop & Cart -->
<script id='productTemplate' type='text/template'>
  <div class="product">
  <h1></h1>
  <p></p>
  <div class="button">
  <div class="price"></div>
  <a class="addtocart">
  <div class="add">Add to Cart</div>
  <div class="added">Added!</div>
  </a>
  </div>
  </div>
</script>

<div class="add">Add to Cart TEst </div>
<script id='cartItem' type='text/template'>
    <li><div class="cart-product">
    <input class="quantity" value="1">

    </div><div class="cart-description">
    <h3></h3>
    <button type="button" class="delitems">Delete</button>
    <span class="subtotal"></span>

    </div></li>
</script>

  <script src='https://codepen.io/assets/libs/fullpage/jquery.js'></script>

 <!--  <script src="js/index.js"></script> -->
  
 
  <script type="text/javascript">

  <% String payloadRequest1 = (String)request.getAttribute("data");  %>
  var data=<%=payloadRequest1%>;
  $(document).ready(function() {

  	  // Product data to be used in shop and in cart
  	 
  	  
  /* 	  var data=[{"p_id":1,"p_name":"wplbook","p_desc":"Any wpl book","id":1},{"p_id":2,"p_name":"DAA","p_desc"
  		  :"Cormen","id":2},{"p_id":3,"p_name":"DAA","p_desc":"Neesd a DAA book","id":2},{"p_id":4,"p_name":"ML"
  		  ,"p_desc":"MLBook","id":3},{"p_id":5,"p_name":"dtre","p_desc":"dtrees","id":3},{"p_id":6,"p_name":"DataStructure"
  		  ,"p_desc":"Thomas Cormen","id":3},{"p_id":7,"p_name":"maths","p_desc":"mathbook","id":3},{"p_id":8,"p_name"
  		  :"tuhu","p_desc":"uhuh","id":3},{"p_id":9,"p_name":"tyyt","p_desc":"yt","id":3},{"p_id":10,"p_name":"VLsi"
  		  ,"p_desc":"Vlsi","id":3}];
  	   */
  	  // Populates shop with items based on template and data in var products
  	  
  	  var $shop = $('.shop');
  	  var $cart = $('.cart-items');
  	  for(var i=0;i<data.length;i++){
//  		  for(var item in data[i]) {
//  		    var itemName = products[item][0],
//  		        itemDescription = products[item][1],
//  		        itemPrice = products[item][2],
//  		       // itemImg = products[item][3],
//  		        itemId = products[item][4],
//  		        $template = $($('#productTemplate').html());
  		    
  		    var itemPrice = data[i].bid_price,
  	        itemDescription = data[i].bid_id,
  	        itemName = data[i].id,
  	        itemId = data[i].p_id,
  	        $template = $($('#productTemplate').html());
  		    
  		    $template.find('h1').text(itemName);
  		    $template.find('p').text(itemDescription);
  		    $template.find('.price').text('$' + itemPrice);
  		    //$template.css('background-image', 'url(' + itemImg + ')');
  		    
  		    $template.data('id', itemId);
  		    $template.data('name', itemName);
  		    $template.data('price', itemPrice);
  		    //$template.data('image', itemImg);
  		    
  		    $shop.append($template);
//  		  }
  	  }
  	  // Checks quantity of a cart item on input blur and updates total
  	  // If quantity is zero, item is removed
  	  
  	  $('body').on('blur', '.cart-items input', function() {
  	    var $this = $(this),
  	        $item = $this.parents('li');
  	    if (+$this.val() === 0) {
  	      $item.remove();
  	    } else {
  	      calculateSubtotal($item);
  	    }
  	    updateCartQuantity();
  	    calculateAndUpdate();
  	  });
  	  
  	  $('body').on('click', '.cart-description .delitems', function() {
  	    var $this = $(this),
  	        $item = $this.parents('li');
  	      $item.remove();
  	    updateCartQuantity();
  	    calculateAndUpdate();
  	  });
  	  
  	  // Add item from the shop to the cart
  	  // If item is already in the cart, +1 to quantity
  	  // If not, creates the cart item based on template
  	  
  	  $('body').on('click', '.product .add', function() {
  	    var items = $cart.children(),
  	        $item = $(this).parents('.product'),
  	        $template = $($('#cartItem').html()),
  	        $matched = null,
  	        quantity = 0;
  	    
  	    $matched = items.filter(function(index) {
  	      var $this = $(this);
  	      return $this.data('id') === $item.data('id');
  	    });
  	   
  	    if ($matched.length) {
  	      quantity = +$matched.find('.quantity').val() + 1;
  	      $matched.find('.quantity').val(quantity);
  	      calculateSubtotal($matched);
  	    } else {
  	      $template.find('.cart-product').css('background-image', 'url(' + $item.data('image') + ')');
  	      $template.find('h3').text($item.data('name'));
  	      $template.find('.subtotal').text('$' + $item.data('price'));
  	    
  	      $template.data('id', $item.data('id'));
  	      $template.data('price', $item.data('price'));
  	      $template.data('subtotal', $item.data('price'));
  	      
  	      $cart.append($template);
  	    }
  	    
  	    updateCartQuantity();
  	    calculateAndUpdate();
  	  });

  	  // Calculates subtotal for an item
  	  
  	  function calculateSubtotal($item) {
  	    var quantity = $item.find('.quantity').val(),
  	        price = $item.data('price'),
  	        subtotal = quantity * price;
  	    $item.find('.subtotal').text('$' + subtotal);
  	    $item.data('subtotal', subtotal);
  	  } 
  	    
  	  // Clicking on the cart link opens up the shopping cart
  	  
  	  var $cartlink = $('.cart-link'), $wrap = $('#wrap');
  	  
  	  $cartlink.on('click', function() {
  	    $cartlink.toggleClass('active');
  	    $wrap.toggleClass('active');
  	    return false;    
  		});
  	  
  	  // Clicking outside the cart closes the cart, unless target is the "Add to Cart" button 
  	 
  	  $wrap.on('click', function(e){
  	    if (!$(e.target).is('.add')) {
  	      $wrap.removeClass('active');
  	      $cartlink.removeClass('active');
  	    }
  	  });
  	 
  	  // Calculates and updates totals, taxes, shipping
  	  
  	  function calculateAndUpdate() {
  	    var subtotal = 0,
  	        items = $cart.children(),
  	        // shipping not applied if there are no items
  	        shipping = items.length > 0 ? 5 : 0,
  	        tax = 0;
  	    items.each(function(index, item) {
  	      var $item = $(item),
  	          price = $item.data('subtotal');
  	      subtotal += price;
  	    });
  	    $('.subtotalTotal span').text(formatDollar(subtotal));
  	    tax = subtotal * .05;
  	    $('.taxes span').text(formatDollar(tax));
  	    $('.shipping span').text(formatDollar(shipping));
  	    $('.finalTotal span').text(formatDollar(subtotal + tax + shipping));
  	  }

  	  //  Update the total quantity of items in notification, hides if zero
  	  
  	  $('#checkout').on('click',function(){
  		var items = $('.cart-items li');
  		var retObj = {};
  		var itemArr = [];
  		for(var i=0;i<items.length;i++){
  		  var obj = {};
  		  obj['quantity'] = $(items[i]).find('input').val();
  		  obj['userId'] = $(items[i]).find('h3').text();
  		  obj['subTotal'] = $(items[i]).find('span.subtotal').text();
  		  itemArr.push(obj); 
  		}
  		retObj['items'] = itemArr;
  		retObj['total'] = $('div.finalTotal span').text();
  		console.log(retObj);
  		
  		
  		 $.ajax({
  		    type: 'POST',
  		    url: 'order',
  		    crossDomain: true,
  		    data: JSON.stringify(retObj),
  		    
  		    dataType: "json",
  		    success: function(responseData, textStatus, jqXHR) {
  		        var value = responseData.someKey;
  		    },
  		    error: function (responseData, textStatus, errorThrown) {
  		        alert('POST failed.');
  		    }
  		});
  		
  	  });
  	  
  	  function updateCartQuantity() {
  	    var quantities = 0,
  	        $cartQuantity = $('span.cart-quantity'),
  	        items = $cart.children();
  	    items.each(function(index, item) {
  	      var $item = $(item),
  	          quantity = +$item.find('.quantity').val();
  	      quantities += quantity;
  	    });
  	    if(quantities > 0){
  	      $cartQuantity.removeClass('empty');
  	    } else {
  	      $cartQuantity.addClass('empty');
  	    }
  	    $cartQuantity.text(quantities);
  	  }
  	  
  	 
  	  //  Formats number into dollar format
  	     
  	  function formatDollar(amount) {
  	    return '$' + parseFloat(Math.round(amount * 100) / 100).toFixed(2);
  	  }
  	  
  	  // Restrict the quantity input field to numbers only
  	     
  	  $('body').on('keypress', '.cart-items input', function (ev) {
  	      var keyCode = window.event ? ev.keyCode : ev.which;
  	      if (keyCode < 48 || keyCode > 57) {
  	        if (keyCode != 0 && keyCode != 8 && keyCode != 13 && !ev.ctrlKey) {
  	          ev.preventDefault();
  	        }
  	      }
  	    });
  	  
  	  // Trigger animation on Add to Cart button click
  	  
  	  $('.addtocart').on('click', function () {
  	    $(this).addClass('active');
  	    setTimeout(function () {
  	      $('.addtocart').removeClass('active');    
  	    }, 1000);
  	  });
  	  
  	  // Trigger error animation on Checkout button
  	  
  	  $('.checkout').on('click', function () {
  	    $(this).addClass('active');
  	    
  	            var final_price= $('.finalTotal').text().split('\n')[2];
  	           final_price= final_price.split('$')[1];
  	  
  	            var items ={};
  	    $('.cart-items li').each(function(){
  	        var i_name=$.trim($(this).text().split('\n')[4]);
  	        var i_price =$(this).text().split('\n')[6];
  	         i_price = i_price.replace(/[^0-9]/g, '');
  	        var i_qty = 0;
  	        
  	        var i_num=0;
  	        //alert(i_price);

  	    for(var itemss in products) {

  	            if(i_name == products[itemss][0])
  	            {
  	                i_qty=i_price/products[itemss][2];
  	                i_num=products[itemss][4];
  	            }
  	        } 
  	        
//  	        var dta= {[i_num]:i_qty};
  	        items[i_num] = i_qty;
//  	        data.push(dta);

  	    });
  	    var data = {};
  	    data["orderItems"] = items;
  	    data["orderAmount"] = final_price;
//  	    data= {"orderItems":data,"orderAmount":final_price};
  	       data={"orderData":data};
  	        var c= JSON.stringify(data);
  	        $.post('https://localhost:8443/utdeats/order', c)
  		        .done(function(data) {
  					alert("Order placed successfully!");
  					window.location.href = "https://localhost:8443/utdeats/pastorders.html";
  		        })
  		        .fail(function(data) {
  		        	alert("Failed to place order.");
  		    });
  	          
  	  }); 

  	        
  	  });</script></script>

</body>

</html>