package com.soezi.tebakgambar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.os.Bundle;

public class MainActivity extends Activity {
	protected boolean _aktif = true;
	protected int awal_ = 5000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int delay_ = 0;
					while (_aktif && (delay_ < awal_)) {
						sleep(25);
						if (_aktif) {
							delay_ += 25;
						}
					}
				} catch (InterruptedException e) {
				} finally {
					finish();
					Intent panggil_class = new Intent(MainActivity.this,
							MenuUtama.class);
					startActivityForResult(panggil_class, 0);
				}
			}
		};
		splashTread.start();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			_aktif = false;
		}
		return true;
	}

	@Override
	public void onBackPressed() {
		finish();
		System.exit(0);
	}

	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
