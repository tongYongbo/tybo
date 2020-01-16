package com.wn.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wn.beans.Goods;
import com.wn.beans.GoodsType;
import com.wn.tools.ConnectionManager;

public class GoodsDao {

	public void addGood(Goods g) {

		// private int goods_id;
		// private String goods_code;
		// private String goods_name;
		// private Date goods_date;
		// private Float goods_price;
		// private String goods_quality;
		// private int type_id;
		// private int sup_id;
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"insert into goods(goods_code,goods_name,goods_date,goods_price,goods_quality,type_id,sup_id)values(?,?,?,?,?,?,?)");
			ps.setString(1, g.getGoods_code());
			ps.setString(2, g.getGoods_name());
			ps.setDate(3, new java.sql.Date(g.getGoods_date().getTime()));
			ps.setFloat(4, g.getGoods_price());
			ps.setString(5, g.getGoods_quality());
			ps.setInt(6, g.getType_id());
			ps.setInt(7, g.getSup_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	public List<Goods> getGoodById(int goodId) {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		List<Goods> l = new ArrayList<Goods>();

		try {
			PreparedStatement prs = conn.prepareStatement("select * from goods where goods_id= ?");
			prs.setInt(1, goodId);
			ResultSet rs = prs.executeQuery();
			while (rs.next()) {
				String goods_code = rs.getString("goods_code");
				String goods_name = rs.getString("goods_name");

				Date goods_date = rs.getTimestamp("goods_date");

				Float goods_price = rs.getFloat("goods_price");
				String goods_quality = rs.getString("goods_quality");
				int type_id = rs.getInt("type_id");
				int sup_id = rs.getInt("sup_id");

				Goods g = new Goods(goodId, goods_code, goods_name, goods_date, goods_price, goods_quality, type_id,
						sup_id);
				l.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		return l;
	}

	public void updateGood(Goods g) {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update goods set goods_code=?,goods_name=?,goods_date=?,goods_price=?,goods_quality=?,type_id=?,sup_id=? where goods_id =?");
			ps.setString(1, g.getGoods_code());
			ps.setString(2, g.getGoods_name());
			ps.setDate(3, new java.sql.Date(g.getGoods_date().getTime()));
			ps.setFloat(4, g.getGoods_price());
			ps.setString(5, g.getGoods_quality());
			ps.setInt(6, g.getType_id());
			ps.setInt(7, g.getSup_id());
			ps.setInt(8, g.getGoods_id());
			ps.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		
	}
}
