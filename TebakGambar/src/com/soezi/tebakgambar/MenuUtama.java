package com.soezi.tebakgambar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MenuUtama extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_utama);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	public void btn_menu(View v) {
		Intent panggil_class = new Intent(this, Soal1.class);
		startActivity(panggil_class);
    }
	

		@Override
		public void onBackPressed() {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Keluar dari Tebak Gambar ?")
					.setCancelable(false)
					.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							Intent keluar = new Intent(Intent.ACTION_MAIN);
							keluar.addCategory(Intent.CATEGORY_HOME);
							keluar.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							finish();
							startActivity(keluar);
						}
					})
					.setNegativeButton("Tidak",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
								}
							}).show();
		}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_utama, menu);
		return true;
	}
	
}
