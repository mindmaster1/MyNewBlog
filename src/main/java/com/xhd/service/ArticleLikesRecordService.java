package com.xhd.service;

import com.xhd.model.ArticleLikesRecord;
import com.xhd.utils.DataMap;
import org.springframework.stereotype.Service;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 15 - 14:55
 * @Description:com.xhd.service
 * @version:
 */
@Service
public interface ArticleLikesRecordService {
    /**
     * 文章是否已经点过赞
     * @param articleId 文章id
     * @param username 点赞人
     * @return true--已经点过赞  false--没有点赞
     */
    boolean isLiked(long articleId, String username);

    /**
     * 保存文章中点赞的记录
     * @param articleLikesRecord
     */
    void insertArticleLikesRecord(ArticleLikesRecord articleLikesRecord);

    /**
     * 通过文章id删除文章点赞记录
     * @param articleId 文章id
     */
    void deleteArticleLikesRecordByArticleId(long articleId);

    /**
     * 获得文章点赞信息
     */
    DataMap getArticleThumbsUp(int rows, int pageNum);

    /**
     * 已读一条点赞记录
     */
    DataMap readThisThumbsUp(int id);

    /**
     * 已读所有点赞记录
     */
    DataMap readAllThumbsUp();
}
