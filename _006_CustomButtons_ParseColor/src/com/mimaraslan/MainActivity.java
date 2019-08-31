package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Color;

public class MainActivity extends Activity {



	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		Button btnRectangle = (Button) findViewById(R.id.btnKoseli);
		btnRectangle.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(getApplicationContext(),"Köşeli düğme tıklandı.", Toast.LENGTH_SHORT).show();
				
				findViewById(R.id.LinearLayout1).setBackgroundColor(Color.parseColor("#8d395b"));
				
			}
		});

		Button btnOval = (Button) findViewById(R.id.btnOval);
		btnOval.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(getApplicationContext(), "Oval düğme tıklandı.",Toast.LENGTH_SHORT).show();
				
				findViewById(R.id.LinearLayout1).setBackgroundColor(Color.parseColor("#e09a00"));
				
			}
		});

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
