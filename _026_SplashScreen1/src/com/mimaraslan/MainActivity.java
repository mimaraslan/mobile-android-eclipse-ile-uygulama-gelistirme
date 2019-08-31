package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.Dialog;
import android.os.Handler;

public class MainActivity extends Activity {

	
	private class DurumKoruyucu{
		private boolean splashScreenGosterimDurumu = true;
	}
	
	private static final int GOSTERILME_SANIYESI = 10;
	private Dialog splashDialog;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //   setContentView(R.layout.activity_main);
        

@SuppressWarnings("deprecation")
DurumKoruyucu durumKoruyucu = (DurumKoruyucu) getLastNonConfigurationInstance();
        
        if(durumKoruyucu != null){
		        	if(durumKoruyucu.splashScreenGosterimDurumu){
		        		gosterSplashScreen();
		        	}
		        	// setContentView(R.layout.activity_main);
        }else{
        	 gosterSplashScreen();
        	 setContentView(R.layout.activity_main);
        }

    }

    
    
    private void saklaSplashScreen(){
    	if(splashDialog != null){
    		splashDialog.dismiss();
    		splashDialog = null;
    	}
    }

	private void gosterSplashScreen() {
		splashDialog = new Dialog(this);
		splashDialog.setContentView(R.layout.splashscreen);
		splashDialog.setCancelable(false);
		splashDialog.show();
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				saklaSplashScreen();
				
			}
		}, GOSTERILME_SANIYESI * 1000);
		
		
	}
	 
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
