package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Spinner spinner1;
	
	private static final String[] personel = { 
			"Ali Fansa", "Görkem Sezgin",
			"Mehmet Özdemir", "Evren Tombul", "Alican Akkuş", "Ümit Bakan",
			"Eren Satı", "Ali Uyanık", "Ali Bal", "Ebubekir Yılmaz",
			"Büşra Demirel", "Serkan Ayaydın" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		acilirListeyiGoster();
	}


	public void acilirListeyiGoster() {
		spinner1 = (Spinner) findViewById(R.id.spinner1);

		ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(this,
				android.R.layout.simple_list_item_checked, personel);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(adapter);

		spinner1.setOnItemSelectedListener(new bizimSpinnerListener());
	}

	
	class bizimSpinnerListener implements Spinner.OnItemSelectedListener {
		@Override
		public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

			Toast.makeText(parent.getContext(),"ADI SOYADI : "+ parent.getItemAtPosition(position).toString(),
					Toast.LENGTH_LONG).show();
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}

	

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
