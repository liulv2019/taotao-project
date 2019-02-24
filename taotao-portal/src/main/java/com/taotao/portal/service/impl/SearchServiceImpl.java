package com.taotao.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.util.HttpClientUtil;
import com.taotao.common.util.TaotaoResult;
import com.taotao.portal.pojo.SearchResult;
import com.taotao.portal.service.SearchService;

/**
 * 查询服务
 * @author Liulv
 * 2019年1月11日
 */
@Service
public class SearchServiceImpl implements SearchService {

	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;
	
	@Override
	public SearchResult search(String queryString, int page) {

		//查询参数
		Map<String, String> map = new HashMap<>();
		map.put("q", queryString);
		map.put("page", page + "");
		try {
			//调用taotao-search的服务
			String jsonData = HttpClientUtil.doGet(SEARCH_BASE_URL,map);
			//把字符串转换成java对象
			TaotaoResult taotaoResult = TaotaoResult.formatToPojo(jsonData, SearchResult.class);
			if(taotaoResult.getStatus() == 200){
				SearchResult result = (SearchResult) taotaoResult.getData();
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
