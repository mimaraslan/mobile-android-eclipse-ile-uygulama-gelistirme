package com.mimaraslan;
import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.view.Menu;



public class MainActivity extends Activity {

	private ListView lv;
	private EditText et;
	private String personel[] = { 

		"Farida Asadova","Orhan Eripek",
		"Alper Kızılgil","Kerem Vatandaş",
		"Yunus Turan","Gizem Türker",
		"Zeynep Temel","Ümit İlhan",
		"Uğur Okur","İlhan Çiçek",
		"Kadir Ergül","Anıl Alan",
		"Müslüm Öncel","Cavad Bağırov",
		"Hüseyin Yapıcı","Fikret Çevik",
		"Adnan Aydemir","Turgut Güdük",
		"Hatice Arslan","Ferdi Küçük",
		"Recep Ali Tellioğlu","Muhammed Salih Çevik"
	
	};
	
	private ArrayList<String> diziListesi= new ArrayList<String>();
	int kelimeUzunlugu=0;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		lv = (ListView) findViewById(R.id.lvSonuc);
		et = (EditText) findViewById(R.id.etAranacakSey);
		
		lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, personel));

		
		et.addTextChangedListener(new TextWatcher(){
		
			// TextWatcher Interface'inden gelen metotlar		
			public void afterTextChanged(Editable s){
				
			}
			public void beforeTextChanged(CharSequence s, int start, int count, int after){
			
			}
			
			public void onTextChanged(CharSequence s,int start, int before, int count){
				
				kelimeUzunlugu = et.getText().length();
				diziListesi.clear();
				for (int i = 0; i < personel.length; i++){
					
					if (kelimeUzunlugu <= personel[i].length()){
						if(et.getText().toString().equalsIgnoreCase((String)personel[i].subSequence(0,kelimeUzunlugu))){
							diziListesi.add(personel[i]);
						    }
					   }
				  }
					lv.setAdapter(new ArrayAdapter<String> (MainActivity.this,android.R.layout.simple_list_item_1, diziListesi));
				}
		  });
		
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
