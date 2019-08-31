package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	ConnectivityManager connectivityManager = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		final TextView txtBaglantiDurumu = (TextView) findViewById(R.id.txtBaglantiDurumu);
		final ImageView ivBaglantiSimgesi = (ImageView) findViewById(R.id.ivBaglantiSimgesi);

		if (baglantiKontrol()) {
			Toast.makeText(getApplicationContext(), R.string.baglanti_var,	Toast.LENGTH_LONG).show();
			ivBaglantiSimgesi.setImageResource(R.drawable.baglanti_var);
			txtBaglantiDurumu.setText(R.string.baglanti_var);
		} else {
			Toast.makeText(getApplicationContext(), R.string.baglanti_yok,	Toast.LENGTH_LONG).show();
			ivBaglantiSimgesi.setImageResource(R.drawable.baglanti_yok);
			txtBaglantiDurumu.setText(R.string.baglanti_yok);
		}

	}

	public boolean baglantiKontrol() {
		connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivityManager.getActiveNetworkInfo() != null) {
			if (connectivityManager.getActiveNetworkInfo().isConnected())
				return true;
		}
		return false;
	}
	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
