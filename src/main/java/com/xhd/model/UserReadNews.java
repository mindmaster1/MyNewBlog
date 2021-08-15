package com.xhd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:23
 * @Description:c 用户留言评论未读数
 * @version:
 */
@Data
@NoArgsConstructor
public class UserReadNews implements Serializable
{
    /**
     * 留言+评论未读数
     */
    private int allNewsNum;

    /**
     * 评论未读数
     */
    private int commentNum;

    /**
     * 留言未读数
     */
    private int leaveMessageNum;

    public UserReadNews(int allNewsNum, int commentNum, int leaveMessageNum) {
        this.allNewsNum = allNewsNum;
        this.commentNum = commentNum;
        this.leaveMessageNum = leaveMessageNum;
    }
}
