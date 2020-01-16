package com.wn.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.wn.beans.Goods;
import com.wn.daos.GoodsDao;

public class GoodsView {
	Scanner input = new Scanner(System.in);

	public void addGoods() {
		System.out.println("��������Ʒ����");
		String goodsCode = input.next();
		System.out.println("��������Ʒ����");
		String goodsName = input.next();

		System.out.println("��������Ʒ����ʱ��");
		String strDate = input.next();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		java.sql.Date goodsDate = null;
		try {
			date = sdf.parse(strDate);
			goodsDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("��������Ʒ�۸�");
		Float goodsPrice = input.nextFloat();
		System.out.println("��������Ʒ����");
		String goodsQuality = input.next();
		System.out.println("��������Ʒ���ͱ��");
		int goodsTypeid = input.nextInt();
		System.out.println("��������Ʒ��Ӧ�̱��");
		int goodssSupid = input.nextInt();
		Goods g = new Goods(goodsCode, goodsName, goodsDate, goodsPrice, goodsQuality, goodsTypeid, goodssSupid);
		new GoodsDao().addGood(g);
	}

	public void getGoodById() {
		System.err.println("������Id");
		int goodId = input.nextInt();
		new GoodsDao().getGoodById(goodId);
		List<Goods> l = new ArrayList<Goods>();
		l = new GoodsDao().getGoodById(goodId);
		for (Goods g : l) {
			System.out.println(g);
		}
	}

	public void updateGoodById() {
		System.err.println("������Ҫ�޸ĵ���ƷId");
		int goods_id = input.nextInt();
		System.out.println("�������޸ĺ���Ʒ����");
		String goodsCode = input.next();
		System.out.println("�������޸ĺ���Ʒ����");
		String goodsName = input.next();

		System.out.println("�������޸ĺ���Ʒ����ʱ��");
		String strDate = input.next();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		java.sql.Date goodsDate = null;
		try {
			date = sdf.parse(strDate);
			goodsDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�������޸ĺ���Ʒ�۸�");
		Float goodsPrice = input.nextFloat();
		System.out.println("�������޸ĺ���Ʒ����");
		String goodsQuality = input.next();
		System.out.println("�������޸ĺ���Ʒ���ͱ��");
		int goodsTypeid = input.nextInt();
		System.out.println("�������޸ĺ���Ʒ��Ӧ�̱��");
		int goodssSupid = input.nextInt();
		Goods g = new Goods(goods_id, goodsCode, goodsName, goodsDate, goodsPrice, goodsQuality, goodsTypeid,
				goodssSupid);
		new GoodsDao().updateGood(g);
	}

	public static void main(String[] args) {
		new GoodsView().updateGoodById();
	}
}
