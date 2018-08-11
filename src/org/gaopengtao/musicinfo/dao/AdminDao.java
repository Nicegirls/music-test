package org.gaopengtao.musicinfo.dao;

import org.gaopengtao.musicinfo.entity.Admin;

public interface AdminDao {
	/**
	 * 登录校验
	 * 
	 * @param admin
	 * @return
	 */
	public abstract boolean login(Admin admin);
	/**
	 * 注册用户
	 * @param admin
	 * @return
	 */
	public int register(Admin admin);
}
