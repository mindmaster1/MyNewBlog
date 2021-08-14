package com.xhd.aspect.annotation;

import java.lang.annotation.*;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 08 - 16:24
 * @Description:com.xhd.aspect.annotation
 * @version:
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PermissionCheck {
    String value();
}
