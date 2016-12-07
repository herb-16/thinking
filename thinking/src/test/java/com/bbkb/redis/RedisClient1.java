package com.bbkb.redis;

import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/21<br>
 */
public class RedisClient1 {
    private JedisPool jedisPool;
    private ShardedJedisPool shardedJedisPool;

    public  static RedisClient1 redisClient1;
    public RedisClient1() {
        initialPool();
        initialShardPool();
    }

    public static RedisClient1 getRedisCilent1(){
        if (redisClient1 == null){
            synchronized (RedisClient1.class){
                redisClient1 = new RedisClient1();
            }
        }
        return redisClient1;
    }

    public Jedis getJedis(){
        return jedisPool.getResource();
    }

    public ShardedJedis getShardedJedis(){
        return shardedJedisPool.getResource();
    }
    private JedisPool initialPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(25);
        jedisPoolConfig.setMaxWaitMillis(1000l);
//      获取连接时检查有效性，默认false
        jedisPoolConfig.setTestOnBorrow(false);
        return new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
    }
    private ShardedJedisPool initialShardPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(25);
        jedisPoolConfig.setMaxWaitMillis(1000l);
        jedisPoolConfig.setTestOnBorrow(false);
        List<JedisShardInfo> shardInfos = new ArrayList<JedisShardInfo>();
        shardInfos.add(new JedisShardInfo("127.0.0.1",6379,"master"));
        return new ShardedJedisPool(jedisPoolConfig,shardInfos);
    }
    public void closed(){
        jedisPool.close();
        shardedJedisPool.close();
    }
}
