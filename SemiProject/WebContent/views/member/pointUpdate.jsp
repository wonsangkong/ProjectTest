<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>
	<!-- 2021/01/21 이슬 upser_coin에 point를 update시키기 위한 과정 추가 수정필요!!-->
	 <section>
        <p>충전 확인</p>
            <form name="pointUpdate" action="<%= request.getContextPath()%>/member/pointUpdate" method="post">
                <table id="pointCheck">
                    <tr>
                        <td>충전할 포인트  </td>
                        <td><input type="text" vlaue="<%=payer.getPaymentAmount() %>" readonly> point</td>
                    </tr>
                    <tr>
                        <td>잔여 포인트  </td>
                        <td><input type="text" value="<%= loginMember.getUserCoin() %>" readonly> point</td>
                    </tr>
                    <tr>
       					<td><input type="hidden" name= "userNo" value="<%= loginMember.getUserNo() %>" ></td>
       					<td><input type="hidden" name= "payerNo" value="<%= payer.getPayerNo() %>" ></td>
                    </tr>
                </table>
                <input type="submit" name="pointUpdateButton" id="pointUpdateButton" value="확인">
            </form>
     </section>
 
<%@ include file="/views/common/footer.jsp" %>