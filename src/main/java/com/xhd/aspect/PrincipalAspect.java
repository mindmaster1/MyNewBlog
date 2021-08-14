package com.xhd.aspect;

import com.xhd.constant.CodeType;
import com.xhd.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import com.xhd.aspect.annotation.PermissionCheck;

import java.util.Collection;

/**
 * @author:xinghaodong
 * @Date:2021 - 8 - 08 - 16:25
 * @Description: 定义切面，拦截所有需要登陆操作的controller接口
 * @version:
 */
/*
@Aspect:作用是把当前类标识为一个切面供容器读取
@Component表明当前类为组件类，并告知spring为这个类创建一个bean对象到容器中

 */
@Aspect
@Component
@Slf4j
public class PrincipalAspect {
    //定义一个匿名用户
    public static final String ANONYMOUS_USER = "annoymousUser";

    @Pointcut("execution(public * com.xhd.controller..*(..))")
    public void login(){

    }

    @Around(("login()&&@annotation(permissionCheck)"))
    /**
     * Authentication用来表示用户认证信息，保存在SecurityContextHolder所持有的SecurityContext中，供后续的程序调用
     */
    public Object principalAround(ProceedingJoinPoint pjp, PermissionCheck permissionCheck) throws Throwable {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loginName = auth.getName();
        //开始检验登陆情况
        //没有登陆
        if (loginName.equals(ANONYMOUS_USER)) {
            return JsonResult.fail(CodeType.USER_NOT_LOGIN).toJson();
        }
        //接口权限拦截
        Collection<? extends GrantedAuthority> authority = auth.getAuthorities();
        String value = permissionCheck.value();
        for (GrantedAuthority g : authority) {
            if (g.getAuthority().equals(value)) {
                return pjp.proceed();
            }
        }
        log.error("[{}] has no access to the [{}] method ", loginName, pjp.getSignature().getName());
        return JsonResult.fail(CodeType.PERMISSION_VERIFY_FAIL).toJson();
    }
}