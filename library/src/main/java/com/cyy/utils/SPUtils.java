package com.cyy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * @author :ChenYangYi
 * @date :2018/09/19/10:28
 * @description :对SharedPreference文件中的各种类型的数据进行存取操作
 * @github :https://github.com/chenyy0708
 */
public class SPUtils {

    private static SharedPreferences sp;

    private static void init(Context context) {
        if (sp == null) {
            sp = PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public static void setInt(Context context, String key, int value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putInt(key, value).apply();
    }

    public static void setLong(Context context, String key, Long value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putLong(key, value).apply();
    }

    public static int getInt(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getInt(key, 2);
    }

    public static void setLong(Context context, String key, long value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putLong(key, value).apply();
    }

    public static long getSharedlongData(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getLong(key, 0L);
    }

    public static void setFloat(Context context, String key,
                                float value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putFloat(key, value).apply();
    }

    public static Float getFloat(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getFloat(key, 0f);
    }

    public static void setBoolean(Context context, String key,
                                  boolean value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putBoolean(key, value).apply();
    }

    public static Boolean getBoolean(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getBoolean(key, false);
    }

    public static void setString(Context context, String key, String value) {
        if (sp == null) {
            init(context);
        }
        sp.edit().putString(key, value).apply();
    }

    public static String getString(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getString(key, "");
    }

    public static Long getLong(Context context, String key) {
        if (sp == null) {
            init(context);
        }
        return sp.getLong(key, 0);
    }

}