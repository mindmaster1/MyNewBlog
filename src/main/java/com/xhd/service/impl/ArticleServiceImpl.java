package com.xhd.service.impl;

import com.xhd.mapper.ArticleMapper;
import com.xhd.model.Article;
import com.xhd.service.ArticleLikesRecordService;
import com.xhd.service.ArticleService;
import com.xhd.utils.DataMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 15 - 10:47
 * @Description: impl of Article ArticleService
 * @version:
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleLikesRecordService articleLikesRecordService;



    @Override
    public DataMap insertArticle(Article article) {
        return null;
    }

    @Override
    public DataMap updateArticleById(Article article) {
        return null;
    }

    @Override
    public DataMap getArticleByArticleId(long articleId, String username) {
        return null;
    }

    @Override
    public Map<String, String> findArticleByArticleId(long id) {
        return null;
    }

    @Override
    public DataMap findAllArticles(int rows, int pageNum) {
        return null;
    }

    @Override
    public void updateArticleLastOrNextId(String lastOrNext, long lastOrNextArticleId, long articleId) {

    }

    @Override
    public DataMap updateLikeByArticleId(long articleId) {
        return null;
    }

    @Override
    public DataMap findArticleByTag(String tag, int rows, int pageNum) {
        return null;
    }

    @Override
    public DataMap findArticleByCategory(String category, int rows, int pageNum) {
        return null;
    }

    @Override
    public DataMap findArticleByArchive(String archive, int rows, int pageNum) {
        return null;
    }

    @Override
    public DataMap getDraftArticle(Article article, String[] articleTags, int articleGrade) {
        return null;
    }

    @Override
    public DataMap getArticleManagement(int rows, int pageNum) {
        return null;
    }

    @Override
    public Article findArticleById(int id) {
        return null;
    }

    @Override
    public int countArticleCategoryByCategory(String category) {
        return 0;
    }

    @Override
    public int countArticleArchiveByArchive(String archive) {
        return 0;
    }

    @Override
    public int countArticle() {
        return 0;
    }

    @Override
    public DataMap deleteArticle(long id) {
        return null;
    }
}
