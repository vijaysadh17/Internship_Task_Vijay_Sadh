package com.vj.NewsFeed;

public class News {

	private String title;
	private String details;
	private String img_path;

	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

	public News(String title, String details, String img_path) {
		super();

		this.title = title;
		this.details = details;
		this.img_path = img_path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", details=" + details + ", img_path=" + img_path + "]";
	}

}
