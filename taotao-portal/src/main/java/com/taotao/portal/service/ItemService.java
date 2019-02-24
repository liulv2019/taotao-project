package com.taotao.portal.service;

import com.taotao.portal.pojo.ItemInfo;

/**
 * 商品信息管理
 * @author Liulv
 * 2019年1月12日
 */
public interface ItemService {

	/**
	 * 取商品信息
	 * @param itemId
	 * @return
	 */
	ItemInfo geTbItemById(Long itemId);
	
	String getItemDescById(Long itemId);
	
	String getItemParam(Long itemId);
}
