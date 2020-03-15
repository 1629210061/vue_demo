package com.hwh.vue_demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author hwh
 * @Date 2020/3/13 15:31
 **/
@Aspect
@Component
public class ControllerLogService {

    private final Logger logger = LoggerFactory.getLogger(ControllerLogService.class);

    @Pointcut("execution(* com.hwh.vue_demo.controller.*.*(..))")
    public void controllerLog(){}


    @Before("controllerLog()")
    public void beforeController(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        // 记录下请求内容
        logger.info("-----------URL : " + request.getRequestURL().toString());
        logger.info("-----------HTTP_METHOD : " + request.getMethod());
        logger.info("-----------IP : " + request.getRemoteAddr());
        logger.info("-----------THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));

        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("-----------CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }

}
