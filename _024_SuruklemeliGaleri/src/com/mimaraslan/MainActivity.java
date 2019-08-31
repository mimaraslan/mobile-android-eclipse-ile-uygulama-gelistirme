package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	private Gallery gallery;
	private ImageAdapter imageAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("Android Foto Galerisi");
        gallery = (Gallery) this.findViewById(R.id.galeri1);
        imageAdapter = new ImageAdapter(this);
        
        gallery.setAdapter(imageAdapter);
        gallery.setOnItemClickListener(this);
    }
    
    
	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int positon, long duration) {
		int kaynakId = (Integer) imageAdapter.getItem(positon);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), kaynakId);
		Toast.makeText(this,
				"Seçilen resmin : " + getResources().getText(kaynakId) + "\n"
				+"Yüksekliği   : " + bitmap.getHeight() +"\n"
				+"Genişliği     : " +bitmap.getWidth(),
				Toast.LENGTH_SHORT).show();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
