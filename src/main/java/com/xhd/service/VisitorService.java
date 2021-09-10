package com.xhd.service;

import com.xhd.utils.DataMap;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 15 - 14:56
 * @Description:com.xhd.service
 * @version:
 */
@Service
public interface VisitorService {
    /**
     * 通过页名来增加访客量
     * @param pageName
     */
    DataMap addVistorNUmByPageName(String pageName, HttpServletRequest request);

    /**
     * 通过页名来获得访客量
     * @param pageName 页名
     * @return 访客量
     * */
    long getNumPageName(String pageName);

    /**
     * 发布文章后保存该文章的访客量
     * @param pageName 文章url
     */
    void insertVisitorArticlePage(String pageName);

    /**
     * 获得总访问量
     * @return
     */
    long getTotalVistor();

    /**
     * 通过页名更新访客人数
     */
    void updateVisitorNumByPageName(String pageName,String visitorNum);







}
