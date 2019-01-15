package com.mvcoder.materialdesignlibdemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

public class MaterialDesignLibDemo extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
