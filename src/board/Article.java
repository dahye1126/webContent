package board;

import java.sql.Date;

public class Article {
	private int num;
	private String writer;
	private String title;
	private String content;
	private Date w_date;
	
	public Article() {} //default 생성자 쓰던안쓰던 꼭 넣을것
	public Article(int num, String writer, String title, String content, Date w_date) {
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.w_date = w_date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getW_date() {
		return w_date;
	}

	public void setW_date(Date w_date) {
		this.w_date = w_date;
	}

	@Override
	public String toString() {
		return "Article [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", w_date="
				+ w_date + "]";
	}
	
	
	
	
}
