package com.mimaraslan;

import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.text.format.DateFormat;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
               
        TextView textView1 = (TextView) findViewById(R.id.textview1);
        TextView textView2 = (TextView) findViewById(R.id.textview2);
        TextView textView3 = (TextView) findViewById(R.id.textview3);
        TextView textView4 = (TextView) findViewById(R.id.textview4);
        TextView textView5 = (TextView) findViewById(R.id.textview5);
                
        String format = "MM/dd/yy hh:mm a"; // 04/29/1453 06:32 pm
        Date tarih = Calendar.getInstance().getTime();
        textView1.setText("Tarih Formatı : "+DateFormat.format(format,tarih));
        
        format = "MMM dd, yyyy h:mm aa"; // Apr 29,1453 06:32 pm
        textView2.setText("Tarih Formatı : "+DateFormat.format(format,tarih)); 
        
        format = "MMMM dd, yyyy h:mmaa"; //April 29,1453 06:32pm
        textView3.setText("Tarih Formatı : "+DateFormat.format(format,tarih)); 
        
        format = "E, MMMM dd, yyyy h:mm:ss aa";//Fri, April 29,1453 06:32:00 pm
        textView4.setText("Tarih Formatı : "+DateFormat.format(format,tarih)); 
        
        format = "EEEE, MMMM dd, yyyy h:mm aa"; //Friday, Apr 21,2014 06:32:00 pm
        textView5.setText("Tarih Formatı : "+DateFormat.format(format,tarih)); 
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
