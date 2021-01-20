<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>

<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/projectwriteagree.css">
</head>

<body>
	<!-- 1.20 승현 프로젝트 올리기 전 동의 부분 화면구성 -->
	<section>
	<form id="writeagreefrm" action="" method="">
		<div id="full1">
	        <div>
	            <img src="<%= request.getContextPath() %>/resources/BCP1.PNG" id="BCP1" width="950px">
	        </div>
	        <div id="msg1">
	            <h2>프로젝트를 올리기 전에 확인해 주세요.</h2>
	        </div>
	        <div id="msg2">
	            캐리펀딩은 검토절차를 통해 창작자님이 작성한 프로젝트가 캐리펀딩의 정책을 준수하는지 검토하고 있습니다. <br>
	            아래 사항들을 확인 후 프로젝트를 올려주세요.
	        </div>
	        <table>
	            <tr>
	                <td id="check1"><input type="checkbox" id="checkBox1" name="checkBox1"></td>
	                <td id="text1"><div id="checkdiv1">이미 시판된 제품, 현금이나 지분등의 수익제공, 단순 기부 등의 기준에 맞지 않는 선물을 제공하지 않습니다.</div></td>
	            </tr>
	            <tr>
	                <td id="check1"><input type="checkbox" id="checkBox2" name="checkBox2"></td>
	                <td id="text1"><div id="checkdiv2">창작자의 신분증 혹은 사업자등록증, 은행 계좌, 연락 가능한 번호가 있습니다.</div></td>
	            </tr>
	        </table>
	
	        <input type="button" value="계속하기" class="submitCheck" id="submitbtn" onclick="location.href=('<%= request.getContextPath() %>/project/projectWrite');">
	        <input type="button" value="뒤로하기" id="submitbtn" onclick="location.replace('<%= request.getContextPath()%>');">
	        
	        <!-- 수정 필요.... -->
	        <script>
			$(".submitCheck").on("click", () => {
			
				if(($("input:checkbox[name=checkBox1]:checked").length == 0) && ($("input:checkbox[name=checkBox2]:checked").length == 0)){
				
				
				alert("체크 후 전송해주세요.~~");
				
				return false;
				
				}
		
			})
	</script>
    	</div>
    </form>
	</section>
	

	
<%@ include file="/views/common/footer.jsp" %>