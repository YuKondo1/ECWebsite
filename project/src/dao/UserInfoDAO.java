package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import base.DBManager;
import base.Helper;
import beans.UserInfoBeans;

public class UserInfoDAO {


	/**
	 * ユーザー情報登録
	 * @param uib
	 * @throws SQLException
	 */
	public static void insertUser(UserInfoBeans uib) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("INSERT INTO u_info(login_id, name, password, phone, postal_code, address, create_date) VALUES(?,?,?,?,?,?,?)");
			st.setString(1, uib.getLoginId());
			st.setString(2, uib.getName());
			st.setString(3, uib.getPassword());
			st.setString(4, uib.getPhone());
			st.setString(5, uib.getPostalCode());
			st.setString(6, uib.getAddress());
			st.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
			System.out.println("insertUser completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
	/**ログインIDとパスワードが一致したらidを返す
	 * 一致しない場合、０を返す*/
	public static int getUserId(String loginId, String password) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("SELECT * FROM t_user WHERE login_id = ?");
			st.setString(1, loginId);
			ResultSet rs = st.executeQuery();
			int userId = 0;
			while (rs.next()) {
				if (Helper.getSha256(password).equals(rs.getString("login_password"))) {
					userId = rs.getInt("id");
					System.out.println("login succeeded");
					break;
				}
			}
			System.out.println("getUserId completed");
			return userId;
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
	 * ユーザー情報更新
	 * @param uib
	 * @throws SQLException
	 */
	public static void updateUser(UserInfoBeans uib) throws SQLException {
		UserInfoBeans updatedUib = new UserInfoBeans();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement("UPDATE u_info SET ligin_id = ?, name = ?, password = ?, phone = ?, postal_code = ?, address = ? WHERE id=?;");
			st.setString(1, uib.getLoginId());
			st.setString(2, uib.getName());
			st.setString(3, uib.getPassword());
			st.setString(4, uib.getPhone());
			st.setString(5, uib.getPostalCode());
			st.setString(6, uib.getAddress());
			st.executeUpdate();
			System.out.println("updateUser completed");

			st = con.prepareStatement("SELECT login_id, name, password, phone, postal_code, address FROM u_info WHERE id=" + uib.getId());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				updatedUib.setLoginId(rs.getString("login_id"));
				updatedUib.setName(rs.getString("name"));
				updatedUib.setPassword(rs.getString("password"));
				updatedUib.setPhone(rs.getString("phone"));
				updatedUib.setPostalCode(rs.getString("postal_code"));
				updatedUib.setAddress(rs.getString("address"));
			}
			st.close();
			System.out.println("searching updated-UserInfoBeans completed");
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
	 * 　login_idの重複チェック
	 * @param loginId
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public static boolean isOverlapLoginId(String loginId, int userId) throws SQLException {
		// 重複しているかどうか表す変数
		boolean isOverlap = false;
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DBManager.getConnection();
			// 入力されたlogin_idが存在するか調べる
			st = con.prepareStatement("SELECT login_id FROM u_info WHERE login_id = ? AND id != ?");
			st.setString(1, loginId);
			st.setInt(2, userId);
			ResultSet rs = st.executeQuery();

			System.out.println("searching loginId by inputLoginId has been completed");

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

}
