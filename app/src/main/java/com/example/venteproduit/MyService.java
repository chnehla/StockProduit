package com.example.venteproduit;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
//creation de java class de service puis on a va créer onclick event from produitlist activity
public class MyService  extends Service {

    private  static final String TAG = "MyService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public int onStartCommand(Intent intent , int flags , int startId){
        CountDownTimer countDownTimer= new CountDownTimer(60000, 10000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.e(TAG,"onTick"+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Log.e(TAG, "onFinish");
            }
        }.start();

        return START_STICKY;
    }
}
