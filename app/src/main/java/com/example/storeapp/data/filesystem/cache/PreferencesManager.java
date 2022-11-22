package com.example.storeapp.data.filesystem.cache;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

public class PreferencesManager {

    private static final String PREFS_KEY = "prefs_key";

    private final SharedPreferences sharedPreferences;

    @Inject
    public PreferencesManager (Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getEditor () {
        return sharedPreferences.edit();
    }

    public void putInt (String key, int value) {
        getEditor().putInt(key, value).apply();
    }

    public void getInt (String key, int value) {
        sharedPreferences.getInt(key, -1);
    }
}
