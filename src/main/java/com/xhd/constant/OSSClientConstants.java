package com.xhd.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 13 - 10:21
 * @Description:阿里云连接密钥
 * @version:
 */
@Component
public class OSSClientConstants {
    /*
    阿里云API的外网域名
     */
    public static final String ENDPOINT = "oss-cn-beijing.aliyuncs.com";

    //阿里云API的密钥Access Key ID
    public static String ACCESS_KEY_ID;

    //阿里云的密钥Access Key Secret
    public static String ACCESS_KEY_SECRET;

    //aliyunAPI的bucket名称
    public static final String BUCKET_NAME="xhd-myblog";

    //在阿里云上创建文件夹，分类管理图片
    public static final String FOLDER = "public/";
    //该注解的作用是将我们配置文件的属性读出来，有@Value(“${}”)和@Value(“#{}”)两种方式
    @Value("${aliyun.accessKeyId}")
    public void setAccessKeyId(String accessKeyId){
        ACCESS_KEY_ID = accessKeyId;
    }
    @Value("${aliyun.secret}")
    public void setAccessKeySecret(String accessKeySecret){
        ACCESS_KEY_SECRET  = accessKeySecret;
    }

}
