package com.taotao.rest.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	@Test
	public void testJedisSingle() throws Exception {
		//创建一个jedis的对象
		Jedis jedis = new Jedis("47.107.182.64", 6379);
		//调用jedis对象的方法，方法名称和redis的命令一致
		jedis.set("key1", "jedis test");
		String string = jedis.get("key1");
		System.out.println(string);
		//关闭jedis
		jedis.close();
	}
	
	/**
	 * 使用连接池
	 */
	@Test
	public void testJedisPool() throws Exception {
		//创建连接池
		JedisPool jedisPool = new JedisPool("47.107.182.64", 6379);
		//从连接池中获取Jedis对象
		Jedis jedis = jedisPool.getResource();
		String string = jedis.get("key1");
		System.out.println(string);
		//关闭jedis对象
		jedis.close();
		//关闭连接池
		jedisPool.close();
	}
	
	/**
	 * 集群版测试
	 * 
	 */
	@Test
	public void testJedisCluster() throws Exception {
		
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("47.107.182.64", 7001));
		nodes.add(new HostAndPort("47.107.182.64", 7002));
		nodes.add(new HostAndPort("47.107.182.64", 7003));
		nodes.add(new HostAndPort("47.107.182.64", 7004));
		nodes.add(new HostAndPort("47.107.182.64", 7005));
		nodes.add(new HostAndPort("47.107.182.64", 7006));
		
		JedisCluster jedisCluster = new JedisCluster(nodes);
		
		jedisCluster.set("key1", "jedisCluster test");
		String string = jedisCluster.get("key1");
		System.out.println(string);
		
		jedisCluster.close();
	}
	
	/**
	 * 单机版测试
	 */
	@Test
	public void testSpringJedisSingle() throws Exception {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
		JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
		Jedis jedis = pool.getResource();
		String string = jedis.get("key1");
		System.out.println(string);
		jedis.close();
		pool.close();
	}
	
	@Test
	public void testSpringJedisCluster() throws Exception {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-jedis.xml");
		JedisCluster jedisCluster = (JedisCluster) applicationContext.getBean("redisClient");
		jedisCluster.set("key1", "test jedisCluster");
		String string = jedisCluster.get("key1");
		System.out.println(string);
		jedisCluster.close();
	}
	
}
