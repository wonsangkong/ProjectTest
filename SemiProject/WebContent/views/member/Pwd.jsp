<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- (은주) 1/20일 스크립트 추가 css추가 이미지 헤더부분추가 include 풋터 추가 -->
<%
	String script = (String)request.getAttribute("script");
	String location = (String)request.getAttribute("location");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호변경</title>
<style>
   .wa {
        width: 1000px; 
        height: 800px;
        margin: auto;
    }

    #na {
        text-align: center;
        margin-left: 30px;
    }

    div#updatePassword-container{
        background:grey;
    }
    div#updatePassword-container table {
        margin:0 auto;
        border-spacing: 40px;
    }
    div#updatePassword-container table tr:last-of-type td {
        text-align:center;
    }
        #ss {

    width: 80px;
    height: 33px;
    margin-top: 0px;
    float: right;
    margin-right: 20px;
    background-color: black;
    color: white;
    border-radius: 30px;
    border-color: black;
    }
</style>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
</head>
<body>
    <div class="wa">
        <header>
        <br><br><br><br><br><br>
            <div id="na">
    
                <a href="">
                 <img src="<%= request.getContextPath()%>/resources/logo.PNG" width="250px">
                </a>
            </div>
        </header>
        <br><br><br><br><br><br>
   <section>     
	<div id="updatePassword-container">
		<form action="<%=request.getContextPath() %>/member/Pwd" method="post">
			<table>
				<tr>
					<th>비밀번호 변경</th>
					<td>
						<input type="password" name="userPwd" id="pass1" required>
					</td>
				</tr>
				<tr>
					<th>비밀번호확인</th>
					<td>
						<input type="password" id="pass2">
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<!--(은주) 1/20일 닫기 , 변경부분 위치 변경  -->
						  <input type="button" value="닫기" id="ss" onclick="self.close();">
						&nbsp;
						<input type="submit" value="변경" id="ss" onclick="return validate();">
					</td>
				</tr>
			</table>
			<input	type="hidden" name="userId" value="<%=request.getParameter("userId") %>">	
		</form>
	</div>
	<script>
		function validate() {
			let pass1 = $("#pass1").val();
			let pass2 = $("#pass2").val();
			
			if(pass1.trim() != pass2.trim()){
				alert("비밀번호가 일치하지 않습니다.");
				$("#pass1").val("");
				$("#pass2").val("");
				$("#pass1").focus();
				
				return false;
			}
		}
	</script>
<%@ include file="/views/common/footer.jsp" %>