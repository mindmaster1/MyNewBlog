package com.xhd.model;

import lombok.Data;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 9:19
 * @Description: 文章统计
 * @version:
 */
@Data
public class Article {
    private static final long serialVersionUID = 1L;

    //文章id
    private long articleId;

    //文章作者
    private String author;

    //文章原作者
    private String originalAuthor;

    //文章名
    private String articleTitle;

    //发布时间
    private String publishDate;

    //最后一次修改时间
    private String updateDate;

    //文章内容
    private String articleContent;

    //文章标签
    private String articleTags;

    //文章类型
    private String articleType;

    //博客分类
    private  String articleCategories;

    //文章链接
    private String articleUrl;

    //文章摘要
    private String articleTabloid;

    //上一篇文章id
    private long lastArticleId;

    //下一篇文章id
    private long nextArticleId;

    //喜欢
    private int likes = 0;


}
