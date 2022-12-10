package com.multi.mvc40;

public class MysongVO {
	private int id;
	private String memberid;
	private int musicid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public int getMusicid() {
		return musicid;
	}
	public void setMusicid(int musicid) {
		this.musicid = musicid;
	}
	@Override
	public String toString() {
		return "MysongVO [id=" + id + ", memberid=" + memberid + ", musicid=" + musicid + "]";
	}
	
	
}
