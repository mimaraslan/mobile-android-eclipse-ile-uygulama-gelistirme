package com.mimaraslan;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	// url to make request
	static final String URL = "http://mimaraslan.com/listeleme.json";
	

	
	
	// UYGULAMADAKI TUM SABIT DEGERLER
	private static final String KAYIT = "item"; // BIR KAYIT - parent node
	static final String ID = "id";
	static final String ADI = "name";
	static final String MAAS = "salary";
	static final String ACIKLAMA = "description";

	// item JSONArray
	JSONArray item = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// ListView İÇİN Hashmap 
		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

		
		JSONParser jParser = new JSONParser();// JSON Parser instance NESNESİ	 
		JSONObject json = jParser.getJSONFromUrl(URL);// URL'DEN JSON string

		try {
			//  BİR KAYIT item,  Array HALİNE GETİRİLİYOR
			item = json.getJSONArray(KAYIT);
			
			// KAYITLAR DÖNGÜ İLE ALNIYOR
			for(int i = 0; i < item.length(); i++){
				JSONObject c = item.getJSONObject(i);
				
				// KAYITLARA AİT DEĞERLER DEPOLANIYOR 
				String id = c.getString(ID);
				String adi = c.getString(ADI);
				String maas = c.getString(MAAS) + " YTL";
				String aciklama = c.getString(ACIKLAMA);
					
				// HashMap OLUSTURUYORUZ
				HashMap<String, String> map = new HashMap<String, String>();
				
				// COCUK child node LARIMIZI HashMap ANAHTAR key => value DEGER ILE BIRLESTIRIYORUZ
				map.put(ID, id);
				map.put(ADI, adi);
				map.put(MAAS, maas);
				map.put(ACIKLAMA, aciklama);
		
				// ArrayList BILGILERINI HashList ICINE EKLIYORUZ
				menuItems.add(map);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
		// menuItems VERILERINI ListView ICINE EKLIYORUZ
		ListAdapter adapter = new SimpleAdapter(
				this, menuItems, 
				R.layout.list_item,
				new String[] { ADI, ACIKLAMA, MAAS }, 
				new int[] { R.id.adi, R.id.aciklama, R.id.maas }
				);

		setListAdapter(adapter);

		// ListView LISTEMIZI ALIYORUZ
		ListView lv = getListView();

		// LISTEDEN SECILEN KAYIT ICIN YENI SAYFAYA GIDILIYOR
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// LISTEDEKI BIR KAYDIN SECILMESI SONUCUNDA KAYDA AIT VERILER ALINIYOR
				String adi = ((TextView) view.findViewById(R.id.adi)).getText().toString();
				String maas = ((TextView) view.findViewById(R.id.maas)).getText().toString();
				String aciklama = ((TextView) view.findViewById(R.id.aciklama)).getText().toString();
				
				// SADECE SECILEN KAYDA AIT VERILER intent ILE BIR BASKA SAYFAYA GONDERILIYOR 
				Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
				in.putExtra(ADI, adi);
				in.putExtra(MAAS, maas);
				in.putExtra(ACIKLAMA, aciklama);
				startActivity(in);

			}
		});
		
		

	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}