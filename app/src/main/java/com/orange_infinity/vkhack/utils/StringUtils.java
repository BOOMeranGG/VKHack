package com.orange_infinity.vkhack.utils;

import android.text.TextUtils;

public class StringUtils {

    public static final String MAIN_TAG = "MAIN_TAG";

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
