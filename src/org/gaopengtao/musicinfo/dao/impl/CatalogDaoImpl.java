package org.gaopengtao.musicinfo.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.gaopengtao.musicinfo.dao.CatalogDao;
import org.gaopengtao.musicinfo.entity.CataLog;

public class CatalogDaoImpl implements CatalogDao {
	List<Object> lo = new ArrayList<Object>();

	@Override
	public int updateCatalog(CataLog catalog) {
		// int i = 0;
		String sql = "update catalog set c_name = ? where m_cataid = ?";// +catalog.getM_cataid()+"";
		// i = ChangeSQL.changerSQL(sql);
		lo.clear();
		lo.add(catalog.getC_name());
		lo.add(catalog.getM_cataid());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public ResultSet selectMusic(CataLog catalog) {
		// TODO Auto-generated method stub
		String sql = "Select m_id,m_name,s_name,c_name,m_describe from singerinfo s right join MusicInfo m on s.m_singerid = m.m_singerid left join catalog c on m.m_cataid = c.m_cataid where c_name = ?";
		// ResultSet rs= null;
		// rs = SelectSQL.selectSQL(sql);
		lo.clear();
		lo.add(catalog.getC_name());
		return BaseDao.selectInfo(sql, lo);
	}

	@Override
	public int addCatalog(CataLog ca) {
		// int i =0;
		String sql = "insert into catalog(m_cataid,c_name) values(?,?) ";
		// i = ChangeSQL.changerSQL(sql);
		lo.clear();
		lo.add(ca.getM_cataid());
		lo.add(ca.getC_name());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public ResultSet selectCatalog(CataLog catalog) {
		// TODO Auto-generated method stub

		// ResultSet rs = null;
		String sql = "Select * from catalog where c_name = ?";
		// rs = SelectSQL.selectSQL(sql);
		lo.clear();
		lo.add(catalog.getC_name());
		return BaseDao.selectInfo(sql, lo);
	}

	@Override
	public int deteleCatalog(CataLog catalog) {
		// TODO Auto-generated method stub
		// int i = 0;
		String sql = "delete catalog where c_name = ?";
		// i = ChangeSQL.changerSQL(sql);
		lo.clear();
		lo.add(catalog.getC_name());
		return BaseDao.updateInfo(sql, lo);
	}

	@Override
	public ResultSet selectCataid(CataLog cata) {
		// TODO Auto-generated method stub
		// ResultSet rs = null;
		String sql = "select m_cataid from catalog where c_name = ?";// +cata.getC_name()+"'";
		// rs = SelectSQL.selectSQL(sql);
		lo.clear();
		lo.add(cata.getC_name());
		return BaseDao.selectInfo(sql, lo);
	}

	@Override
	public ResultSet isCataid(CataLog catalog) {
		// TODO Auto-generated method stub
		// ResultSet rs = null;
		String sql = "select * from catalog where m_cataid = ?";// +catalog.getM_cataid();
		// rs = SelectSQL.selectSQL(sql);
		lo.clear();
		lo.add(catalog.getM_cataid());
		return BaseDao.selectInfo(sql, lo);
	}

	@Override
	public ResultSet isCname(CataLog catalog) {
		// TODO Auto-generated method stub
		// ResultSet rs = null;
		String sql = "select * from catalog where c_name = ?";// +catalog.getC_name()+"'";
		// rs = SelectSQL.selectSQL(sql);
		lo.clear();
		lo.add(catalog.getC_name());
		return BaseDao.selectInfo(sql, lo);
	}

	@Override
	public ResultSet selectAllCata() {
		// TODO Auto-generated method stub
		String sql = "select c_name from catalog";
		lo.clear();
		return BaseDao.selectInfo(sql, lo);
	}

}
