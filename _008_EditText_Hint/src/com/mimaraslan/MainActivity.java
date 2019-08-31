package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       findViewById(R.id.button1).setOnClickListener(new KapatmaSinifi()); 
    }
    
    private class KapatmaSinifi implements OnClickListener{
    	public void onClick(View view){
    		finish();
    	}
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
