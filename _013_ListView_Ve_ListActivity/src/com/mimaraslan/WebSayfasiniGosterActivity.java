package com.mimaraslan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class WebSayfasiniGosterActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent sonuc = getIntent();
        String content = sonuc.getData().toString();

        WebView viewer = (WebView) findViewById(R.id.webView1);
        viewer.loadUrl(content);
    }
}
