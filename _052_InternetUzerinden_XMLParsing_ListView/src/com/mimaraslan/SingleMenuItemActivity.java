package com.mimaraslan;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleMenuItemActivity  extends Activity {
	
	// XML node keys KOK ELEMANLARI
	static final String ADI = "name";
	static final String MAAS = "salary";
	static final String ACIKLAMA = "description";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        
        // intent ILE VERILER ALINIYOR
        Intent in = getIntent();
        
        // XML VERI DEGERLERI intent ICERISINDEN ALINIYOR
        String adi = in.getStringExtra(ADI);
        String maas = in.getStringExtra(MAAS);
        String aciklama = in.getStringExtra(ACIKLAMA);
        
        // ALINAN VERILER BIR BILESENDE EKRANADA GOSTERILIYOR
        TextView lblAdi= (TextView) findViewById(R.id.adi_etiketi);
        TextView lblMaas = (TextView) findViewById(R.id.maas_etiketi);
        TextView lblAciklama = (TextView) findViewById(R.id.aciklama_etiketi);
        
        lblAdi.setText(adi);
        lblMaas.setText(maas);
        lblAciklama.setText(aciklama);
    }
}
