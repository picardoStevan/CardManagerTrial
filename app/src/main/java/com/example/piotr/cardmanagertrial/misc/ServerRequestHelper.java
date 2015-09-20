package com.example.piotr.cardmanagertrial.misc;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Piotr on 20.09.2015.
 */
public class ServerRequestHelper {

   private final Context mCtx;
   private RequestQueue mRequestQueue;
   private StringRequest stringRequest;
   private String TAG ="ServerRequestHelper";

   public ServerRequestHelper(Context ctx){
      mCtx = ctx;
      getRequestQueue();

   }
   public void MakeStringRequset(Context ctx,String url,final ServerRequestResponseListenr<String> callbackResponse, final ServerRequestOnErrorListenr<VolleyError> callbackError ){
      stringRequest = new StringRequest(0,url,callbackResponse,callbackError);
      addToRequestQueue(stringRequest);
   }

   public interface ServerRequestResponseListenr<T> extends Response.Listener<String> {


      @Override
      void onResponse(String s);
   }
   public interface ServerRequestOnErrorListenr<T> extends Response.ErrorListener {

      @Override
      void onErrorResponse(VolleyError volleyError);
   }
   public RequestQueue getRequestQueue() {
      if (mRequestQueue == null) {
         mRequestQueue = Volley.newRequestQueue(mCtx);
      }

      return mRequestQueue;
   }
   public <T> void addToRequestQueue(Request<T> req) {
      req.setTag(TAG);
      getRequestQueue().add(req);
   }

}
