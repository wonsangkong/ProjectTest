<!-- 1월 21일 원상 프로젝트 상세페이지 관련 JSP 추가 -->
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mvc.member.model.vo.Member"%>
<%@page import="com.mvc.project.model.vo.CarryProject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CarryProject project = (CarryProject)request.getAttribute("project");

// 1.24 승현 마감날짜 표현 형태 변환
	SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
	Date date = dt.parse(project.getProjectEnddate()); 
	String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);

%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/view.css">
<body>
    <div class="wrap">
		
        <section>
        	<form action="<%= request.getContextPath() %>/project/funding" method="post">
        	<input type="hidden" name="userNo" value="<%= loginMember.getUserNo()%>">
        	<input type="hidden" name="projectNo" value="<%= project.getProjectNo()%>">
            <div id="itemDetailPageContainer">
                <!-- 선택한 프로젝트의 카테고리명과 프로젝트명이 보이게 -->
                <!-- 카테고리명 삭제 --> 
                <div id="projectName"><%= project.getProjectTitle() %></div>
                
                <div id="projectContent_1">
                    <table>
                        <tr>
                            <td colspan="">
                                <img src="<%= request.getContextPath() %>/upload/proFile/<%= project.getImgRenamedName() %>">
                            </td>
                            <td>
                                <h3><%= newstring %> 마감예정</h3>
                                <p>달성률 : <%= project.getAttainmentPercent() %> %</p>
                                <p>모인 금액 : <%= project.getReachAmount() %> 원</p>
                                <p>목표 금액 : <%= project.getTargetAmount() %> 원</p>
                                <p></p>
                                <!-- <p>xx명 펀딩</p> -->
                                <input type="text" id="fundingPrice" name="fundingPrice" placeholder="펀딩할 금액 입력해주세요">
                                <input type="submit" id="doFundingButton" value="펀딩하기">
                                <input type="button" id="likeButton" value="&hearts;">
                            </td>
                    </table>
                </div>
                <div id="projectContent_2">
                    <div>
                    	<input type="button" class="inputTag" id="tag1" value="창작자와 소통하기">
                    </div>
                    <div>
                    	<input type="button" class="inputTag" id="tag1" value="캐리하는 게시판">
                    </div>
                </div>
                <div id="productInfo" style="text-align: center; position: absolute; margin-top: 100px; margin-left: 85px; width:26%;" >
                	<span>&nbsp;&nbsp;&nbsp;* 제품 설명 *&nbsp;&nbsp;&nbsp;</span>
                	<p> 
                	<br>              	
                		<%= project.getProjectContent() %>
                	<br>
                	<br>	
                	</p>
                	<br>
                	<p>업체명 : <%= project.getProjectCompany() %></p>
                	<input type="text">
                </div>
                <div id="projectContent_3">
                    <p>리워드 선택</p>
                    <div id="reward_1">
                        <a href="">
                            <p><span>1,000원+</span><br>리워드는 받지않고 펀딩합니다.</p>
                        </a>
                    </div>
                    <div id="reward_2">
                        <a href="">
                            <p>
                                <span>00,000원+</span><br>
                                배송비 포함<br>
                                -제품 상세내역
                            </p>
                        </a>
                    </div>
                    <div id="reward_3">
                        <a href="">
                            <p>
                                <span>00,000원+</span><br>
                                배송비 포함<br>
                                -제품 상세내역
                            </p>
                        </a>
                    </div>
                </div>
            </div>
            </form>
        </section>
	</div>
<%@ include file="/views/common/footer.jsp" %>