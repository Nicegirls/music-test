package org.gaopengtao.musicinfo.service.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.gaopengtao.musicinfo.dao.CatalogDao;
import org.gaopengtao.musicinfo.dao.impl.CatalogDaoImpl;
import org.gaopengtao.musicinfo.entity.CataLog;
import org.gaopengtao.musicinfo.service.CatalogService;

public class CatalogServiceImpl implements CatalogService {
	List<Vector> lv = new ArrayList<Vector>();
	CatalogDao cata = new CatalogDaoImpl();

	@Override
	public List<Vector> selectMusic(CataLog catalog) {
		// TODO Auto-generated method stub

		ResultSet rs = cata.selectMusic(catalog);
		if (rs != null) {
			try {
				while (rs.next()) {
					Vector v = new Vector();
					v.add(rs.getString(1));
					v.add(rs.getString(2));
					v.add(rs.getString(3));
					v.add(rs.getString(4));
					lv.add(v);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lv;
	}

	@Override
	public boolean addCatalog(CataLog catalog) {
		// TODO Auto-generated method stub
		int i = cata.addCatalog(catalog);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public Boolean detelCatalog(CataLog catalog) {
		// TODO Auto-generated method stub
		int i = cata.deteleCatalog(catalog);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateCatalog(CataLog catalog) {
		// TODO Auto-generated method stub
		int i = cata.updateCatalog(catalog);
		if (i > 0)
			return true;
		return false;
	}

	@Override
	public List<Integer> selectCataid(CataLog catalog) {
		// TODO Auto-generated method stub
		ResultSet rs = cata.selectCataid(catalog);
		List<Integer> li = new ArrayList<Integer>();
		if (rs != null) {
			try {
				while (rs.next()) {
					li.add(rs.getInt("m_cataid"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return li;
	}

	@Override
	public boolean isCataid(CataLog catalog) {
		// TODO Auto-generated method stub
		ResultSet rs = cata.isCataid(catalog);
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
	public boolean isCname(CataLog catalog) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		rs = cata.isCname(catalog);
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
	public Set allCatalog() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
//		List<String> ls = null;
		Set set = new HashSet();
//		set.add("");
		rs = cata.selectAllCata();
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
