package com.sosaley.sosy.utils;

import android.content.Context;
import android.graphics.Typeface;

public class MathUtil {

    public static boolean validatePassword(String password) {
        if (password.length() < 6) {

            // ToastUtils.getInstance(SignUpActivity.this).showLongToast(R.string.short_password);
            return false;
        }
        return true;
    }

    public static boolean validateMobile(String mobile) {

        if (mobile.length() < 10) {
            return false;
        }
        return true;
    }

    public static Typeface getOctinPrisonFont(Context context){

        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"fonts/Roboto-Medium.ttf");

        return typeface;

    }

}
