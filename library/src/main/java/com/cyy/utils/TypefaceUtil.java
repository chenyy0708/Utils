package com.cyy.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Hashtable;

/**
 * @author : Guojin
 * <p>
 * 使用字体文件（.ttf）修改控件中文字的显示样式
 * <p>
 * 需要注意的是，.ttf 字体文件应该放在 `assets` 目录下
 */
public final class TypefaceUtil {

    private static final Hashtable<String, Typeface> cache = new Hashtable<>();

    /**
     * 替换指定控件的字体样式
     *
     * @param context  上下文
     * @param view     指定的 TextView 控件
     * @param fontPath 字体文件路径 eg: "font/test.ttf"
     */
    public static void replaceFont(Context context, TextView view, String fontPath) {
        try {
            Typeface tf = Typeface.createFromAsset(context.getAssets(), fontPath);
            view.setTypeface(tf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改整个 Activity 下的文字相关控件的文字样式
     *
     * @param activity 需要修改的界面
     * @param fontPath 字体文件路径（需在 assets 资源文件路径下）
     */
    public static void replaceFont(Activity activity, String fontPath) {
        replaceFont(getRootView(activity), fontPath);
    }


    /**
     * 通过遍历根布局下与 TextView 相关的控件，然后修改其中字体大样式
     *
     * @param root
     * @param fontPath
     */
    private static void replaceFont(View root, String fontPath) {
        if (null == root || TextUtils.isEmpty(fontPath)) {
            return;
        }

        if (root instanceof TextView) {
            //如果当前类型是 TextView 或其子类，则替换其字体
            TextView textView = (TextView) root;

            int style = Typeface.NORMAL;
            if (textView.getTypeface() != null) {
                style = textView.getTypeface().getStyle();
            }
            textView.setTypeface(createTypeface(root.getContext(), fontPath), style);
        } else if (root instanceof ViewGroup) {
            //如果是 ViewGroup 则遍历其下面的子 View, 然后执行本方法（递归）
            ViewGroup viewGroup = (ViewGroup) root;
            for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                replaceFont(viewGroup.getChildAt(i), fontPath);
            }
        }
    }


    /**
     * 从 Activity 中获取 rootView 的根节点
     *
     * @param context Activity 对象
     * @return 当前 Activity 布局的根节点
     */
    private static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }

    /**
     * 通过 字体文件(.ttf) 来获取该字体的对象
     *
     * @param c         上下文
     * @param assetPath 字体文件assets路径
     * @return .ttf 字体实例
     */
    private static Typeface createTypeface(Context c, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(c.getAssets(), assetPath);
                    cache.put(assetPath, t);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }

}
