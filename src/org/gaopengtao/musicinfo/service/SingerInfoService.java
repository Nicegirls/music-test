package org.gaopengtao.musicinfo.service;

import java.util.Set;

import org.gaopengtao.musicinfo.entity.SingerInfo;

public interface SingerInfoService {
	/**
	 * 添加歌手
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean addSinger(SingerInfo singerInfo);

	/**
	 * 删除歌手
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean deteleSinger(SingerInfo singerInfo);

	/**
	 * 修改歌手
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean upDateSinger(SingerInfo singerInfo);

	/**
	 * 判断歌手ID是否存在
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean isSinger(SingerInfo singerInfo);

	/**
	 * 判断歌手名是否存在
	 * 
	 * @param singerInfo
	 * @return
	 */
	public boolean isSingerByname(SingerInfo singerInfo);
	/**
	 * 返回全部的歌手
	 * @return
	 */
	public Set allSinger();

}
