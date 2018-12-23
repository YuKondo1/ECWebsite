package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.NewsBeans;

public class NewsDAO {


	/**
	 * newsから全情報取得
	 * @return
	 */
	public static ArrayList<NewsBeans> getAllNews() {
		Connection conn = null;
		PreparedStatement st = null;
		ArrayList<NewsBeans> newsList = new ArrayList<NewsBeans>();
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM news");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				NewsBeans news = new NewsBeans();
				news.setId(rs.getInt("id"));
				news.setCreateDate(rs.getDate("create_date"));
				news.setInfo(rs.getString("info"));
				newsList.add(news);
			}
			System.out.println("getAllNews completed");
			return newsList;
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
