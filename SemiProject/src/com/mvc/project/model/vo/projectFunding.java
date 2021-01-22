package com.mvc.project.model.vo;

public class projectFunding {
	private int fundingNo;
	private int fundingPrice;
	private String fundingStatus;
	private int fundingUser;
	private int fundingProject;
	
	public projectFunding() {
	}

	public projectFunding(int fundingNo, int fundingPrice, String fundingStatus, int fundingUser, int fundingProject) {
		this.fundingNo = fundingNo;
		this.fundingPrice = fundingPrice;
		this.fundingStatus = fundingStatus;
		this.fundingUser = fundingUser;
		this.fundingProject = fundingProject;
	}

	public int getFundingNo() {
		return fundingNo;
	}

	public void setFundingNo(int fundingNo) {
		this.fundingNo = fundingNo;
	}

	public int getFundingPrice() {
		return fundingPrice;
	}

	public void setFundingPrice(int fundingPrice) {
		this.fundingPrice = fundingPrice;
	}

	public String getFundingStatus() {
		return fundingStatus;
	}

	public void setFundingStatus(String fundingStatus) {
		this.fundingStatus = fundingStatus;
	}

	public int getFundingUser() {
		return fundingUser;
	}

	public void setFundingUser(int fundingUser) {
		this.fundingUser = fundingUser;
	}

	public int getFundingProject() {
		return fundingProject;
	}

	public void setFundingProject(int fundingProject) {
		this.fundingProject = fundingProject;
	}

	@Override
	public String toString() {
		return "projectFunding [fundingNo=" + fundingNo + ", fundingPrice=" + fundingPrice + ", fundingStatus="
				+ fundingStatus + ", fundingUser=" + fundingUser + ", fundingProject=" + fundingProject + "]";
	}
	
}
