package net.neiquan.search.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 作者:  hjb
 * 时间: 2016/2/28.
 */
public class SharedPreferencesUtil {
    private static String APP_NAME = "neiquan";

    public SharedPreferencesUtil() {
    }

    public static void setDefaultFileName(String fileName) {
        APP_NAME = fileName;
    }

    public static boolean readIsFirstUse(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_NAME, 0);
        boolean isUse = preferences.getBoolean("firstUse", true);
        return isUse;
    }

    public static void writeIsFirstUse(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(APP_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("firstUse", false);
        editor.commit();
    }

    public static void add(Context context, Map<String, String> map) {
        Set set = map.keySet();
        SharedPreferences preferences = context.getSharedPreferences(APP_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        Iterator var6 = set.iterator();

        while(var6.hasNext()) {
            String key = (String)var6.next();
            editor.putString(key, (String)map.get(key));
        }

        editor.commit();
    }

    public static void add(Context context, String key, String content) {
        SharedPreferences preferences = context.getSharedPreferences(APP_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, content);
        editor.commit();
    }

    public static void add(Context context, String key, boolean flag) {
        SharedPreferences preferences = context.getSharedPreferences(APP_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, flag);
        editor.commit();
    }


    public static void delete(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(APP_NAME, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.commit();
    }

    public static String get(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(APP_NAME, 0);
        return preferences != null?preferences.getString(key, ""):"";
    }
}
