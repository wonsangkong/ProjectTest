<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.mvc.project.model.vo.CarryProject"%>

<%@ include file="/views/common/header.jsp" %>
<%
	CarryProject project = (CarryProject)request.getAttribute("project");
%>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/projectWrite.css">
</head>

<body>	
	<section>
		
	<div id="pUploadImg">
	    <img src="<%=request.getContextPath() %>/resources/uploadSystem.png" alt="">
    </div>
    
    <h1>프로젝트 리워드 등록하기</h1>
        <div id="pUploadContainer">
            <form name="pUploadJoinFrm" id="pUploadJoinFrm" action="" method="post">
                <table>
                    <p>모든 항목을 입력하세요.</p>
                    <tr>
	                    <th>개설자ID</th>
                            <td>
                                <input type="text" name="writer" id="pOpenName" value="<%= loginMember.getUserId() %>" readonly>
                            </td>
                    </tr>
                    <tr>
                        <th>리워드 이름</th>
                            <td>
                                <input type="text" name="rewardName" id="openEmail" required>
                            </td>
                    </tr>
                    <tr>
                        <th>리워드 가격</th>
                            <td>
                                <input type="text" name="rewardPrice" id="openPhoneNum" required>
                            </td>
                    </tr>
                    <tr>
                        <th>프로젝트 번호</th>
                        <td>
                            <input type="text" name="proNo" id="openBasicAddress" value="" readonly><br>
                        </td>
                    </tr>
 
                    </table>
                    <div id="projectButton">
                        <input type="submit" id="projectSubmit"  value="추가하기">
                        <input type="reset" value="취소">
                        <input type="button" id="endwriteBtn" value="작성종료">
                    </div>
                </form>
            </div>
</section>	

<%@ include file="/views/common/footer.jsp" %>	
