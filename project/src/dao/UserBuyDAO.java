package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import base.DBManager;
import beans.UserBuyBeans;

public class UserBuyDAO {


	/**
	 * 購入情報登録
	 * @param ubb
	 * @return autoIncKey
	 * @throws SQLException
	 */
	public static int insertBuy(UserBuyBeans ubb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO u_buy(user_id, total_price, create_date) VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, ubb.getUserId());
			st.setInt(2, ubb.getTotalPrice());
			st.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			System.out.println("insertBuy completed");
			return autoIncKey;
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
	 * 全購入情報を取得
	 * @return
	 */
	public ArrayList<UserBuyBeans> getAllUserBuy() {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<UserBuyBeans> userBuyList = new ArrayList<UserBuyBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM u_buy");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				UserBuyBeans userBuy = new UserBuyBeans();
				userBuy.setId(rs.getInt("id"));
				userBuy.setUserId(rs.getInt("user_id"));
				userBuy.setTotalPrice(rs.getInt("total_price"));
				userBuy.setCreateDate(rs.getDate("create_date"));
				userBuyList.add(userBuy);
			}
			System.out.println("getAllItem completed");
			return userBuyList;
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
	 * user_idから購入情報を取得
	 * @param targetId
	 * @return userBuy
	 */
	public UserBuyBeans getUserBuyById(int targetUserId) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM u_buy WHERE user_id = ?");
			st.setInt(1, targetUserId);
			ResultSet rs = st.executeQuery();
			UserBuyBeans userBuy = new UserBuyBeans();
			if (rs.next()) {
				userBuy.setId(rs.getInt("id"));
				userBuy.setUserId(rs.getInt("user_id"));
				userBuy.setTotalPrice(rs.getInt("total_price"));
				userBuy.setCreateDate(rs.getDate("create_date"));
			}
			System.out.println("getItemById completed");
			return userBuy;
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
