package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private static final String TAG = "_010_DDMS_Log_Islemleri";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        try {
       	 Log.d("DENEME", String.format("x0 = %5.2f, x1 = %5.2.f", "BİRİNCİ MESAJ", "İKİNCİ mesaj"));
       	
       } catch (Exception e) {
           Log.e(TAG, "HATA : errors");
           Log.w(TAG, "UYARI : warnings");
           Log.i(TAG, "BİLGİLENDİRME : informational");
           Log.d(TAG, "HATA AYIKLAMA : debug");
           Log.v(TAG, "AYRINTTLI MESAJ : verbose");
           Log.wtf(TAG, "FECİ BİR HATA : What a Teribble Failure");
           
           Log.d("Deneme", "Seyir defteri için bir hata ayıklama mesajı");
           
       }
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
