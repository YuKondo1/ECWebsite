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
	public static ArrayList<ItemBeans> getAllItem() {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item ORDER BY name ASC");
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
	public static ItemBeans getItemById(int targetId) {
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

	/**
	 * itemIdとidが一致する全商品情報を取得
	 * @param targetItemId
	 * @return
	 */
	public static ArrayList<ItemBeans> getAllItemById(int targetItemId) {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item WHERE id = ?");
			st.setInt(1, targetItemId);
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

	public static ArrayList<ItemBeans> getItemByItemName(String searchKeyWord) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			if (searchKeyWord.length() == 0) {
				// 全検索
				st = con.prepareStatement("SELECT * FROM item");
			} else {
				// 商品名検索
				st = con.prepareStatement("SELECT * FROM item WHERE name LIKE ?");
				st.setString(1, "%"+searchKeyWord+"%");
			}
			ResultSet rs = st.executeQuery();
			ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();
			while (rs.next()) {
				ItemBeans item = new ItemBeans();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPrice(rs.getInt("price"));
				item.setImage(rs.getString("image"));
				itemList.add(item);
			}
			System.out.println("getItemByItemName completed");
			return itemList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static void deleteItem(int id) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("DELETE FROM item WHERE id = ?;");
			st.setInt(1, id);
			st.executeUpdate();
			System.out.println("deleteItem completed");
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
