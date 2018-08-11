package org.gaopengtao.musicinfo.entity;

public class Music {
	/**
	 * ∏Ë«˙–≈œ¢ Ù–‘
	 */
	private int m_id;
	private String m_name;
	private String s_name;
	private String c_name;
	private String m_describe;

	public Music() {

	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public Music(int m_id, String m_name) {
		this.m_id = m_id;
		this.m_name = m_name;
	}

	public Music(int m_id) {
		this.m_id = m_id;

	}

	public String getM_describe() {
		return m_describe;
	}

	public void setM_describe(String m_describe) {
		this.m_describe = m_describe;
	}

	public Music(String m_name, String s_name) {
		super();
		this.m_name = m_name;
		this.s_name = s_name;
	}

	public Music(int m_id, String m_name, String m_describe) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_describe = m_describe;
	}

	public Music(int m_id, String m_name, String s_name, String c_name, String m_describe) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.s_name = s_name;
		this.c_name = c_name;
		this.m_describe = m_describe;
	}
}
