package com.internousdev.ECsite.Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {

		private Map<String, Object> session;
		// ユーザーをデータベースに登録する
		public String execute() {

			String result = ERROR;
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			int count = userInfoDAO.resetPassword(session.get("userIdForResetPassword").toString(),
					session.get("newPassword").toString());

			if (count > 0) {
					result = SUCCESS;
			}
			// 新しいパスを判別し、指定
			session.remove("userIdForResetPassword");
			session.remove("newPassword");

			return result;
		}
		// getter,setter
		public Map<String, Object> getSession() {
			return session;
		}

		public void setSession(Map<String, Object> session) {
			this.session = session;
		}

}

