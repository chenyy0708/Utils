package com.cyy.utils;

/**
 * @author : Guojin
 * <p>
 * 处理返回键点击事件
 * 后续功能待完善
 */
public final class KeyBackUtil {

    private static long mLastTime;

    /**
     * 返回键被连续两次按操作工具类
     * 返回键被点击的判断依据：
     * keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN
     *
     * @param interval 时间间隔
     * @param listener 事件点击监听
     */
    public static void setOnBackClickListener(long interval, OnBackClickListener listener) {

        long curTime = System.currentTimeMillis();
        if (curTime - mLastTime > interval) {
            mLastTime = curTime;
            listener.firstClick();
        } else {
            listener.secondClick();
        }
    }

    public interface OnBackClickListener {

        void firstClick();

        void secondClick();
    }
}
