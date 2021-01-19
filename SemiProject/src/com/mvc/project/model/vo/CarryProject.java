package com.mvc.project.model.vo;

import java.sql.Date;

public class CarryProject {
	// 1.19 수정사항 rowNum, AttainmentPercent 추가
	private int projectNo;
	private int rowNum;
	private String projectTitle;
	private String userId;
	private String projectCompany;
	private int targetAmount;
	private int reachAmount;
	private int AttainmentPercent;
	private Date projectEnrolldate;
	private Date projectModifydate;
	private Date projectEnddate;
	private String imgOriginalName;
	private String imgRenamedName;
	private String projectContent;
	private String projectCheck;
	private int projectCount;
	private int projectLike;
	private String projectStatus;
	private int createNo;
	
	public CarryProject() {
	}

	public CarryProject(int projectNo, int rowNum, String projectTitle, String userId, String projectCompany,
			int targetAmount, int reachAmount, int attainmentPercent, Date projectEnrolldate, Date projectModifydate,
			Date projectEnddate, String imgOriginalName, String imgRenamedName, String projectContent,
			String projectCheck, int projectCount, int projectLike, String projectStatus, int createNo) {
		this.projectNo = projectNo;
		this.rowNum = rowNum;
		this.projectTitle = projectTitle;
		this.userId = userId;
		this.projectCompany = projectCompany;
		this.targetAmount = targetAmount;
		this.reachAmount = reachAmount;
		AttainmentPercent = attainmentPercent;
		this.projectEnrolldate = projectEnrolldate;
		this.projectModifydate = projectModifydate;
		this.projectEnddate = projectEnddate;
		this.imgOriginalName = imgOriginalName;
		this.imgRenamedName = imgRenamedName;
		this.projectContent = projectContent;
		this.projectCheck = projectCheck;
		this.projectCount = projectCount;
		this.projectLike = projectLike;
		this.projectStatus = projectStatus;
		this.createNo = createNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProjectCompany() {
		return projectCompany;
	}

	public void setProjectCompany(String projectCompany) {
		this.projectCompany = projectCompany;
	}

	public int getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}

	public int getReachAmount() {
		return reachAmount;
	}

	public void setReachAmount(int reachAmount) {
		this.reachAmount = reachAmount;
	}

	public int getAttainmentPercent() {
		return AttainmentPercent;
	}

	public void setAttainmentPercent(int attainmentPercent) {
		AttainmentPercent = attainmentPercent;
	}

	public Date getProjectEnrolldate() {
		return projectEnrolldate;
	}

	public void setProjectEnrolldate(Date projectEnrolldate) {
		this.projectEnrolldate = projectEnrolldate;
	}

	public Date getProjectModifydate() {
		return projectModifydate;
	}

	public void setProjectModifydate(Date projectModifydate) {
		this.projectModifydate = projectModifydate;
	}

	public Date getProjectEnddate() {
		return projectEnddate;
	}

	public void setProjectEnddate(Date projectEnddate) {
		this.projectEnddate = projectEnddate;
	}

	public String getImgOriginalName() {
		return imgOriginalName;
	}

	public void setImgOriginalName(String imgOriginalName) {
		this.imgOriginalName = imgOriginalName;
	}

	public String getImgRenamedName() {
		return imgRenamedName;
	}

	public void setImgRenamedName(String imgRenamedName) {
		this.imgRenamedName = imgRenamedName;
	}

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public String getProjectCheck() {
		return projectCheck;
	}

	public void setProjectCheck(String projectCheck) {
		this.projectCheck = projectCheck;
	}

	public int getProjectCount() {
		return projectCount;
	}

	public void setProjectCount(int projectCount) {
		this.projectCount = projectCount;
	}

	public int getProjectLike() {
		return projectLike;
	}

	public void setProjectLike(int projectLike) {
		this.projectLike = projectLike;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public int getCreateNo() {
		return createNo;
	}

	public void setCreateNo(int createNo) {
		this.createNo = createNo;
	}

	@Override
	public String toString() {
		return "CarryProject [projectNo=" + projectNo + ", rowNum=" + rowNum + ", projectTitle=" + projectTitle
				+ ", userId=" + userId + ", projectCompany=" + projectCompany + ", targetAmount=" + targetAmount
				+ ", reachAmount=" + reachAmount + ", AttainmentPercent=" + AttainmentPercent + ", projectEnrolldate="
				+ projectEnrolldate + ", projectModifydate=" + projectModifydate + ", projectEnddate=" + projectEnddate
				+ ", imgOriginalName=" + imgOriginalName + ", imgRenamedName=" + imgRenamedName + ", projectContent="
				+ projectContent + ", projectCheck=" + projectCheck + ", projectCount=" + projectCount
				+ ", projectLike=" + projectLike + ", projectStatus=" + projectStatus + ", createNo=" + createNo + "]";
	}
	
	
}
