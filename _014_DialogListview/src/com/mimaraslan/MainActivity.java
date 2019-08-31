package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
    	final CharSequence[] digitList = { "Android", "iPhone", "Blackberry" };

		AlertDialog.Builder alt_bid = new AlertDialog.Builder(this);
		alt_bid.setIcon(R.drawable.visa);
		alt_bid.setTitle("Lütfen seçimlerinizi yapınız.");

		alt_bid.setMultiChoiceItems(digitList, new boolean[] { true, false, false },
				new OnMultiChoiceClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {

				Toast.makeText(getApplicationContext(), "Seçilen birşey var.", Toast.LENGTH_LONG).show();	
				
			}
		});

		alt_bid.setPositiveButton("Tamam", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				ListView list = ((AlertDialog) dialog).getListView();

				StringBuilder sb = new StringBuilder();

				for (int position = 0; position < list.getCount(); position++) {
					boolean seciliMi = list.isItemChecked(position);

					if (seciliMi) {
						if (sb.length() > 0) {
							sb.append(", ");
							}
						
							sb.append(list.getItemAtPosition(position));
					}
					
				}
				
				Toast.makeText(getApplicationContext(), "SEÇİMİNİZ : " + sb.toString(),Toast.LENGTH_LONG).show();	
		
			}
		});

		alt_bid.setNegativeButton("İptal", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {

						Toast.makeText(getApplicationContext(), 
								"İptal düğmesine bastınız.",
								Toast.LENGTH_LONG).show();	
						
					}
				});

		AlertDialog alertDialog = alt_bid.create();
		alertDialog.show();

        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
