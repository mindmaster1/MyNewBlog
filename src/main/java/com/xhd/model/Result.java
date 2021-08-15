package com.xhd.model;

import lombok.Data;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 14 - 10:21
 * @Description: 返回统一的响应格式
 * @version:
 */
@Data
public class Result<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}