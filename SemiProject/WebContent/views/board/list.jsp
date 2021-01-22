
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/board.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
    <section id="content">
        <br><br><br><br>
        <h2 align="center"> * 커뮤니티 공간 * </h2>
        <div id="board-container">
	
    <%if(loginMember != null) {%>
        <button type="button" id="btn-add"
        onclick="location.href ='<%=request.getContextPath() %>/board/write'">글쓰기</button>
    <%}%>
            <table id="tbl-board" >
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>첨부파일</th>
                    <th>조회수</th>
                </tr>

                <tr>
                    <td colspan="6">
                        조회된 게시글이 없습니다.
                    </td>
                </tr>	

                </tr>		
               
            </table>
            <div id="pageBar">
                <button onclick="location.href=''">&lt;&lt;</button>

                <button>&lt;</button>

                <button disabled>1</button>
                <button onclick="location.href=''">2</button>
                <button onclick="location.href=''">3</button>
                <button>4</button>
                <button>5</button>
                <button>6</button>
                <button>7</button>
                <button>8</button>
                <button>9</button>
                <button>10</button>

                <button >&gt;</button>

                <button>&gt;&gt;</button>
            </div>
        </div>
    </section>

<%@ include file="/views/common/footer.jsp" %>
