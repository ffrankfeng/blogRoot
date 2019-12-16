package test;

import com.fengf.common.utils.JedisPoolUtil;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDemo {
    private Jedis jedis = null;

    /**
     * 单连接
     */
    @Test
    public void jedisSingleConn(){
        String host = "106.14.147.163";
        int port = 6379;
        Jedis jedis = new Jedis(host, port);
        jedis.set("name","张三");
        jedis.set("age","18");
        String s = jedis.get("name");
        String s1 = jedis.get("age");
        System.out.println(s);
        System.out.println(s1);
    }

    /**
     * 连接池连接
     */
    @Test
    public void jedisPoolConn(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMinIdle(10);
        jedisPoolConfig.setMaxIdle(15);
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
        //取数据
        jedis.set("name","xy");
        jedis.set("age","21");
        String s1 = jedis.get("name");
        String s2 = jedis.get("age");
        System.out.println(s1);
        System.out.println(s2);
    }

    /**
     * 连接池连接
     * 工具类
     */
    @Test
    public void jedisPoolConn1(){
//        Jedis jedis = JedisPoolUtil.getJedis();
//        //取数据
//        jedis.set("name","xy");
//        jedis.set("age","21");
//        String s1 = jedis.get("name");
//        String s2 = jedis.get("age");
//        System.out.println(s1);
//        System.out.println(s2);
    }
}