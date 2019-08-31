package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

	
	  AutoCompleteTextView autocompletetextview;

	    String[] array = { 
	    		"Nurullah Karakoca",
	    		"İsmail Filiz",
	    		"Mehmet Resul Yılmaz",
	    		"Burak Benli",
	    		"Mustafa Ceviz",
	    		"Bilal Durnagol",
	    		"Burak Oral",
	    		"Oğuzhan Uzun",
	    		"Soner Koç",
	    		"Jack Cotter",
	    		"Erkin Emre Yılmaz",
	    		"Mehmet Furkan Kara",
	    		"Abdullah Bildik",
	    		"Veysel Karani Ece",
	    		"Samil Mehdiyev",
	    		"Ali Imran Selman",
	    		"Mert Can Başkaya",
	    		"Erkam Demirci",
	    		"Ümit Vardar",
	    		"Pashabeyli Fuad",
	    		"Fizuli Movlamov",
	    		"Tolgahan Demirayak",
	    		"Ismayil Agazade",
	    		"Birdal Özcan",
	    		"Esra Şengün",
	    		"Büşra Başcı",
	    		"Sümeyye Kaptan",
	    		"Emre Öztürk",
	    		"Esra Aslan",
	    		"Yusuf Yl",
	    		"Erdoğan Yalçın",
	    		"Abdullah Çetinkaya",
	    		"Emin Aslan",
	    		"Bilal Simsek",
	    		"Murat Necip Arcan",
	    		"Leman Seferova",
	    		"Ahmet Çığşar",
	    		"Jen Flsener",
	    		"Ali Aktas",
	    		"Ali Rıza Koçaş",
	    		"Oğuzcan Aslan",
	    		"Levent Çelik",
	    		"Özkan Önder",
	    		"Hakan Jan Kocabey",
	    		"Fatih Baykal",
	    		"Mete Gökpınar",
	    		"Büşra Günaltay",
	    		"Yavuz Osmanoğlu",
	    		"Suat Celik",
	    		"Mehmet Akif Olgun",
	    		"İbrahim Karataş",
	    		"Alican Akkuş",
	    		"Zekeriya Besiroglu",
	    		"Numan Burak Alpaydın",
	    		"Aysel Seyitoğlu",
	    		"Alper Özaslan",
	    		"Mustafa Demiraslan",
	    		"Dilek ArslanTaşcı",
	    		"Zeynep Temel",
	    		"Sevda Turan",
	    		"Niyazi Özsoy",
	    		"Meherrem Memmedov",
	    		"Yunus Seçgin",
	    		"Orhan Eripek",
	    		"Rifat Akdağ",
	    		"Ahmet Şen",
	    		"Yunus Savaş",
	    		"İsmail Sinan Gülbaş",
	    		"Osman Urfalıoğlu",
	    		"Azer Ekberov",
	    		"Özmen Kilit",
	    		"Vuqar Xanaliyev Proudly",
	    		"Haticee Arslan",
	    		"Arda Balkan",
	    		"Murad Haciyev",
	    		"Turgay Tanyolaç",
	    		"Shelale Hemzeyeva",
	    		"Khayyam Amrahov",
	    		"Hakan Düz",
	    		"Haluk Yamaner",
	    		"Ömer Türkyılmaz",
	    		"Onur Turan",
	    		"Elcin Memmedov",
	    		"Emrah Doğdu",
	    		"Çağla Taşcı",
	    		"Mubariz F-ev",
	    		"Sefa Gürel",
	    		"Seyfi Genç",
	    		"Nevruz Sengir",
	    		"Fatma Arslan Birinci" 
	    		};

	   



 
 
	        
	        
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	       autocompletetextview = (AutoCompleteTextView)     findViewById(R.id.autocompletetextview);

 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, array);

	        autocompletetextview.setThreshold(1);

	        autocompletetextview.setAdapter(adapter);
	        
	        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
