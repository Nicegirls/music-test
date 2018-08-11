package org.gaopengtao.musicinfo.entity;

public class Admin {
	/**
	 * 管理员账户，密码
	 */
	private String a_name;
	private String a_password;

	/**
	 * 备用字段名
	 */
	private int a_by1;
	private String a_by2;

	public Admin() {
	}

	public Admin(String a_name, String a_password) {
		super();
		this.a_name = a_name;
		this.a_password = a_password;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_password() {
		return a_password;
	}

	public void setA_password(String a_password) {
		this.a_password = a_password;
	}

	public int getA_by1() {
		return a_by1;
	}

	public void setA_by1(int a_by1) {
		this.a_by1 = a_by1;
	}

	public String getA_by2() {
		return a_by2;
	}

	public void setA_by2(String a_by2) {
		this.a_by2 = a_by2;
	}

}
