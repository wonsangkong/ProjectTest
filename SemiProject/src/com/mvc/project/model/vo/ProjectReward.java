package com.mvc.project.model.vo;

// 1.21 승현 리워드 클래스 추가 -> 현재 실행과는 연관x
public class ProjectReward {
	private int rewardNo;
	private String rewardName;
	private int rewardPrice;
	private int proNo;
	
	public ProjectReward() {
	}

	public ProjectReward(int rewardNo, String rewardName, int rewardPrice, int proNo) {
		this.rewardNo = rewardNo;
		this.rewardName = rewardName;
		this.rewardPrice = rewardPrice;
		this.proNo = proNo;
	}

	public int getRewardNo() {
		return rewardNo;
	}

	public void setRewardNo(int rewardNo) {
		this.rewardNo = rewardNo;
	}

	public String getRewardName() {
		return rewardName;
	}

	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}

	public int getRewardPrice() {
		return rewardPrice;
	}

	public void setRewardPrice(int rewardPrice) {
		this.rewardPrice = rewardPrice;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	@Override
	public String toString() {
		return "ProjectReward [rewardNo=" + rewardNo + ", rewardName=" + rewardName + ", rewardPrice=" + rewardPrice
				+ ", proNo=" + proNo + "]";
	}
	
	
}
