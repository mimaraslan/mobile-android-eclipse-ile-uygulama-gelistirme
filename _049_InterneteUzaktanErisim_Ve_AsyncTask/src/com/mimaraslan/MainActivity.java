package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.io.InputStream;
import java.net.URL;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	ImageView imgLogo;
	ProgressBar yukleniyor;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        imgLogo = (ImageView) findViewById(R.id.logo);
        yukleniyor = (ProgressBar) findViewById(R.id.yukleniyor);        
    }


	
	
	@SuppressWarnings("deprecation")
	public void btnResimleriYukle(View view)
    {
    	imgLogo.setBackgroundDrawable(LoadImageFromWeb("http://mimaraslan.com/turkce/images/mimar%20aslan%20kartvizit.jpg"));
    					   new loadImageTask().execute("http://mimaraslan.com/turkce/images/ANDROID%20turkce%20kitap.jpg");
    }
    
    public class loadImageTask extends AsyncTask<String, Void, Void>
    {
    	Drawable imgLoad;
    	
    	@Override
    	protected void onPreExecute() {
    		super.onPreExecute();
    		
    		yukleniyor.setVisibility(View.VISIBLE);
    	}
    	
    	@Override
    	protected Void doInBackground(String... params) {
    		imgLoad = LoadImageFromWeb(params[0]);
			return null;
    	}
    	
    
	
		@SuppressWarnings("deprecation")
		@Override
    	protected void onPostExecute(Void result) {
    		super.onPostExecute(result);
    		
    		if(yukleniyor.isShown())
    		{
    			yukleniyor.setVisibility(View.GONE);
    			imgLogo.setVisibility(View.VISIBLE);
    			imgLogo.setBackgroundDrawable(imgLoad);
    		}
    	}
    }
    
    public static Drawable LoadImageFromWeb(String url) 
    {
        try 
        {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
