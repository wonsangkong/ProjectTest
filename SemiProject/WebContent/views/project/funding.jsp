<%@page import="com.mvc.project.model.vo.projectFunding"%>
<%@page import="com.mvc.project.model.vo.CarryProject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	projectFunding funding = (projectFunding)session.getAttribute("funding");
	
%>
<%@ include file="/views/common/header.jsp" %>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/projectWrite.css">
</head>

<body>	
	<section>
		
	<div id="pUploadImg">
	    <img src="<%=request.getContextPath() %>/resources/uploadSystem.png" alt="">
    </div>
    
    <h1>프로젝트 후원하기</h1>
        <div id="pUploadContainer">
            <form name="pUploadJoinFrm" id="pUploadJoinFrm" action="<%=request.getContextPath() %>/project/updatefund" method="post">
                <table>
                    <p>해당 내역 확인 후 확인을 누르시면 후원이 진행됩니다.</p>
                    <tr>
	                    <th>로그인 ID</th>
                            <td>
                                <input type="text" name="userId" id="pOpenName" value="<%= loginMember.getUserId() %>" readonly>
                            </td>
                    </tr>
                    <tr>
                        <th>이름</th>
                            <td>
                                <input type="text" name="writer" id="openEmail" value="<%= loginMember.getUserName() %>" readonly>
                            </td>
                    </tr>
                    <tr>
                        <th>펀딩 금액</th>
                            <td>
                                <input type="text" name="fundingPrice" id="openPhoneNum" value="<%= funding.getFundingPrice() %>" readonly>
                            </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input type="test" name="userNo" id="openBasicAddress" value="<%= funding.getFundingUser() %>"><br>
                            <input type="test" name="projectNo" id="openBasicAddress" value="<%= funding.getFundingProject()%>"><br>
                        </td>
                    </tr>
 					
                    </table>
                    <br><br><br>
                    
                    <div id="projectButton">
                        <input type="submit" id="projectSubmit"  value="확인">
                        <input type="reset" value="취소">
                    </div>
                </form>
            </div>
</section>	

<%@ include file="/views/common/footer.jsp" %>	
