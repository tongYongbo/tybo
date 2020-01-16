package com.wn.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wn.beans.GoodsType;
import com.wn.tools.ConnectionManager;

public class GoodsTypeDao {
	public void addType(GoodsType t) {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into goods_type(type_code,type_name)values(?,?)");
			ps.setString(1, t.getType_code());
			ps.setString(2, t.getType_name());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);

		}

	}

	public void delTypeById(int typeId) {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from goods_type where type_id=?");
			ps.setInt(1, typeId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}

	public List<GoodsType> getGoodsTypeById(int typeId) {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		List<GoodsType> l = new ArrayList<GoodsType>();
		try {
			PreparedStatement prs = conn.prepareStatement("select * from goods_type where type_id= ?");
			prs.setInt(1, typeId);
			ResultSet rs = prs.executeQuery();
			if (rs.next()) {
				String type_code = rs.getString("type_code");
				String type_name = rs.getString("type_name");
				GoodsType gt = new GoodsType(typeId, type_code, type_name);
				l.add(gt);
			} else {
				System.out.println("您查询的信息不存在，请确认后再输入");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		return l;
	}

	public List<GoodsType> show() {
		Connection conn = null;
		conn = ConnectionManager.getConnection();
		List<GoodsType> l = new ArrayList<GoodsType>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from goods_type");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int type_id = rs.getInt("type_id");
				String type_code = rs.getString("type_code");
				String type_name = rs.getString("type_name");
				GoodsType gt = new GoodsType(type_id, type_code, type_name);
				l.add(gt);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);

		}
		return l;
	}

	public void updateType(GoodsType gt) {

		Connection conn = null;
		conn = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("update goods_type set type_code=?,type_name= ?where type_id= ?");
			ps.setInt(3, gt.getType_id()); 
			ps.setString(1, gt.getType_code());
			ps.setString(2, gt.getType_name());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
	}
}
