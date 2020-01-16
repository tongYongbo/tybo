package com.wn.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.wn.beans.GoodsType;
import com.wn.daos.GoodsTypeDao;

public class TypeView {
	Scanner input = new Scanner(System.in);

	public void addTypes() {
		System.out.println("请输入 类型编号");
		String typeCode = input.next();
		System.out.println("请输入 类型名称");
		String typeName = input.next();
		GoodsType gt = new GoodsType(0, typeCode, typeName);
		new GoodsTypeDao().addType(gt);
	}

	public void delTypes() {
		System.out.println("请输入 要删除的类型ID");
		int typeId = input.nextInt();
		if (!new GoodsTypeDao().getGoodsTypeById(typeId).equals("您查询的信息不存在，请确认后再输入")) {
			// new GoodsTypeDao().delTypeById(typeId);
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	public void getTypeById() {
		System.out.println("请输入 要查询的类型ID");
		int typeId = input.nextInt();
		new GoodsTypeDao().getGoodsTypeById(typeId);
		List<GoodsType> l = new ArrayList<GoodsType>();
		l = new GoodsTypeDao().getGoodsTypeById(typeId);
		for (GoodsType g : l) {
			System.out.println(g);
		}
	}

	public void show() {
		List<GoodsType> l = new ArrayList<GoodsType>();
		l = new GoodsTypeDao().show();
		for (GoodsType g : l) {
			System.out.println(g);
		}
	}

	public void updateType() {
		System.out.println("请输入要修改的id");
		int typeId = input.nextInt();
		System.out.println("请输入修改后的code");
		String typeCode = input.next();
		System.out.println("请输入修改后的name");
		String typeName = input.next();
		GoodsType gt = new GoodsType(typeId, typeCode, typeName);
		new GoodsTypeDao().updateType(gt);	
		System.out.println("修改成功");
	}

	public static void main(String[] args) {
		new TypeView().delTypes();
	}
}
