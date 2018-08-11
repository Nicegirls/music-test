package org.gaopengtao.musicinfo.dao;

import java.sql.ResultSet;

import org.gaopengtao.musicinfo.entity.CataLog;
import org.gaopengtao.musicinfo.entity.Music;
import org.gaopengtao.musicinfo.entity.MusicInfo;
import org.gaopengtao.musicinfo.entity.SingerInfo;

public interface MusicInfoDao {
	/**
	 * 修改乐曲信息
	 * 
	 * @param music
	 * @return
	 */
	public int updateMusicInfo(Music music);

	/**
	 * 通过歌名或者歌曲名或者曲风查询歌曲
	 * 
	 * @param ms
	 * @return
	 */
	public ResultSet selectMusic(String ms);

	/**
	 * 查询全部音乐
	 * 
	 * @return
	 */
	public ResultSet selectAllMusic();

	/**
	 * 判断歌曲ID是否已经存在
	 * 
	 * @param musicInfo
	 * @return
	 */
	public ResultSet isSame(MusicInfo musicInfo);

	/**
	 * 添加歌曲
	 * 
	 * @param musicinfo
	 * @return
	 */
	public int addMusic(Music music);

	/**
	 * 通过音乐ID删除音乐
	 * 
	 * @param musicinfo
	 * @return
	 */
	public int deleteMusic(MusicInfo musicinfo);

	/**
	 * 通过曲风删除音乐
	 * 
	 * @param catalog
	 * @return
	 */
	public int deleteMusic(CataLog catalog);

	/**
	 * 通过删除歌手删除音乐
	 * 
	 * @param singerinfo
	 * @return
	 */
	public int deleteMusic(SingerInfo singerinfo);

	/**
	 * 判断歌曲ID是否已经纯在
	 * 
	 * @param music
	 * @return
	 */
	public ResultSet isMusicid(Music music);

}
