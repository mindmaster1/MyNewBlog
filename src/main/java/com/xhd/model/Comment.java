package com.xhd.model;

import lombok.Data;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 8:41
 * @Description: 文章评论
 * @version:
 */
@Data
public class Comment {
    private long id;
    //留言的文章ID
    private long articleId;
    //回复的父id 若是评论则为 0，若是评论中的回复则为对应评论的id ?
    private long pId = 0;

    //评论者
    private int answerId;

    //被回复者
    private int respondentId;

    //评论日期
    private String commentDate;

    //喜欢数
    private int likes = 0;

    //评论内容
    private String commentContent;

    //该评论的状态，是否已读 1---未读    0----已读
    private int isRead = 1;











}
