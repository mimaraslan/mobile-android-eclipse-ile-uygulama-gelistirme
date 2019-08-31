package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener
{
	//private static final String TAG = "_038_IntervalZamanlayici";
	private GeriSayimSinifi geriSayim;
	private long gecenSure;
	private boolean zamanlayiciBasladi = false;
	private Button baslatmaDugmesi;
	private TextView sonDurum;
	private TextView gecenSureyiGoruntule;

	private final long baslamaZamani = 50000;
	private final long intervalAraligi = 1000;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        baslatmaDugmesi = (Button) this.findViewById(R.id.button);
		baslatmaDugmesi.setOnClickListener(this);

		sonDurum = (TextView) this.findViewById(R.id.zaman);
		gecenSureyiGoruntule = (TextView) this.findViewById(R.id.gecenSure);
		geriSayim = new GeriSayimSinifi(baslamaZamani, intervalAraligi);
		sonDurum.setText(sonDurum.getText() + String.valueOf(baslamaZamani));

    }

    
    
    @Override
	public void onClick(View v)
		{
			if (!zamanlayiciBasladi)
				{
				    geriSayim.start();
					zamanlayiciBasladi = true;
					baslatmaDugmesi.setText("Başlat");
				}
			else
				{

			    	geriSayim.cancel();
					zamanlayiciBasladi = false;
					baslatmaDugmesi.setText("Sıfırla");
				}
		}


	public class GeriSayimSinifi extends CountDownTimer
		{

			public GeriSayimSinifi(long startTime, long interval)
				{
					super(startTime, interval);
				}

			@Override
			public void onFinish()
				{
				sonDurum.setText("Süre doldu!");
					gecenSureyiGoruntule.setText("Geçen süre: " + String.valueOf(baslamaZamani));
				}

			@Override
			public void onTick(long millisUntilFinished)
				{
				sonDurum.setText("Kalan süre:" + millisUntilFinished);
					gecenSure = baslamaZamani - millisUntilFinished;
					gecenSureyiGoruntule.setText("Geçen süre: " + String.valueOf(gecenSure));
				}
		}

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
