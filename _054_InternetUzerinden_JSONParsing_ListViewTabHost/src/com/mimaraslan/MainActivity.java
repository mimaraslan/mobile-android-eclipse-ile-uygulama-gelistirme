package com.mimaraslan;

import android.os.Bundle;
import android.view.Menu;

import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
 
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	// TabSpec Sekme isimleri
	private static final String PERSONEL_SPEC = "Personel";
	private static final String UYE_SPEC = "Üye";
   
            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                
                TabHost tabHost = getTabHost();
                
                // Personel Sekmesi
                TabSpec personelSpec = tabHost.newTabSpec(PERSONEL_SPEC);
                // Sekmenin Simgesi
                personelSpec.setIndicator(PERSONEL_SPEC, getResources().getDrawable(R.drawable.icon_personel));
                
                Intent personelIntent = new Intent(this, PersonelActivity.class);
                // Sekmenin Icerigi
                personelSpec.setContent(personelIntent);
                
                // Uye Tab
                TabSpec uyeSpec = tabHost.newTabSpec(UYE_SPEC);
                uyeSpec.setIndicator(UYE_SPEC, getResources().getDrawable(R.drawable.icon_uye));
                Intent uyeIntent = new Intent(this, UyeActivity.class);
                uyeSpec.setContent(uyeIntent);
  
                // TabHost'a bütün TabSpec'leri ekle
                tabHost.addTab(personelSpec); // Personel sekmesini ekle
                tabHost.addTab(uyeSpec); // Uye sekmesini ekle
           
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
