package org.gaopengtao.musicinfo.service;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.gaopengtao.musicinfo.entity.CataLog;

public interface CatalogService {
	/**
	 * 查通过曲风查询歌曲
	 * 
	 * @return
	 */
	public List<Vector> selectMusic(CataLog catalog);

	/**
	 * 添加曲风
	 * 
	 * @param cata
	 * @return
	 */
	public boolean addCatalog(CataLog catalog);

	/**
	 * 删除曲风
	 * 
	 * @param catalog
	 * @return
	 */
	public Boolean detelCatalog(CataLog catalog);

	/**
	 * 修改曲风
	 * 
	 * @param catalog
	 * @return
	 */
	public boolean updateCatalog(CataLog catalog);

	/**
	 * 查找曲风ID
	 * 
	 * @param cata
	 * @return
	 */
	public List<Integer> selectCataid(CataLog catalog);

	/**
	 * 判断曲风ID是否纯在
	 * 
	 * @return
	 */
	public boolean isCataid(CataLog catalog);

	/**
	 * 判断曲风名是否存在
	 * 
	 * @return
	 */
	public boolean isCname(CataLog catalog);
	/**
	 * 搜索全部曲风
	 */
	public Set allCatalog();
}
