<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
         <section>
         
         <!-- ***** 1월 22일 원상 메인 화면 구성 변경 ***** -->
         
            <div>
                <a href="<%=request.getContextPath()%>/project/list">
                    <img src="<%=request.getContextPath() %>/img/main1.jpg" id="main-rolling" width="1000px" style="margin-top:30px">
                </a>
            </div>
            
            <div>
                <a href="<%= request.getContextPath() %>/project/projectwriteagree">
                    <img src="<%=request.getContextPath() %>/img/main2.jpg" id="main-rolling" width="1000px" style="margin-top:30px">
                </a>
            </div>

            <div id="content_3">
                <div id="protitle2">
                    <hr id="hr3">
                        <h3>인기 프로젝트</h3>
                    <hr id="hr4">
                </div>
                <form class="prodform">
                    <div class="prod" id="prod1"><img src="resources/logo.PNG" alt=""></div>
                    <p>프로젝트명</p>
                    <p>달성률(%)</p>
                </form>
                <form class="prodform">
                    <div class="prod" id="prod2"><img src="resources/logo.PNG" alt=""></div>
                    <p>프로젝트명</p>
                    <p>달성률(%)</p>
                </form>
                <form class="prodform">
                    <div class="prod" id="prod3"><img src="resources/logo.PNG" alt=""></div>
                    <p>프로젝트명</p>
                    <p>달성률(%)</p>
                </form>
                <form class="prodform">
                    <div class="prod" id="prod4"><img src="resources/logo.PNG" alt=""></div>
                    <p>프로젝트명</p>
                    <p>달성률(%)</p>
                </form>
            </div>
        
        </section>

<%@ include file="/views/common/footer.jsp" %>