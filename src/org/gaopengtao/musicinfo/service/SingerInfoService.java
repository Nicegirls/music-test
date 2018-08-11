package org.gaopengtao.musicinfo.service;

import java.util.Set;

import org.gaopengtao.musicinfo.entity.SingerInfo;

public interface SingerInfoService {
	/**
	 * ��Ӹ���
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean addSinger(SingerInfo singerInfo);

	/**
	 * ɾ������
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean deteleSinger(SingerInfo singerInfo);

	/**
	 * �޸ĸ���
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean upDateSinger(SingerInfo singerInfo);

	/**
	 * �жϸ���ID�Ƿ����
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean isSinger(SingerInfo singerInfo);

	/**
	 * �жϸ������Ƿ����
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean isSingerByname(SingerInfo singerInfo);
	/**
	 * ����ȫ���ĸ���
	 * @return
	 */
	public Set allSinger();

}
