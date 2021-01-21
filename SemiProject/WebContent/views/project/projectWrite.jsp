<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/views/common/header.jsp" %>

<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/projectWrite.css">
</head>

<body>
<section>
	<div id="pUploadImg">
	    <img src="<%=request.getContextPath() %>/resources/uploadSystem.png" alt="">
    </div>
    <h1>프로젝트 신청하기</h1>
        <div id="pUploadContainer">
            <form name="pUploadJoinFrm" id="pUploadJoinFrm" action="<%= request.getContextPath() %>/project/projectWrite" method="post" enctype="multipart/form-data">
                <table>
                    <p>모든 항목을 입력하세요.</p>
                    <tr>
	                    <th>개설자ID</th>
                            <td>
                                <input type="text" name="writer" id="pOpenName" value="<%= loginMember.getUserId() %>" readonly>
                            </td>
                    </tr>
                    <!-- <tr>
                        <th>이메일</th>
                            <td>
                                <input type="email" name="openEmail" id="openEmail" placeholder="abc@abc.com" required>
                            </td>
                    </tr>
                    <tr>
                        <th>휴대폰번호</th>
                            <td>
                                <input type="number" name="openPhoneNum" id="openPhoneNum" placeholder="숫자만 입력하세요." required>
                            </td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                            <input type="text" name="openBasicAddress" id="openBasicAddress" placeholder="주소" required><br>
                        </td>
                    </tr> -->
                    <tr>
                        <th>업체명</th>
                        <td>
                            <input type="text" name="company" id="openHomeUrl" placeholder="업체명">
                        </td>
                    </tr>
                <!--     </table>
                </form>
                <form name="pUploadDetailFrm" id="pUploadDetailFrm" action="">
                    <table> 
                        <p>*모든 항목을 입력해주세요.</p> -->
                        <tr>
                            <th>프로젝트명</th>
                            <td><input type="text" name="title" id="projectName"></td>
                        </tr>
                        <tr>
                            <th>목표 펀딩 금액</th>
                            <td><input type="text" name="targetAmount" id="fundingAmount" placeholder="000,000,000" required></td>
                        </tr>
                        <tr>
                            <th>프로젝트 개시일 (yyMMdd)형태로 입력하시오</th>
                            <td><input type="text" name="projectEnrolldate" class="" id="startDate" required></td>
                        </tr>
                        <tr>
                            <th>프로젝트 마감일 (yyMMdd)형태로 입력하시오</th>
                            <td><input type="text" name="projectEndDate" class="" id="endDate" required></td>
                        </tr>
                        <tr>
                            <th>파일 업로드</th>
                            <td>
                                <input type="file" name="upfile" class="product" required><br>
                            </td>
                        </tr>
                        <tr>
                        	<th>프로젝트 상세내용</th>
                            <td>
                                <textarea name="projectContent" id="addItemNameList" cols="20" rows="7"></textarea>
                            </td>
                        </tr>
                    </table>
                    <div id="projectButton">
                        <input type="submit" id="projectSubmit"  value="신청하기" >
                        <input type="reset" value="취소">
                    </div>
                </form>
            </div>
</section>	

<%@ include file="/views/common/footer.jsp" %>