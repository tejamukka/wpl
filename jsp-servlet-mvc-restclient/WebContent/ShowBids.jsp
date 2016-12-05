<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">

	<title>Tiny editable jQuery Bootstrap spreadsheet from MindMup</title>
	
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="keywords" content="opensource jquery bootstrap editable table spreadsheet" />
    <meta name="description" content="This tiny jQuery bootstrap plugin turns any table into an editable spreadsheet" />
    <link rel="apple-touch-icon" href="https://d1g6a398qq2djm.cloudfront.net/img/apple-touch-icon.png" />
    <link rel="shortcut icon" href="https://d1g6a398qq2djm.cloudfront.net/img/favicon.ico" />
    <link href="external/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
    <style type="text/css">
      .selected {
    background-color: brown;
    color: #FFF;
}
    </style>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    <script src="external/google-code-prettify/prettify.js"></script>
		<link href="index.css" rel="stylesheet">
    <script src="js/mindmup-editabletable.js"></script>
    <script src="js/sorttable.js"></script>
    <script src="js/numeric-input-example.js"></script>
  </head>
  <body>
<div class="container">
  <div class="hero-unit">
  <div class="pull-right">
	<div class="fb-like" data-href="https://facebook.com/mindmupapp" data-send="false" data-layout="button_count" data-width="100" data-show-faces="false"></div><br/>
    <a href="https://twitter.com/mindmup" class="twitter-follow-button" data-show-count="true" data-show-screen-name="true" data-lang="en">Follow @mindmup</a> 
  </div>
	<h1>editableTableWidget<br/> <small>tiny editable jQuery Bootstrap spreadsheet</small></h1>
	<hr/>
		

			
			
          <table id="mainTable" class="table table-striped sortable">
            <thead><tr><th>bid_id</th><th>bid_price</th><th>id</th><th>p_id</th><th>Cart</th></tr></thead>
	
	
          </table>
          <h2><small>just start typing to edit, or move around with arrow keys or mouse clicks!</small></h2>
          <input type="button" name="OK" class="ok" value="OK"/>
</div>
<div class="row">
    <div class="span6">
          <h2>About</h2>
          <p>
		  This <a href="https://github.com/mindmup/editable-table/blob/master/mindmup-editabletable.js">tiny (3KB, &lt; 120 lines) jQuery plugin</a> turns any 
		  table into an editable spreadsheet. 
          Here are the key features:
      </p>
          <ul>
            <li>No magic - works on a normal HTML table (so you can plug it in into any web table, and apply any JS function to calculate values)</li>
            <li>Supports validation and change events (so you can warn about invalid input or prevent invalid changes)</li>
            <li>Uses standard DOM focus for selection (so does not interrupt scrolling or tabbing outside the table)</a></li>
			<li>Input automatically copies underlying table cell styling</li>
            <li>Native copy/paste support</li>
            <li>Does not force any styling (so you can style it any way you want, using normal CSS)</li>
			<li>Works well with Bootstrap</li>
			<li>Depends only on jQuery</li>
			<li>Tested in Chrome 32, Firefox 26, IE 10, Safari 7, Android Chrome and iOS 7 Safari</li>
      </ul>


      <h2>Usage</h2>
