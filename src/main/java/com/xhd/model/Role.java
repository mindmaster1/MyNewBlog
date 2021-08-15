package com.xhd.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:23
 * @Description: 权限
 * @version:
 */
@Data
@NoArgsConstructor
public class Role {
    private int id;
    private String name;

    public Role(int id,String name){
        this.id = id;
        this.name = name;
    }

}
