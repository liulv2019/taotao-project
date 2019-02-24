package com.taotao.rest.service;

import com.taotao.common.util.TaotaoResult;

public interface RedisService {

	/**
	 * 接收内容分类id，调用dao删除redis中对应的hash中key为分类id的项
	 * @param contentCid
	 * @return
	 */
	TaotaoResult syncContent(long contentCid);
}
