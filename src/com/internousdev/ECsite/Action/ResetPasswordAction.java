package com.internousdev.ECsite.Action;
import java.util.Map;

public class ResetPasswordAction extends ActionSupport implements SessionAware {

		//
		private String backFlg;
		private Map<String, Object> session;

		public String execute() {

			if (backFlg == null) {
				// 戻るボタンから戻った際にユーザーID以外は未入力状態
				session.remove("userIdForResetPassword");
			}
			return SUCCESS;
	}

// getter,setterで値を定義し、それぞれのフィールド変数へ格納される
	public String getBackFlg() {
		return backFlg;
	}

	public void setBackFlg(String backFlg) {
		this.backFlg = backFlg;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}

