package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import java.util.Locale;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity implements TextToSpeech.OnInitListener {


	private TextToSpeech tts;
	private Button btnOku;
	private EditText txtKonusmaMetni;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

		tts = new TextToSpeech(this, this);

		btnOku = (Button) findViewById(R.id.btnOku);

		txtKonusmaMetni = (EditText) findViewById(R.id.txtKonusmaMetni);

		// dugme  click  olayi
		btnOku.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				speakOut();
			}

		});

    }

    
   
	@Override
	public void onDestroy() {
		// Kapatma unutmayin!
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}

	@Override
	public void onInit(int status) {
	

		if (status == TextToSpeech.SUCCESS) {

			int result = tts.setLanguage(Locale.US);

			// tts.setPitch(5); // Saha duzeyini ayarlama
			// tts.setSpeechRate(2); // konusma hizini ayarlama

			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "Dil desteklenmiyor.");
			} else {
				btnOku.setEnabled(true);
				speakOut();
			}

		} else {
			Log.e("TTS", "Baslatma basarisiz");
		}

	}

	private void speakOut() {

		String text = txtKonusmaMetni.getText().toString();

		tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}

    
    
    
    
    
    
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
