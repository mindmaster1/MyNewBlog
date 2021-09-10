package com.xhd.service.impl;

import com.xhd.mapper.ArchiveMapper;
import com.xhd.service.ArchiveService;
import com.xhd.service.ArticleService;
import com.xhd.utils.DataMap;
import com.xhd.utils.TimeUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 15 - 10:47
 * @Description:  获得所有归档日期以及每个归档日期的文章数目
 * @version:
 * @service: Service层的注解类，代表将当前类向spring容器内注册
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveMapper archiveMapper;
    @Autowired
    ArticleService  articleService;

    //获取归档信息，包括文章数量、文章名字
    @Override
    public DataMap findArchiveNameAndArticleNum() {
        //获得归档下所有文章的名字
        List<String> archives = archiveMapper.findArchive();
        JSONArray archivesJsonArray = new JSONArray();
        JSONObject archiveJson;

        TimeUtil timeUtil = new TimeUtil();

        for(String archiveName : archives){
            //注意：这里每次循环都要重新创建一个archiveJson;
            archiveJson = new JSONObject();
            archiveJson.put("archiveName",archiveName);
            //时间中的年转换为横杠
            archiveName = timeUtil.timeYearToWhippletree(archiveName);
            archiveJson.put("archiveArticleNum",articleService.countArticleArchiveByArchive(archiveName));
            archivesJsonArray.put(archiveJson);
        }
        JSONObject returnJson = new JSONObject();
        returnJson.put("result",archivesJsonArray);
        return DataMap.success().setData(returnJson);
    }

    @Override
    public void addArchiveName(String archiveName) {
            int archiveNameisExist = archiveMapper.findArchiveNameByArchiveName(archiveName);
        if(archiveNameisExist == 0){
            archiveMapper.save(archiveName);
        }

    }
}
