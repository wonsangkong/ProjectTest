
<!-- 1/20 원상 새로 추가한 JSP -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호변경</title>
<style>
    div#changePassword-container{
        background:silver;
       
    }
    div#changePassword-container table {
        margin:0 auto;
        border-spacing: 20px;
    }
    div#changePassword-container table tr:last-of-type td {
        text-align:center;
    }
    
    
</style>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
</head>
<body>
	<div id="changePassword-container">
		<form action="<%=request.getContextPath() %>/member/changePwd" method="post">
			<table>
				<tr>
					<th style="font-weight: lighter; color:white;">변경할 비밀번호</th>
					<td>
						<input type="password" name="userPwd" id="pass1" required>
					</td>
				</tr>
				<tr>
					<th style="font-weight:lighter; color:white;">비밀번호확인</th>
					<td>
						<input type="password" id="pass2">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="변경" onclick="return validate();" style="border-radius: 20px; background-color: black; color:white; border-color:black">
						&nbsp;
						<input type="button" value="닫기" onclick="self.close();" style="border-radius: 20px; background-color: black; color:white; border-color: black">
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
</body>
</html>












