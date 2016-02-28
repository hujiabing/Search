package net.neiquan.search.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * 作者:  hjb
 * 时间: 2016/2/28.
 */
public class PixelUtil {
    public PixelUtil() {
    }

    public static int dp2px(Context context, float value) {
        float scale = (float)context.getResources().getDisplayMetrics().densityDpi;
        return (int)(value * (scale / 160.0F) + 0.5F);
    }

    public static int px2dp(float value, Context context) {
        float scale = (float)context.getResources().getDisplayMetrics().densityDpi;
        return (int)(value * 160.0F / scale + 0.5F);
    }

    public static int sp2px(float value, Context context) {
        Resources r;
        if(context == null) {
            r = Resources.getSystem();
        } else {
            r = context.getResources();
        }

        float spvalue = value * r.getDisplayMetrics().scaledDensity;
        return (int)(spvalue + 0.5F);
    }

    public static int px2sp(float value, Context context) {
        float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(value / scale + 0.5F);
    }

    public static int getScreenWidth(Context activity) {
        new DisplayMetrics();
        DisplayMetrics dm = activity.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static float getScreenWidthDp(Context activity) {
        new DisplayMetrics();
        DisplayMetrics dm = activity.getResources().getDisplayMetrics();
        return dm.xdpi;
    }

    public static int getScreenHeight(Activity activity) {
        new DisplayMetrics();
        DisplayMetrics dm = activity.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}
