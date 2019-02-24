package com.taotao.rest.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.rest.dao.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisClientSingle implements JedisClient {

	@Autowired
	private JedisPool JedisPool;
	
	@Override
	public String get(String key) {

		Jedis jedis = JedisPool.getResource();
		String string = jedis.get(key);
		jedis.close();
		return string;
	}

	@Override
	public String set(String key, String value) {

		Jedis jedis = JedisPool.getResource();
		String string = jedis.set(key, value);
		jedis.close();
		return string;
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = JedisPool.getResource();
		String string = jedis.hget(hkey, key);
		jedis.close();
		return string;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis = JedisPool.getResource();
		Long redult = jedis.hset(hkey, key, value);
		jedis.close();
		return redult;
	}

	@Override
	public long incr(String key) {
		Jedis jedis = JedisPool.getResource();
		Long redult = jedis.incr(key);
		jedis.close();
		return redult;
	}

	@Override
	public long expire(String key, int second) {
		Jedis jedis = JedisPool.getResource();
		Long redult = jedis.expire(key, second);
		jedis.close();
		return redult;
	}

	@Override
	public long ttl(String key) {
		Jedis jedis = JedisPool.getResource();
		Long redult = jedis.ttl(key);
		jedis.close();
		return redult;
	}

	@Override
	public long del(String key) {
		
		Jedis jedis = JedisPool.getResource();
		Long redult = jedis.del(key);
		jedis.close();
		return redult;
	}

	@Override
	public long hdel(String hkey, String key) {

		Jedis jedis = JedisPool.getResource();
		Long redult = jedis.hdel(hkey, key);
		jedis.close();
		return redult;
	}

}
