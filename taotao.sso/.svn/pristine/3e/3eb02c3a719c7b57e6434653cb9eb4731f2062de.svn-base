package com.taotao.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taotao.common.util.TaotaoResult;
import com.taotao.pojo.TbUser;

public interface UserService {

	/**
	 * 校验用户信息
	 * @param content
	 * @param type
	 * @return
	 */
	TaotaoResult checkData(String content, Integer type);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	TaotaoResult createUser(TbUser user);
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	TaotaoResult userLogin(HttpServletRequest request, HttpServletResponse response, String username, String password);
	
	/**
	 * 接收token，到redis中查询token对应的用户信息。返回用户信息并更新过期时间
	 * @param token
	 * @return
	 */
	TaotaoResult getUserByToken(String token);
}