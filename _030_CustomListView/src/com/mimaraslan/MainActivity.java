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

public class MainActivity extends Activity implements OnItemClickListener {
	 	ListView listemiz;
	    ListViewCustomAdapter adapter;
	    private ArrayList<Object> itemList;
	    private Pojo pojo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listeyiHazirla();
        listemiz = (ListView) findViewById(R.id.listView1);
        adapter = new ListViewCustomAdapter(this, itemList);
        listemiz.setAdapter(adapter);
 
        listemiz.setOnItemClickListener(this);  
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
    	
    	Pojo bean = (Pojo) adapter.getItem(position);
    	Toast.makeText(this, 
    			"Etiket => "+bean.getYazi()+
    			" \n Açıklaması => "+bean.getAciklama(), Toast.LENGTH_SHORT).show();
    	
    }
    

    public void listeyiHazirla(){
    	
    	itemList = new ArrayList<Object>();
    	 
    	ListeyeElemanEkle(R.drawable.ic_add, "Ekle", "Ekleme işlemi");
    	ListeyeElemanEkle(R.drawable.ic_delete, "Sil", "Silme işlemi");
    	ListeyeElemanEkle(R.drawable.ic_down, "Aşağı", "Aşağı al");
    	ListeyeElemanEkle(R.drawable.ic_info, "Bilgi", "Bilgi ver");
    	ListeyeElemanEkle(R.drawable.ic_help, "Yardım", "Yardım et");
    	ListeyeElemanEkle(R.drawable.ic_download, "İndir", "İndirme işlemi");
    	ListeyeElemanEkle(R.drawable.ic_mail, "Mail", "Eposta gönder");
    	ListeyeElemanEkle(R.drawable.ic_search, "Ara", "Arama yap");
    	ListeyeElemanEkle(R.drawable.ic_settings, "Ayarlar", "Ayar yap");
    }
    

    public void ListeyeElemanEkle(int simge, String yazi, String aciklama){
    	
    	pojo = new Pojo();
    	pojo.setAciklama(aciklama);
    	pojo.setSimge(simge);
    	pojo.setYazi(yazi);
    	itemList.add(pojo);
    }

    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
