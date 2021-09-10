package com.xhd.service.impl;

import com.xhd.component.StringAndArray;
import com.xhd.constant.SiteOwner;
import com.xhd.mapper.ArticleMapper;
import com.xhd.model.Article;
import com.xhd.service.*;
import com.xhd.utils.DataMap;
import com.xhd.utils.StringUtil;
import com.xhd.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    @Autowired
    private VisitorService visitorService;
    @Autowired
    private ArchiveService archiveService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentLikesRecordService commentLikesRecordService;

    //插入新文章
    @Override
    public DataMap insertArticle(Article article) {
        //HashMap源码中initialCapacity的初始值为16，负载因子为0.75；设置初始容量可以节约空间
        Map<String,Object> datamap = new HashMap<>(6);
        //定义文章原作者
        if(StringUtil.BLANK.equals(article.getOriginalAuthor())){
            article.setOriginalAuthor(article.getAuthor());
        }
        //定义文章URL
        if(StringUtil.BLANK.equals(article.getArticleUrl())){
            String url = SiteOwner.SITE_OWNER_URL + "/article/" +article.getArticleId();
            article.setArticleUrl(url);
        }

        Article endArticleId = articleMapper.findEndArticleId();
        //确保当前归档内至少有一篇文章，从而可以设置当前文章的上一篇文章
        if(endArticleId!=null){
            article.setLastArticleId(endArticleId.getArticleId());
        }
        articleMapper.save(article);

        //判断文章的归档日期是否存在，不存在就插入到归档日期中
        TimeUtil timeUtil = new TimeUtil();
        //获取到归档日期archiveName
        String  archiveName = timeUtil.timeWhippletreeToYear(article.getPublishDate());
        archiveService.addArchiveName(archiveName);

        //新文章加入访客量
        visitorService.insertVisitorArticlePage("article/"+article.getArticleId());
        //设置上一篇文章的下一篇文章id
        if(endArticleId != null){
            articleService.updateArticleLastOrNextId("nextArticleId",article.getArticleId(),endArticleId.getArticleId());
        }
        return  DataMap.success().setData(datamap);
    }

    @Override
    public DataMap updateArticleById(Article article) {
        //是原创，要表示原创作者信息
        Article a = articleMapper.getArticleByArticleId(article.getArticleId());
        if("原创".equals(article.getArticleType())){
            article.setOriginalAuthor(article.getAuthor());
            String url = SiteOwner.SITE_OWNER_URL+"/article/"+a.getArticleId();
            article.setArticleUrl(url);
        }

        //
        articleMapper.updateArticleById(article);
        Map<String,Object> dataMap =  new HashMap<>(4);
        dataMap.put("articleTitle",article.getArticleTitle());
        dataMap.put("updateDate",article.getUpdateDate());
        dataMap.put("author",article.getAuthor());
        dataMap.put("articleUrl","/article/"+article.getArticleUrl());

        return DataMap.success().setData(dataMap);
    }

    @Override
    public DataMap getArticleByArticleId(long articleId, String username) {
        Article article = articleMapper.getArticleByArticleId(articleId);

        if(article != null){
            Map<String,Object> dataMap = new HashMap<>(32);
            Article lastArticle = articleMapper.findArticleByArticleId(article.getLastArticleId());
            Article NextArticle = articleMapper.findArticleByArticleId(article.getNextArticleId());
            dataMap.put("author",article.getAuthor());
            dataMap.put("articleId",article.getArticleId());
            dataMap.put("originalAutor",article.getOriginalAuthor());
            dataMap.put("articleTitle",article.getArticleTitle());
            dataMap.put("publishDate",article.getPublishDate());
            dataMap.put("updateDate",article.getUpdateDate());
            dataMap.put("articleContent",article.getArticleContent());
            dataMap.put("articleTags", StringAndArray.stringToArray(article.getArticleTags()));
            dataMap.put("articleType",article.getArticleType());
            dataMap.put("articleCategories",article.getArticleCategories());
            dataMap.put("articleUrl",article.getArticleUrl());
            dataMap.put("likes",article.getLikes());
            if(username == null){
                dataMap.put("isLiked",0);
            }else{
                if(articleLikesRecordService.isLiked(articleId,username)){

                }
            }
        }

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
