package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.ItemBeans;
import beans.UserBuyDetailBeans;

public class UserBuyDetailDAO {


	/**
	 * 購入情報詳細を登録
	 * @param ubdb
	 * @throws SQLException
	 */
	public static void insertUserBuyDetail(int buyId, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO u_buy_detail(buy_id,item_id) VALUES(?,?)");
			st.setInt(1, buyId);
			st.setInt(2, itemId);
			st.executeUpdate();
			System.out.println("insertUserBuyDetail completed");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * buy_idから購入情報詳細を取得
	 * @param targetBuyId
	 * @return userBuyDetail
	 */
	public UserBuyDetailBeans getUserBuyDetailByBuyId(int targetBuyId) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM u_buy_detail WHERE buy_id = ?");
			st.setInt(1, targetBuyId);
			ResultSet rs = st.executeQuery();
			UserBuyDetailBeans userBuyDetail = new UserBuyDetailBeans();
			if (rs.next()) {
				userBuyDetail.setId(rs.getInt("id"));
				userBuyDetail.setBuyId(rs.getInt("buy_id"));
				userBuyDetail.setItemId(rs.getInt("item_id"));
			}
			System.out.println("getUserBuyDetailByBuyId completed");
			return userBuyDetail;
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

	public static ArrayList<ItemBeans> getUserBuyDetailsByBuyId(int targetBuyId) {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT item.*, u_buy_detail.* FROM item INNER JOIN u_buy_detail ON item.id = u_buy_detail.item_id WHERE u_buy_detail.buy_id = ?");
			st.setInt(1, targetBuyId);
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
			System.out.println("getUserBuyDetailsByBuyId completed");
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
}
