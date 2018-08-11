package org.gaopengtao.musicinfo.dao;

import org.gaopengtao.musicinfo.entity.Admin;

public interface AdminDao {
	/**
	 * µÇÂ¼Ð£Ñé
	 * 
	 * @param admin
	 * @return
	 */
	public abstract boolean login(Admin admin);

}
