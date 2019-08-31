package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {
	//1. HATA AYIKLAMA
    private final static String DEBUG_TAG = "MainActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //2. HARITAYA TIKLAYINCA AC
        ImageView map = (ImageView)findViewById(R.id.ImageViewMap);
        map.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String localeString = getResources().getString(R.string.locale);
                Log.d(DEBUG_TAG, "Verilen mesaj: "+localeString+" alınamadı.");
                
            
            	Context context = getApplicationContext();
            	CharSequence text = localeString;
            	int duration = Toast.LENGTH_SHORT;

            	Toast toast = Toast.makeText(context, text, duration);
            	
            	//3.Toast mesajının posisyonu
            	toast.setGravity(Gravity.CENTER|Gravity.LEFT, 0, 0);
            	toast.show();
            	
      
            	
            }
        });

        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
