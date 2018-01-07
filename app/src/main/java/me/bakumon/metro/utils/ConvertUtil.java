package me.bakumon.metro.utils;

import me.bakumon.metro.App;

/**
 * @author Bakumon
 * @date 2018/1/7
 */

public class ConvertUtil {
    /**
     * dp 转 px
     *
     * @param dpValue dp 值
     * @return px 值
     */
    public static int dp2px(final float dpValue) {
        final float scale = App.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
