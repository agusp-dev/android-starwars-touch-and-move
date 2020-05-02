package com.versusgoal.versusgoaltouchmoveapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

		@BindView(R.id.activity_main_btLuke)
		Button btLuke;
		@BindView(R.id.activity_main_btLeia)
		Button btLeia;
		@BindView(R.id.activity_main_btChewacca)
		Button btChewacca;
		@BindView(R.id.activity_main_rlCanvas)
		RelativeLayout rlCanvas;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				ButterKnife.bind(this);
		}

		@Override
		protected void onDestroy() {
				super.onDestroy();
		}

		@OnClick(R.id.activity_main_btLuke)
		public void onLukeButtonClick() {
				createLukeView();
		}

		@OnClick(R.id.activity_main_btLeia)
		public void onLeiaButtonClick() {
				createLeiaView();
		}

		@OnClick(R.id.activity_main_btChewacca)
		public void onChewaccaButtonClick() {
				createChewaccaView();
		}

		private void createLukeView() {
				createView(R.drawable.img_luke);
		}

		private void createLeiaView() {
				createView(R.drawable.img_leia);
		}

		private void createChewaccaView() {
				createView(R.drawable.img_chewacca);
		}

		@SuppressLint("ClickableViewAccessibility")
		private void createView(int resource) {
				ImageView iv = getView(resource);
				rlCanvas.addView(iv);
				iv.getLayoutParams().width = dpToPx();
				iv.getLayoutParams().height = dpToPx();
				iv.setOnTouchListener(new Touch(rlCanvas));
		}

		private ImageView getView(int resource) {
				LayoutInflater inflater = (LayoutInflater) getBaseContext()
								.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				ImageView iView = (ImageView) inflater.inflate(R.layout.view, null);
				iView.setImageResource(resource);
				return iView;
		}

		private int dpToPx() {
				return (int) (64 * Resources.getSystem().getDisplayMetrics().density);
		}
}