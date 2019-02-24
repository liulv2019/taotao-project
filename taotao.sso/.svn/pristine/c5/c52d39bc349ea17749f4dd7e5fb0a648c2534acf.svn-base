package com.taotao.sso.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.taotao.common.util.CookieUtils;
import com.taotao.common.util.ExceptionUtil;
import com.taotao.common.util.JsonUtils;
import com.taotao.common.util.TaotaoResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.pojo.TbUserExample.Criteria;
import com.taotao.sso.dao.JedisClient;
import com.taotao.sso.service.UserService;

@Service
@Transactional
public class UserserviceImpl implements UserService {

	@Autowired
	private TbUserMapper userMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_USER_SESSION_KEY}")
	private String REDIS_USER_SESSION_KEY;
	@Value("${SSO_SESSION_EXPIRE}")
	private Integer SSO_SESSION_EXPIRE;
	
	@Override
	public TaotaoResult checkData(String content, Integer type) {

		try {
			TbUserExample example = new TbUserExample();
			Criteria criteria = example.createCriteria();
			//对数据进行校验：1、2、3分别代表username、phone、email
			if(1 == type){//用户名校验
				criteria.andUsernameEqualTo(content);
			}else if(2 == type){//电话校验
				criteria.andPhoneEqualTo(content);
			}else if(3 == type){//邮件校验
				criteria.andEmailEqualTo(content);
			}
			//执行查询
			List<TbUser> list = userMapper.selectByExample(example);
			if(list == null || list.size() == 0){
				return TaotaoResult.ok(true);
			}
			return TaotaoResult.ok(false);
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500,ExceptionUtil.getStackTrace(e));
		}
	}

	@Override
	public TaotaoResult createUser(TbUser user) {

		user.setCreated(new Date());
		user.setUpdated(new Date());
		//md5加密
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userMapper.insert(user);
		
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult userLogin(HttpServletRequest request, HttpServletResponse response, String username, String password) {

		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> userList = userMapper.selectByExample(example);
		//如果没有此用户
		if(null == userList || userList.size() == 0){
			return TaotaoResult.build(400, "用户名或密码错误");
		}
		TbUser user = userList.get(0);
		//对比密码
		if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())){
			return TaotaoResult.build(400, "用户名或密码错误");
		}
		
		//生成token
		String token = UUID.randomUUID().toString();
		//保存用户之前，把用户对象中的密码清空
		user.setPassword(null);
		//把用户信息写入redis
		jedisClient.set(REDIS_USER_SESSION_KEY + ":" + token, JsonUtils.objectToJson(user));
		//设置session过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
		
		//添加cookie的逻辑,cookie有效期默认是关闭浏览器就失效
		CookieUtils.setCookie(request, response, "TT_TOKEN", token);
		
		//返回token
		return TaotaoResult.ok(token);
	}

	@Override
	public TaotaoResult getUserByToken(String token) {

		//根据token从redis中查询用户信息
		String json = jedisClient.get(REDIS_USER_SESSION_KEY +":"+ token);
		//判断是否为空
		if(StringUtils.isBlank(json)){
			return TaotaoResult.build(400, "此session已经过期，请重新登录");
		}
		//跟新过期时间
		jedisClient.expire(REDIS_USER_SESSION_KEY +":"+ token, SSO_SESSION_EXPIRE);
		//返回用户信息
		return TaotaoResult.ok(JsonUtils.jsonToPojo(json, TbUser.class));
	}
	
	
	

}
