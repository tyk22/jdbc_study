package com.gn.study.model.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectVo {
	private int projectId; // 번호
	private String projectName; // 프로젝트명
	private int projectManager; // FK(employee의 emp_id) > 관리자 사번
	private LocalDateTime regDate; // 등록일
	private LocalDateTime modDate; // 수정일
	private String managerName; // 괸리자 이름
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public ProjectVo() {
	}
	public ProjectVo(int projectId, String projectName, int projectManager) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
	}
	
	public ProjectVo(int projectId, String projectName, int projectManager, LocalDateTime regDate,
			LocalDateTime modDate) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectManager = projectManager;
		this.regDate = regDate;
		this.modDate = modDate;
	}
	
	public LocalDateTime getModDate() {
		return modDate;
	}
	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(int projectManager) {
		this.projectManager = projectManager;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtft = DateTimeFormatter.ofPattern("yy-MM-dd(E)");
		return "[번호 : " + projectId 
				+ ", 이름 : " + projectName 
				+ ", 관리자 : "+ managerName + "("+projectManager +")"
				+ ", 등록일 : " + regDate.format(dtft) 
				+ ", 수정일 : " + modDate.format(dtft) + "]";
	}
	
	

}
