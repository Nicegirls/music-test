package org.gaopengtao.musicinfo.service.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.gaopengtao.musicinfo.dao.MusicInfoDao;
import org.gaopengtao.musicinfo.dao.impl.MusicInfoDaoImpl;
import org.gaopengtao.musicinfo.entity.CataLog;
import org.gaopengtao.musicinfo.entity.Music;
import org.gaopengtao.musicinfo.entity.MusicInfo;
import org.gaopengtao.musicinfo.entity.SingerInfo;
import org.gaopengtao.musicinfo.service.CatalogService;
import org.gaopengtao.musicinfo.service.MusicInfoService;
import org.gaopengtao.musicinfo.service.SingerInfoService;

public class MusicInfoServiceImpl implements MusicInfoService {
	MusicInfoDao musicInfoDao = new MusicInfoDaoImpl();
	List<Vector> lv = new ArrayList<Vector>();
	ResultSet rs = null;

	@Override
	public boolean updateMusic(Music music) {
		// TODO Auto-generated method stub
		int i = musicInfoDao.updateMusicInfo(music);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public List<Vector> selectMusic(String ms) {
		ResultSet rs = musicInfoDao.selectMusic(ms);
		if (rs != null) {
			try {
				while (rs.next()) {
					Vector vc = new Vector();
					vc.add(rs.getInt(1));
					vc.add(rs.getString(2));
					vc.add(rs.getString(3));
					vc.add(rs.getString(4));
					vc.add(rs.getString(5));
					lv.add(vc);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lv;
	}

	@Override
	public List<Vector> selectAllMusic() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		rs = musicInfoDao.selectAllMusic();
		if (rs != null) {
			try {
				while (rs.next()) {
					Vector vc = new Vector();
					vc.add(rs.getInt(1));
					vc.add(rs.getString(2));
					vc.add(rs.getString(3));
					vc.add(rs.getString(4));
					vc.add(rs.getString(5));
					lv.add(vc);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lv;
	}

	@Override
	public boolean isSame(MusicInfo musicInfo) {
		// TODO Auto-generated method stub
		ResultSet rs = musicInfoDao.isSame(musicInfo);
		if (rs != null)
			return false;
		return true;
	}

	@Override
	public boolean addMusic(Music music) {
		// TODO Auto-generated method stub
		int i = musicInfoDao.addMusic(music);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public boolean deletMusic(MusicInfo musicinfo) {
		// TODO Auto-generated method stub
		int i = musicInfoDao.deleteMusic(musicinfo);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public boolean deletMusic(CataLog catalog) {
		// TODO Auto-generated method stub
		int i = musicInfoDao.deleteMusic(catalog);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public boolean deletMusic(SingerInfo singerinfo) {
		// TODO Auto-generated method stub
		int i = musicInfoDao.deleteMusic(singerinfo);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public boolean isMusicid(Music music) {
		// TODO Auto-generated method stub
		ResultSet rs = musicInfoDao.isMusicid(music);
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
	public String addMusicInfo(Music music) {
		// TODO Auto-generated method stub

		rs = musicInfoDao.isMusicid(new Music(music.getM_id()));
		boolean s = true;
		try {
			s = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (s)
			return "歌曲ID已经存在!";
		else {
			SingerInfoService singer = new SingerInfoServiceImpl();
			boolean m = singer.isSingerByname(new SingerInfo(music.getS_name()));
			if (m == false)
				return "歌手不存在!";
			else {
				CatalogService catalog = new CatalogServiceImpl();
				boolean n = catalog.isCname(new CataLog(music.getC_name()));
				if (n == false)
					return "曲风不存在!";
				else {
					boolean b = false;
					int i = musicInfoDao.addMusic(music);// idvalue,mname,sname,cname,mdec));
					if (i > 0)
						b = true;
					else
						b = false;
					if (b)
						return "添加成功!";
					else
						return "添加失败!";
				}
			}
		}
	}
}
