<%@page import="com.mvc.member.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc.member.model.dao.*"%>
<%@ page import="com.mvc.member.model.vo.*"%>
<%
	Member id = (Member)session.getAttribute("id");
	String name = request.getParameter("userName");
	String email = request.getParameter("Email");
	MemberService ms = new MemberService();
	String userId = null;
	if (id != null) { 
}
%>
    
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
<br><br>
	<section>
	<br><br>
     <form action="<%= request.getContextPath() %>/member/Id" method="post">
      <tr>
     <td>
      <% if (id != null) { %>
      <table width="550px" align=center border="0"
       style="color: black; font-size: 30px;">
       <tr align=center>
        <td style="height: 170px">* 회원님의 아이디를 찾았습니다! *</td>
       </tr>
       <tr align=center>
        <td style="font-size: 50px"><%=id.getUserId()%></td>
       </tr>
      </table> 
      <%} else { %>

      <table width="600px" align=center border="0"
       style="color: black; font-size: 30px;">
       <tr align= center>
        <td style="height: 170px">* 아이디를 찾지 못했습니다 * <br><br>
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