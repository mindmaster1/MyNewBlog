package com.xhd.redis;

import javax.print.DocFlavor;

/**
 * @author:xinghaodong
 * @Date:2021 - 9 - 14 - 16:31
 * @Description:com.xhd.redis
 * @version:
 */
public interface RedisService {
    /**
     * 用于判断某个key在redis中是否存在
     */
    Boolean hashkey(String key);
}
