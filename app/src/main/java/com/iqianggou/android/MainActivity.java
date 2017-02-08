package com.iqianggou.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.mobileim.YWChannel;
import com.alibaba.mobileim.channel.event.IWxCallback;

public class MainActivity extends Activity {

    public static final String TAG = "OpenIM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button im = (Button) findViewById(R.id.start_im);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIM();
            }
        });
    }

    private void startIM(){
        final String userId = "2556317";
        String password = "5779h2";
        //final String appkey = IMAutoLoginInfoStoreUtil.getAppk();
        final String appkey = "23055920";
        YWChannel.getInstance().getNetWorkState().isNetWorkNull();
        //LoginSampleHelper.getInstance().initSDK_Sample(AiQGApplication.getInstance());
        LoginSampleHelper.getInstance().login_Sample(userId, password, appkey, new IWxCallback() {
            @Override
            public void onSuccess(Object... objects) {
                Log.d(TAG, "login onSuccess at " + objects);
                LoginSampleHelper.getInstance().dochatWithServer(MainActivity.this);
            }

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onProgress(int i) {

            }
        });
    }
}
