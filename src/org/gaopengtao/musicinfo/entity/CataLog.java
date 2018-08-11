package org.gaopengtao.musicinfo.entity;

public class CataLog {
	/**
	 * 曲风表中字段
	 */
	private int m_cataid;
	private String c_name;
	/**
	 * 备用字段
	 */
	private String c_by1;
	private String c_by2;
	private String c_by3;
	private String c_by4;

	public CataLog() {

	}

	public CataLog(int m_cataid) {
		super();
		this.m_cataid = m_cataid;
	}

	public CataLog(String c_name) {
		super();
		this.c_name = c_name;
	}

	public CataLog(int m_cataid, String c_name) {
		super();
		this.m_cataid = m_cataid;
		this.c_name = c_name;
	}

	public int getM_cataid() {
		return m_cataid;
	}

	public void setM_cataid(int m_cataid) {
		this.m_cataid = m_cataid;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
}
