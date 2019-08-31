package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
		Button btnShowProgress;
		private ProgressDialog pDialog;
		ImageView imgIndirilen;
													// Horizontal
		public static final int progress_bar_type = 0; 
	
		private static String file_url = "http://mimaraslan.com/turkce/images/ANDROID%20turkce%20kitap.jpg";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        btnShowProgress = (Button) findViewById(R.id.btnProgressBar);

        imgIndirilen = (ImageView) findViewById(R.id.imgIndirilen);
 
      
        btnShowProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            					// başlıyor new Async Task
                new DownloadFileFromURL().execute(file_url);
            }
        });

        
    }
    
    
    
    
    /**
	 * Dialog Göster
	 * */
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case progress_bar_type:
			pDialog = new ProgressDialog(this);
			pDialog.setMessage("İndiriliyor...");
			pDialog.setIndeterminate(false);
			pDialog.setMax(100);
			pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pDialog.setCancelable(true);
			pDialog.show();
			return pDialog;
		default:
			return null;
		}
	}

	/**
	 * Geri planda Async Task ile indirilen dosya
	 * */
	class DownloadFileFromURL extends AsyncTask<String, String, String> {

		/**
		 * Geri planda thread'den önce ki durum
		 * Progress Bar Dialog gösteriliyor
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			showDialog(progress_bar_type);
		}

		/**
		 * İndirme işlemi thread
		 * */
		@Override
		protected String doInBackground(String... f_url) {
			int count;
	        try {
	            URL url = new URL(f_url[0]);
	            URLConnection conection = url.openConnection();
	            conection.connect();
	            // Dosya uzunluğu
	            int lenghtOfFile = conection.getContentLength();

	            // input stream ile 8k buffer olarak dosya okunuyor. 
	            InputStream input = new BufferedInputStream(url.openStream(), 8192);
	            
	            // Output stream ile indirilen dosya yazılıyor.
	            OutputStream output = new FileOutputStream("/sdcard/downloadedfile.jpg");

	            byte data[] = new byte[1024];

	            long total = 0;

	            while ((count = input.read(data)) != -1) {
	                total += count;
	                // progress işlemi kendini tazeliyor.
	                publishProgress(""+(int)((total*100)/lenghtOfFile));
	                
	                // bilgi yazılıyor
	                output.write(data, 0, count);
	            }

	            // son durum tazeleniyor
	            output.flush();
	            
	            // aktarım streams sonuçlanında kapanışlar yapılıyor
	            output.close();
	            input.close();
	            
	        } catch (Exception e) {
	        	Log.e("Hata: ", e.getMessage());
	        }
	        
	        return null;
		}
		
		/**
		 * progress bar yenileniyor.
		 * */
		protected void onProgressUpdate(String... progress) {
			// yüzde olarak değer
            pDialog.setProgress(Integer.parseInt(progress[0]));
       }

		/**
		 * Tamamlanmadan sonra ki durumda progress dialog sonlanıyor
		 * **/
		@Override
		protected void onPostExecute(String file_url) {
			// İndirme bitince progress dialog yok ediliyor.
			dismissDialog(progress_bar_type);
			
			// sdcard'a indilen resim okunuyor ve gösteriliyor
			String imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile.jpg";
			// İnen resmin gösterilişi
			imgIndirilen.setImageDrawable(Drawable.createFromPath(imagePath));
		}

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
