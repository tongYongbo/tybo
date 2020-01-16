package com.wn.beans;

import java.util.Date;

public class Goods {

	private int goods_id;
	private String goods_code;
	private String goods_name;
	private Date goods_date;
	private Float goods_price;
	private String goods_quality;
	private int type_id;
	private int sup_id;

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(String goods_code, String goods_name, Date goods_date, Float goods_price, String goods_quality,
			int type_id, int sup_id) {
		super();
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.goods_date = goods_date;
		this.goods_price = goods_price;
		this.goods_quality = goods_quality;
		this.type_id = type_id;
		this.sup_id = sup_id;
	}

	public Goods(int goods_id, String goods_code, String goods_name, Date goods_date, Float goods_price,
			String goods_quality, int type_id, int sup_id) {
		super();
		this.goods_id = goods_id;
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.goods_date = goods_date;
		this.goods_price = goods_price;
		this.goods_quality = goods_quality;
		this.type_id = type_id;
		this.sup_id = sup_id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_code() {
		return goods_code;
	}

	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public Date getGoods_date() {
		return goods_date;
	}

	public void setGoods_date(Date goods_date) {
		this.goods_date = goods_date;
	}

	public Float getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(Float goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_quality() {
		return goods_quality;
	}

	public void setGoods_quality(String goods_quality) {
		this.goods_quality = goods_quality;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getSup_id() {
		return sup_id;
	}

	public void setSup_id(int sup_id) {
		this.sup_id = sup_id;
	}

	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", goods_code=" + goods_code + ", goods_name=" + goods_name
				+ ", goods_date=" + goods_date + ", goods_price=" + goods_price + ", goods_quality=" + goods_quality
				+ ", type_id=" + type_id + ", sup_id=" + sup_id + "]";
	}

}
