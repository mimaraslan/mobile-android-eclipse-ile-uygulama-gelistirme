package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView txt = (TextView) findViewById(R.id.custom_font);  
        Typeface font = Typeface.createFromAsset(getAssets(), "Chantelli_Antiqua.ttf");  
        txt.setTypeface(font);   
        
        TextView tv = (TextView) findViewById(R.id.tvYazi1);
		Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/CHOCD.otf");
		tv.setTypeface(typeface);

		tv = (TextView) findViewById(R.id.tvYazi2);
		typeface = Typeface.createFromAsset(getAssets(),"fonts/ABADDON.TTF");
		tv.setTypeface(typeface);

		tv = (TextView) findViewById(R.id.tvYazi3);
		typeface = Typeface.createFromAsset(getAssets(),"fonts/ANGEL.otf");
		tv.setTypeface(typeface);

		tv = (TextView) findViewById(R.id.tvYazi4);
		typeface = Typeface.createFromAsset(getAssets(),"fonts/NorthernTerritories.ttf");
		tv.setTypeface(typeface);

		tv = (TextView) findViewById(R.id.tvYazi5);
		typeface = Typeface.createFromAsset(getAssets(),"fonts/WoodWud.ttf");
		tv.setTypeface(typeface);    
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
