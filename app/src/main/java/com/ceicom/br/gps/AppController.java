package com.ceicom.br.gps;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by paulo on 27/01/2017.
 */

public class AppController extends Application{
    public static final String TAG = AppController.class.getSimpleName();

    private RequestQueue queue;

    private static AppController appController;

    @Override
    public void onCreate(){
        super.onCreate();
        appController = this;
    }

    public static synchronized AppController getInstance(){
        return appController;
    }

    public RequestQueue getRequestQueue(){
        if(queue == null){
            queue = Volley.newRequestQueue(getApplicationContext());
        }
        return queue;
    }

    public <T> void addParaQueue(Request<T> req, String tag){
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }


    public <T> void addParaQueue(Request<T> req){
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelarReqPendentes(Object tag){
        if(queue != null){
            queue.cancelAll(tag);
        }
    }
}
