package com.me.myshareprefrences;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference {
    private static final String PREFS_NAME = "user_pref";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String AGE = "age";
    private static final String PHONE_NUMBER = "phone";
    private static final String LOVE_MU = "islove";

    private final SharedPreferences preferences;

    UserPreference(Context context){
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setUser(UserModel user){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(NAME, user.getName());
        editor.putString(EMAIL, user.getEmail());
        editor.putInt(AGE, user.getAge());
        editor.putString(PHONE_NUMBER, user.getPhoneNumber());
        editor.putBoolean(LOVE_MU, user.isLove());
        editor.apply();
    }

    UserModel getUser(){
        UserModel model = new UserModel();
        model.setName(preferences.getString(NAME, ""));
        model.setEmail(preferences.getString(EMAIL, ""));
        model.setAge(preferences.getInt(AGE, 0));
        model.setPhoneNumber(preferences.getString(PHONE_NUMBER, ""));
        model.setLove(preferences.getBoolean(LOVE_MU, false));
        return model;
    }
}
