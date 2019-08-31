package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.content.Intent;
import android.net.Uri;



public class MainActivity extends Activity implements Listemiz_Fragment.OnTutSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listemiz_fragment);
	}

	public void onTutSelected(String tutUrl) {
		Web_Sayfasini_GosterFragment viewer = (Web_Sayfasini_GosterFragment) getFragmentManager()
				.findFragmentById(R.id.web_sayfasini_goster_fragment);

		if (viewer == null || !viewer.isInLayout()) {
			Intent showContent = new Intent(getApplicationContext(),Web_Sayfasini_GosterActivity.class);
			showContent.setData(Uri.parse(tutUrl));
			startActivity(showContent);
		} else {
			viewer.updateUrl(tutUrl);
		}
	}



	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
