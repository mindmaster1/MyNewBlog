package com.xhd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 9:04
 * @Description: 文章评论点赞记录
 * @version:
 */
//@NoArgsConstructor注解在类上，为类提供一个无参数构造方法
@Data
@NoArgsConstructor
public class CommentLikesRecord {
    private long id;

    //文章Id
    private long articleId;

    //评论ID
    private long pId;

    //点赞人
    private int likerId;

    //点赞时间
    private String likeDate;

    public CommentLikesRecord(long articleId,long pId,int likerId,String likeDate){
        this.articleId = articleId;
        this.likeDate = likeDate;
        this.likerId = likerId;
        this.pId = pId;

    }


}
