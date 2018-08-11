package org.gaopengtao.musicinfo.service.Impl;

import org.gaopengtao.musicinfo.dao.AdminDao;
import org.gaopengtao.musicinfo.dao.impl.AdminDaoImpl;
import org.gaopengtao.musicinfo.entity.Admin;
import org.gaopengtao.musicinfo.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Override
	public boolean login(Admin admin) {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao.login(admin);
	}
}
