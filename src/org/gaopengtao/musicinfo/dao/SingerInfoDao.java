package org.gaopengtao.musicinfo.dao;

import java.sql.ResultSet;
import org.gaopengtao.musicinfo.entity.SingerInfo;

public interface SingerInfoDao {
	/**
	 * 通过歌手名称查询对应的歌曲
	 * 
	 * @param singerInfo
	 * @return
	 */
	public ResultSet selectSingerByname(SingerInfo singerInfo);

	/**
	 * 修改歌手名
	 * 
	 * @param music
	 * @return
	 */
	public int updateSinger(SingerInfo singerInfo);

	/**
	 * 添加歌手
	 * 
	 * @param singerInfo
	 * @return
	 */
	public int addSinger(SingerInfo singerInfo);

	/**
	 * 删除歌手
	 * 
	 * @param singerInfo
	 * @return
	 */
	public int deteleSinger(SingerInfo singerInfo);

	/**
	 * 判断歌手ID是否存在
	 * 
	 * @return
	 */
	public ResultSet isSingerid(SingerInfo singerInfo);

	/**
	 * 判断歌手名是否存在
	 * 
	 * @param singerInfo
	 * @return
	 */
	public ResultSet isSingerName(SingerInfo singerInfo);
	/**
	 * 查询全部的歌手
	 * @return
	 */
	public ResultSet allSinger();
}
