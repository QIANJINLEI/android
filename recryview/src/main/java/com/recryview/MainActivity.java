package com.recryview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRly;
    private ArrayList<String> data;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRly = (RecyclerView) findViewById(R.id.rlv);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        data = new ArrayList<>();
        for (int i=0;i<100;i++){
            data.add(i,"第"+i+"个！");
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1 :
                mRly.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                adapter = new MyRecyclerViewAdapter(data);
                mRly.setAdapter(adapter);
                adapter.setOnClick(new MyRecyclerViewAdapter.onClick() {
                    @Override
                    public void click(View itemView, int postion) {
                        Log.e("qwe",itemView.getId()+"+++"+postion);
                    }
                });
                break;
            case R.id.btn2 :

                break;
            case R.id.btn3 :

                break;
            case R.id.btn4 :

                break;

        }

    }
}
