package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service("log")
@Aspect // Aspect = Pointcut + Advice
public class Log4jAdvice {

//    @Pointcut( "execution( * com.springbook.biz..*Impl.*(..) )" )
//    public void allPointcut(){}
//
//    @Pointcut( "execution( * com.springbook.biz..*Impl.get*(..) )" )
//    public void getPointcut(){}

    @Before("PointcutCommon.allPointcut()")
    public void printLogging() {
        System.out.println("[공통 로그-Log4j] 비즈니스 로직 수행 전 동작");
    }
}
