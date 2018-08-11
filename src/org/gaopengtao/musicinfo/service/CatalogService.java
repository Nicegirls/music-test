package org.gaopengtao.musicinfo.service;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.gaopengtao.musicinfo.entity.CataLog;

public interface CatalogService {
	/**
	 * ��ͨ�������ѯ����
	 * 
	 * @return
	 */
	public List<Vector> selectMusic(CataLog catalog);

	/**
	 * �������
	 * 
	 * @param cata
	 * @return
	 */
	public boolean addCatalog(CataLog catalog);

	/**
	 * ɾ������
	 * 
	 * @param catalog
	 * @return
	 */
	public Boolean detelCatalog(CataLog catalog);

	/**
	 * �޸�����
	 * 
	 * @param catalog
	 * @return
	 */
	public boolean updateCatalog(CataLog catalog);

	/**
	 * ��������ID
	 * 
	 * @param cata
	 * @return
	 */
	public List<Integer> selectCataid(CataLog catalog);

	/**
	 * �ж�����ID�Ƿ���
	 * 
	 * @return
	 */
	public boolean isCataid(CataLog catalog);

	/**
	 * �ж��������Ƿ����
	 * 
	 * @return
	 */
	public boolean isCname(CataLog catalog);
	/**
	 * ����ȫ������
	 */
	public Set allCatalog();
}
