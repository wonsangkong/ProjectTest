<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/IdAndPwd.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
</head>
<body>
<div class="wa">
    <header>
        <div id="na">

            <a href="">
            <!--(은주 1/20일 이미지 코드변경 -->
                <img src="<%= request.getContextPath()%>/resources/logo.PNG" width="250px">
            </a>
        </div>
    </header>

    <p></p>
  
        <section>

            <div>
                <div>
                  <form action="<%= request.getContextPath()%>/member/Id" method="post">
                    <hr id="hr1">
                    <h1> ID ● PWD 찾기</h1>
                    <hr id="hr2">
                    <table>

                        <fieldset>
                            <legend>
                                <h2> ★ 아이디 찾기 ★ </h2>
                            </legend>

                            <label id="idLabel">이름<input type="text" name="userName" id="userName"
                                    placeholder=" 이름을 입력해주세요." required><br></label>
                            <p></p><br>

                            <label>휴대폰번호<input type="text" name="phone" id="phone" placeholder="  (-없이)01012349876"
                                    required><br></label>
                            <p></p><br>

                            <label>이메일<input type="email" name="email" id="email" placeholder=" abc@defg.com"
                                    required><br></label>
                            <p></p><br>
                        </fieldset>
                        <input type="submit" value="취소" id="submitbtn" onclick="Id();">
                        <input type="submit" value="확인" id="submitbtn" >

                    </table>
          		</form>
          		<script>
          			function Id(){
          				const url="<%= request.getContextPath()%>/member/Id";
          				
          				open(url,"");
          			}
          		</script>
                    <br><br><br><br><br><br>
                    <br><br><br><br><br><br>
                  </div>  

				<div>
				 <form action="<%= request.getContextPath()%>/member/Pwd" method="post">
                    <hr id="hr1">
                    <h1> ID ● PWD 찾기</h1>
                    <hr id="hr2">
                    <table>

                        <fieldset>
                            <legend>
                                <h2> ★ 비밀번호 찾기 ★ </h2>
                            </legend>

                            <label id="idLabel">아이디<input type="text" name="userId" id="userId"
                                    placeholder=" 아이디를 입력해주세요." required><br></label>
                            <p></p><br>
                            <label>이름<input type="text" name="userName" id="userName" placeholder=" 이름을 입력해주세요."
                                    required><br></label>
                            <p></p><br>

                            <label>휴대폰번호<input type="text" name="phone" id="phone" placeholder="  (-없이)01012349876"
                                    required><br></label>
                            <p></p><br>

                            <label>이메일<input type="email" name="email" id="email" placeholder=" abc@defg.com"
                                    required><br></label>
                            <p></p><br>
                        </fieldset>
                        <input type="submit" value="취소" id="submitbtn" onclick="Pwd"();>
                        <input type="submit" value="확인" id="submitbtn">

                    </table>
                 </form>
                 <script>
                 function Pwd(){
       				const url="<%= request.getContextPath()%>/member/Pwd?userId="+$("#userId").val();
       				const status="left=500px,top=200px,width=400px,height=210px";
       				open(url,"");
       			}
                 </script>
          	
			  </div>
        </section>
<%@ include file="/views/common/footer.jsp" %>