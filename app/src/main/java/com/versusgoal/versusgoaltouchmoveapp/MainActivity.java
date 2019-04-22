package com.versusgoal.versusgoaltouchmoveapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
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
    private ImageView ivVersusgoal1;
    private ImageView ivVersusgoal2;

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
        ivVersusgoal1 = (ImageView) findViewById(R.id.activity_main_iv1);
        ivVersusgoal2 = (ImageView) findViewById(R.id.activity_main_iv2);

        ivVersusgoal1.setOnTouchListener(new Touch(rlMain));
        ivVersusgoal2.setOnTouchListener(new Touch(rlMain));
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
        createNewView();
    }

    private void createNewView() {

        ACA QUEDE

        ImageView iv;

        LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        iv = (ImageView) inflater.inflate(R.layout.view_versusgoal, null);


        rlMain.addView(iv);
        iv.setOnTouchListener(new Touch(rlMain));
    }







    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}