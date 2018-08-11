package org.gaopengtao.musicinfo.service;

import java.util.List;
import java.util.Vector;

import org.gaopengtao.musicinfo.entity.CataLog;
import org.gaopengtao.musicinfo.entity.Music;
import org.gaopengtao.musicinfo.entity.MusicInfo;
import org.gaopengtao.musicinfo.entity.SingerInfo;

public interface MusicInfoService {
	/**
	 * �޸�������Ϣ
	 * 
	 * @param music
	 * @return
	 */
	public boolean updateMusic(Music music);

	/**
	 * ���ݸ������߸��ֻ�������ɸѡ����
	 * 
	 * @param ms
	 * @return
	 */
	public List<Vector> selectMusic(String ms);

	/**
	 * ��ѯȫ������
	 * 
	 * @return
	 */
	public List<Vector> selectAllMusic();

	/**
	 * �ж�����ID�Ƿ��Ѿ�����
	 * 
	 * @param musicInfo
	 * @return
	 */
	public boolean isSame(MusicInfo musicInfo);

	/**
	 * ��Ӹ���
	 * 
	 * @param musicInfo
	 * @return
	 */
	public boolean addMusic(Music music);

	/**
	 * ɾ������
	 * 
	 * @param musicinfo
	 * @return
	 */
	public boolean deletMusic(MusicInfo musicinfo);

	/**
	 * ͨ������ɾ������
	 * 
	 * @param catalog
	 * @return
	 */
	public boolean deletMusic(CataLog catalog);

	/**
	 * ͨ������ɾ������
	 * 
	 * @param singerinfo
	 * @return
	 */
	public boolean deletMusic(SingerInfo singerinfo);

	/**
	 * �жϸ���ID�Ƿ��Ѿ�����
	 * 
	 * @param music
	 * @return
	 */
	public boolean isMusicid(Music music);

	/**
	 * 
	 * @param music
	 * @return
	 */
	public String addMusicInfo(Music music);

}
