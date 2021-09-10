package com.xhd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 18 - 7:54
 * @Description:com.xhd.mapper
 * @version:
 */
@Repository
@Mapper
public interface ArchiveMapper {
    //获得归档下文章名字
    @Select("select archiveName from archives order by id desc")
    List<String> findArchive();

    //添加归档信息
    @Insert("insert into archives(archivesName) values(#{archiveName})")
    void save(@Param("archiveName") String archiveName);

    //通过所给文章名字判断在归档中是否存在所给文章，如果不存在返回0
    @Select("select IFNULL(max(id),0) form archives where archiveName=#{archiveName}")
    int findArchiveNameByArchiveName(@Param("archiveName") String archiveName);


}
