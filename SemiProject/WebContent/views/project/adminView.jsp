
<!-- 1월 22일 원상 신규 JSP 파일 생성 -->

<%@page import="com.mvc.member.model.vo.Member"%>
<%@page import="com.mvc.project.model.vo.CarryProject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CarryProject project = (CarryProject)request.getAttribute("project");
%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/view.css">
<body>
    <div class="wrap">

        <section>
            <div id="itemDetailPageContainer">
                <!-- 선택한 프로젝트의 카테고리명과 프로젝트명이 보이게 -->
                <!-- 카테고리명 삭제 --> 
                <div id="projectName">프로젝트명</div>
                
            	<div style="float:right; margin-top:60px; margin-right:53px;">
            		<input type="button" value="승인"  onclick="confirmProject()" style="margin-right:10px; background-color: black; color: white; border-radius: 20px; border-color: black;">	
            		<input type="button" value="삭제"  onclick="deleteProject();" style="background-color: black; color: white; border-radius: 20px; border-color: black;">	
            	</div>
                
                <div id="projectContent_1">
                    <table>
                        <tr>
                            <td colspan="">
                                <img src="resources/logo.PNG" alt="">
                            </td>
                            <td>
                                <h1>XX일 남음</h1>
                                <p>xx%달성</p>
                                <p>000,000,000원 펀딩</p>
                                <p>xx명 펀딩</p>
                                <input type="button" id="doFundingButton" value="펀딩하기">
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
                		정말 예쁜 가방입니다.<br><br>
                		무조건 사셔야 하는 핫템입니다 !<br><br><br><br><br><br><br>
                		안 사면 밤에 잡으러 갑니다잉~~
                	</p>
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
            
            <script>
            	function deleteProject(){
     			
     				if(confirm("정말로 프로젝트를 삭제하시겠습니까?")){
     					location.replace('<%=request.getContextPath()%>/project/delete?projectNo=<%=project.getProjectNo()%>');
     				}
     			}    
            	
            	function confirmProject(){
         			
     				if(confirm("이 프로젝트를 승인처리 하시겠습니까?")){
     					location.replace('<%=request.getContextPath()%>/project/confirm?projectNo=<%=project.getProjectNo()%>');
     				}
     			}   
            </script>
            
        </section>
	</div>
<%@ include file="/views/common/footer.jsp" %>