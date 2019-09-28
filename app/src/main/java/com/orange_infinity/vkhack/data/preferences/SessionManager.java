package com.orange_infinity.vkhack.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String FILE_SETTINGS_NAME = "settingsFileName";
    private static final String IS_PLAYER_AUTH_KEY = "isPlayerAuth";
    private static final String PASSWORD_KEY = "password";
    private static final String BDATE_KEY = "bdate";
    private static final String GENERAL_INFO_KEY = "generalInfo";
    private static final String PROF_FIELD_KEY = "profField";
    private static final String LOGIN_KEY = "login";
    private static final String NICKNAME_KEY = "nickname";
    private static final String ID_KEY = "id";

    // Инициализация SharedPreferences
    public SessionManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(FILE_SETTINGS_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    // Сохранение дданных при регистрации
    public static void saveUserAuthData(String password, String login, String nickname) {
        editor.putString(PASSWORD_KEY, password); // Пароль
        editor.putString(LOGIN_KEY, login); // Почта
        editor.putString(NICKNAME_KEY, nickname); // Фимилия и имя (через пробел)
        editor.putBoolean(IS_PLAYER_AUTH_KEY, true);
        editor.apply();
    }

    // Сохранение инфы со страницы редактирования
    public static void saveInfoProfile(String bdate, String generalInfo, String profField){
        editor.putString(BDATE_KEY, bdate); // Дата рождения
        editor.putString(GENERAL_INFO_KEY, generalInfo); // Общая информация
        editor.putString(PROF_FIELD_KEY, profField); // Сфера деятельности
        editor.apply();
    }

    public static void saveId(int id){
        editor.putInt(ID_KEY, id); // Дата рождения
        editor.apply();
    }

    public static boolean isUserAuth() {
        return sharedPreferences.getBoolean(IS_PLAYER_AUTH_KEY, false);
    }

    public static void userLogOut() {
        editor.putBoolean(IS_PLAYER_AUTH_KEY, false);
        editor.apply();
    }



    // Получение имени и фамилии
    public static String getNickName(){
        return sharedPreferences.getString(NICKNAME_KEY, null);
    }

    // Получене Email
    public static String getEmail() {
        return sharedPreferences.getString(LOGIN_KEY, null);
    }

    public static String getPassword() {
        return sharedPreferences.getString(PASSWORD_KEY, null);
    }

    public static int getId() {
        return sharedPreferences.getInt(ID_KEY, 0);
    }

}
