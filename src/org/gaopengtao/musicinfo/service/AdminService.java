package org.gaopengtao.musicinfo.service;

import org.gaopengtao.musicinfo.entity.Admin;

public interface AdminService {
	/**
	 * ��½У��
	 * 
	 * @param admin
	 * @return
	 */
	public boolean login(Admin admin);
	/**
	 * ע���û�
	 * @param admin
	 * @return
	 */
	public boolean register(Admin admin);
}
