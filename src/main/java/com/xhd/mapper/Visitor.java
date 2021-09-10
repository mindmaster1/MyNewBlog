package com.xhd.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 18 - 11:37
 * @Description:com.xhd.mapper
 * @version:
 */
@Mapper
@Repository
public interface Visitor {

    @Insert("insert into visitor(visitorNum,pageName) values(0,#{pageName})")
    void save(String pageName);

    @Select("select * from visitor where pageName=#{pageName}")
    Visitor getVisitorNumByPageName(@Param("pageName") String pageName);

    @Select("select visitorNum from visitor where pageName='totalVisitor'")
    long getTotalVisitor();

    @Update("update visitor set visitorNum=#{visitorNum} where pageName=#{pageName}")
    void updateVisitorNumByPageName(@Param("pageName") String pageName, @Param("visitorNum") String visitorNum);
}
