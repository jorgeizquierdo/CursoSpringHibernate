package com.hiberus.api.aop;

import com.hiberus.api.aop.annotation.RegisterLog;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Daniel on 18/06/2016.
 */
@Aspect
@Component
public class LogAspect {

    private int registerRequests = 0;

    @Pointcut("within(com.hiberus.api.controller.rest.*) || within(com.hiberus.api.controller.web.*)")
    public void anyController() {
    }

    @Before("anyController() && @annotation(registerLog)")
    public void afterAddOrUpdateOnlineUser(RegisterLog registerLog) throws Exception {

        System.out.println("Current register request: " + this.registerRequests++);
    }

}