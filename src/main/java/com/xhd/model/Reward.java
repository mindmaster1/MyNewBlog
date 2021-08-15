package com.xhd.model;

import lombok.Data;

import java.util.Date;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:22
 * @Description: 募捐
 * @version:
 */
@Data
public class Reward {
    private int id;

    /**
     * 募捐人
     */
    private String fundRaiser;

    /**
     * 募捐来源
     */
    private String fundRaisingSources;

    /**
     * 募捐去处
     */
    private String fundraisingPlace;

    /**
     * 募捐金额
     */
    private float rewardMoney;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 募捐日期
     */
    private Date rewardDate;

    /**
     * 募捐证书url
     */
    private String rewardUrl;
}
