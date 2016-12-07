package com.bbkb.redis;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/18<br>
 */
public class RedisClient {
    private JedisPool jedisPool;//非切片连接池

    private ShardedJedisPool shardedJedisPool;//切片连接池

    private static RedisClient redisClient;

    private RedisClient(){
        initialPool();
        initialSharedPool();
    }

    public static RedisClient getRedisClient(){
        if (redisClient == null){
            synchronized (RedisClient.class){
                if (redisClient == null) redisClient = new RedisClient();
            }
        }
        return redisClient;
    }

    public Jedis getJedis(){
        return jedisPool.getResource();
    }

    public ShardedJedis getShardedJedis() {
        return shardedJedisPool.getResource();
    }

    /**
     * 初始化非切片池
     */
    private void initialPool(){
        //池基本配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxWaitMillis(1000l);
        jedisPoolConfig.setTestOnBorrow(false);

        jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379);
    }

    /*
    * 初始化切片池
    * */
    private void initialSharedPool(){
        //池基本配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxWaitMillis(1000l);
        jedisPoolConfig.setTestOnBorrow(false);
        //slave链接
        List<JedisShardInfo> shardInfos = new ArrayList<JedisShardInfo>();
        shardInfos.add(new JedisShardInfo("127.0.0.1",6379,"master"));
        //构造池
        shardedJedisPool = new ShardedJedisPool(jedisPoolConfig,shardInfos);
    }

    public void Close(){
        jedisPool.close();
        shardedJedisPool.close();
    }


}
