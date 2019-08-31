package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	EditText editTextEmail;
	String strEmailAdres;
	
	EditText kulllaniciAdi, parolasi;
	String KULLANICIADI, PAROLASI;
	
	Button dugmemiz;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        kulllaniciAdi =(EditText) findViewById(R.id.editTextKullaniciAdi) ;
        KULLANICIADI = kulllaniciAdi.getText().toString();
       
        
        parolasi =(EditText) findViewById(R.id.editTextParola) ;
        PAROLASI = parolasi.getText().toString();
        
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        
        
        dugmemiz = (Button) findViewById(R.id.button1);
        dugmemiz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				btnValidateEmailAddress(v);
			}
		});

        
    }
    
    
    //mimaraslan@gmail.com
    
    String mailDenetlemeFormati = "^\\D.+@.+\\.[a-z]+";
    
    public void btnValidateEmailAddress(View v){
    	strEmailAdres = editTextEmail.getText().toString().trim();
    	
    	Matcher matcherObj  = Pattern.compile(mailDenetlemeFormati).matcher(strEmailAdres);
    	
    	if (matcherObj.matches()) {
			Toast.makeText(v.getContext(), "Girilen adres : "+strEmailAdres +" geçerlidir.", Toast.LENGTH_LONG).show();
			
		} else {
			Toast.makeText(v.getContext(), "Girilen adres : "+strEmailAdres +" geçersizdir.", Toast.LENGTH_LONG).show();
			editTextEmail.setError("Hatal› mail giriﬂi yapt›n›z.");
		}
    	
    	
    	
    	if (kulllaniciAdi.getText().length() == 0) {
			kulllaniciAdi.setError("Lütfen kullan›c› ad›n›z› giriniz.");
		} 
    	
    	
    	if(parolasi.getText().length() == 0){
    		parolasi.setFocusableInTouchMode(true);
    		parolasi.requestFocus();
    		parolasi.setError("Parolan›z› lütfen giriniz.");
    		
    	}
    	
    	
    	
    }
    

    
    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
