$(document).ready(function() {

  // Product data to be used in shop and in cart
 
  
  var data=[{"p_id":1,"p_name":"wplbook","p_desc":"Any wpl book","id":1},{"p_id":2,"p_name":"DAA","p_desc"
	  :"Cormen","id":2},{"p_id":3,"p_name":"DAA","p_desc":"Neesd a DAA book","id":2},{"p_id":4,"p_name":"ML"
	  ,"p_desc":"MLBook","id":3},{"p_id":5,"p_name":"dtre","p_desc":"dtrees","id":3},{"p_id":6,"p_name":"DataStructure"
	  ,"p_desc":"Thomas Cormen","id":3},{"p_id":7,"p_name":"maths","p_desc":"mathbook","id":3},{"p_id":8,"p_name"
	  :"tuhu","p_desc":"uhuh","id":3},{"p_id":9,"p_name":"tyyt","p_desc":"yt","id":3},{"p_id":10,"p_name":"VLsi"
	  ,"p_desc":"Vlsi","id":3}];
  
  // Populates shop with items based on template and data in var products
  
  var $shop = $('.shop');
  var $cart = $('.cart-items');
  for(var i=0;i<data.length;i++){
//	  for(var item in data[i]) {
//	    var itemName = products[item][0],
//	        itemDescription = products[item][1],
//	        itemPrice = products[item][2],
//	       // itemImg = products[item][3],
//	        itemId = products[item][4],
//	        $template = $($('#productTemplate').html());
	    
	    var itemName = data[i].p_name,
        itemDescription = data[i].p_desc,
        itemPrice = data[i].p_id,
        itemId = data[i].id,
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
//	  }
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
        
//        var dta= {[i_num]:i_qty};
        items[i_num] = i_qty;
//        data.push(dta);

    });
    var data = {};
    data["orderItems"] = items;
    data["orderAmount"] = final_price;
//    data= {"orderItems":data,"orderAmount":final_price};
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

        
  });