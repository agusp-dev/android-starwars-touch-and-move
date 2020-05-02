package com.versusgoal.versusgoaltouchmoveapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



		private ViewGroup rlMain;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
		}

		@Override
		protected void onDestroy() {
				super.onDestroy();
		}

		/**
			* Click en item de menu.
			*/
		private void onAddViewMenuItemClick() {
				createNewView();
		}

		@SuppressLint("ClickableViewAccessibility")
		private void createNewView() {
//				ImageView iv = createNewImageView();
//				rlMain.addView(iv);
//				iv.getLayoutParams().width = dpToPx(56);
//				iv.getLayoutParams().height = dpToPx(56);
//				iv.setOnTouchListener(
//								new Touch(rlMain));
		}

		private ImageView createNewImageView() {
				LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				return (ImageView) inflater.inflate(R.layout.view_versusgoal, null);
		}

		private int dpToPx(int dp) {
				return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
		}
}