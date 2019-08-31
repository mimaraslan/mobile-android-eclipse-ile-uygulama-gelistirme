package com.mimaraslan;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //  setContentView(R.layout.activity_main);
        
        
        setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(), 
        		R.array.video_egitim_kurslari, R.layout.listemiz));

        final String[] baglantilar = getResources().getStringArray(R.array.web_adresleri);

        getListView().setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            	String content = baglantilar[position];
                Intent showContent = new Intent(getApplicationContext(), WebSayfasiniGosterActivity.class);
                showContent.setData(Uri.parse(content));
                startActivity(showContent);
            }
        });
    }
}