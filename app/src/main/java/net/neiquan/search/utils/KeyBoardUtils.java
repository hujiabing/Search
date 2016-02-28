package net.neiquan.search.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者:  hjb
 * 时间: 2016/2/28.
 */
public class KeyBoardUtils {
    public KeyBoardUtils() {
    }

    public static void openKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager)mContext.getSystemService("input_method");
        imm.showSoftInput(mEditText, 2);
        imm.toggleSoftInput(2, 1);
    }

    public static void hideSoftInput(EditText et) {
        InputMethodManager is = (InputMethodManager)et.getContext().getSystemService("input_method");
        is.hideSoftInputFromWindow(et.getWindowToken(), 0);
    }

    public static void close(Context context) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService("input_method");
        imm.toggleSoftInput(0, 2);
    }

    public static void showSoftInput(final EditText et, int time) {
        time = time == 0?998:time;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                InputMethodManager inputManager = (InputMethodManager)et.getContext().getSystemService("input_method");
                inputManager.showSoftInput(et, 0);
            }
        }, (long)time);
    }

    public static void closeKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager)mContext.getSystemService("input_method");
        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
