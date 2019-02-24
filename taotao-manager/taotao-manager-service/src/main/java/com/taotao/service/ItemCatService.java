package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;

public interface ItemCatService {

	/**
	 * 商品类目查询
	 * @param parentId
	 * @return
	 */
	List<EUTreeNode> getCatList(long parentId);
}
