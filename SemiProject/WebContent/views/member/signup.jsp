<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/signup.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
</head>
<body>

<div id="allcode">
    <div id="title1">
        <h1>회원가입</h1>
    </div>

    <div id="first">
        <label id="info1">* 모든 항목을 입력해주세요. </label>
        <hr id="hr1">
    </div>
    
	<!--
	 
		1. form 태그 내 id 수정,
		2. 아이디 input id 'userId' -> 'newId' 로 변경,
		3. 중복검사 id 'checkDuplicate' 추가,
		4. 비밀번호 및 비밀번호 확인 name 변경,
		5. 회원가입 버튼 내 onclick 함수 추가,
		6. 회원가입 버튼 바로 밑 form 내 input 'hidden' 추가
		
	-->    

    <form action="<%= request.getContextPath()%>/member/signup" method="post">
        <label id="idLabel">아이디<input type="text" name="userId" id="newId" placeholder="(4글자이상)" required>
        <input type="button" value="중복검사" id="checkDuplicate"><br></label>
        <p></p><br>
		<label>비밀번호<input type="password" name="userPwd" id="userPwd1" required><br>
        <label class="hint">영문자, 숫자, 특수문자(!@#$%...)를 조합한 8자 이상</label></label>
        <p></p><br>
        
        <label>비밀번호 확인<input type="password" name="userPwdCheck" id="userPwd2" required><br></label>
        <p></p><br>
        
        <label>이름<input type="text" name="userName" id="userName" required><br></label>
        <p></p><br>

        <label>휴대폰번호<input type="text" name="phone" id="phone" placeholder="(-없이)01012349876" maxlength="11" required><br>
        <label class="hint">숫자만 입력해주세요.</label></label>
        <p></p><br>

        <label>이메일<input type="email" name="email" id="email" placeholder="abc@defg.com" required><br></label>
        <p></p><br>

        <label>주소<input type="text" name="address" id="address" required><br></label>
        <p></p><br>

        <input type="submit" value="회원가입" id="submitbtn" onclick="validate();">
    </form>
    <form name="checkIdForm">
	 		<input type="hidden" name="userId">
	</form>
</div>

	<!-- 
		script 내에 function blur 처리한 비밀번호 정규식 추가.
		근데 script 안에 이 주석 쓰면 왜 작동이 안되죠? 촤암나~
	-->

<script>

	$("#userPwd2").blur((e) => {
		let pwd1 = $("#userPwd1").val();
    	let pwd2 = $(e.target).val();

    	if(!(/(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/.test(pwd1))) {
        	alert('유효한 비밀번호를 입력하세요.');
        	$("#userPwd1").val("");
    		$(e.target).val("");
    		$("#userPwd1").focus();
        	
    	}
	});

	$(document).ready(() => {
		$("#userPwd2").blur((e) => {
        	let pwd1 = $("#userPwd1").val();
        	let pwd2 = $(e.target).val();
        	
        	if(pwd1.trim() != pwd2.trim()){
        		alert("비밀번호가 일치하지 않습니다.");
        		$("#userPwd1").val("");
        		$(e.target).val("");
        		$("#userPwd1").focus();
        	}
        	
		});  
        	
      
        $("#checkDuplicate").on("click", () => {
       
            let id = $("#newId").val().trim();
          
            if(id.length < 4) {
        	    alert("아이디는 최소 4글자 이상 입력하셔야 합니다.");
        	  
        	    return;
            }
          
            const url = "<%= request.getContextPath() %>/member/checkId";
            const title = "duplicate";
            const status = "left=500px, top=100px, width=300px, height=200px";
          
            open("", title, status);
            
            checkIdForm.target = title;
            checkIdForm.action = url;
            checkIdForm.method = "post";
            checkIdForm.userId.value = id;
          
            checkIdForm.submit();
         })
    });

</script>

<%@ include file="/views/common/footer.jsp" %>


