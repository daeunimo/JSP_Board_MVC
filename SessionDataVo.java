package com.ja.board.model.vo;
//세션 정보 구성
public class SessionDataVo {
	private String sessionIdx;
	private String sessionNick;
	public SessionDataVo(String sessionIdx, String sessionNick) {
		super();
		this.sessionIdx = sessionIdx;
		this.sessionNick = sessionNick;
	}
	public String getSessionIdx() {
		return sessionIdx;
	}
	public void setSessionIdx(String sessionIdx) {
		this.sessionIdx = sessionIdx;
	}
	public String getSessionNick() {
		return sessionNick;
	}
	public void setSessionNick(String sessionNick) {
		this.sessionNick = sessionNick;
	}
	
	
	
	
	
}
