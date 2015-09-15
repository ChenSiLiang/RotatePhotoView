package com.chensl.customview;

import android.util.Log;

/**
 * 打印日志信息
 *
 * @author ChenSL
 */
public final class MyLog {

    private static final String TAG = "photoview";
    private static final boolean ENABLE_INFO = true;
    private static final boolean ENABLE_ERROR = true;
    private static final boolean ENABLE_DEBUG = true;
    private static final boolean ENABLE_VERBOSE = false;
    private static final boolean ENABLE_WARN = false;
    private static MyLog mInstance = null;

    private static MyLog getInstance() {
        if (mInstance == null) {
            mInstance = new MyLog();
        }
        return mInstance;
    }

    public static void d(String message) {
        if (ENABLE_DEBUG) {
            Log.d(TAG, MyLog.getInstance().getFunctionName() + message);
        }
    }

    public static void e(String message) {
        if (ENABLE_ERROR) {
            Log.e(TAG, MyLog.getInstance().getFunctionName() + message);
        }
    }

    public static void i(String message) {
        if (ENABLE_INFO) {
            Log.i(TAG, MyLog.getInstance().getFunctionName() + message);
        }
    }

    public static void v(String message) {
        if (ENABLE_VERBOSE) {
            Log.v(TAG, MyLog.getInstance().getFunctionName() + message);
        }
    }

    public static void w(String message) {
        if (ENABLE_WARN) {
            Log.w(TAG, MyLog.getInstance().getFunctionName() + message);
        }
    }

    private String getFunctionName() {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }
        for (StackTraceElement st : sts) {
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals(this.getClass().getName())) {
                continue;
            }
            return "[ " + Thread.currentThread().getName() + ": "
                    + st.getFileName() + ":" + st.getMethodName() + ":"
                    + st.getLineNumber() + " ]  ";
        }

        return null;
    }

}
