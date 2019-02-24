package com.taotao.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.taotao.common.util.CookieUtils;
import com.taotao.pojo.TbUser;
import com.taotao.portal.service.impl.UserServiceImpl;

/**
 * 登录拦截器
 * @author Liulv
 * 2019年1月14日
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private UserServiceImpl userService;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// 返回ModelAndView之后
		//响应用户中(一般的取异常)

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// Handler执行之后，返回ModelAndView之前

	}

	/**
	 * 在Handler执行之前处理,返回值决定是否执行，true执行，false不执行。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//从cookie中取token
		String token = CookieUtils.getCookieValue(request, "TT_TOKEN");
		//根据token换取用户信息，调用sso系统的接口
		TbUser user = userService.getUserByToken(token);
		//取不到用户信息，重定向到登录页面，把用户请求的url作为参数传递给登录页面，返回false
		if(null == user){
			response.sendRedirect(userService.SSO_BASE_URL + userService.SSO_PAGE_LOGIN + "?redirect=" + request.getRequestURL());
			//返回false
			return false;
		}
		//把用户信息放入request中
		request.setAttribute("user", user);
		//取到用户信息，放行true
		return true;
	}

}
