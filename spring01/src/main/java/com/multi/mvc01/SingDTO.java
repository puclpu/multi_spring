package com.multi.mvc01;

public class SingDTO {
	private int id;
	private String title;
	private String singer;
	private String writer;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "SingDTO [id=" + id + ", title=" + title + ", singer=" + singer + ", writer=" + writer + "]";
	}
}
