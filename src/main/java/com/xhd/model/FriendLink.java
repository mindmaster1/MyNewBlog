package com.xhd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:18
 * @Description: 友链
 * @version:
 */
@Data
@NoArgsConstructor
public class FriendLink {
    private int id;

    /**
     * 博主
     */
    private String blogger;

    /**
     * 博主url
     */
    private String url;

    public FriendLink(String blogger, String url){
        this.blogger = blogger;
        this.url = url;
    }
}
