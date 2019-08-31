package com.mimaraslan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Web_Sayfasini_GosterActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_sayfasini_goster_fragment);

		Intent launchingIntent = getIntent();
		String content = launchingIntent.getData().toString();

		Web_Sayfasini_GosterFragment viewer = (Web_Sayfasini_GosterFragment) getFragmentManager()
				.findFragmentById(R.id.web_sayfasini_goster_fragment);

		viewer.updateUrl(content);
	}

}
