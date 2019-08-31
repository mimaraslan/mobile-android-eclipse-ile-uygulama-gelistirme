package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        WebView webSayfasi = (WebView) findViewById(R.id.webView1);
		webSayfasi.getSettings().setJavaScriptEnabled(true);
		// webSayfasi.loadUrl("http://www.mimaraslan.com/");

		String veri = "<html>        "
				+ "<head>"
				+ "        <meta charset='utf-8'>"
				+ "        <title>ANDROID PROGRAMLAMA</title>"
				+ "        </head>"
				+ "        <body>"
				+ "        <h1>ANDROID</h1>"
				+ "        <h2>WEBVIEW</h2>" + "        <p>HTML</p>" 
				+ "        <table width='100%' border='1'>"
				+ "          <tr>"
				+ "            <td bgcolor='#FF0000'><strong>1</strong></td>"
				+ "            <td align='center' bgcolor='#00FFFF'><h1>2</h1></td>"
				+ "            <td bgcolor='#66CCFF'>3</td>"
				+ "          </tr>"
				+ "          <tr>"
				+ "            <td align='right' valign='bottom' bgcolor='#FF00FF'>4</td>"
				+ "            <td bgcolor='#33FF00'><h3><em>5</em></h3></td>"
				+ "            <td bgcolor='#FFFF00'><h1>6</h1></td>"
				+ "          </tr>" + "        </table>"
				+ "        </body>" + "        </html>";
		
		webSayfasi.loadData(veri, "text/html", "UTF-16");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
