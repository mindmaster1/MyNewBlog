package com.xhd.model;

import lombok.Data;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:17
 * @Description:com.xhd.model
 * @version:
 */
@Data
public class FeedBack {
    private int id;

    /**
     * 反馈内容
     */
    private String feedbackContent;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 反馈人
     */
    private int personId;

    /**
     * 反馈时间
     */
    private String feedbackDate;
}
