package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;


public class MainActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        
        
        setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(),R.array.sosyalaglar, R.layout.listemiz));

		final String[] webSayfasininBaglantilari = getResources().getStringArray(R.array.web_adresleri);

		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int positon, long id) {
				String icerik = webSayfasininBaglantilari[positon];

Intent webSayfasiniGosterIntent = new Intent(getApplicationContext(), WebSayfasiniGoster.class);

				webSayfasiniGosterIntent.setData(Uri.parse(icerik));

				startActivity(webSayfasiniGosterIntent);

			}
		});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
