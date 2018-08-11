package org.gaopengtao.musicinfo.dao.impl;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import org.gaopengtao.musicinfo.dao.MusicInfoDao;
import org.gaopengtao.musicinfo.entity.CataLog;
import org.gaopengtao.musicinfo.entity.Music;
import org.gaopengtao.musicinfo.entity.MusicInfo;
import org.gaopengtao.musicinfo.entity.SingerInfo;
import org.gaopengtao.musicinfo.util.SelectSQL;

public class MusicInfoDaoImpl implements MusicInfoDao {

	List<Object> lo = new ArrayList<Object>();

	@Override
	public int updateMusicInfo(Music music) {
		String sql = "update musicInfo set m_name = ?,m_singerid = (select M_singerid from singerInfo where s_name = ?),m_cataid = (select m_cataid from catalog where c_name = ?),m_describe = ? where m_id = ?";
		lo.clear();
		lo.add(music.getM_name());
		lo.add(music.getS_name());
		lo.add(music.getC_name());
		lo.add(music.getM_describe());
		lo.add(music.getM_id());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public ResultSet selectMusic(String ms) {
		ResultSet rs = null;
		String sql = "select m.m_id,m_name,s_name,c_name,m_describe from  catalog c right join musicInfo m on m.m_cataid = c.m_cataid left join singerInfo s on m.M_singerid = s.m_singerid where m.m_name like '%"
				+ ms + "%' or s.s_name like '%" + ms + "%' order by m.m_id ";
		rs = SelectSQL.selectSQL(sql);
		return rs;
	}

	@Override
	public ResultSet selectAllMusic() {
		// TODO Auto-generated method stub
		String sql = "select m.m_id,m_name,s_name,c_name,m_describe from  catalog c right join musicInfo m on m.m_cataid = c.m_cataid left join singerInfo s on m.M_singerid = s.m_singerid order by m_id";
		lo.clear();
		return BaseDao.selectInfo(sql, lo);
	}

	@Override
	public ResultSet isSame(MusicInfo musicInfo) {
		// TODO Auto-generated method stub
		// ResultSet rs =null;
		String sql = "select * from catalog where m_id = ?";// +musicInfo.getM_id()+"";
		// SelectSQL.selectSQL(sql);
		lo.clear();
		lo.add(musicInfo.getM_id());
		return BaseDao.selectInfo(sql, lo);
	}

	@Override
	public int addMusic(Music music) {
		// TODO Auto-generated method stub
		String sql = "insert into Musicinfo(m_id,m_name,m_singerid,m_cataid,m_describe) values (?,?,(select m_singerid from singerinfo where s_name = ?),(select m_cataid from catalog where c_name = ?),?)";
		lo.clear();
		lo.add(music.getM_id());
		lo.add(music.getM_name());
		lo.add(music.getS_name());
		lo.add(music.getC_name());
		lo.add(music.getM_describe());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public int deleteMusic(MusicInfo musicinfo) {
		// TODO Auto-generated method stub
		String sql = "delete musicinfo where m_id =?";// musicinfo.getM_id();
		lo.clear();
		lo.add(musicinfo.getM_id());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public int deleteMusic(CataLog catalog) {
		// TODO Auto-generated method stub
		String sql = "delete musicinfo where m_cataid = ?";// +catalog.getM_cataid();
		lo.clear();
		lo.add(catalog.getM_cataid());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public int deleteMusic(SingerInfo singerinfo) {
		// TODO Auto-generated method stub
		String sql = "delete musicinfo where m_singerid = ?";// +singerinfo.getM_singerid();
		lo.clear();
		lo.add(singerinfo.getM_singerid());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public ResultSet isMusicid(Music music) {
		// TODO Auto-generated method stub
		String sql = "select * from musicinfo where m_id = ?";// +music.getM_id();
		// rs = SelectSQL.selectSQL(sql)
		lo.clear();
		lo.add(music.getM_id());
		return BaseDao.selectInfo(sql, lo);
	}

}
