package com.orange_infinity.vkhack.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    private static final String FILE_SETTINGS_NAME = "settingsFileName";
    private static final String IS_PLAYER_AUTH_KEY = "isPlayerAuth";
    private static final String PASSWORD_KEY = "password";
    private static final String LOGIN_KEY = "login";
    private static final String NICKNAME_KEY = "nickname";

    public static void saveUserAuthData(
            Context context,
            String password,
            String login,
            String nickname
    ) {
        SharedPreferences settings = context.getSharedPreferences(
                FILE_SETTINGS_NAME,
                Context.MODE_PRIVATE
        );
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PASSWORD_KEY, password);
        editor.putString(LOGIN_KEY, login);
        editor.putString(NICKNAME_KEY, nickname);
        editor.putBoolean(IS_PLAYER_AUTH_KEY, true);
        editor.apply();
    }

    public static boolean isUserAuth(Context context) {
        SharedPreferences settings = context.getSharedPreferences(
                FILE_SETTINGS_NAME,
                Context.MODE_PRIVATE
        );
        return settings.getBoolean(IS_PLAYER_AUTH_KEY, false);
    }

    public static void userLogOut(Context context) {
        SharedPreferences settings = context.getSharedPreferences(
                FILE_SETTINGS_NAME,
                Context.MODE_PRIVATE
        );
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(IS_PLAYER_AUTH_KEY, false);
        editor.apply();
    }

}
