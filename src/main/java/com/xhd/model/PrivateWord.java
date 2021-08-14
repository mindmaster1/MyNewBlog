package com.xhd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:21
 * @Description: 悄悄话
 * @version:
 */
@Data
@NoArgsConstructor
public class PrivateWord {
    private int id;

    /**
     * 悄悄话内容
     */
    private String privateWord;

    /**
     * 发布者
     */
    private int publisherId;

    /**
     * 回复者
     */
    private int  replierId;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 发布时间
     */
    private String publisherDate;

    public PrivateWord(String privateWord, int publisherId, String publisherDate) {
        this.privateWord = privateWord;
        this.publisherId = publisherId;
        this.publisherDate = publisherDate;
    }
}
