package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.util.TaotaoResult;

public interface ContentCategoryService {

	/**
	 * 查询内容分类列表
	 * @param parentId
	 * @return
	 */
	List<EUTreeNode> getCategoryList(long parentId);
	
	/**
	 * 增加内容分类
	 * @param parentId
	 * @param name
	 */
	TaotaoResult insertContentCategory(long parentId, String name);
	
	/**
	 * 删除内容分类
	 * @param parentId
	 * @param id
	 * @return
	 */
	TaotaoResult deleteContentCategory(long parentId, long id);
	
	/**
	 * 修改内容分类
	 * @param id
	 * @param name
	 * @return
	 */
	TaotaoResult updateContentCategory(long id, String name);
}
