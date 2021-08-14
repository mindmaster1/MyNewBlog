package com.xhd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:21
 * @Description: 在留言中点赞
 * @version:
 */
@Data
@NoArgsConstructor
public class LeaveMessageLikesRecord {
    private long id;

    /**
     * 文章页
     */
    private String pageName;

    /**
     * 评论的id
     */
    private int pId;

    /**
     * 点赞人
     */
    private int likerId;

    /**
     * 点赞时间
     */
    private String likeDate;

    public LeaveMessageLikesRecord(String pageName, int pId, int likerId, String likeDate) {
        this.pageName = pageName;
        this.pId = pId;
        this.likerId = likerId;
        this.likeDate = likeDate;
    }
}
