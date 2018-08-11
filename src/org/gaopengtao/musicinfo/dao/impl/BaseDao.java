package org.gaopengtao.musicinfo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.gaopengtao.musicinfo.util.JDBCutil;

public class BaseDao {
	private static Connection conn = null;
	private static PreparedStatement ps = null;

	public static int updateInfo(String sql, List<Object> lo) {
		int i = 0;
		try {
			conn = JDBCutil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int j = 1; j <= lo.size(); j++) {
				ps.setObject(j, lo.get(j - 1));
			}
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static ResultSet selectInfo(String sql, List<Object> lo) {
		ResultSet rs = null;
		try {
			conn = JDBCutil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int j = 1; j <= lo.size(); j++) {
				ps.setObject(j, lo.get(j - 1));
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
