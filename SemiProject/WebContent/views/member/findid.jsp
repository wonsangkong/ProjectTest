<%@page import="com.mvc.member.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc.member.model.dao.*"%>
<%@ page import="com.mvc.member.model.vo.*"%>
<%
	Member member = (Member)session.getAttribute("member");
	String name = request.getParameter("userName");
	String email = request.getParameter("Email");
	MemberService ms = new MemberService();
	String userId = null;
	if (member != null) { 
}
%>
  
<%@ include file="/views/common/header.jsp" %>
 <style>
 	@font-face {
    font-family: 'InkLipquid';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/InkLipquid.woff') format('woff');
    font-weight: normal;
    font-style: normal;
	}
	@font-face { 
		font-family: 'BinggraeSamanco-Bold'; 
		src: url('https://github.com/projectnoonnu/noonfonts_20-10/blob/main/BinggraeSamanco-Bold.woff') format('woff'); 
		font-weight: normal; 
		font-style: normal; 
	}
	#ic{
		font-family: 'InkLipquid';
		font-size: 30px; 
	}
	#ic_1{
		font-family: 'BinggraeSamanco-Bold';
		font-size: 50px; 
	}
</style>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
<br><br>
	<section>
	<br><br>
      <tr>
     <td>
      <% if (member != null) { %>
      <table width="550px" align=center border="0"
       style="color: black; font-size: 30px;">
       <tr align=center>
        <td id="ic" style="height: 170px">* 회원님의 아이디를 찾았습니다! *</td>
       </tr>
       <tr align=center>
        <td id="ic_1"><%=member.getUserId()%></td>
       </tr>
      </table> 
      <%} else { %>

      <table width="600px" align=center border="0"
       style="color: black; font-size: 30px;">
       <tr align= center>
        <td id="ic" style="height: 170px">* 아이디를 찾지 못했습니다 * <br><br>
        (회원이 아니시면 회원가입해 주세요.^^)
        </td>
       </tr>

       <tr align=center>
        <td><input style="margin-top: 50px;  margin-right: 20px;background-color: black;
            color: white; border-radius: 30px; border-color: black;" type="button" value="돌아가기"
         onClick="history.back()"></td>
       </tr>
 		</table>
 		<%} %>
 		</form>
     </section>
 

<%@ include file="/views/common/footer.jsp" %>