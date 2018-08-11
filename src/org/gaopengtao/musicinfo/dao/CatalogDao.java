package org.gaopengtao.musicinfo.dao;

import java.sql.ResultSet;
import org.gaopengtao.musicinfo.entity.CataLog;

public interface CatalogDao {
	/**
	 * 修改曲风
	 * 
	 * @param music
	 * @return
	 */
	public int updateCatalog(CataLog catalog);

	/**
	 * 根据曲风查找音乐
	 * 
	 * @param catalog
	 * @return
	 */
	public ResultSet selectMusic(CataLog catalog);

	/**
	 * 添加曲风
	 * 
	 * @param ca
	 * @return
	 */
	public int addCatalog(CataLog ca);

	/**
	 * 查找曲风
	 * 
	 * @param catalog
	 * @return
	 */
	public ResultSet selectCatalog(CataLog catalog);

	/**
	 * 删除曲风
	 * 
	 * @param catalog
	 * @return
	 */
	public int deteleCatalog(CataLog catalog);

	/**
	 * 根据曲风查找曲风ID
	 * 
	 * @param cata
	 * @return
	 */
	public ResultSet selectCataid(CataLog cata);

	/**
	 * 曲风id是否存在
	 * 
	 * @return
	 */
	public ResultSet isCataid(CataLog catalog);

	/**
	 * 判断曲风名是否存在
	 * 
	 * @param catalog
	 * @return
	 */
	public ResultSet isCname(CataLog catalog);
	/**
	 * 查找曲库全部曲风
	 * @return
	 */
	public ResultSet selectAllCata();
}
