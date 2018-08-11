package org.gaopengtao.musicinfo.entity;

public class MusicInfo {
	/**
	 * ÀÖÇú±í×Ö¶Î
	 */
	private int m_id;
	private String m_name;
	private int m_singerid;
	private int m_cataid;
	private String m_describe;
	/**
	 * ±¸ÓÃ×Ö¶Î
	 */
	private String m_by1;
	private String m_by2;
	private String m_by3;
	private String m_by4;
	private String m_by5;
	private String m_by6;

	public MusicInfo() {
		super();
	}

	public MusicInfo(int m_id) {
		this.m_id = m_id;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getM_singerid() {
		return m_singerid;
	}

	public void setM_singerid(int m_singerid) {
		this.m_singerid = m_singerid;
	}

	public int getM_cataid() {
		return m_cataid;
	}

	public void setM_cataid(int m_cataid) {
		this.m_cataid = m_cataid;
	}

	public String getM_describe() {
		return m_describe;
	}

	public void setM_describe(String m_describe) {
		this.m_describe = m_describe;
	}

	public MusicInfo(String m_name) {
		super();
		this.m_name = m_name;
	}

	public MusicInfo(String m_name, String m_describe) {
		super();

		this.m_name = m_name;
		this.m_describe = m_describe;
	}

}
