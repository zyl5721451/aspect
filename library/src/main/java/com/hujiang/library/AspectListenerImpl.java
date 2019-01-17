package com.hujiang.library;

import com.hujiang.library.aspect.AspectListener;

/**
 * Created by allenzhang on 2019/1/17.
 */
public class AspectListenerImpl implements AspectListener {
    @Override
    public String getName() {
        return "getMyname";
    }
}
