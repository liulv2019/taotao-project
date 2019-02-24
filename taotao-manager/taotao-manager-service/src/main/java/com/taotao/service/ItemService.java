package com.taotao.service;

import com.taotao.common.pojo.EUIDataGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	
	/**
	 * 商品列表查询
	 * @param page
	 * @param rows
	 * @return
	 */
	EUIDataGridResult getItemList(int page,int rows);
	
	/**
	 * 添加商品
	 * @param item
	 * @return
	 */
	TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception;
	
}
