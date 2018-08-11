package org.gaopengtao.musicinfo.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.gaopengtao.musicinfo.dao.SingerInfoDao;
import org.gaopengtao.musicinfo.entity.SingerInfo;

public class SingerInfoDaoImpl implements SingerInfoDao {
	List<Object> lo = new ArrayList<Object>();

	@Override
	public int updateSinger(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		String sql = "update SingerInfo set s_name = ? where m_singerid = ?";// +singerInfo.getM_singerid();
		// int i = ChangeSQL.changerSQL(sql);
		lo.clear();
		lo.add(singerInfo.getS_name());
		lo.add(singerInfo.getM_singerid());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public int addSinger(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		// int i = 0;
		String sql = "insert into singerInfo (m_singerid,s_name) values (?,?)";// +singerInfo.getM_singerid()+",'"+singerInfo.getS_name()+"')";
		// i = ChangeSQL.changerSQL(sql);
		lo.clear();
		lo.add(singerInfo.getM_singerid());
		lo.add(singerInfo.getS_name());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public ResultSet selectSingerByname(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deteleSinger(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		// int i = 0;
		String sql = "delete singerinfo where s_name  = ?";// +singerInfo.getS_name()+"'";
		// ChangeSQL.changerSQL(sql);
		lo.clear();
		lo.add(singerInfo.getS_name());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public ResultSet isSingerid(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		// ResultSet rs = null;
		String sql = "select * from singerinfo where m_singerid = ?";// +singerInfo.getM_singerid();
		// rs = SelectSQL.selectSQL(sql);
		lo.clear();
		lo.add(singerInfo.getM_singerid());
		return BaseDao.selectInfo(sql, lo);
	}

	@Override
	public ResultSet isSingerName(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		String sql = "select * from singerInfo where s_name = ?";
		lo.clear();
		lo.add(singerInfo.getS_name());
		return BaseDao.selectInfo(sql, lo);
	}

	@Override
	public ResultSet allSinger() {
		// TODO Auto-generated method stub
		String sql="select s_name from singerinfo";
		lo.clear();
		return BaseDao.selectInfo(sql, lo);
	}

}
