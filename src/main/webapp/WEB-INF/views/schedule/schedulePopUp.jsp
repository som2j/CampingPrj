<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<h1>일정 추가하기</h1>
	<form action="/camp/schedule/addTodo" method="post">
	일정 이름 <input type="text" name="title" maxlength="20"><br><br>
	시작 날짜 <input type="date" name="dateStart" ><br><br>
	종료 날짜 <input type="date" name="dateEnd" ><br><br>
	Allday	  <input type="checkbox" onClick="check(this)" name="allDay" ><br><br>
	<div id="timeBox">
	시작 시간 <input type="time" name="timeStart" maxlength="20"><br><br>
	</div>	
	
			<input type="submit" value="확인" ><br><br>
	</form>
	</div>
</body>

<script>
	function check(obj){
		if(obj.checked)
			document.getElementById('timeBox').style.display='none';
		else
			document.getElementById('timeBox').style.display='block';
	}
</script>

</html>