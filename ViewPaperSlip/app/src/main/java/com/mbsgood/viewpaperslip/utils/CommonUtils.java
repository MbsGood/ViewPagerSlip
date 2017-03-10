package com.mbsgood.viewpaperslip.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/*
* User: ChenCHaoXue
* Create date: 2017-03-10 
* Time: 14:50 
* From VCard
*/
public class CommonUtils {
    /*
    * 获得屏幕的宽度
    * */
    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
