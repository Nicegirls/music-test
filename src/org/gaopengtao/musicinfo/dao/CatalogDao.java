package org.gaopengtao.musicinfo.dao;

import java.sql.ResultSet;
import org.gaopengtao.musicinfo.entity.CataLog;

public interface CatalogDao {
	/**
	 * �޸�����
	 * 
	 * @param music
	 * @return
	 */
	public int updateCatalog(CataLog catalog);

	/**
	 * ���������������
	 * 
	 * @param catalog
	 * @return
	 */
	public ResultSet selectMusic(CataLog catalog);

	/**
	 * �������
	 * 
	 * @param ca
	 * @return
	 */
	public int addCatalog(CataLog ca);

	/**
	 * ��������
	 * 
	 * @param catalog
	 * @return
	 */
	public ResultSet selectCatalog(CataLog catalog);

	/**
	 * ɾ������
	 * 
	 * @param catalog
	 * @return
	 */
	public int deteleCatalog(CataLog catalog);

	/**
	 * ���������������ID
	 * 
	 * @param cata
	 * @return
	 */
	public ResultSet selectCataid(CataLog cata);

	/**
	 * ����id�Ƿ����
	 * 
	 * @return
	 */
	public ResultSet isCataid(CataLog catalog);

	/**
	 * �ж��������Ƿ����
	 * 
	 * @param catalog
	 * @return
	 */
	public ResultSet isCname(CataLog catalog);
	/**
	 * ��������ȫ������
	 * @return
	 */
	public ResultSet selectAllCata();
}
