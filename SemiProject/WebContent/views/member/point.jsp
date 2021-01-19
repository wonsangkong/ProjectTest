<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

	 <section>
            <p>포인트 충전</p>
            <div id="pointInfo">
                <p>
                    저희 carry funding에서는 포인트 충전 후 현금처럼 사용이 가능합니다. <br>
                    원하시는 충전 금액을 선택해 주세요!
                </p>
            
                <form name="choosePoint" action="" > 
                    <label for="point1"><input type="radio" id="point1" name="point" value="10000"> 10,000point</label>
                    <label for="point2"><input type="radio" id="point2" name="point" value="30000"> 30,000point</label>
                    <label for="point3"><input type="radio" id="point3" name="point" value="50000"> 50,000point</label><br>
                    <label for="point4"><input type="radio" id="point4" name="point" value="100000">100,000point</label>
                    <label for="point5"><input type="radio" id="point5" name="point" value="200000">200,000point</label>
                    <label for="point6"><input type="radio" id="point6" name="point" value="300000">300,000point</label>
                </form>
                <form name="paymentInformation" action="">
                    <div id="paymentInfo">
                        <p>
                            입금할 은행 선택 : 
                            <select name="Bank" id="selectBank">
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
                </form>
        </section>

<%@ include file="/views/common/footer.jsp" %>