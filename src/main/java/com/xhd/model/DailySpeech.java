package com.xhd.model;

import lombok.Data;

import java.util.Date;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:15
 * @Description: 日常寄语
 * @version:
 */
@Data
public class DailySpeech {
    //每天说的话
    private String content;

    //每天的心情
    private String mood;

    //图片url拼接后的字符串
    private String picsUrl;

    //发布日期
    private Date publishDate;

}
