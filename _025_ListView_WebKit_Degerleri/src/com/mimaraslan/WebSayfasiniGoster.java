package com.mimaraslan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class WebSayfasiniGoster extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.web_sayfasini_goster);

		Intent alinanAdresBilgisiIntent = getIntent();
		String icerik = alinanAdresBilgisiIntent.getData().toString();

		WebView webView = (WebView) findViewById(R.id.webView1);
		webView.loadUrl(icerik);
	}
}
