package com.boleng.listview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import com.boleng.listview.adapter.MyAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private String TAG=MainActivity.class.getSimpleName();
    private ListView lstContainer;
    private Button btnChangeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstContainer= (ListView) findViewById(R.id.lstContainer);
        btnChangeData= (Button) findViewById(R.id.btnChangeData);

        final ArrayList<String> data=new ArrayList<>();
//        for (int i=0;i<20;i++){
//            data.add(i+" ");
//        }
        final MyAdapter myAdapter=new MyAdapter(this,data);
        lstContainer.setAdapter(myAdapter);
        lstContainer.setEmptyView(findViewById(R.id.imgEmpty));
//        lstContainer.setSelection(3);

        btnChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0;i<20;i++){
                    data.add(i+" ");
                }
                myAdapter.notifyDataSetChanged();
            }
        });

        lstContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        lstContainer.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case SCROLL_STATE_IDLE:
                        Log.i(TAG,"stop scrolling");
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        Log.i(TAG,"is scrolling");
                        break;
                    case SCROLL_STATE_FLING:
                        Log.i(TAG,"inertia scrolling");
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.i(TAG,"firstVisibleItem "+firstVisibleItem +" visibleItemCount "+visibleItemCount+" totalItemCount "+totalItemCount);
            }
        });
    }
}
