package com.network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NetStart netStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        netStart = new NetStart();
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (netStart.isNetWorkNull()){
                    Log.e("qwe","isNetWorkNull");
                }
            }
        });


/*        new Thread(new Runnable() {
             @Override
             public void run() {
                 while(true){
                     try {
                         Thread.sleep(1000);
                         if (netStart.isWifiNetWork()){
                             Log.e("qwe","isWifiNetWork");

                             }else{
                             Log.e("qwe","is4g");
                         }

                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }).start();*/

/*        netStart.addNetWorkChangeListener(new NetStart.INetStartChangeListener() {
            @Override
            public void onNetWorkChange() {
               if (netStart.isNetWorkNull()){
                   Log.e("qwe","isNetWorkNull");
               }
            }
        });*/
    }
}
