package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.TableRow.LayoutParams;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.tablelayout);
       
        
       /*
        TextView tv1 = new TextView(this);
        tv1.setText(R.string.kitap);
        tv1.setTextSize(40);
        tv1.setTextColor(Color.MAGENTA);
        
        TextView tv2 = new TextView(this);
        tv2.setText("UYGULAMA");
        tv2.setTextSize(50);
        tv2.setTextColor(Color.RED); 
        tv2.setGravity(Gravity.CENTER_HORIZONTAL);
        tv2.setLayoutParams(new LayoutParams (android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 
        		android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
        
        ImageView iv1 = new ImageView(this);
        iv1.setImageResource(R.drawable.android);
        iv1.setLayoutParams(new LayoutParams (android.view.ViewGroup.LayoutParams.MATCH_PARENT, 
        		android.view.ViewGroup.LayoutParams.MATCH_PARENT));
        iv1.setScaleType(ScaleType.FIT_CENTER);
      
        
        FrameLayout f1 = new FrameLayout(this);
        f1.setLayoutParams(new LayoutParams (android.view.ViewGroup.LayoutParams.MATCH_PARENT, 
        		android.view.ViewGroup.LayoutParams.MATCH_PARENT));
        f1.addView(tv1);
        f1.addView(iv1);
        f1.addView(tv2);
        setContentView(f1);
        */
       
       
       
        TableLayout havaDurumuTablosu = new TableLayout(this);
        havaDurumuTablosu.setStretchAllColumns(true);
        havaDurumuTablosu.setShrinkAllColumns(true);
        
        TableRow baslikSatirlari =  new TableRow(this);
        baslikSatirlari.setGravity(Gravity.CENTER_HORIZONTAL);
        
        TableRow gunSatirlari = new TableRow(this);
        TableRow yuksekSatirlari = new TableRow(this);
        TableRow dusukSatirlari = new TableRow(this);
        TableRow durumSatirlari = new TableRow(this);
    
        TextView bosluk = new TextView(this);
        
        TextView title = new TextView(this);
        title.setText("HAVA DURUMU TABLOSU");
        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.SERIF, Typeface.BOLD);
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 6;
        
        baslikSatirlari.addView(title, params); 
        
        
        TextView yukseketiket = new TextView(this);
        yukseketiket.setText("Y"); //Yük.
        yukseketiket.setTypeface(Typeface.DEFAULT_BOLD);
        
        TextView dusuketiket = new TextView(this);
        dusuketiket.setText("D"); //Düş.
        dusuketiket.setTypeface(Typeface.DEFAULT_BOLD);
        
        
        TextView durumketiket = new TextView(this);
        durumketiket.setText("Durum"); 
        durumketiket.setTypeface(Typeface.DEFAULT_BOLD);
        
        
        gunSatirlari.addView(bosluk);
        yuksekSatirlari.addView(yukseketiket);
        dusukSatirlari.addView(dusuketiket);
        durumSatirlari.addView(durumketiket);
        
        
       //1.gün
        TextView gun1etiket = new TextView(this);
        gun1etiket.setText("Eylül 15");
        gun1etiket.setTypeface(Typeface.SERIF, Typeface.BOLD);
        
        TextView gun1yuksek = new TextView(this);
        gun1yuksek.setText("6°C");
        gun1yuksek.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun1yuksek.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        TextView gun1dusuk = new TextView(this);
        gun1dusuk.setText("1°C");
        gun1dusuk.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun1dusuk.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        ImageView gun1durumlar = new ImageView(this);
        gun1durumlar.setImageResource(R.drawable.ayaz);
        
        gunSatirlari.addView(gun1etiket);
        yuksekSatirlari.addView(gun1yuksek);
        dusukSatirlari.addView(gun1dusuk);
        durumSatirlari.addView(gun1durumlar);
        
        
        
        
        //2.gün
        TextView gun2etiket = new TextView(this);
        gun2etiket.setText("Eylül 16");
        gun2etiket.setTypeface(Typeface.SERIF, Typeface.BOLD);
        
        TextView gun2yuksek = new TextView(this);
        gun2yuksek.setText("4°C");
        gun2yuksek.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun2yuksek.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        TextView gun2dusuk = new TextView(this);
        gun2dusuk.setText("2°C");
        gun2dusuk.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun2dusuk.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        ImageView gun2durumlar = new ImageView(this);
        gun2durumlar.setImageResource(R.drawable.bulutlu);
        
        gunSatirlari.addView(gun2etiket);
        yuksekSatirlari.addView(gun2yuksek);
        dusukSatirlari.addView(gun2dusuk);
        durumSatirlari.addView(gun2durumlar);
        
        
        //3.gün
        TextView gun3etiket = new TextView(this);
        gun3etiket.setText("Eylül 17");
        gun3etiket.setTypeface(Typeface.SERIF, Typeface.BOLD);
        
        TextView gun3yuksek = new TextView(this);
        gun3yuksek.setText("-4°C");
        gun3yuksek.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun3yuksek.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        TextView gun3dusuk = new TextView(this);
        gun3dusuk.setText("-6°C");
        gun3dusuk.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun3dusuk.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        ImageView gun3durumlar = new ImageView(this);
        gun3durumlar.setImageResource(R.drawable.karli);
        
        gunSatirlari.addView(gun3etiket);
        yuksekSatirlari.addView(gun3yuksek);
        dusukSatirlari.addView(gun3dusuk);
        durumSatirlari.addView(gun3durumlar);
        
        
        
        //4.gün
        TextView gun4etiket = new TextView(this);
        gun4etiket.setText("Eylül 18");
        gun4etiket.setTypeface(Typeface.SERIF, Typeface.BOLD);
        
        TextView gun4yuksek = new TextView(this);
        gun4yuksek.setText("20°C");
        gun4yuksek.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun4yuksek.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        TextView gun4dusuk = new TextView(this);
        gun4dusuk.setText("8°C");
        gun4dusuk.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun4dusuk.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        ImageView gun4durumlar = new ImageView(this);
        gun4durumlar.setImageResource(R.drawable.gunesli);
        
        gunSatirlari.addView(gun4etiket);
        yuksekSatirlari.addView(gun4yuksek);
        dusukSatirlari.addView(gun4dusuk);
        durumSatirlari.addView(gun4durumlar); 
        
        
        
        //5.gün
        TextView gun5etiket = new TextView(this);
        gun5etiket.setText("Eylül 19");
        gun5etiket.setTypeface(Typeface.SERIF, Typeface.BOLD);
        
        TextView gun5yuksek = new TextView(this);
        gun5yuksek.setText("5°C");
        gun5yuksek.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun5yuksek.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        TextView gun5dusuk = new TextView(this);
        gun5dusuk.setText("3°C");
        gun5dusuk.setTypeface(Typeface.SERIF, Typeface.BOLD);
        gun5dusuk.setGravity(Gravity.CENTER_HORIZONTAL);
        
        
        ImageView gun5durumlar = new ImageView(this);
        gun5durumlar.setImageResource(R.drawable.yagmurlu);
        
        gunSatirlari.addView(gun5etiket);
        yuksekSatirlari.addView(gun5yuksek);
        dusukSatirlari.addView(gun5dusuk);
        durumSatirlari.addView(gun5durumlar); 
        
        
        havaDurumuTablosu.addView(baslikSatirlari);
        havaDurumuTablosu.addView(gunSatirlari);
        havaDurumuTablosu.addView(yuksekSatirlari);
        havaDurumuTablosu.addView(dusukSatirlari);
        havaDurumuTablosu.addView(durumSatirlari);
        
        setContentView(havaDurumuTablosu);
    

        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
