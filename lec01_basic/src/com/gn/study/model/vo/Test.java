package com.gn.study.model.vo;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Test {
	private int tsetNo;
	private String tsetName;
	private LocalDateTime testDate;
	
	public Test() {
		
	}

	public Test(int tsetNo, String tsetName, LocalDateTime testDate) {
		super();
		this.tsetNo = tsetNo;
		this.tsetName = tsetName;
		this.testDate = testDate;
	}

	public int getTsetNo() {
		return tsetNo;
	}

	public void setTsetNo(int tsetNo) {
		this.tsetNo = tsetNo;
	}

	public String getTsetName() {
		return tsetName;
	}

	public void setTsetName(String tsetName) {
		this.tsetName = tsetName;
	}

	public LocalDateTime getTestDate() {
		return testDate;
	}

	public void setTestDate(LocalDateTime testDate) {
		this.testDate = testDate;
	}
	
	@Override
	public String toString() {
		return "번호:"+tsetNo+",이름"+tsetName+",등록일:"+testDate;
	}
	
	
}
