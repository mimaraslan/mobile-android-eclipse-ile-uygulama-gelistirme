package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final int NOTIF_ID = 1234; 
	
    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
 Toast.makeText(this, "Mesajınız var.", Toast.LENGTH_LONG).show();
        
        
        NotificationManager notificationManager = ((NotificationManager) getSystemService(NOTIFICATION_SERVICE));
        
        Notification notumuz = new Notification(R.drawable.mail, "Yeni bir e-posta", System.currentTimeMillis());
        
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        
        
        notumuz.setLatestEventInfo(this, "Yeni bir e-posta", "OKUNMAMIŞ MESAJ UYARISI.", pendingIntent);
        notificationManager.notify(NOTIF_ID,notumuz);
        
        
        new AlertDialog.Builder(this)
        .setTitle("MESAJ")
        .setMessage("Mesaj bildirimi!")
        .setIcon(R.drawable.mail)
        .setNeutralButton("Kapat", null)
        .show();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
