
<!-- 1/19 새로 추가한 회원정보 수정 관련 JSP 파일입니다. 그대로 추가해주세요. -->
<%@page import="com.mvc.member.model.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginMember = (Member)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/EditUserInformation.css">
</head>
<body>
	<section id="content">
            <div id="allcode">
                
                <div id="title1">
                    <h1>회원정보 수정</h1>
                </div>
                
                <hr id="hr1">

				<!-- ********** 1/20 원상 form/label 내 value 값 불러오는 것으로 변경 ********** -->
				
                <form id="signupForm" action="<%=request.getContextPath()%>/member/editUserInformation" method="post">
                    <label id="idLabel">아이디<input type="text" name="userId" id="newId" placeholder="(4글자이상)" value="<%= loginMember.getUserId() %>" readonly required>
                    <p></p><br>
                    
                    <label>이름<input type="text" name="userName" id="userName" value="<%= loginMember.getUserName() %>" readonly required><br></label>
                    <p></p><br>
            
                    <label>휴대폰번호<input type="text" name="phone" id="phone" placeholder="(-없이)01012349876" value="<%= loginMember.getPhone() %>" maxlength="11" required><br></label>
                    <p></p><br>
            
                    <label>이메일<input type="email" name="email" id="email" placeholder="abc@defg.com" value="<%= loginMember.getEmail() %>" required><br></label>
                    <p></p><br>
            
                    <label>주소<input type="text" name="address" id="address" value="<%= loginMember.getAddress() %>" required><br></label>
                    <p></p><br>
                
                <!-- ********** 1/20 원상 onclick 값 변경 ********** -->
                
                <div id="buttons">
                    <button type="button" onclick="changePwd();" style="margin-right: 10px; background-color: black; color: white; border-radius: 20px; border-color: black;" >비밀번호변경</button>
	                <input type="submit" value="정보수정" style="margin-right: 10px; background-color: black; color: white; border-radius: 20px; border-color: black;">
	                <input type="button" value="탈퇴" style=" background-color: black; color: white; border-radius: 20px; border-color: black;">
                </div>
                </form>
                <form name="checkIdForm">
                         <input type="hidden" name="userId">
                </form>
            </div>

		<!-- ********** 1/20 원상 스크립트 추가 ********** -->
        <script>
            function changePwd(){
 			
 			const url="<%=request.getContextPath()%>/member/changePwd?userId="+$("#newId").val();
 			const status="left=500px,top=200px,width=400px,height=210px";
 			
 			open(url,"",status);
 			
 		}
 		</script>
 		
        </section>
        
<%@ include file="/views/common/footer.jsp" %>
