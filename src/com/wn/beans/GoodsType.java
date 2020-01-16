package com.wn.beans;

public class GoodsType {
	private int type_id;
	private String type_code;
	private String type_name;
	public GoodsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GoodsType(int type_id, String type_code, String type_name) {
		super();
		this.type_id = type_id;
		this.type_code = type_code;
		this.type_name = type_name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_code() {
		return type_code;
	}
	public void setType_code(String type_code) {
		this.type_code = type_code;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	@Override
	public String toString() {
		return "GoodsType [type_id=" + type_id + ", type_code=" + type_code + ", type_name=" + type_name + "]";
	}	
}
