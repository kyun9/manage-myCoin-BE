package com.mng.mycoin.domain;

public class User {

	private Long userSeq;
	private String userId;
	
	public User(Long userSeq, String userId) {
		super();
		this.userSeq = userSeq;
		this.userId = userId;
	}
	
	public Long getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(Long userSeq) {
		this.userSeq = userSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [userSeq=" + userSeq + ", userId=" + userId + "]";
	}

}