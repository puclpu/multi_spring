package com.multi.mvc40;

public class MusicVO {
	private int id;
	private String title;
	private String singer;
	private String genre;
	private String musicDate;
	private String img;
	private int hits;

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
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMusicDate() {
		return musicDate;
	}
	public void setMusicDate(String musicDate) {
		this.musicDate = musicDate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	@Override
	public String toString() {
		return "MusicVO [id=" + id + ", title=" + title + ", singer=" + singer + ", genre=" + genre + ", musicDate="
				+ musicDate + ", img=" + img + ", hits=" + hits + "]";
	}
	
	
}
