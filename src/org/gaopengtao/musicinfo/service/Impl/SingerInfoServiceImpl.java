package org.gaopengtao.musicinfo.service.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.gaopengtao.musicinfo.dao.SingerInfoDao;
import org.gaopengtao.musicinfo.dao.impl.SingerInfoDaoImpl;
import org.gaopengtao.musicinfo.entity.SingerInfo;
import org.gaopengtao.musicinfo.service.SingerInfoService;

public class SingerInfoServiceImpl implements SingerInfoService {
	SingerInfoDao singerInfoDao = new SingerInfoDaoImpl();

	@Override
	public boolean addSinger(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		int i = singerInfoDao.addSinger(singerInfo);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public boolean deteleSinger(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		int i = singerInfoDao.deteleSinger(singerInfo);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public boolean upDateSinger(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		int i = singerInfoDao.updateSinger(singerInfo);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public boolean isSinger(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		ResultSet rs = singerInfoDao.isSingerid(singerInfo);
		try {
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isSingerByname(SingerInfo singerInfo) {
		// TODO Auto-generated method stub
		ResultSet rs = singerInfoDao.isSingerName(singerInfo);
		try {
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Set allSinger() {
		// TODO Auto-generated method stub
		Set set = new HashSet();
		ResultSet rs = singerInfoDao.allSinger();
		if(rs!=null){
			try {
				while(rs.next()){
					set.add(rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return set;
	}

}
