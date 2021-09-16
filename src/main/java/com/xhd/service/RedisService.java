package com.xhd.service;

import com.xhd.model.UserReadNews;
import com.xhd.redis.HashRedisServiceImpl;
import com.xhd.redis.StringRedisServiceImpl;
import com.xhd.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author:xinghaodong
 * @Date:2021 - 9 - 14 - 16:27
 * @Description:com.xhd.service
 * @version: redis相关业务逻辑
 */
@Service
public class RedisService {
    @Autowired
    StringRedisServiceImpl stringRedisServiceImpl;
    @Autowired
    HashRedisServiceImpl hashRedisServiceImpl;
    @Autowired
    UserService userService;

    /**
     * 获得redis用户的未读消息
     */
    public DataMap getUserNews(String username) {
        Map<String, Object> dataMap = new HashMap<>(2);
        int userId = userService.findIdByUsername(username);
        LinkedHashMap map = (LinkedHashMap) hashRedisServiceImpl.getAllFieldAndValue(String.valueOf(userId));
        if (map.size() == 0) {
            dataMap.put("result", 0);
        } else {
            int allNewNum = (int) map.get("allNewsNum");
            int commentNum = (int) map.get("commentNum");
            int leaveMessageNum = (int) map.get("leaveMessageNum");
            UserReadNews news = new UserReadNews(allNewNum, commentNum, leaveMessageNum);
            dataMap.put("result", news);
        }
        return DataMap.success().setData(dataMap);
    }

    //已读一条消息时修改redis中的未读消息
    public void readOneMsgOnRedis(int userId, int msgType) {
        LinkedHashMap map = (LinkedHashMap) hashRedisServiceImpl.getAllFieldAndValue(String.valueOf(userId));
        int allNewsNum = (int) map.get("allNewsNum");
        hashRedisServiceImpl.hashIncrement(String.valueOf(userId), "allNewsNum", -1);
        //如果总留言评论数为0则删除key
        if (--allNewsNum == 0) {
            hashRedisServiceImpl.hashDelete(String.valueOf(userId), UserReadNews.class);
        } else if (msgType == 1) {
            hashRedisServiceImpl.hashIncrement(String.valueOf(userId), "commensNum", -1);
        } else {
            hashRedisServiceImpl.hashIncrement(String.valueOf(userId), "leadveMessageNums", -1);
        }
    }

    //已读所有消息时修改redis中的未读消息
    public void readAllMsgOnrRedis(int userId, int msgType) {
        LinkedHashMap map = (LinkedHashMap) hashRedisServiceImpl.getAllFieldAndValue(String.valueOf(userId));
        int commentNum = (int) map.get("commentNum");
        int leaveMessageNum = (int) map.get("leaveMessageNum");
        if (commentNum == 0 || leaveMessageNum == 0) {
            //通过实体类删除了指定Key下的所有字段
            hashRedisServiceImpl.hashDelete(String.valueOf(userId), UserReadNews.class);
        } else if (msgType == 1) {
            hashRedisServiceImpl.hashIncrement(String.valueOf(userId), "allNewsNum", -commentNum);
            hashRedisServiceImpl.hashIncrement(String.valueOf(userId), "commentNum", -commentNum);
        } else {
            hashRedisServiceImpl.hashIncrement(String.valueOf(userId), "allNewsNum", -leaveMessageNum);
            hashRedisServiceImpl.hashIncrement(String.valueOf(userId), "leaveMessageNum", -leaveMessageNum);
        }

    }

    //修改redis中的点赞未读量
    public void readThumbsUpRecocrdOnRedis(String key, int increment) {
        boolean thumbsUpNotReadExist = stringRedisServiceImpl.hashkey(key);
        if (!thumbsUpNotReadExist) {
            stringRedisServiceImpl.set(key, 1);
        } else {
            stringRedisServiceImpl.stringIncrement(key, increment);
        }
    }

    //增加redis中的访客量
    public Long addVistorNumOnRedis(String key, Object field, long increment) {
        boolean fieldExist = hashRedisServiceImpl.hasHashKey(key, field);
        if (fieldExist) {
            return hashRedisServiceImpl.hashIncrement(key, field, increment);
        }
        return null;
    }

    //向redis中保存访客量
    public Long putVistorNumOnRedis(String key, Object field, Object value) {
        hashRedisServiceImpl.put(key,field,value);
        return Long.valueOf(hashRedisServiceImpl.get(key,field).toString());
    }

    //获得redis中的访客记录
    public Long getVistorNumOnRedis(String key, Object field) {
        boolean fieldExist = hashRedisServiceImpl.hasHashKey(key, field);
        if (fieldExist) {
            return Long.valueOf(hashRedisServiceImpl.get(key, field).toString());
        }
        return null;
    }
}



















