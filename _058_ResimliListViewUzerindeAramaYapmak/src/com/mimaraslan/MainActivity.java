package com.mimaraslan;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
	

	String[] yazi = { 
			"Kutu", 
			"Takvim", 
			"Sepet",  
			"Sohbet", 
			"Kalp",
			"Ev", 
			"Kilit"  , 
			"Mektup" , "Not", "Kamyon" , "Bayan" , "Erkek", "Visa" , "Tamir"};

	int[] resim = { 
			
			R.drawable.box,
			R.drawable.calendar,
			R.drawable.cart,
			R.drawable.chat,
			R.drawable.heart,
			R.drawable.home,
			R.drawable.lock,
			R.drawable.mail,
			R.drawable.notepad,
			R.drawable.truck,
			R.drawable.user_female,
			R.drawable.user_male,
			R.drawable.visa,
			R.drawable.gears
			
	};
	
	
	 EditText edittext;
	 ListView listview;

	int textlength = 0;
	 
	 ArrayList<String> yazi_sirala = new ArrayList<String>();
	 ArrayList<Integer> resim_sirala = new ArrayList<Integer>();

	 public void onCreate(Bundle savedInstanceState){ 

	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);

	  edittext = (EditText) findViewById(R.id.EditText01);
	  listview = (ListView) findViewById(R.id.ListView01);
	  listview.setAdapter(new OzelCustomAdapter(yazi, resim));
	  
	  edittext.addTextChangedListener(new TextWatcher() {

	   public void afterTextChanged(Editable s){

	   }

	   public void beforeTextChanged(CharSequence s, int start,int count, int after){

	   }

	   public void onTextChanged(CharSequence s, int start, int before, int count){

	    textlength = edittext.getText().length();
	    yazi_sirala.clear();
	    resim_sirala.clear();

	    for (int i = 0; i < yazi.length; i++){
	     if (textlength <= yazi[i].length()) {
	      if (edittext.getText().toString().equalsIgnoreCase((String) yazi[i].subSequence(0, textlength))) {
	       yazi_sirala.add(yazi[i]);
	       resim_sirala.add(resim[i]);
	      }
	     }
	    }

	    listview.setAdapter(new OzelCustomAdapter(yazi_sirala, resim_sirala));

	   }
	  });
	 }

	 
	 
	 
	 
	 
	 class OzelCustomAdapter extends BaseAdapter {

	  String[] data_text;
	  int[] data_image;

	  OzelCustomAdapter() {

	  }

	  OzelCustomAdapter(String[] yazi, int[] resim){
	   data_text = yazi;
	   data_image = resim;
	  }
	  
	  OzelCustomAdapter(ArrayList<String> yazi, ArrayList<Integer> resim) { 
	  
	   data_text = new String[yazi.size()];
	   data_image = new int[resim.size()];

	   for(int i=0;i<yazi.size();i++){
	    data_text[i] = yazi.get(i);
	    data_image[i] = resim.get(i);
	   }

	  }

	  public int getCount(){
	   return data_text.length;
	  }

	  public String getItem(int position){
	   return null;
	  }

	  public long getItemId(int position){
	   return position;
	  }

	  public View getView(int position, View convertView, ViewGroup parent){

	   LayoutInflater inflater = getLayoutInflater();
	   View row = inflater.inflate(R.layout.listview, parent, false);

	   TextView textview = (TextView) row.findViewById(R.id.TextView01);
	   ImageView imageview = (ImageView) row.findViewById(R.id.ImageView01);

	   textview.setText(data_text[position]);
	   imageview.setImageResource(data_image[position]);

	   return (row);

	  }
	 }

	}