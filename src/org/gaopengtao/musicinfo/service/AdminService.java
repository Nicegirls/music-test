package org.gaopengtao.musicinfo.service;

import org.gaopengtao.musicinfo.entity.Admin;

public interface AdminService {
	/**
	 * 登陆校验
	 * 
	 * @param admin
	 * @return
	 */
	public boolean login(Admin admin);
	/**
	 * 注册用户
	 * @param admin
	 * @return
	 */
	public boolean register(Admin admin);
}
