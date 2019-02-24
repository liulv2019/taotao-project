package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

public interface UserService {

	/**
	 * 根据token获取用户信息
	 * @param token
	 * @return
	 */
	TbUser getUserByToken(String token);
}
