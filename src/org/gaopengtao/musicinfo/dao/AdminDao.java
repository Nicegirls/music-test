package org.gaopengtao.musicinfo.dao;

import org.gaopengtao.musicinfo.entity.Admin;

public interface AdminDao {
	/**
	 * ��¼У��
	 * 
	 * @param admin
	 * @return
	 */
	public abstract boolean login(Admin admin);
	/**
	 * ע���û�
	 * @param admin
	 * @return
	 */
	public int register(Admin admin);
}
