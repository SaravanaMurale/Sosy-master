package com.sosaley.sosy.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class PreferenceUtil {

    public static final String SHARED_PREF_NAME="sosy";
    public static final String HOME_ITEM_ID="home_item_id";
    public static final String ROOM_CLICKED_STATUS="room_clicked_status";
    public static final String DOOR_ROOM_CLICKED_STATUS="door_room_clicked_status";
    public static final String AIR_QUALITY_CLICKED_STATUS="air_quality_clicked_status";
    public static final String ROOM_TEMP_CLICKED_STATUS="room_temp_clicked_status";
    public static final String INTRUDER_ROOM_CLICKED_STATUS="intruder_room_clicked_status";
    public static final String BATTER_MONITORING_CLICKED_STATUS="battery_clicked_status";

    public static void setValueString(Context context, String key, String value) {

        if (context == null) return;
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();

    }

    public static String getValueString(Context context, String key) {

        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        return preferences.getString(key, null);

    }


    public static void setValueSInt(Context context, String key, int value) {

        if (context == null) return;
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();

    }

    public static int getValueInt(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        return preferences.getInt(key, -1);

    }

    public static void remove(Context contextRemoveRewardID,String key){

        SharedPreferences removeRewardID = contextRemoveRewardID.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = removeRewardID.edit();
        editor.remove(key);
        editor.commit();


    }


}
