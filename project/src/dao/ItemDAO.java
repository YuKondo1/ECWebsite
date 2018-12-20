package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.ItemBeans;

public class ItemDAO {

	/**
	 * 全商品情報を取得
	 * @return <ItemBeans>
	 */
	public ArrayList<ItemBeans> getAllItem() {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				ItemBeans item = new ItemBeans();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPrice(rs.getInt("price"));
				item.setImage(rs.getString("image"));
				itemList.add(item);
			}
			System.out.println("getAllItem completed");
			return itemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * idから商品情報を取得
	 * @param targetId
	 * @return ItemBeans
	 */
	public ItemBeans getItemById(int targetId) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item WHERE id = ?");
			st.setInt(1, targetId);
			ResultSet rs = st.executeQuery();
			ItemBeans item = new ItemBeans();
			if (rs.next()) {
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPrice(rs.getInt("price"));
				item.setImage(rs.getString("image"));
			}
			System.out.println("getItemById completed");
			return item;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 商品情報を登録
	 * @param ib
	 */
	public static void setItem(ItemBeans ib) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("INSERT INTO item(name, item_detail, price, image) VALUES(?,?,?,?)");
			st.setString(1, ib.getName());
			st.setString(2, ib.getItemDetail());
			st.setInt(3, ib.getPrice());
			st.setString(4, ib.getImage());
			st.executeUpdate();
			System.out.println("setItem completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
