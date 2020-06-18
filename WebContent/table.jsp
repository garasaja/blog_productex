<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fruit store</title>
<style>
      table {
        width: 100%;
      }
      table, th, td {
        border: 1px solid #bcbcbc;
      }
    </style>
    
    
</head>
<body>
	 <input onclick="first()" type ="button" value ="처음으로"/>
     <input onclick="priceDesc()" type ="button" value ="가격순(DESC)"/>
     <input onclick="countpriceDesc()" type ="button" value ="판매순(DESC)"/>
	<table>
      <caption><h1>버전1</h1></caption>
      
      <thead>
        <tr>          
          <th>번호</th>
          <th>이름</th>
          <th>종류</th>
          <th>가격</th>
          <th>판매수</th>
          <th></th>
        </tr>
      </thead>
      <tbody id="body_id">       
        <c:forEach var="fruit" items="${kindslist}">
<%--         <tr id = "delete_id-${fruit.id}"> --%>
		<tr>
    	  <td>${fruit.id}</td>
          <td>${fruit.name}</td>
          <td>${fruit.type}</td>
          <td>${fruit.price}</td>
          <td>${fruit.countprice}</td>
          <td><input onclick="deletebyid(${fruit.id})" type="button" value="삭제"></td> 
          
   	    </c:forEach>
      </tbody>
     
    </table>
    
   
    
    <script>

	
    
    function first(){
		$.ajax({
			url:"/fruitstore/fruit?cmd=idProc",
			type:"get",//방식
			dataType:"json",//받는타입
			contentType: "Application/x-www-urlencoded; charset=utf-8",//보내는타입	
		}).done( (result)=> {
			$("#body_id").empty();

			for (var fruit of result) {
				var trItem = "<tr>";
				trItem += "<td>" + fruit.id + "</td>";
				trItem += "<td>" + fruit.name + "</td>";
				trItem += "<td>" + fruit.type + "</td>";
				trItem += "<td>" + fruit.price + "</td>";
				trItem += "<td>" + fruit.countprice + "</td>";
				trItem += "<td><input onclick=\"deletebyid("+fruit.id+")\" type=\"button\" value=\"삭제\"></td>";
				trItem += "</tr>";

				$("#body_id").append(trItem);
			}
			
		}).fail( (error)=> {
			
		})
		
	}
    
    function priceDesc(){
    	$.ajax({
			url:"/fruitstore/fruit?cmd=priceProc",
			type:"get",//방식
			dataType:"json",//받는타입
			contentType: "Application/x-www-urlencoded; charset=utf-8",//보내는타입	
		}).done( (result)=> {
			$("#body_id").empty();

			for (var fruit of result) {
				var trItem = "<tr>";
				trItem += "<td>" + fruit.id + "</td>";
				trItem += "<td>" + fruit.name + "</td>";
				trItem += "<td>" + fruit.type + "</td>";
				trItem += "<td>" + fruit.price + "</td>";
				trItem += "<td>" + fruit.countprice + "</td>";
				trItem += "<td><input onclick=\"deletebyid("+fruit.id+")\" type=\"button\" value=\"삭제\"></td>";
				trItem += "</tr>";

				$("#body_id").append(trItem);
			}
			
		}).fail( (error)=> {
			
		})
		
	}

	function countpriceDesc(){
		$.ajax({
			url:"/fruitstore/fruit?cmd=countpriceProc",
			type:"get",//방식
			dataType:"json",//받는타입
			contentType: "Application/x-www-urlencoded; charset=utf-8",//보내는타입	
		}).done( (result)=> {
			$("#body_id").empty();

			for (var fruit of result) {
				var trItem = "<tr>";
				trItem += "<td>" + fruit.id + "</td>";
				trItem += "<td>" + fruit.name + "</td>";
				trItem += "<td>" + fruit.type + "</td>";
				trItem += "<td>" + fruit.price + "</td>";
				trItem += "<td>" + fruit.countprice + "</td>";
				trItem += "<td><input onclick=\"deletebyid("+fruit.id+")\" type=\"button\" value=\"삭제\"></td>";
				trItem += "</tr>";

				$("#body_id").append(trItem);
			}
			
		}).fail( (error)=> {
			
		})
		
	}
    
    function deletebyid(id){
    	
    	$.ajax({ 
     		type: "get", 
     		url: "/fruitstore/fruit?cmd=deleteProc&id="+id, 
    		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
     		dataType: "json" 
     	}).done(function(result){ 
    			alert("댓글 삭제 성공"); 
     			$("#body_id").empty(); 
    			for (var fruit of result) { 
     				var trItem = "<tr>"; 
    				trItem += "<td>" + fruit.id + "</td>"; 
     				trItem += "<td>" + fruit.name + "</td>"; 
     				trItem += "<td>" + fruit.type + "</td>"; 
     				trItem += "<td>" + fruit.price + "</td>"; 
     				trItem += "<td>" + fruit.countprice + "</td>"; 
     				trItem += "<td><input onclick=\"deletebyid("+fruit.id+")\" type=\"button\" value=\"삭제\"></td>"; 
     				trItem += "</tr>"; 

     				$("#body_id").append(trItem); 
    			}
     	}).fail(function(error){ 
    		alert("실패");
     	}); 
     } 
</script>
</body>
</html>