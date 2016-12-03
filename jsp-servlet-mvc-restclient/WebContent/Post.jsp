
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Insert title here</title>
<style type="text/css">
    table {
        border-collapse: collapse;
        border: none;
    }
    th,
    td {
        border: 1px solid black;
        padding: 4px 16px;
        font-family: Times New Roman;
        font-size: 24px;
        text-align: left;
    }
    th {
        background-color: #C8C8C8;
        cursor: pointer;
    }
    
.selected {
    background-color: brown;
    color: #FFF;
}
</style>
<script src="sorttable.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript">

</script>
<script>
<% String payloadRequest = (String)request.getAttribute("jsonArray");  %>
var myList=<%=payloadRequest%>;
function buildHtmlTable() {
	var columns = addAllColumnHeaders(myList);

	for (var i = 0 ; i < myList.length ; i++) {
	 var row$ = $('<tr/>');
	 
	 for (var colIndex = 0 ; colIndex < columns.length ; colIndex++) {
	     var cellValue = myList[i][columns[colIndex]];

	     if (cellValue == null) { cellValue = ""; }

	     row$.append($('<td/>').html(cellValue));
	 }
	 $("#excelDataTable").append(row$);
	}
	
	function addAllColumnHeaders(myList)
	{
	var columnSet = [];
	var headerTr$ = $('<tr/>');
	for (var i = 0 ; i < myList.length ; i++) {
	 var rowHash = myList[i];
	 for (var key in rowHash) {
	     if ($.inArray(key, columnSet) == -1){
	         columnSet.push(key);
	         headerTr$.append($('<th/>').html(key));
	     }
	 }
	}
	$("#excelDataTable").append(headerTr$);

	return columnSet;
	}
	}
	
	

</script>
<script>
var table = document.getElementById('excelDataTable'),
selected = table.getElementsByClassName('selected');
table.onclick = highlight;
function highlight(e) {
if (selected[0]) selected[0].className = '';
e.target.parentNode.className = 'selected';
}
function fnselect(){
var $row=$(this).parent().find('td');
var clickeedID=$row.eq(0).text();
alert(clickeedID);
}
</script>

</head>
<body onload="buildHtmlTable()" >
<!-- <input type="submit" id="button" value="submit" onclick="buildHtmlTable()">  -->
<table id="excelDataTable" border="1" class="sortable">
</table>


</body>

</html>