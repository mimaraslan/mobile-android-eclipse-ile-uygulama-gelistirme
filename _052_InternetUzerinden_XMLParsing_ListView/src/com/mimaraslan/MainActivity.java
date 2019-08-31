package com.mimaraslan;


import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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

	// UYGULAMADAKI TUM SABIT DEGERLER
	static final String URL = "http://mimaraslan.com/liste.xml";
	// XML node keys KOK ELEMANLARI
	static final String KAYIT = "item"; // BIR KAYIT - parent node
	static final String ID = "id";
	static final String ADI = "name";
	static final String MAAS = "salary";
	static final String ACIKLAMA = "description";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

		
		XMLParser parser = new XMLParser();
		String xml = parser.getXmlFromUrl(URL); // XML'I AL
		Document doc = parser.getDomElement(xml); // DOM ELEMANLARINI AL

		NodeList nl = doc.getElementsByTagName(KAYIT);
		// XML'DEKI KOK ELEMANLARINI DONGU ILE BIRER BIRER ALIYORUZ <item>
		for (int i = 0; i < nl.getLength(); i++) {
			//  HashMap OLUSTUR
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			// COCUK ELEMANLARI HashMap key => value ILE YAZDIRIYORUZ
			map.put(ID, parser.getValue(e, ID));
			map.put(ADI, parser.getValue(e, ADI));
			map.put(MAAS, parser.getValue(e, MAAS) + " YTL");
			map.put(ACIKLAMA, parser.getValue(e, ACIKLAMA));

			// HashList ICINDEKI VERILERI ArrayList ICINE EKLIYORUZ
			menuItems.add(map);
		}
		
		
		

		// menuItems VERILERINI ListView ICINE EKLIYORUZ
		ListAdapter adapter = new SimpleAdapter(
				this, menuItems, 
				R.layout.list_item,
				new String[] { ADI, ACIKLAMA, MAAS }, 
				new int[] { R.id.adi, R.id.aciklama, R.id.maas }
				);

		setListAdapter(adapter);

		// LISTEDEN BIR KAYIT SECILIYOR
		ListView lv = getListView();

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				
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