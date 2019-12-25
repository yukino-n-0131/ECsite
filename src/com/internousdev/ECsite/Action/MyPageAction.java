package com.internousdev.ECsite.Action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ECsite.dao.UserInfoDAO;
import com.internousdev.ECsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

//truts2が持つActionSupportクラスを継承する
public class MyPageAction extends ActionSupport implements SessionAware {

	UserInfoDTO userInfoDTO;
	// 制限されたStringとObjectをsessionでログイン保持するフィールド変数
	private Map<String, Object> session;

	public String execute() {

		/* 仮ログインnullを初期値として、tempで仮ログインを一時利用、整数を解析する */
		/* loginFlgと1が等しくない場合は、loginErrorページでへ飛ぶ */
		String tempLogined = String.valueOf(session.get("loginFlg"));
		int loginFlg = "null".equals(tempLogined)? 0 : Integer.parseInt(tempLogined);
		if (loginFlg != 1) {
			return "loginError";
		}
		// UserInfoDAOをインスタンス化してsessionしたuserIdをDTOに受け渡す
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		userInfoDTO = userInfoDAO.getUserInfo(String.valueOf(session.get("userId")));

		return SUCCESS;
	}

	// getterで制限されたフィールドの値をUserInfoDTOから取得する
	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}

	// setterで制限されたフィールドの値をUserInfoDTOから書き換える
	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

	// Mapで紐付けしsessionする
	public Map<String,Object> getSession() {
		return this.session;
	}

	// sessionした情報を持ってくる
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}