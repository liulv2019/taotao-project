package com.taotao.sso.dao;

public interface JedisClient {

	
	String get(String key);
	
	String set(String key, String value);
	
	String hget(String hkey, String key);
	
	long hset(String hkey, String key, String value);
	
	/**
	 * 自增长
	 * @param key
	 * @return
	 */
	long incr(String key);
	
	/**
	 * 设置过期时间
	 * @param key
	 * @param second
	 * @return
	 */
	long expire(String key, int second);
	
	/**
	 * 查看过期时间
	 * @param key
	 * @return
	 */
	long ttl(String key);
	
	/**
	 * 删除
	 * @param key
	 * @return
	 */
	long del(String key);
	
	/**
	 * 
	 * @param hkey
	 * @param key
	 * @return
	 */
	long hdel(String hkey, String key);
}
