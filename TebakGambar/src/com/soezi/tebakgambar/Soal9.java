package com.soezi.tebakgambar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Soal9 extends Activity {
	EditText jawabanTxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_soal9);
		jawabanTxt = (EditText) findViewById(R.id.editText1);
		jawabanTxt.setFilters(new InputFilter[] {new InputFilter.AllCaps()});
	}

	public void cekJawaban(View v){
		String jawabanBenar = "RUMAH TANGGA";
		String jawabanUser = jawabanTxt.getText().toString();
		if(jawabanUser.equals(jawabanBenar)){
			Toast.makeText(getApplicationContext(),
					"JAWABAN TEPAT!",Toast.LENGTH_LONG).show();
			Intent i = new Intent(getApplicationContext(),Soal10.class);
			startActivity(i);
		}
		else{
			//PESAN TOAST
			Toast.makeText(getApplicationContext(),
					"JAWABAN MASIH SALAH!",Toast.LENGTH_LONG).show();
		}		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.soal9, menu);
		return true;
	}

}
