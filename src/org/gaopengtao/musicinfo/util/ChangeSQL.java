package org.gaopengtao.musicinfo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangeSQL {
	private static int i = 0;

	public static int changerSQL(String sql) {
		Connection conn = JDBCutil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
