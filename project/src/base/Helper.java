package base;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import beans.ItemBeans;

public class Helper {
	//閲覧履歴
	public static final String BROWSING_HISTORY_PAGE = "/WEB-INF/jsp/browsingHistory.jsp";
	//購入
	public static final String BUY_PAGE = "/WEB-INF/jsp/buy.jsp";
	//購入確認
	public static final String BUY_CONFIRM_PAGE = "/WEB-INF/jsp/buyConfirm.jsp";
	//購入履歴
	public static final String BUY_HISTORY_PAGE = "/WEB-INF/jsp/buyHistory.jsp";
	//購入履歴詳細
	public static final String BUY_HISTORY_DETAIL_PAGE = "/WEB-INF/jsp/buyHistoryDetail.jsp";
	//購入結果
	public static final String BUY_RESULT_PAGE = "/WEB-INF/jsp/buyResult.jsp";
	//買い物かご
	public static final String CART_PAGE = "/WEB-INF/jsp/cart.jsp";
	//エラーページ
	public static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";
	//TOPページ
	public static final String INDEX_PAGE = "/WEB-INF/jsp/index.jsp";
	//商品詳細
	public static final String ITEM_DETAIL_PAGE = "/WEB-INF/jsp/itemDetail.jsp";
	//ログイン
	public static final String LOGIN_PAGE = "/WEB-INF/jsp/login.jsp";
	//検索結果
	public static final String SEARCH_RESULT_PAGE = "/WEB-INF/jsp/searchResult.jsp";
	//マイページ
	public static final String USER_PAGE = "/WEB-INF/jsp/user.jsp";
	//ユーザー情報削除確認
	public static final String USER_DELETE_PAGE = "/WEB-INF/jsp/userDelete.jsp";
	//ユーザー情報削除結果
	public static final String USER_DELETE_RESULT_PAGE = "/WEB-INF/jsp/userDeleteResult.jsp";
	//お気に入り
	public static final String USER_FAVORITE_PAGE = "/WEB-INF/jsp/userFavorite.jsp";
	//ユーザー情報新規登録
	public static final String USER_REGISTER_PAGE = "/WEB-INF/jsp/userRegister.jsp";
	//ユーザー情報新規登録確認
	public static final String USER_REGISTER_CONFIRM_PAGE = "/WEB-INF/jsp/userRegisterConfirm.jsp";
	//ユーザー情報新規登録結果
	public static final String USER_REGISTER_RESULT_PAGE = "/WEB-INF/jsp/userRegisterResult.jsp";
	//ユーザー情報更新
	public static final String USER_UPDATE_PAGE = "/WEB-INF/jsp/userUpdate.jsp";
	//ユーザー情報更新確認
	public static final String USER_UPDATE_CONFIRM_PAGE = "/WEB-INF/jsp/userUpdateConfirm.jsp";
	//ユーザー情報更新結果
	public static final String USER_UPDATE_RESULT_PAGE = "/WEB-INF/jsp/userUpdateResult.jsp";

	public static Helper getInstance() {
		return new Helper();
	}

	/**
	 * セッションから指定データを取得（削除も一緒に行う）
	 * @param session
	 * @param str
	 * @return
	 */
	public static Object cutSessionAttribute(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);
		return test;
	}

	/**
	 * ログインIDのバリデーション
	 * @param inputLoginId
	 * @return
	 */
	public static boolean isLoginIdValidation(String inputLoginId) {
		// 英数字アンダースコア以外が入力されていたら
		if (inputLoginId.matches("[0-9a-zA-Z-_]+")) {
			return true;
		}
		return false;
	}

	/**
	 * ハッシュ関数
	 * @param target
	 * @return
	 */
	public static String getSha256(String target) {
		MessageDigest md = null;
		StringBuffer buf = new StringBuffer();
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(target.getBytes());
			byte[] digest = md.digest();
			for (int i = 0; i < digest.length; i++) {
				buf.append(String.format("%02x", digest[i]));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}

	public static int getTotalItemPrice(ArrayList<ItemBeans> items) {
		int total = 0;
		for (ItemBeans item : items) {
			total += item.getPrice();
		}
		return total;
	}
}
