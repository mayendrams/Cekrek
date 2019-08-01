package com.mayendrams.cekrek.SharedPreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.mayendrams.cekrek.Login;
import com.mayendrams.cekrek.MainActivity;
import com.mayendrams.cekrek.Opening;

import java.util.HashMap;

public class Session {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAMA = "NAMA";
    public static final String EMAIL = "EMAIL";
    public static final String PHOTO = "FOTOPROFIL";


    public Session(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String nama, String email, String photo) {

        editor.putBoolean(LOGIN, true);
        editor.putString(NAMA, nama);
        editor.putString(EMAIL, email);
        editor.putString(PHOTO, photo);

        editor.apply();

    }

    public boolean isLoggin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin() {

        if (!this.isLoggin()) {
            Intent i = new Intent(context, Login.class);
            context.startActivity(i);
            ((MainActivity) context).finish();
        }
    }


    public HashMap<String, String> getUserDetail() {

        HashMap<String, String> user = new HashMap<>();
        user.put(NAMA, sharedPreferences.getString(NAMA, null));
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));
        user.put(PHOTO, sharedPreferences.getString(PHOTO, null));
        return user;
    }

    public void logout() {
        editor.clear();
        editor.commit();
        Intent i = new Intent(context, Opening.class);
        context.startActivity(i);
        ((MainActivity) context).finish();


    }

    public void hapus() {
        editor.clear();
        editor.commit();


    }
}
