package com.sosaley.sosy.dhome.dutils;

import android.util.Patterns;
import android.widget.Toast;

public class Validation {


    public static boolean validateEmptyString(String string) {
        if (string.isEmpty() || string.equals("") || string.equals(null)) {
            return false;
        }
        return true;


    }

    public static boolean validateName(String name) {

        if (name.length() < 3) {
            return false;
        }

        return true;

    }

    public static boolean validateEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern) && email.length() > 0){
            return true;
        }

        return false ;
    }

    public static boolean validateMobileNumber(String mobile) {

        String regex = "(0/91)?[7-9][0-9]{9}";

        if(Patterns.PHONE.matcher(mobile).matches()){
            return true;
        }

        return false;
    }

    public static boolean validateMobileNumberLength(String mobile){

        if(mobile.length()<10){
            return false;
        }
        return true;

    }

    public static boolean validatePassword(String password) {
        if (password.length() < 6) {

            // ToastUtils.getInstance(SignUpActivity.this).showLongToast(R.string.short_password);
            return false;
        }
        return true;
    }



}
