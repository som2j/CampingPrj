<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta id="_csrf" name="_csrf" content="${_csrf.token}"></meta>
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"></meta>
</head>
<body>
	<div>
	<h1>일정 추가하기</h1>
	<form id="form">
	일정 이름 <input type="text" name="title" id="title" maxlength="20"><br><br>
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
	
	let token = document.querySelector("meta[name='_csrf']").content;
    let header = document.querySelector("meta[name='_csrf_header']").content;
    
    let data = {title : title.value};

    async function PostTest(){
        let response = await fetch("http://localhost:8080/schedule/addTodo",{
            method : 'post',
            headers: {
                'header': header,
                'X-CSRF-Token': token,
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        }).then((result)=>{
            return result;
        } )
        console.dir(response);
    }

    form.addEventListener('submit',PostTest);
    
</script>

</html>