<pre class="prettyprint ">
$('#table').editableTableWidget();
</pre>    
<p>Use a text area instead of input field to input (or supply a custom editor element)</p>
<pre class="prettyprint ">
$('#table').editableTableWidget({editor: $('&lt;textarea&gt;')});
</pre>
<p>Make sure that the editor clones some specific CSS properties of the underlying cell</p>
<pre class="prettyprint ">
$('#table').editableTableWidget({
	cloneProperties: ['background', 'border', 'outline']
});
</pre>
<p>Mark content as invalid during editing (for example, change one of the item names above to blank or try to enter a non-numeric cost)</p>
<pre class="prettyprint">
$('table td').on('validate', function(evt, newValue) {
	if (....) { 
		return false; // mark cell as invalid 
	}
});
</pre>
<p>Act on a change (or even reject it). This is how the numbers above recalculate. Also, try to increase total cost over 5000!</p>
<pre class="prettyprint">
$('table td').on('change', function(evt, newValue) {
	// do something with the new cell value 
	if (....) { 
		return false; // reject change
	}
});
</pre>
    </div>
    <div class="span6" >
        <h2>Why?</h2>

        <a href="https://www.mindmup.com"><img class="span5" src="https://mindmup.github.io/promo-868x350.png"></a>
        <br clear="all" />
        <p>
		We built a tabular data editor for <a href="https://www.mindmup.com">MindMup</a>. Yes, there are plenty of existing widgets such as this, but
		the ones we could find were either too magic (automatically generated tables with custom styles, interrupting normal focus flow, faking selection with background styles, flash-based copy-paste) 
		or too big (good ones start at 200KB).</p>
		<p>MindMup targets recent browsers, so with HTML5, everything we need can fit into less than 3K. We built this tiny tiny 
		editor that does everything we need, does not impose
          any particular additional CSS, does not fight DOM but uses it as normal, works well with Bootstrap styling, and fits nicely into jQuery event processing. </p>
          <p>It's released under the MIT license, so fork and enjoy!  </p>
		<h2>FAQ</h2>
		

          
		</div>
	</div>
	<div class="row">
		<div class="span6 offset3">
			 <p style="text-align:center;">
				<a class="btn btn-large btn-primary jumbo" href="https://github.com/mindmup/editable-table">View project on Github</a>
				<a class="btn btn-large jumbo" href="mailto:contact@mindmup.com"><i class="icon-envelope"></i></a>
          <a class="btn btn-large jumbo" href="https://facebook.com/mindmupapp"><i class="icon-facebook"></i></a>
          <a class="btn btn-large jumbo" href="https://twitter.com/mindmup"><i class="icon-twitter"></i></a>
          <a class="btn btn-large jumbo" href="https://plus.google.com/u/0/communities/112831595986131146219"><i class="icon-google-plus"></i></a>
        </p>
		</div>
	</div>
</div>

<script>
  $('#mainTable').editableTableWidget().numericInputExample().find('td:first').focus();
  $('#textAreaEditor').editableTableWidget({editor: $('<textarea>')});
  window.prettyPrint && prettyPrint();
</script>
<a href="https://github.com/mindmup/editable-table"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://s3.amazonaws.com/github/ribbons/forkme_right_gray_6d6d6d.png" alt="Fork me on GitHub"></a>
<div id="fb-root"></div>

<script>
<% String payloadRequest = (String)request.getAttribute("data");  %>
var data=<%=payloadRequest%>;

        $("#div1").append(tbl);
    for(var i=0;i<data.length;i++)
    {
         var tr="<tr>";
         $("tr").attr("id","row"+i);

        var td1="<td>"+data[i]["bid_id"]+"</td>";

        var td2="<td>"+data[i]["bid_price"]+"</td>";
        var td3="<td>"+data[i]["id"]+"</td>";
        var td4="<td>"+data[i]["p_id"]+"</td>";
      //  var td5="<td>"+ " "+"</td>";
        var td5="<td>"+"<button class=\"editbtn\">Add To Cart</button>"+"</td></tr>";

    
       var tbl=$("<table/>").attr("id","mainTable");
       tbl.addClass("table");

       $("#mainTable").append(tr+td1+td2+td3+td4+td5); 

    }  
      

</script>

<script type="text/javascript">
$('.editbtn').on('click',function(){
  var tdarr = $(this).parents('tr').find('td');
  var tharr = $(this).parents('table').find('th')
  var retObj = {};
  for(var i=0;i<tharr.length;i++){
    retObj[$(tharr[i]).text()] =$(tdarr[i]).text() ;
  }  
  console.log(retObj);
  //$.post("http://localhost:8080/RestHibernate/rest/bidRequest/Bid", retObj);

   $.ajax({
    type: 'POST',
    url: 'CartServlet',
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
  //$.post(url="http://localhost:8080/RestHibernate/rest/bidRequest/Bid", data=retObj,crossDomain=true);
});

//$("#mainTable").click(function() { $(this).closest("tr").text();
//  });
// Finds the closest row <tr> 
 // Gets a descendent with class="nr" .text(); // Retrieves the text within <td> $("#resultas").append($item); // Outputs the answer 

</script>
<script>
  $('#mainTable').editableTableWidget().numericInputExample().find('td:first').focus();
  $('#textAreaEditor').editableTableWidget({editor: $('<textarea>')});
  window.prettyPrint && prettyPrint();
</script>
<script type="text/javascript">
  $('.ok').on('click', function(e){
    alert($("#mainTable row9.selected td:first").html());
});

     $('#editbtn').click(function() {

              var temp = JSON.parse({"p_id":1,"p_name":"wplbook","p_desc":"Any wpl book","id":1});
              var nm=$('#p_id').val();
              temp.name=nm;
              var phn=$('#p_name').val();
              temp.phNo=phn;
              var em=$('#p_desc').val();
              temp.emailId=em;
              var ps=$('#id').val();
              
              $.post("https://localhost:8443/utdeats/createUser", temp);
              
             });
</script>


  </body>
</html>
    