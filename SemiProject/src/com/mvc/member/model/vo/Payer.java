package com.mvc.member.model.vo;

import java.sql.Date;

// 2021/01/20 이슬 결제자 정보 담을 payer.java생성
public class Payer {
	private int paymentNo;
	private int paymentAmount;
	private String bankName;
	private int accountNumber;
	private Date paymentDate;
	private Date canclePaymentDate;
	private String paymentProgress;
	private int payerNo;
	
	
	public Payer() {
	}


	public Payer(int paymentNo, int paymentAmount, String bankName, int accountNumber, Date paymentDate,
			Date canclePaymentDate, String paymentProgress, int payerNo) {
		super();
		this.paymentNo = paymentNo;
		this.paymentAmount = paymentAmount;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.paymentDate = paymentDate;
		this.canclePaymentDate = canclePaymentDate;
		this.paymentProgress = paymentProgress;
		this.payerNo = payerNo;
	}


	public int getPaymentNo() {
		return paymentNo;
	}


	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}


	public int getPaymentAmount() {
		return paymentAmount;
	}


	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Date getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}


	public Date getCanclePaymentDate() {
		return canclePaymentDate;
	}


	public void setCanclePaymentDate(Date canclePaymentDate) {
		this.canclePaymentDate = canclePaymentDate;
	}


	public String getPaymentProgress() {
		return paymentProgress;
	}


	public void setPaymentProgress(String paymentProgress) {
		this.paymentProgress = paymentProgress;
	}


	public int getPayerNo() {
		return payerNo;
	}


	public void setPayerNo(int payerNo) {
		this.payerNo = payerNo;
	}


	@Override
	public String toString() {
		return "Payer [paymentNo=" + paymentNo + ", paymentAmount=" + paymentAmount + ", bankName=" + bankName
				+ ", accountNumber=" + accountNumber + ", paymentDate=" + paymentDate + ", canclePaymentDate="
				+ canclePaymentDate + ", paymentProgress=" + paymentProgress + ", payerNo=" + payerNo + "]";
	}

}

