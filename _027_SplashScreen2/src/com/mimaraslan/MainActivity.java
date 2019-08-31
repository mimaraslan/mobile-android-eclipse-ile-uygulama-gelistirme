package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.content.Intent;



public class MainActivity extends Activity {
	
	private long ms=0;
	private long splashTime=5000;
	private boolean splashActive = true;
	private boolean paused=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        
    	setContentView(R.layout.splash);	
    	
		Thread mythread = new Thread() {
    	public void run() {
    		try {
    			while (splashActive && ms < splashTime) {
    				if(!paused)
    					ms=ms+100;
    				sleep(100);
    			}
    		} catch(Exception e) {
    			
    			
    		}
    		finally {
    			Intent intent = new Intent(MainActivity.this, Anasayfa.class);
        		startActivity(intent);
    		}
        	}
    };
    mythread.start(); 

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
