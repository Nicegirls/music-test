package org.gaopengtao.musicinfo.entity;

public class SingerInfo {
	/**
	 * 歌手表中字段
	 */
	private int m_singerid;
	private String s_name;
	/**
	 * 备用字段
	 */
	private String s_by1;
	private String s_by2;
	private String s_by3;
	private String s_by4;

	public SingerInfo() {
	}

	public SingerInfo(int m_singerid) {
		super();
		this.m_singerid = m_singerid;
	}

	public SingerInfo(String s_name) {
		super();
		this.s_name = s_name;
	}

	public SingerInfo(int m_singerid, String s_name) {
		super();
		this.m_singerid = m_singerid;
		this.s_name = s_name;
	}

	public int getM_singerid() {
		return m_singerid;
	}

	public void setM_singerid(int m_singerid) {
		this.m_singerid = m_singerid;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_by1() {
		return s_by1;
	}

	public void setS_by1(String s_by1) {
		this.s_by1 = s_by1;
	}

	public String getS_by2() {
		return s_by2;
	}

	public void setS_by2(String s_by2) {
		this.s_by2 = s_by2;
	}

	public String getS_by3() {
		return s_by3;
	}

	public void setS_by3(String s_by3) {
		this.s_by3 = s_by3;
	}

	public String getS_by4() {
		return s_by4;
	}

	public void setS_by4(String s_by4) {
		this.s_by4 = s_by4;
	}

}
