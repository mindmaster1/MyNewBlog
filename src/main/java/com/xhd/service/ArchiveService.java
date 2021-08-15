package com.xhd.service;

import com.xhd.utils.DataMap;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 15 - 10:46
 * @Description: 归档业务操作
 * @version:
 */
public interface ArchiveService {
    /**
     * 获得归档信息，包括文章名字和文章数量
     * @return
     */
    DataMap findArchiveNameAndArticleNum();

    /**
     * 添加归档信息
     * @parame archiveName
     */
    void addArchiveName(String archiveName);
}
