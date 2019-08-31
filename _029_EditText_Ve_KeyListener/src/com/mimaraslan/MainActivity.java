package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.text.method.DateKeyListener;
import android.text.method.DigitsKeyListener;
import android.text.method.MultiTapKeyListener;
import android.text.method.QwertyKeyListener;
import android.text.method.TextKeyListener;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
		EditText editText1=(EditText)findViewById(R.id.editText1);
        DigitsKeyListener digkl1=DigitsKeyListener.getInstance(true,true);//Pozitif / negatif  ve ondalık sayı ile haneleri 
        editText1.setKeyListener(digkl1);
        
        EditText editText2=(EditText)findViewById(R.id.editText2);
        DigitsKeyListener digkl2=DigitsKeyListener.getInstance();//Sadece pozitif inetger ve ondalıklı değerler
        editText2.setKeyListener(digkl2);
        
        EditText editText3=(EditText)findViewById(R.id.editText3);
        DateKeyListener dtkl=new DateKeyListener();//tarih
        editText3.setKeyListener(dtkl);
        
        EditText editText4=(EditText)findViewById(R.id.editText4);
        MultiTapKeyListener multitapkl=new MultiTapKeyListener(TextKeyListener.Capitalize.WORDS,true);//12li tuş takımı düzeni 
        editText4.setKeyListener(multitapkl);
        
        EditText editText5=(EditText)findViewById(R.id.editText5);
        QwertyKeyListener qkl=new QwertyKeyListener(TextKeyListener.Capitalize.SENTENCES,true);//yazmak için klavye qwerty düzeni
        editText5.setKeyListener(qkl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
