package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.util.ArrayList;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    	ArrayList<KayitBilgileri> kayitBilgileri = AramaListesiniAl();

		final ListView listView = (ListView) findViewById(R.id.ogrenci_listesi);
		listView.setAdapter(new BizimAdapterSinifimiz(this, kayitBilgileri));

		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				
				Object o = listView.getItemAtPosition(position);
				
				KayitBilgileri kayit = (KayitBilgileri) o;
				Toast.makeText(MainActivity.this,
						"Seçilen kayıt\n" + kayit.getAdiSoyadi() 
						+ "\n" + kayit.getSehir()
						+ "\n" + kayit.getTelefon(),
						Toast.LENGTH_LONG).show();
			}
		});

		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    private ArrayList<KayitBilgileri> AramaListesiniAl() {
		ArrayList<KayitBilgileri> sonuc = new ArrayList<KayitBilgileri>();

		KayitBilgileri kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Harun Can Tekin");
		kayit.setSehir("Ankara");
		kayit.setTelefon("0532 111 222 33");
		sonuc.add(kayit);

		kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Doğancan Ülker");
		kayit.setSehir("Adana");
		kayit.setTelefon("0532 111 222 33");
		sonuc.add(kayit);

		kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Murat Özer");
		kayit.setSehir("Bursa");
		kayit.setTelefon("0537 111 222 33");
		sonuc.add(kayit);
		
		kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Veysel Karani Ece (터키인)"); 
		kayit.setSehir("Sivas");
		kayit.setTelefon("0534 111 256 33");
		sonuc.add(kayit);

		kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Kemal Bali");
		kayit.setSehir("Bursa");
		kayit.setTelefon("0532 782 222 33");
		sonuc.add(kayit);

		kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Kadir Kartal");
		kayit.setSehir("Samsun");
		kayit.setTelefon("0578 741 895 10");
		sonuc.add(kayit);

		kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Ömer Yılmaz");
		kayit.setSehir("Sivas");
		kayit.setTelefon("0536 952 222 33");
		sonuc.add(kayit);

		kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Önder Akbulut");
		kayit.setSehir("Ağrı");
		kayit.setTelefon("0552 111 222 33");
		sonuc.add(kayit);

		kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Recai Aydoğdu");
		kayit.setSehir("Malatya");
		kayit.setTelefon("0544 78 452 00");
		sonuc.add(kayit);

		kayit = new KayitBilgileri();
		kayit.setAdiSoyadi("Baki Bilen");
		kayit.setSehir("Hatay");
		kayit.setTelefon("0500 445 322 11");
		sonuc.add(kayit);

		return sonuc;
	}
}
