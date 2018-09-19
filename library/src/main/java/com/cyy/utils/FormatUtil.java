package com.cyy.utils;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author :ChenYangYi
 * @date :2018/09/19/10:28
 * @description :手机、邮箱正则验证
 * @github :https://github.com/chenyy0708
 */
public class FormatUtil {
    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobiles) {
		/*
	    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188、178
	    联通：130、131、132、152、155、156、185、186、176
	    电信：133、153、180、189、（1349卫通）、177
	    总结起来就是第一位必定为1，第二位必定为3或5或8或7，其他位置的可以为0-9
		 */
        if (!TextUtils.isEmpty(mobiles)) {
            //"[1]"代表第1位为数字1，"[3458]"代表第二位可以为3、4、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
            String telRegex = "^1[3|4|5|7|8]\\d{9}$";
            Pattern pattern = Pattern.compile(telRegex);
            Matcher matcher = pattern.matcher(mobiles);
            return matcher.matches();
        }
        return false;
    }

    /**
     * 判断email格式是否正确
     *
     * @param email 邮箱
     * @return 是否是邮箱
     */
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    /**
     * 判断是否全是数字
     *
     * @param str 字符
     * @return 全是数字返回true
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断身份证格式
     */
    public static boolean isIdCardNo(String idNum) {
        //定义判别用户身份证号的正则表达式（要么是15位或18位，最后一位可以为字母）
        Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])");
        //通过Pattern获得Matcher
        Matcher idNumMatcher = idNumPattern.matcher(idNum);
        return idNumMatcher.matches();
    }

    /**
     * 检测String是否全是中文
     *
     * @param name 字符串
     * @return 是否为中文
     */
    public static boolean checkNameChese(String name) {
        boolean res = true;
        char[] cTemp = name.toCharArray();
        for (int i = 0; i < name.length(); i++) {
            if (!isChinese(cTemp[i])) {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * 判定输入汉字
     *
     * @param c 字符
     * @return 是否为汉字
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * 格式化手机号 隐藏关键位数
     * 将手机号变成 151****7788 格式
     */
    public static String phoneSetMiddleGone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        } else {
            if (phone.length() < 11) {
                return phone;
            } else {
                String sMiddle = phone.substring(3, 7);
                return phone.replaceFirst(sMiddle, "****");
            }
        }
    }

    /**
     * 格式化手机号 分隔手机号 3 4 4格式
     * 将手机号变成 151 2233 7788 格式
     */
    public static String phoneSetMiddleEmpty(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return "";
        } else {
            if (phone.length() < 11) {
                return phone;
            } else {
                StringBuilder sb = new StringBuilder(phone);
                sb.insert(7, "  ");
                sb.insert(3, "  ");
                return sb.toString();
            }
        }
    }

    /**
     * 文字转换Hmtl的格式固定不要动
     */
    private static final String SRM = "<font color=\"⊙\">%1$s</font>";
    /**
     * 替换颜色的字符
     */
    private static final String OF = "⊙";

    /**
     * @param tv      TextView
     * @param allText 全部文字
     * @param keyText 关键字
     * @param color   关键字颜色 Context.getResources().getColor(R.color.bg)
     */
    public static void setColorText(TextView tv, String allText, String keyText, int color) {
        String NF = String.format("#%06X", 0xFFFFFF & color);
        String replace = SRM.replace(OF, NF);
        String format = String.format(replace, keyText);
        try {
            String textStr = allText.replaceAll(keyText, format);
            Spanned spanned = Html.fromHtml(textStr);
            tv.setText(spanned);
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * 空值null返回"",防止脏数据奔溃
     */
    public static String checkValue(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }
}

