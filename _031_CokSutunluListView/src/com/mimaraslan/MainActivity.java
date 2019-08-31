package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.ListView;

import static com.mimaraslan.SabitDegerlerSinifi.BIRINCI_KOLON;
import static com.mimaraslan.SabitDegerlerSinifi.DORDUNCU_KOLON;
import static com.mimaraslan.SabitDegerlerSinifi.IKINCI_KOLON;
import static com.mimaraslan.SabitDegerlerSinifi.UCUNCU_KOLON;



public class MainActivity extends Activity {
	private ArrayList<HashMap<String, String>> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = (ListView) findViewById(R.id.listView1);
		kitapYazarListesi();
		listviewAdapter adapter = new listviewAdapter(this, list);
		listView.setAdapter(adapter);

    }

    
	private void kitapYazarListesi() {

		list = new ArrayList<HashMap<String, String>>();

		
		HashMap<String, String> temp0 = new HashMap<String, String>();
		temp0.put(BIRINCI_KOLON, "JavaServer Pages");
		temp0.put(IKINCI_KOLON, "Mimar Aslan");
		temp0.put(UCUNCU_KOLON, "605 s.");
		temp0.put(DORDUNCU_KOLON, "35,70 TL");
		list.add(temp0);
		
		HashMap<String, String> temp1 = new HashMap<String, String>();
		temp1.put(BIRINCI_KOLON, "Android");
		temp1.put(IKINCI_KOLON, "Mimar Aslan");
		temp1.put(UCUNCU_KOLON, "680 s.");
		temp1.put(DORDUNCU_KOLON, "35,70 TL");
		list.add(temp1);

		HashMap<String, String> temp2 = new HashMap<String, String>();
		temp2.put(BIRINCI_KOLON, "Objective-C Programlama Dili");
		temp2.put(IKINCI_KOLON, "Mimar Aslan");
		temp2.put(UCUNCU_KOLON, "320 s.");
		temp2.put(DORDUNCU_KOLON, "25,00 TL");
		list.add(temp2);

		HashMap<String, String> temp3 = new HashMap<String, String>();
		temp3.put(BIRINCI_KOLON, "JavaServer Faces");
		temp3.put(IKINCI_KOLON, "Mimar Aslan");
		temp3.put(UCUNCU_KOLON, "632 s.");
		temp3.put(DORDUNCU_KOLON, "31,50 TL");
		list.add(temp3);

		HashMap<String, String> temp4 = new HashMap<String, String>();
		temp4.put(BIRINCI_KOLON, "Java Web Servisleri ile Android Programlama");
		temp4.put(IKINCI_KOLON, "Mimar Aslan");
		temp4.put(UCUNCU_KOLON, "450 s.");
		temp4.put(DORDUNCU_KOLON, "32,00 TL");
		list.add(temp4);

		HashMap<String, String> temp5 = new HashMap<String, String>();
		temp5.put(BIRINCI_KOLON, "Java Persistence API ve Hibernate Çatısı ile ORM");
		temp5.put(IKINCI_KOLON, "Mimar Aslan");
		temp5.put(UCUNCU_KOLON, "655 s.");
		temp5.put(DORDUNCU_KOLON, "35,00 TL");
		list.add(temp5);
		
		HashMap<String, String> temp6 = new HashMap<String, String>();
		temp6.put(BIRINCI_KOLON, "Spring Uygulama Çatısı ile Kurumsal Java Projeleri");
		temp6.put(IKINCI_KOLON, "Mimar Aslan");
		temp6.put(UCUNCU_KOLON, "689 s.");
		temp6.put(DORDUNCU_KOLON, "36,00 TL");
		list.add(temp6);
		
	}  
    
    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
