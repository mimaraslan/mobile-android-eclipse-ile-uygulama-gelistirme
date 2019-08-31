package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GridView gridView = (GridView) findViewById(R.id.gridView1);
	    gridView.setAdapter(new ImageAdapter(this));
	    gridView.setOnItemClickListener(new OnItemClickListener() {
	        		@Override
	    			public void onItemClick(AdapterView<?> parent, View gorunum, int position, long id) {
	                        
			Toast.makeText(MainActivity.this, "NO : "+position , Toast.LENGTH_SHORT).show();
				
			Toast.makeText(getApplicationContext(), "NO : "+position, Toast.LENGTH_LONG).show();
			
				// image id FullScreenActivity için gönderiliyor
				Intent i = new Intent(getApplicationContext(),FullImageActivity.class);
				 //dizi index'i geçiriliyor. 
				i.putExtra("pozisyon", position);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
}
