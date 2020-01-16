package com.wn.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.wn.beans.GoodsType;
import com.wn.daos.GoodsTypeDao;

public class TypeView {
	Scanner input = new Scanner(System.in);

	public void addTypes() {
		System.out.println("������ ���ͱ��");
		String typeCode = input.next();
		System.out.println("������ ��������");
		String typeName = input.next();
		GoodsType gt = new GoodsType(0, typeCode, typeName);
		new GoodsTypeDao().addType(gt);
	}

	public void delTypes() {
		System.out.println("������ Ҫɾ��������ID");
		int typeId = input.nextInt();
		if (!new GoodsTypeDao().getGoodsTypeById(typeId).equals("����ѯ����Ϣ�����ڣ���ȷ�Ϻ�������")) {
			// new GoodsTypeDao().delTypeById(typeId);
			System.out.println("ɾ���ɹ�");
		} else {
			System.out.println("ɾ��ʧ��");
		}
	}

	public void getTypeById() {
		System.out.println("������ Ҫ��ѯ������ID");
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
		System.out.println("������Ҫ�޸ĵ�id");
		int typeId = input.nextInt();
		System.out.println("�������޸ĺ��code");
		String typeCode = input.next();
		System.out.println("�������޸ĺ��name");
		String typeName = input.next();
		GoodsType gt = new GoodsType(typeId, typeCode, typeName);
		new GoodsTypeDao().updateType(gt);	
		System.out.println("�޸ĳɹ�");
	}

	public static void main(String[] args) {
		new TypeView().delTypes();
	}
}
