<%@page import="com.mvc.project.model.vo.CarryProject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

<%
	List<CarryProject> list = (ArrayList)request.getAttribute("list");
%>    

         <section>

            <div id="content_2">
                <div id="protitle1">
                    <hr id="hr1">
                        <h3>성공 임박 프로젝트</h3>
                    <hr id="hr2">
                </div>
                <% if(list.isEmpty()) { %>
                <form class="prodform">
                    <div class="prod" id="prod1"><img src="resources/logo.PNG" alt=""></div>
                    <p>조회된 프로젝트가 없습니다.</p>
                    <p>달성률(%)</p>
                </form>
                <% } else {
                   for(CarryProject project : list) {%>
                 
                <form class="prodform">
                    <div class="prod" id="prod1"><img src="resources/logo.PNG" alt=""></div>
                    <p><a href="<%= request.getContextPath() %>/project/view?projectNo=<%= project.getProjectNo()%>">
						<%= project.getProjectTitle() %>
					</a></p>
                    <p>달성률(
                    <% float i = project.getReachAmount();
                       float j = project.getTargetAmount();%>
                    <%= i/j*100 %> %)</p>
                </form>
                <%	}
                } %>
                
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
                <form class="prodform">
                    <div class="prod" id="prod4"><img src="resources/logo.PNG" alt=""></div>
                    <p>프로젝트명</p>
                    <p>달성률(%)</p>
                </form>
                <form class="prodform">
                    <div class="prod" id="prod4"><img src="resources/logo.PNG" alt=""></div>
                    <p>프로젝트명</p>
                    <p>달성률(%)</p>
                </form>
                <form class="prodform">
                    <div class="prod" id="prod4"><img src="resources/logo.PNG" alt=""></div>
                    <p>프로젝트명</p>
                    <p>달성률(%)</p>
                </form>
                <form class="prodform">
                    <div class="prod" id="prod4"><img src="resources/logo.PNG" alt=""></div>
                    <p>프로젝트명</p>
                    <p>달성률(%)</p>
                </form>
                <form class="prodform">
                    <div class="prod" id="prod4"><img src="resources/logo.PNG" alt=""></div>
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
