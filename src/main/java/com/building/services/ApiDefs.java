package com.building.services;

/**
 * SFAの認証などの汎用要素でHTTPやJAXRSの保持名に関する定数の宣言クラス.
 * @author masahiro.takahashi
 *
 */
public interface ApiDefs {
	//認証直後のヘッダー応答に含めるヘッダー
	/** トークン保存HTTPヘッダー名[クライアントリクエストからも利用] */
	String TOKEN_HEADER_NAME = "AUTHORIZED_TOKEN";
	String EMPLOYEE_DIVISION_ID_HEADER_NAME = "EMPLOYEE_DIVISION_ID";
	/** トークン保存のログイン者所属組織名 */
	String EMPLOYEE_DIVISION_NAME_HEADER_NAME = "EMPLOYEE_DIVISION_NAME";
	/** トークン保存の認証者のマネージャ組織(配下組織含む)*/
	String MANAGE_DIVISON_IDS_HEADER_NAME = "MANAGE_DIVISION_IDS";
	/** トークン保存の認証者の社員ID(employeeId)*/
	String LOGIN_USER_ID_HEADER_NAME = "LOGIN_USER_ID";
	/** トークン保存の認証者の社員の姓名 */
	String LOGIN_USER_NAME_HEADER_NAME = "LOGIN_USER_NAME";
	/** 認証ユーザ保持ロールリストヘッダー名 */
	String ROLE_LIST_HEADER_NAME = "ROLE_ID_LIST";
	/** トークンのパラメータ渡しの場合のパラメータ名 */
	String TOKEN_PARAMETER_NAME = "authorizedToken";
	/////
	/** Auth information JAXRS Property name (inside the HttpRequest storage key) */
	String AUTH_PROP_NAME = "AUTHORIZED_PROPERTY";
}
