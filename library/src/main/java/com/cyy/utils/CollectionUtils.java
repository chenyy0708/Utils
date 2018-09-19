package com.cyy.utils;

import java.util.Collection;

/**
 * @author :ChenYangYi
 * @date :2018/09/19/12:53
 * @description :判断集合是否为空 长度是否为0
 * @github :https://github.com/chenyy0708
 */

public class CollectionUtils {

    /**
     * 判断集合是否为null或者0个元素
     *
     * @param c 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Collection c) {
        return null == c || c.isEmpty() || c.size() <= 0;
    }
}
