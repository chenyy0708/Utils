package com.cyy.utils;


import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;


/**
 * @author :ChenYangYi
 * @date :2018/09/19/10:28
 * @description :Logger 开启关闭
 * @github :https://github.com/chenyy0708
 */
public class LogUtils {
    /**
     * 是否调试模式
     */
    private static boolean DEBUG_ENABLE;

    /**
     * 在application调用初始化
     */
    public static void init(boolean debug) {
        DEBUG_ENABLE = debug;
        FormatStrategy formatStrategy;
        if (DEBUG_ENABLE) {
            formatStrategy = PrettyFormatStrategy.newBuilder()
                    .showThreadInfo(true)
                    .methodCount(2)
                    .methodOffset(0)
                    .tag("HoRen")
                    .build();
        } else {
            formatStrategy = PrettyFormatStrategy.newBuilder()
                    .showThreadInfo(false)
                    .methodCount(3)
                    .methodOffset(2)
                    .tag("HoRen")
                    .build();
        }
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }

    public static void d(String tag, String message) {
        if (DEBUG_ENABLE) {
            Logger.d(tag, message);
        }
    }

    public static void d(String message) {
        if (DEBUG_ENABLE) {
            Logger.d(message);
        }
    }

    public static void e(Throwable throwable, String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.e(throwable, message, args);
        }
    }

    public static void e(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.e(message, args);
        }
    }

    public static void i(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.i(message, args);
        }
    }

    public static void v(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.v(message, args);
        }
    }

    public static void w(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.v(message, args);
        }
    }

    public static void wtf(String message, Object... args) {
        if (DEBUG_ENABLE) {
            Logger.wtf(message, args);
        }
    }

    public static void json(String message) {
        if (DEBUG_ENABLE) {
            Logger.json(message);
        }
    }

    public static void xml(String message) {
        if (DEBUG_ENABLE) {
            Logger.xml(message);
        }
    }
}
