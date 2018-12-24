package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import base.DBManager;
import beans.BrowsingHistoryBeans;
import beans.ItemBeans;

public class BrowsingHistoryDAO {

	/**
	 * 閲覧履歴を登録
	 * @param userId
	 * @param bId
	 * @throws SQLException
	 */
	public static void insertBrowsingHistory(int userId, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO b_history(u_id, i_id, create_date) VALUES(?,?,?)");
			st.setInt(1, userId);
			st.setInt(2, itemId);
			st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
			System.out.println("insertBrowsingHistory completed");
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
	 * 全閲覧履歴取得
	 * @return
	 */
	public static ArrayList<BrowsingHistoryBeans> getAllBrowsingHistory() {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<BrowsingHistoryBeans> bHList = new ArrayList<BrowsingHistoryBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM b_history");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				BrowsingHistoryBeans bhb = new BrowsingHistoryBeans();
				bhb.setId(rs.getInt("id"));
				bhb.setUserId(rs.getInt("u_id"));
				bhb.setItemId(rs.getInt("i_id"));
				bhb.setCreateDate(rs.getDate("create_date"));
				bHList.add(bhb);
			}
			System.out.println("getAllBrowsingHistory completed");
			return bHList;
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
	 * UserIdより閲覧履歴取得
	 * @param targetUserId
	 * @return
	 */
	public static ArrayList<ItemBeans> getAllItemByUserId(int targetUserId) {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT distinct item.*, b_history.* FROM item INNER JOIN b_history ON item.id = b_history.i_id WHERE u_id = ? ORDER BY create_date DESC LIMIT 12");
			st.setInt(1, targetUserId);
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

	public static boolean isOverlapItemId(int userId, int itemId) throws SQLException {
		// 重複しているかどうか表す変数
		boolean isOverlap = false;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT i_id FROM b_history WHERE u_id = ? and i_id = ?;");
			st.setInt(1, userId);
			st.setInt(2, itemId);
			ResultSet rs = st.executeQuery();

			System.out.println("searching loginId by inputItemId has been completed");

			if (rs.next()) {
				isOverlap = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
		System.out.println("overlap check has been completed");
		return isOverlap;
	}

	public static void updateBrowsingHistory(int userId, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("UPDATE b_history SET create_date = ? WHERE u_id = ? and i_id = ?;");
			st.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			st.setInt(2, userId);
			st.setInt(3, itemId);
			st.executeUpdate();
			System.out.println("updateBrowsingHistory completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
