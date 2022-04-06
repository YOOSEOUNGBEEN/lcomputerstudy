package com.lcomputerstudy.testmvc.vo;

public class Board {

	private int b_idx;
	private String b_title;
	private String b_contents;
	private String b_count;
	private String b_writer;
	private String b_date;
	

	/** 원글 번호  == b_group**/
	private int b_group;
	
	/** 원글에 대한 순서 == b_order**/
	private int b_order;
	
	/** 답글계층 == b_order**/
	private int b_depth;
	
	/** ---------------------------------------------------------**/
	
	public int getB_group() {
		return b_group;
	}
	public void setB_group(int b_group) {
		this.b_group = b_group;
	}
	
	public int getB_order() {
		return b_order;
	}
	public void setB_order(int b_order) {
		this.b_order = b_order;
	}
	
	public int getB_depth() {
		return b_depth;
	}
	public void setB_depth(int b_depth) {
		this.b_depth = b_depth;
	}
	
	/** ---------------------------------------------------------**/
	
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_contents() {
		return b_contents;
	}
	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}
	public String getB_count() {
		return b_count;
	}
	public void setB_count(String b_count) {
		this.b_count = b_count;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
}
