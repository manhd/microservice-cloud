package com.haidm.spring.cn.untils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisTemplateUtil
 * @Description TODO
 * @Author sh-manhd
 * @Date 2019/6/21 9:40
 * @Version 1.0
 **/
@Component
public class RedisTemplateUtil {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;


    /*****************************string************************************/

    /**
     *@Author manhd
     *@Description string 类型 写入  redis
     *@Date 2019/6/21 9:52
     *@Param key  value
     *@Return boolean
    **/
    public boolean set(final String key, Object value){
        boolean result = false;
        try {
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            result = true;
        } catch (Exception e) {
            log.error("====redis set error (operType string)====");
            e.printStackTrace();
        }
        return result;
    }

    /**
     *@Author manhd
     *@Description string 类型 写入 redis  并设置失效时间
     *@Date 2019/6/21 9:52
     *@Param key  value
     *@Return boolean
     **/
    public boolean set(final String key, Object value,Long expireTime){
        boolean result = false;
        try {
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("====redis set error (operType string)====");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        try {
            result = null;
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            result = operations.get(key);
        } catch (Exception e) {
            log.error("redis get erro (operType string)");
            e.printStackTrace();
        }
        return result;
    }




    /**
     * 根据key删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }


    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }



    /************************************哈希*****************************************************/




    /**
     *@Author manhd
     *@Description 哈希 类型 写入  redis
     * 向一张hash表中放入数据,如果不存在将创建
     *@Date 2019/6/21 9:52
     *@Param key  value
     *@Return boolean
     **/
    public boolean hsSet(String key, Object hashKey, Object value){
        boolean result = false;
        try {
            HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
            hashOperations.put(key,hashKey,value);
            result = true;
        } catch (Exception e) {
            log.error("====redis set error (operType HASH)====");
            e.printStackTrace();
        }
        return result;
    }

    /**
     *@Author manhd
     *@Description 哈希 类型 写入 redis  并设置失效时间
     * 向一张hash表中放入数据,如果不存在将创建
     *@Date 2019/6/21 9:52
     *@Param key  value expireTime
     *@Return boolean
     **/
    public boolean hsSet(String key, Object hashKey, Object value, Long expireTime){
        boolean result = false;
        try {
            HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
            hashOperations.put(key,hashKey,value);
            if(expireTime > 0 ) redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("====redis set error (operType HASH)====");
            e.printStackTrace();
        }
        return result;
    }


    /**
     *@Author manhd
     *@Description 哈希 类型 写入 redis  并设置失效时间
     *@Date 2019/6/21 9:52
     *@Param key  map  expireTime
     *@Return boolean
     **/
    public boolean hsSet(String key, Map map, Long expireTime){
        boolean result = false;
        try {
            HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
            hashOperations.putAll(key,map);
            if(expireTime > 0) redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("====redis set error (operType HASH)====");
            e.printStackTrace();
        }
        return result;
    }




    /**
     *@Author manhd
     *@Description 哈希获取数据
     *@Date 2019/6/21 10:16
     *@param key
     *@param hashKey
     *@Return
    **/
    public Object hsGet(String key, Object hashKey){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }




    /**
     *@Author manhd
     *@Description 获取hashKey 对应的所有值
     *@Date 2019/6/21 10:23
     *@Param
     *@Return
    **/
    public Map hsKeyGet(Object hashKey){
        return redisTemplate.opsForHash().entries(hashKey);
    }

    
    /**
     *@Author manhd
     *@Description 删除hash表中的值
     * key 键 不能为null
     * item 项 可以使多个 不能为null
     *@Date 2019/6/21 10:33
     *@Param 
     *@Return 
    **/
    public void hsDel(String key, Object item){
        if(hsHasKey(key,item)){
            redisTemplate.opsForHash().delete(key, item);
        }
    }


    /**
     *@Author manhd
     *@Description 判断hash 表中是否有该项的值
     *@Date 2019/6/21 10:39
     *@Param
     *@Return
    **/
    public boolean hsHasKey(String key, Object item){
        return redisTemplate.opsForHash().hasKey(key, item);
    }


/********************************set**************************************/

    /**
    *@Author manhd
    *@Description 根据key 获取set 中的值
    *@Date 2019/6/21 10:52
    *@Param
    *@Return
    **/
    public Set sGet(String key){
    return redisTemplate.opsForSet().members(key);
    }

    /**
     *@Author manhd
     *@Description 在set 中添加值
     *@Date 2019/6/21 10:57
     *@Param
     *@Return
    **/
    public long sSet(String key, Object... value){
        try {
            Long add = redisTemplate.opsForSet().add(key, value);
            return add;
        } catch (Exception e) {
            log.error("====redis set error (operType set)====");
            e.printStackTrace();
            return 0;
        }

    }

    /**
     *@Author manhd
     *@Description 在set 中添加值
     *@Date 2019/6/21 10:57
     *@Param
     *@Return
     **/
    public long sSet(String key,Long expireTime, Object... value){

        try {
            Long result = redisTemplate.opsForSet().add(key, value);
            if(expireTime > 0 ) redisTemplate.expire(key,expireTime,TimeUnit.SECONDS);
            return result;
        } catch (Exception e) {
            log.error("====redis set error (operType set)====");
            e.printStackTrace();
        }
        return 0;

    }



    public long sRemove(String key, Object value){
        try {
            Long result = redisTemplate.opsForSet().remove(key, value);
            return result;
        } catch (Exception e) {
            log.error("====redis remove error (operType set)====");
            e.printStackTrace();
            return 0;
        }

    }


    /**
     *@Author manhd
     *@Description 根據value 判斷set中查詢，是否存在
     *@Date 2019/6/21 10:58
     *@Param
     *@Return
    **/
    public boolean sHasKey(String key, Object value){
        return redisTemplate.opsForSet().isMember(key, value);
    }


    /**************************************list**************************************/

    /**
     *@Author manhd
     *@Description list  类型获取数据
     *@Date 2019/6/21 13:22
     *@Param
     *@Return
    **/
    public List lGet(String key, long start, long  end){
        try {
            List range = redisTemplate.opsForList().range(key, start, end);
            return range;
        } catch (Exception e) {
            log.error("====redis range error (operType list)====");;
            e.printStackTrace();
            return null;
        }

    }

    /**
     *@Author manhd
     *@Description list 类型添加数据
     *@Date 2019/6/21 13:23
     *@Param
     *@Return
    **/
    public long lPush(String key, Object value){
        try {
            Long result = redisTemplate.opsForList().rightPushAll(key, value);
            return result;
        } catch (Exception e) {
            log.error("====redis rightPushAll error (operType list)====");;
            e.printStackTrace();
            return 0;
        }

    }


    /**
     *@Author manhd
     *@Description list 添加数据 并设置过期时间
     *@Date 2019/6/21 13:24long
     *@Param
     *@Return
    **/
    public long lPush(String key, Object value, Long expireTime){
        try {
            Long result = redisTemplate.opsForList().rightPushAll(key, value);
            if(expireTime > 0) redisTemplate.expire(key,expireTime,TimeUnit.SECONDS);
            return result;
        } catch (Exception e) {
            log.error("====redis rightPushAll error (operType list)====");
            e.printStackTrace();
            return 0;
        }

    }


    /**
     *@Author manhd
     *@Description 根据索引 修改  list 中的某条数据
     *@Date 2019/6/21 13:51
     *@Param
     *@Return
    **/
    public boolean lUpdateIndex(String key, long index, Object value){
        try {
            redisTemplate.opsForList().set(value, index, key);
            return true;
        } catch (Exception e) {
            log.error("====redis set error (operType list)====");;
            e.printStackTrace();
            return false;
        }
    }

    /**
     *@Author manhd
     *@Description 移除  count 个值为 value 的数据
     *@Date 2019/6/21 13:55
     *@Param
     *@Return
    **/
    public long lRemove(String key, long count, Object value){
        try {
            Long remove = redisTemplate.opsForList().remove(value, count, key);
            return remove;
        } catch (Exception e) {
            log.error("====redis remove error (operType list)====");;
            e.printStackTrace();
            return 0;
        }
    }

}
