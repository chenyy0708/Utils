package com.cyy.utils;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * @author :ChenYangYi
 * @date :2018/09/19/10:28
 * @description :监听多个EditText输入文字是否完全，可以指定每个EditText的输入限制
 * @github :https://github.com/chenyy0708
 */
public class EditTextUtils {
    /**
     * EditText集合
     */
    private EditText[] mEditTexts;
    /**
     * 每个EditText输入个数长度触发值
     */
    private Integer[] mInputLimit;
    /**
     * 输入完成监听
     */
    private EditTextInputListener listener;
    /**
     * 默认不限制
     */
    public static final int NORMAL_LIMIT = -1;

    private EditTextUtils(Builder builder) {
        this.mEditTexts = builder.mEditTexts;
        this.mInputLimit = builder.mInputLimit;
        this.listener = builder.listener;
        // 如果没有输入限制个数集合，新建一个默认的
        if (mInputLimit == null) {
            mInputLimit = new Integer[mEditTexts.length];
            for (int i = 0; i < mEditTexts.length; i++) {
                mInputLimit[i] = NORMAL_LIMIT;
            }
        }
        // 设置监听
        for (EditText editText : mEditTexts) {
            editText.addTextChangedListener(new NewTextWatcher());
        }
    }

    class NewTextWatcher implements TextWatcher {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            // 默认全部输入了文字
            boolean isAllInput = true;
            // 判断所有的EditText是否都输入了字
            for (int i = 0; i < mEditTexts.length; i++) {
                // EditText内容为空，或者达不到最少限制字数条件则判断没有输入完成
                String mStr = mEditTexts[i].getText().toString().trim();
                // 当前EditText对应输入限制值
                Integer limit = mInputLimit[i];
                // 输入内容不为空
                boolean a = TextUtils.isEmpty(mStr);
                // 当前EditText没有输入限制的话，直接false，如果有输入限制，需要判断当前字符长度是否小于限制字符
                boolean b = limit != NORMAL_LIMIT && mStr.length() < limit;
                if (a || b) {
                    isAllInput = false;
                    // 已有空的EditText，跳出循环
                    break;
                }
            }
            // 返回结果
            if (isAllInput) {
                if (listener != null)
                    listener.onSuccess();
            } else {
                if (listener != null)
                    listener.onError();
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
    }

    public static class Builder {
        /**
         * EditText集合
         */
        private EditText[] mEditTexts;
        /**
         * 每个EditText输入个数长度触发值
         */
        private Integer[] mInputLimit;
        /**
         * 输入完成监听
         */
        private EditTextInputListener listener;

        /**
         * 添加监听EditText
         */
        public Builder addEditTexts(EditText... editTexts) {
            mEditTexts = editTexts.clone();
            return this;
        }

        /**
         * 添加EditText限制
         */
        public Builder addInputLimit(Integer... inputLimit) {
            this.mInputLimit = inputLimit.clone();
            return this;
        }

        public Builder addOnInputListener(EditTextInputListener listener) {
            this.listener = listener;
            return this;
        }

        public EditTextUtils build() {
            if (mInputLimit != null && mInputLimit.length != mEditTexts.length) {
                throw new IllegalArgumentException("EditText数组长度 和 限制字符数组 长度必须相同");
            }
            return new EditTextUtils(this);
        }
    }

    public interface EditTextInputListener {
        void onSuccess();

        void onError();
    }
}
