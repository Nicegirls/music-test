package org.gaopengtao.musicinfo.dao;

import java.sql.ResultSet;
import org.gaopengtao.musicinfo.entity.SingerInfo;

public interface SingerInfoDao {
	/**
	 * ͨ���������Ʋ�ѯ��Ӧ�ĸ���
	 * 
	 * @param singerInfo
	 * @return
	 */
	public ResultSet selectSingerByname(SingerInfo singerInfo);

	/**
	 * �޸ĸ�����
	 * 
	 * @param music
	 * @return
	 */
	public int updateSinger(SingerInfo singerInfo);

	/**
	 * ��Ӹ���
	 * 
	 * @param singerInfo
	 * @return
	 */
	public int addSinger(SingerInfo singerInfo);

	/**
	 * ɾ������
	 * 
	 * @param singerInfo
	 * @return
	 */
	public int deteleSinger(SingerInfo singerInfo);

	/**
	 * �жϸ���ID�Ƿ����
	 * 
	 * @return
	 */
	public ResultSet isSingerid(SingerInfo singerInfo);

	/**
	 * �жϸ������Ƿ����
	 * 
	 * @param singerInfo
	 * @return
	 */
	public ResultSet isSingerName(SingerInfo singerInfo);
	/**
	 * ��ѯȫ���ĸ���
	 * @return
	 */
	public ResultSet allSinger();
}
