/*
 * ActivityAspect      2016-03-04
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */

package com.hujiang.library.aspect;

import android.support.annotation.AnimRes;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//import com.hujiang.common.util.ToastUtils;
//import com.hujiang.framework.app.RunTimeManager;

/**
 * activity aspect
 *
 * @author simon
 * @version 1.0.0
 * @since 2016-03-04
 */
@Aspect
public class ActivityAspect {

//    @Pointcut("execution(* android.app.Activity.onCreate(..))")
//    public void onCreateCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onResume())")
//    public void onResumeCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onPause(..))")
//    public void onPauseCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onStart(..))")
//    public void onStartCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onStop(..))")
//    public void onStopCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onDestroy(..))")
//    public void onDestroyCutPoint() {
//
//    }
    @Pointcut("within(com.hujiang.library.demo.Greeter+)")
    public void testImpl() {}


    /**
     *
     * @param joinPoint
     * @throws Throwable
     * 持有TraceDelay注解的任何类的任何方法，符合typePattern中的所有Joint Point
     */
    @After("within(@com.hujiang.library.aspect.TraceDelay *)")
    public void onUi(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "" + joinPoint.getSignature());
    }


    /**
     * 执行方法，方法执行时插入，匹配表达式
     * @param joinPoint
     * @throws Throwable
     */
    @After("execution(* android.app.Activity.on**(..))")
    public void onResumeMethod(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    ///////////
    @After("execution(* com.hujiang.library.demo.Greeter.**())")
    public void greeterAdvice(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    @After("testImpl()")
    public void greeterAdvice2(JoinPoint joinPoint) throws Throwable {
        Log.i("chao", "aspect:::" + joinPoint.getSignature());
    }

    @After("execution(* android.support.v4.app.Fragment.on**(..))")
    public void fragmentMethod(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    @After("call(* com.hujiang.library.demo.AspectJavaDemo.work())")
    public void aspectJavaDemoAdvice(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    @After("execution(* com.nostra13.universalimageloader.core.ImageLoader.displayImage(..))")
    public void aspectImageLoader(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    @After("execution(* com.hujiang.library.demo.NormalClass.**(..))")
    public void aspectNormalClass(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    /**
     * 替换了原来的代码，proceed执行
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution( * com.hujiang.library.demo.AOPActivity.onCreate(..))")
    public void aopActivityAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.proceed();

        Log.i("helloAOP", "aspect:::" + "------------>>>>>AOPActivity.onCreate");
    }
}