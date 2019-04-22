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

                RelativeLayout.LayoutParams layoutParams = getLayoutParams(v);
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        xDelta = x - layoutParams.leftMargin;
                        yDelta = y - layoutParams.topMargin;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        layoutParams.leftMargin = getXposition((x - xDelta), v.getWidth(), rlMain.getWidth());
                        layoutParams.topMargin = getYposition((y - yDelta), v.getHeight(), rlMain.getHeight());
                        Log.d("VersusgoalOnTouch", "x: " + layoutParams.leftMargin);
                        Log.d("VersusgoalOnTouch", "y: " + layoutParams.topMargin);
                        v.setLayoutParams(layoutParams);
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

    private int getXposition(int x, int viewWidth, int parentWidth) {
        return (x < 0) ? 0 //excede limite izquierdo
                : (x + viewWidth > parentWidth) ? (parentWidth - viewWidth) //excede limite derecho
                : x; //no excede ningun limite
    }

    private int getYposition(int y, int viewHeight, int parentHeight) {
        return (y < 0) ? 0 //excede limite superior
                : (y + viewHeight > parentHeight) ? (parentHeight - viewHeight) //excede limite inferior
                : y; //no excede ningun limite
    }











    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}