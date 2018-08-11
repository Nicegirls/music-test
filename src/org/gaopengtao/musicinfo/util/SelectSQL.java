package org.gaopengtao.musicinfo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSQL {
	private static ResultSet rs = null;

	public static ResultSet selectSQL(String sql) {
		Connection conn = JDBCutil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
