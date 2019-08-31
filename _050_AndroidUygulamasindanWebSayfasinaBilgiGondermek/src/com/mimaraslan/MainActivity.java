package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View.OnClickListener;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button sendButton;
	EditText msgTextField;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        msgTextField = (EditText) findViewById(R.id.msgTextField);
		sendButton = (Button) findViewById(R.id.sendButton);
		
		sendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mesajiGonder(v);
			}
		});

	}

	// main.xml'den bir dumeyi tikladiginizda acilan metod
	public void mesajiGonder(View v) {
		// metin kutusundaki mesaj
		String msg = msgTextField.getText().toString();

		// mesaj alaninin bogli oldugundan emin oluyoruz
		if (msg.length() > 0) {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://mimaraslan.com/bizimPhpScript.php");
			try {
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("id", "12345"));
				nameValuePairs.add(new BasicNameValuePair("mesaj", msg));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				httpclient.execute(httppost);
				msgTextField.setText(""); // mesaj kutusunu temizle
				Toast.makeText(getBaseContext(), msg.toString(), Toast.LENGTH_SHORT).show();
			} catch (ClientProtocolException e) {

			} catch (IOException e) {

			}

		} else {
			// metin alanlari boglise mesaj goruntuler
			Toast.makeText(getBaseContext(), "Bu alan gereklidir.",	Toast.LENGTH_SHORT).show();
		}

	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
