package com.xhd.model;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:23
 * @Description: 标签
 * @version:
 */
public class Tag {
    private int id;

    //标签名
    private String tagName;

    //标签大小
    private int tagSize;

    public Tag(String tagName,int tagSize){
        this.tagName = tagName;
        this.tagSize = tagSize;
    }
}
