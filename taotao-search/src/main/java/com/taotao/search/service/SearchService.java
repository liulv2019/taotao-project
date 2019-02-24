package com.taotao.search.service;

import com.taotao.search.pojo.SearchResult;

/**
 * 搜索service
 * @author Liulv
 *
 */
public interface SearchService {

	/**
	 * 搜索
	 * @param queryString
	 * @param page
	 * @param rows
	 * @return
	 */
	SearchResult search(String queryString, int page, int rows) throws Exception;
}
