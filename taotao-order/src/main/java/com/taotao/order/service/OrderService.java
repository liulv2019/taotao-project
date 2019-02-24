package com.taotao.order.service;

import java.util.List;

import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbOrder;
import com.taotao.pojo.TbOrderItem;
import com.taotao.pojo.TbOrderShipping;

/**
 * 订单管理
 * @author Liulv
 * 2019年1月16日
 */
public interface OrderService {

	/**
	 * 新增订单
	 * @param order
	 * @param orderItem
	 * @param orderShippingss
	 * @return
	 */
	TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}
