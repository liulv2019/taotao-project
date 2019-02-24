package com.taotao.service;

import com.taotao.common.pojo.EUIDataGridResult;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {

	/**
	 * 查询内容列表
	 * @param page
	 * @param rows
	 * @param categoryId
	 * @return
	 */
	EUIDataGridResult getContentList(Integer page, Integer rows, Long categoryId);
	
	
	/**
	 * 保存内容
	 * @param content
	 * @return
	 */
	TaotaoResult insertContent(TbContent content);
}
