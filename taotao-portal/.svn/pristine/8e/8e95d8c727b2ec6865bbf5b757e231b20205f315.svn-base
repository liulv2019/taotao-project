package com.taotao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.common.util.TaotaoResult;
import com.taotao.portal.pojo.CartItem;

public interface CartService {

	/**
	 * 加入购物车
	 * @param request
	 * @param response
	 * @param itemId
	 * @param num
	 * @return
	 */
	TaotaoResult addCartItem(HttpServletRequest request, HttpServletResponse response, long itemId, int num);
	
	/**
	 * 获取购物车列表
	 * @param request
	 * @param response
	 * @return
	 */
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 删除购物车商品
	 * @param itemId
	 * @param request
	 * @param response
	 * @return
	 */
	TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
