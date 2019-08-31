package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private GridviewAdapter gridviewAdapter;
	private ArrayList<String> ulkeListesi;
	private ArrayList<Integer> ulkeBayragi;
	private GridView gridView;

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
 listeyiHazirla();
        
        
        gridviewAdapter = new GridviewAdapter(this, ulkeListesi, ulkeBayragi);
        
        gridView = (GridView) findViewById(R.id.gridView1);
        
        gridView.setAdapter(gridviewAdapter); 
        
        gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				Toast.makeText(getApplicationContext(), gridviewAdapter.getItem(position), Toast.LENGTH_SHORT).show();
			}
		});

        
    }

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    

	private void listeyiHazirla() {
		ulkeListesi = new ArrayList<String>();
		ulkeListesi.add("Türkiye");
		ulkeListesi.add("İngiltere");
		ulkeListesi.add("Amerika");
		ulkeListesi.add("Kanada");
		ulkeListesi.add("Rusya");
		ulkeListesi.add("Brezilya");
		ulkeListesi.add("Almanya");
		ulkeListesi.add("İran");
		ulkeListesi.add("İtalya");
		ulkeListesi.add("Fransa");
		ulkeListesi.add("Kore");
		ulkeListesi.add("Meksika");
		ulkeListesi.add("Hollanda");
		ulkeListesi.add("Portekiz");
		ulkeListesi.add("Sudi Arabistan");
		ulkeListesi.add("İspanya");
		ulkeListesi.add("Çin");
		ulkeListesi.add("Hindistan");
		ulkeListesi.add("Japonya");
		
		ulkeBayragi = new ArrayList<Integer>();
		ulkeBayragi.add(R.drawable.turkey);
		ulkeBayragi.add(R.drawable.united_kingdom);
		ulkeBayragi.add(R.drawable.united_states);
		ulkeBayragi.add(R.drawable.canada);
		ulkeBayragi.add(R.drawable.russia);
		ulkeBayragi.add(R.drawable.brazil);
		ulkeBayragi.add(R.drawable.germany);
		ulkeBayragi.add(R.drawable.iran);
		ulkeBayragi.add(R.drawable.italy);
		ulkeBayragi.add(R.drawable.france);
		ulkeBayragi.add(R.drawable.korea);
		ulkeBayragi.add(R.drawable.mexico);
		ulkeBayragi.add(R.drawable.netherlands);
		ulkeBayragi.add(R.drawable.portugal);
		ulkeBayragi.add(R.drawable.saudi_arabia);
		ulkeBayragi.add(R.drawable.spain);
		ulkeBayragi.add(R.drawable.china);
		ulkeBayragi.add(R.drawable.india);
		ulkeBayragi.add(R.drawable.japan);
	}

}
