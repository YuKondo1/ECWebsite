package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.ItemBeans;
import beans.UserFavoriteBeans;

public class UserFavoriteDAO {


	/**
	 * お気に入り登録
	 * @param ufb
	 * @throws SQLException
	 */
	public static void insertUserFavorite(int userId, int itemId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO u_favorite(u_id, item_id) VALUES(?,?)");
			st.setInt(1, userId);
			st.setInt(2, itemId);
			st.executeUpdate();
			System.out.println("insertUserFavorite completed");
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
	 * u_idからお気に入り商品情報を取得
	 * @param targetId
	 * @return
	 */
	public static ArrayList<UserFavoriteBeans> getFavoriteItemById(int targetUserId) {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<UserFavoriteBeans> favoriteList = new ArrayList<UserFavoriteBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM u_favorite WHERE u_id = ?");
			st.setInt(1, targetUserId);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				UserFavoriteBeans ufb = new UserFavoriteBeans();
				ufb.setId(rs.getInt("id"));
				ufb.setUserId(rs.getInt("u_id"));
				ufb.setItemId(rs.getInt("item_id"));
				favoriteList.add(ufb);
			}
			System.out.println("getFavoriteItemById completed");
			return favoriteList;
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
	 * u_idからお気に入り商品を取得
	 * @param targetUserId
	 * @return
	 */
	public static ArrayList<ItemBeans> getAllItemByUserId(int targetUserId) {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<ItemBeans> itemList = new ArrayList<ItemBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT item.*, u_favorite.* FROM item INNER JOIN u_favorite ON item.id = u_favorite.item_id WHERE u_id = ?");
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
}
