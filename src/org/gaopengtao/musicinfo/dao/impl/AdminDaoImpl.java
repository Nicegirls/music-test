package org.gaopengtao.musicinfo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.gaopengtao.musicinfo.dao.AdminDao;
import org.gaopengtao.musicinfo.entity.Admin;

public class AdminDaoImpl implements AdminDao {
	List<Object> lo = new ArrayList<Object>();

	@Override
	public boolean login(Admin admin) {
		String sql = "select * from Admin where a_name = ? and a_password = ?";
		lo.clear();
		lo.add(admin.getA_name());
		lo.add(admin.getA_password());
		ResultSet rs = BaseDao.selectInfo(sql, lo);
		try {
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int register(Admin admin) {
		// TODO Auto-generated method stub
		String sql = "insert into admin(a_name,a_password) values of(?,?)";
		lo.clear();
		lo.add(admin.getA_name());
		lo.add(admin.getA_password());
		return BaseDao.updateInfo(sql, lo);
	}

}
