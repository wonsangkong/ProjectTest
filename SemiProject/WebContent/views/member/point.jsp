<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>
	 <section>
        <p>포인트 충전</p>
        	<!--2021/01/20 (이슬) section 밑으로 내용 전체적으로 감싸는 form 추가/ 내부에 두단락으로 나뉘었던 form태그 삭제 / 라디오버튼 name을 point에서 paymentAmount로 변경 / 은행명 select의 name을 bank에서 bankName으로 변경-->
            <form name="chargingPointFrm" action="<%= request.getContextPath()%>/member/point" method="POST">
                <div id="pointInfo">
                    <p>
                        저희 carry funding에서는 포인트 충전 후 현금처럼 사용이 가능합니다. <br>
                        원하시는 충전 금액을 선택해 주세요!
                    </p>
                    <!-- 1.23 승현 userNo 추가 -->
                    <input type="hidden" name="userNo" id="pOpenName" value="<%= loginMember.getUserNo() %>">
                   
                    <label for="point0"><input type="radio" id="point0" name="paymentAmount" value="10000"> 10,000point</label>
                    <label for="point1"><input type="radio" id="point1" name="paymentAmount" value="30000"> 30,000point</label>
                    <label for="point2"><input type="radio" id="point2" name="paymentAmount" value="50000"> 50,000point</label><br>
                    <label for="point3"><input type="radio" id="point3" name="paymentAmount" value="100000">100,000point</label>
                    <label for="point4"><input type="radio" id="point4" name="paymentAmount" value="200000">200,000point</label>
                    <label for="point5"><input type="radio" id="point5" name="paymentAmount" value="300000">300,000point</label>
                
                    <div id="paymentInfo">
                        <p>
                            입금할 은행 선택 : 
                            <select name="bankName" id="selectBank">
                                <option value="">은행선택</option>
                                <option value="국민">국민</option>
                                <option value="신한">신한</option>
                                <option value="우리">우리</option>
                                <option value="시티">시티</option>
                                <option value="카카오">카카오</option>
                                <option value="신협">신협</option>
                                <option value="농협">농협</option>
                            </select>
                        </p>
                        <p>
                            무통장 입금 계좌번호 입력 : 
                            <input type="text" name="accountNumber" id="accountNumber" placeholder="통장번호를 입력해주세요.">
                        </p>
                    </div>
                    <div id="chargingOrResetB">
                        <input type="submit" id="doChargingSubmit" value="충전하기" >
                        <input type="reset" value="취소하기">
                    </div>
                </div>
            </form>
        </section>
        
        <script>
        // 2021/01/21 (이슬) 전송 전 유효성검사 추가 / 충전금액, 은행, 계좌번호 입력 안하면 alert 뜨게 ./
        	$("#doChargingSubmit").on("click", () => {
        		let bankName = $("#selectBank").val();
        		let paymentAmount = $("input:radio[name=paymentAmount]:checked").length;
        		let accountNumber = $("#accountNumber").val().length;
        		
        		if(paymentAmount === 0) {
        			alert("충전금액을 선택하세요.")
	       			return false;	
	       		}
        		
        		if(bankName.length === 0) {
	        		alert("은행을 선택해주세요.");
	        		return false;
        		}
        		
        		if(accountNumber === 0) {
        			alert(" 올바른 계좌번호를 입력해주세요.")
        			return false;
        		}	
        	});
        </script>

<%@ include file="/views/common/footer.jsp" %>