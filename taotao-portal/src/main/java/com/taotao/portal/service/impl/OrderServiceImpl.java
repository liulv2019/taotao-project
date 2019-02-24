package com.taotao.portal.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.util.HttpClientUtil;
import com.taotao.common.util.JsonUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbUser;
import com.taotao.portal.pojo.Order;
import com.taotao.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	
	@Override
	public String createOrder(HttpServletRequest request, Order order) {

		//补全用户信息,从cookie中回去TT_TOKEN内容，根据tt_token获取用户信息
		TbUser user = (TbUser) request.getAttribute("user");
		order.setUserId(user.getId());
		order.setBuyerNick(user.getUsername());
		//调用taotao-order的服务提交订单。
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL,  JsonUtils.objectToJson(order));
		//把json转换成taotaoResult
		TaotaoResult result = TaotaoResult.format(json);
		if(result.getStatus() == 200){
			Object orderId = result.getData();
			return orderId.toString();
		}
		
		return "";
	}

}
