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
	
			"Sedat Demir",
			"Ayşe Zorlu",
			"Kerem Can",
			"Mustafa Çiçek",
			"Adnan Aydemir",
			"Müjdat Karacan",
			"Rashid Moradi",
			"Ömer Narman",
			"Ibrhm Erkn",
			"Evren Yıldırım",
			"Safak Yilmaz",
			"Runay Ayan",
			"Mehmet Aca",
			"Ahmet Gençkal",
			"Murat Güven",
			"Hüseyin Eşin",
			"Elvin Ibrahimov",
			"Mehmet İpek",
			"Erkin Emre Yılmaz",
			"Can Karapınar",
			"Halil İbrahim Zengin"
	
	};
	
	private ArrayList<String> diziListesi= new ArrayList<String>();
	int kelimeUzunlugu=0;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		lv = (ListView) findViewById(R.id.lvSonuc);
		et = (EditText) findViewById(R.id.etAranacakSey);
		
		lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, personel));

		
		et.addTextChangedListener(new TextWatcher(){
		
			// TextWatcher Interface'inden gelen metotlar		
			
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

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
		  });
		
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
