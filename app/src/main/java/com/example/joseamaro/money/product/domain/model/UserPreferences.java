package com.example.joseamaro.money.product.domain.model;

import android.content.Context;

import com.core.data.local.preferences.Preferences;

import javax.inject.Inject;

/**
 * Created by joseamaro on 19-06-19.
 */

public class UserPreferences extends Preferences {

    enum Key {email, islogin}

    @Inject
    public UserPreferences(Context context) {
        super(context);
    }

    @Override
    public String getName() {
        return "UserPreferences";
    }

    public String getEmail() {

        return getString(Key.email);
    }

    public void saveEmail(String value) {
        save(Key.email, value);
    }

    public boolean isLogin() {
        return getBool(Key.islogin);
    }

    public void saveLogin(boolean value) {
        save(Key.islogin, value);
    }
}
