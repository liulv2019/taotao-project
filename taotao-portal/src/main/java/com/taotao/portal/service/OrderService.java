package com.taotao.portal.service;

import javax.servlet.http.HttpServletRequest;

import com.taotao.portal.pojo.Order;

public interface OrderService {

	/**
	 * 新增订单
	 * @param order
	 * @return
	 */
	String createOrder(HttpServletRequest request, Order order);
}
