package com.versusgoal.versusgoaltouchmoveapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewGroup rlMain;
    private ImageView ivVersusgoal;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setToolbar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_versusgoal);
        rlMain = (ViewGroup) findViewById(R.id.activity_main_rlMain);
        ivVersusgoal = (ImageView) findViewById(R.id.imageview_versusgoal);

//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
//                ivVersusgoal.getLayoutParams());
//        layoutParams.leftMargin = 300;
//        layoutParams.topMargin = 50;
//        layoutParams.bottomMargin = -250;
//        layoutParams.rightMargin = -250;
//        ivVersusgoal.setLayoutParams(layoutParams);

        //rlMain.addView(ivVersusgoal);

        ivVersusgoal.setOnTouchListener(onTouchListener());
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        setTitle(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.main_menu_add_view) {
            onAddViewMenuItemClick();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Click en item de menu.
     */
    private void onAddViewMenuItemClick() {
        //todo
    }

    /**
     * Listener de view.
     */
    private View.OnTouchListener onTouchListener() {

        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

//                Log.d("VersusgoalOnTouch", "x: " + x);
//                Log.d("VersusgoalOnTouch", "y: " + y);


                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams layoutParams1 = getLayoutParams(v);
                        xDelta = x - layoutParams1.leftMargin;
                        yDelta = y - layoutParams1.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        break;

                    case MotionEvent.ACTION_MOVE:

                        RelativeLayout.LayoutParams layoutParams2 = getLayoutParams(v);

                        layoutParams2.leftMargin = (x - xDelta > 0) ? (x - xDelta) : 0;
                        layoutParams2.topMargin = (y - yDelta > 0) ? (y - yDelta) : 0;
                        layoutParams2.rightMargin = -350;
                        layoutParams2.bottomMargin = 100;
                        v.setLayoutParams(layoutParams2);

                        Log.d("VersusgoalOnTouch", "leftMargin: " + layoutParams2.leftMargin);
                        Log.d("VersusgoalOnTouch", "topMargin: " + layoutParams2.topMargin);
                        Log.d("VersusgoalOnTouch", "rightMargin: " + layoutParams2.rightMargin);
                        Log.d("VersusgoalOnTouch", "bottomMargin: " + layoutParams2.bottomMargin);


//                        layoutParams2.leftMargin = x - xDelta;
//                        layoutParams2.topMargin = y - yDelta;
//                        layoutParams2.rightMargin = 0;
//                        layoutParams2.bottomMargin = 0;
//                        v.setLayoutParams(layoutParams2);
                        break;
                }

                rlMain.invalidate();
                return true;
            }
        };
    }

    private RelativeLayout.LayoutParams getLayoutParams(View view) {
        return (RelativeLayout.LayoutParams) view.getLayoutParams();
    }











    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}