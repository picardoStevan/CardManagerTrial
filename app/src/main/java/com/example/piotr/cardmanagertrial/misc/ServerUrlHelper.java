package com.example.piotr.cardmanagertrial.misc;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Piotr on 20.09.2015.
 */
public class ServerUrlHelper {
    private static final String baseUrl = " https://trello.com/1/boards/";
    private final Context mCtx;
    private String mBaseUrl = "";
    private String mMethod;
    private Uri.Builder mUri;
    private HashMap<Object, Object> mParamters;

    public ServerUrlHelper(Context context){
        mCtx = context;
        mBaseUrl = baseUrl + Constants.ID_BOARD+"/";
    }
    public ServerUrlHelper method(String method){
        mMethod = method;
        mUri = Uri.parse(mBaseUrl+method).buildUpon();
        mParamters = new HashMap<>();
        return this;

    }
    public ServerUrlHelper addParameter(String key, String value){
        mUri.appendQueryParameter(key,value);
        return this;
    }
    public String build() {
        if (mCtx == null)
            return "";

        addDefaultParameters(mCtx);

        String result = mUri.build().toString();

        if(mMethod == null) {
            Log.w(ServerUrlHelper.class.getSimpleName(), "Method name isn't set. Url = " + result);
        }

        clear();

        return result;
    }

    private void addDefaultParameters(Context mCtx) {
        mUri.appendQueryParameter("key",Constants.DEV_API_KEY);
    }

    protected void clear() {
        mMethod = null;
        mUri = null;
        mParamters = null;
        mBaseUrl = null;
    }

}
