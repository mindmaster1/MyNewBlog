package com.xhd.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author:xinghaodong
 * @Date:2021 - 9 - 14 - 16:32
 * @Description: string类型的redis操作
 * @version:
 */
@Service
public class StringRedisServiceImpl implements RedisService{

    //springboot集成了redis spring-boot-start-data-redis
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 设置key和value，过期时间为-1
     */
    public void set(String key,Object value){
        //ValueOperations是操作简单的value例如String工具类 HashOperations是操作value为Map的工具类
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set(key,value);
    }

    public void set(String key,Object value,long timeout){
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set(key,value,timeout, TimeUnit.SECONDS);
    }

    //获取相关key的值
    public  Object get(String key){
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    /**
     * 获得key超时时间
     * @param key key值
     * @return 超时时间
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key);
    }

    /**
     * 设置key的超时时间(秒)
     */
    public Boolean expire(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 删除key-value
     * @param key key值
     */
    public void remove(String key){
        redisTemplate.delete(key);
    }

    /**
     * key的指定字段的整数值加上增量increment
     */
    public Long stringIncrement(String key, long increment){
        return redisTemplate.opsForValue().increment(key, increment);
    }


    @Override
    public Boolean hashkey(String key) {
        return redisTemplate.opsForValue().getOperations().hasKey(key);
    }

}
