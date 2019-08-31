package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.content.Intent;
import android.view.KeyEvent;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
    }

   // MENU DUGMESINE BASINCA ACILIS EKRANI KAYBOLUYOR
    public boolean onKeyDown(int keyCode, KeyEvent event) {
		super .onKeyDown(keyCode, event);
		if(KeyEvent.KEYCODE_MENU == keyCode) {
			Intent intent = new Intent(MainActivity.this, Anasayfa.class);
			startActivity(intent);
		}
		if(KeyEvent.KEYCODE_BACK == keyCode) {
			finish();
		}
		return false;
	}

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
