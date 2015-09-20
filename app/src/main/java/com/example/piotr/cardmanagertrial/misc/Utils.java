package com.example.piotr.cardmanagertrial.misc;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.example.piotr.cardmanagertrial.R;

/**
 * Created by Piotr on 20.09.2015.
 */
public class Utils {
    private final Context mCtx;
    private SharedPreferences sharedPreferences;
    public static final String DEV_API_KEY= "kDevApi";
    public static final String DEV_SECRET = "kSecret";

    public Utils(Context context) {
        initSharedPreferences(context);
        mCtx = context;

    }

    private static SharedPreferences initSharedPreferences(Context context) {
        return context.getSharedPreferences(context.getResources().getString(R.string.sharedID),Context.MODE_PRIVATE);
    }
    private static void saveValues(Context context,String key,String value){
        SharedPreferences sharedPreferences = initSharedPreferences(context);
        sharedPreferences.edit().putString(key,value).commit();
    }
    public static void saveDevApiKey(@NonNull Context context,String apiKey){
        if(context==null)return;
        saveValues(context,DEV_API_KEY,apiKey);
    }
    public static String getDevApiKey(@NonNull Context context){
        if(context==null)return null;
        SharedPreferences sharedPreferences = initSharedPreferences(context);
        return sharedPreferences.getString(DEV_API_KEY, "");

    }
    public static void saveDevSecret(@NonNull Context context,String secret){
        if(context==null)return;
        saveValues(context,DEV_SECRET,secret);
    }
    public static String getDevSecret(@NonNull Context context){
        if(context==null)return null;
        SharedPreferences sharedPreferences = initSharedPreferences(context);
        return sharedPreferences.getString(DEV_SECRET, "");

    }

}
