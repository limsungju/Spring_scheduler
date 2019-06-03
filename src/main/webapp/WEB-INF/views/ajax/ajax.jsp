<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function ajaxTest() {
		var name01 = document.getElementById("name").value;
		var age01 = $("#age").val();
		var form={ name:name01, age:age01 };
		$.ajax({
			//url : "ajax",
			//url : "ajax_result",
			//url : "ajax_result01",
			url : "ajax_json",
			//type : "GET",
			type : "POST",
			data : form,
			//data : $("#frm").serialize(),
			success : function(cnt) {
				$("#result").text(cnt.aaa+"=>"+cnt.bbb);
				//console.log("성공")
				},
			error : function() {	
				alert("문제가 발생 했습니다!!!")
				//console.log("실패")
				}
		});
	}
</script>
</head>
<body>
	<form id="frm">
		이름 : <input type="text" name="name" id="name"><br> 나이 : <input
			type="text" name="age" id="age"><br>
	</form>
	<button onclick="ajaxTest()">클릭해주세요</button>
	<!-- 
	<h1>일</h1><h1>이</h1><h1>삼</h1>
	<h1>사</h1><h1>오</h1><h1>육</h1>
	<button onclick="ajaxTest()">클릭해주세요</button>
	 -->
	<label id="result"></label>

</body>
</html>






