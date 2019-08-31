package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ustKismiHazirla("ViewStub başlığı FİRMA ADI");

	}

	public void ustKismiHazirla(String baslikYazisi) {

		ViewStub stub = (ViewStub) findViewById(R.id.vsHeader);
		View inflated = stub.inflate();

		TextView txtTitle = (TextView) inflated.findViewById(R.id.txtHeading);
		txtTitle.setText(baslikYazisi);
	}

	
	public void metot1() {

	}
	
	
	public void metot2() {

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
