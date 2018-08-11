package org.gaopengtao.musicinfo.dao;

import java.sql.ResultSet;

import org.gaopengtao.musicinfo.entity.CataLog;
import org.gaopengtao.musicinfo.entity.Music;
import org.gaopengtao.musicinfo.entity.MusicInfo;
import org.gaopengtao.musicinfo.entity.SingerInfo;

public interface MusicInfoDao {
	/**
	 * �޸�������Ϣ
	 * 
	 * @param music
	 * @return
	 */
	public int updateMusicInfo(Music music);

	/**
	 * ͨ���������߸��������������ѯ����
	 * 
	 * @param ms
	 * @return
	 */
	public ResultSet selectMusic(String ms);

	/**
	 * ��ѯȫ������
	 * 
	 * @return
	 */
	public ResultSet selectAllMusic();

	/**
	 * �жϸ���ID�Ƿ��Ѿ�����
	 * 
	 * @param musicInfo
	 * @return
	 */
	public ResultSet isSame(MusicInfo musicInfo);

	/**
	 * ��Ӹ���
	 * 
	 * @param musicinfo
	 * @return
	 */
	public int addMusic(Music music);

	/**
	 * ͨ������IDɾ������
	 * 
	 * @param musicinfo
	 * @return
	 */
	public int deleteMusic(MusicInfo musicinfo);

	/**
	 * ͨ������ɾ������
	 * 
	 * @param catalog
	 * @return
	 */
	public int deleteMusic(CataLog catalog);

	/**
	 * ͨ��ɾ������ɾ������
	 * 
	 * @param singerinfo
	 * @return
	 */
	public int deleteMusic(SingerInfo singerinfo);

	/**
	 * �жϸ���ID�Ƿ��Ѿ�����
	 * 
	 * @param music
	 * @return
	 */
	public ResultSet isMusicid(Music music);

}
