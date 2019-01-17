package com.hujiang.library.aspect;

import com.hujiang.library.AspectListenerImpl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareMixin;

/**
 * class description here
 *
 * @author simon
 * @version 1.0.0
 * @since 2017-05-12
 */
@Aspect
public class AbilityAspect {

    @DeclareMixin("*.AOPActivity")
    public AspectListener createDelegate() {
        return new AspectListenerImpl();
    }


}
