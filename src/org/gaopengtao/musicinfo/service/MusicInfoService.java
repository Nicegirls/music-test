package org.gaopengtao.musicinfo.service;

import java.util.List;
import java.util.Vector;

import org.gaopengtao.musicinfo.entity.CataLog;
import org.gaopengtao.musicinfo.entity.Music;
import org.gaopengtao.musicinfo.entity.MusicInfo;
import org.gaopengtao.musicinfo.entity.SingerInfo;

public interface MusicInfoService {
	/**
	 * 修改音乐信息
	 * 
	 * @param music
	 * @return
	 */
	public boolean updateMusic(Music music);

	/**
	 * 根据歌名或者歌手或者曲风筛选歌曲
	 * 
	 * @param ms
	 * @return
	 */
	public List<Vector> selectMusic(String ms);

	/**
	 * 查询全部音乐
	 * 
	 * @return
	 */
	public List<Vector> selectAllMusic();

	/**
	 * 判断音乐ID是否已经存在
	 * 
	 * @param musicInfo
	 * @return
	 */
	public boolean isSame(MusicInfo musicInfo);

	/**
	 * 添加歌曲
	 * 
	 * @param musicInfo
	 * @return
	 */
	public boolean addMusic(Music music);

	/**
	 * 删除歌曲
	 * 
	 * @param musicinfo
	 * @return
	 */
	public boolean deletMusic(MusicInfo musicinfo);

	/**
	 * 通过曲风删除歌曲
	 * 
	 * @param catalog
	 * @return
	 */
	public boolean deletMusic(CataLog catalog);

	/**
	 * 通过歌手删除歌曲
	 * 
	 * @param singerinfo
	 * @return
	 */
	public boolean deletMusic(SingerInfo singerinfo);

	/**
	 * 判断歌曲ID是否已经纯在
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
