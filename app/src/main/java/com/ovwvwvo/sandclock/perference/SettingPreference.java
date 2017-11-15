package com.ovwvwvo.sandclock.perference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Copyright ©2016 by rawer
 */

public class SettingPreference extends BasePreference {
    private static final String FILENAME = "preference";

    private static final String FIRST_LAUNCH = "first_launch";
    private static final String DISPLAY_ADS = "show_ads";
    private static final String BACKGROUND_PATH = "background_path";


    public static void setFirstLaunch(Context context, boolean isFirstLaunch) {
        SharedPreferences.Editor editor = getEditor(context, FILENAME);
        editor.putBoolean(FIRST_LAUNCH, isFirstLaunch);
        editor.apply();
    }

    public static boolean getFirstLaunch(Context context) {
        SharedPreferences preferences = getPreference(context, FILENAME);
        return preferences.getBoolean(FIRST_LAUNCH, false);
    }

    public static void setDisplayAds(Context context, boolean isDisplayAds) {
        SharedPreferences.Editor editor = getEditor(context, FILENAME);
        editor.putBoolean(DISPLAY_ADS, isDisplayAds);
        editor.apply();
    }

    public static boolean getDisplayAds(Context context) {
        SharedPreferences preferences = getPreference(context, FILENAME);
        return preferences.getBoolean(DISPLAY_ADS, true);
    }

    public static void setBackgroundPath(Context context, String path) {
        SharedPreferences.Editor editor = getEditor(context, FILENAME);
        editor.putString(BACKGROUND_PATH, path);
        editor.apply();
    }

    public static String getBackgroundPath(Context context) {
        SharedPreferences preferences = getPreference(context, FILENAME);
        return preferences.getString(BACKGROUND_PATH, "");
    }
}
