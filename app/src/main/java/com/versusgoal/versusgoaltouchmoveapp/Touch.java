package com.versusgoal.versusgoaltouchmoveapp;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Touch implements View.OnTouchListener {

    private View parent;
    private int xDelta;
    private int yDelta;

    public Touch(View v) {
        parent = v;
    }

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
                layoutParams.leftMargin = getXposition((x - xDelta), v.getWidth(), parent.getWidth());
                layoutParams.topMargin = getYposition((y - yDelta), v.getHeight(), parent.getHeight());
                v.setLayoutParams(layoutParams);
                break;
        }

        parent.invalidate();
        return true;
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
}