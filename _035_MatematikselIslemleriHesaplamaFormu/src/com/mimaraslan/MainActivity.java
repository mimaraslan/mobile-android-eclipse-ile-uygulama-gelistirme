package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class MainActivity extends Activity {

	// Uygulama elemanlar˝m˝z ile ileti˛ime geÁelim
		private EditText txtTutar;
		private EditText txtKisiSayisi;
		private EditText txtElleGirilenYuzdeOrani;
		private RadioGroup rdoGroupKdv;
		private Button btnHesapla;
		private Button btnTemizle;
		private TextView txtKdv;
		private TextView txtToplamOdenecekTutar;
		private TextView txtKisiSayisiOdenecekMiktar;

	// KDV seÁim kutular˝n˝n seÁim durumu iÁin
		private int radioSeciliDurumId = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     // Viewlerimiz ile ileti˛im kural˝m.
     		txtTutar = (EditText) findViewById(R.id.txtTutar);
     		
     // Kursor'fokuslanmas˝na izin verelim.
     		txtTutar.requestFocus();
     		
     		txtKisiSayisi = (EditText) findViewById(R.id.txtKisiSayisi);
     		
     		txtElleGirilenYuzdeOrani = (EditText) findViewById(R.id.txtElleGirilenYuzdeOrani);
     		
     		rdoGroupKdv = (RadioGroup) findViewById(R.id.RadioGroupKdv);
     		
     		btnHesapla = (Button) findViewById(R.id.btnHesapla);
     		
     // Ba˛lang˝Áta hesaplama butununu kullan˝lamaz disable hale getirelim.
     		btnHesapla.setEnabled(false);

     		btnTemizle = (Button) findViewById(R.id.btnTemizle);

     		txtKdv = (TextView) findViewById(R.id.txtKdv);
     		txtToplamOdenecekTutar = (TextView) findViewById(R.id.txtToplamOdenecekTutar);
     		txtKisiSayisiOdenecekMiktar = (TextView) findViewById(R.id.txtKisiSayisiOdenecekMiktar);

     // Elle girilen kutucuu ba˛lang˝Áta disable hale getirelim.
     		txtElleGirilenYuzdeOrani.setEnabled(false);

     		
     //Kullan˝c˝n˝n hangi radio butonunu seÁtiini belirleyelim.
     		rdoGroupKdv.setOnCheckedChangeListener(new OnCheckedChangeListener() {

     			@Override
     			public void onCheckedChanged(RadioGroup group, int checkedId) {
     			
     				if (checkedId == R.id.radioOnBes || checkedId == R.id.radioYirmi) {
     					txtElleGirilenYuzdeOrani.setEnabled(false);
     					
     					//Text kutucuklar˝na girilen deerlerin s˝f˝rdan b¸y¸k olmas˝n˝ salayal˝m. 
     					btnHesapla.setEnabled(txtTutar.getText().length() > 0	&& txtKisiSayisi.getText().length() > 0);
     				}
     				if (checkedId == R.id.radioBaska) {
     					
     					// Eer ba˛ka bir KDV seÁenek oran˝ girilecekse text kutucuunu aktifle˛tirelim.
     					txtElleGirilenYuzdeOrani.setEnabled(true);
     					
     					// fokuslanmaya izin verelim.
     					txtElleGirilenYuzdeOrani.requestFocus();
     		
     					//HESAPLAMA D‹–MES›N› AKT›FLEﬁT›R
     btnHesapla.setEnabled(txtTutar.getText().length() > 0	&& txtKisiSayisi.getText().length() > 0
     														&& txtElleGirilenYuzdeOrani.getText().length() > 0);
     				}	
     				
     				//KDV ORANI SE«›M DURUMU
     				radioSeciliDurumId = checkedId;
     			}
     		});

     		//SE«›LEN KDV SE«›M ORANI
     		txtTutar.setOnKeyListener(mKeyListener);
     		txtKisiSayisi.setOnKeyListener(mKeyListener);
     		txtElleGirilenYuzdeOrani.setOnKeyListener(mKeyListener);

     		//HESAPLAMA VE TEM›LE D‹–MELER› ›«›N KULLANILACAK OLAY
     		btnHesapla.setOnClickListener(onClickListener);
     		btnTemizle.setOnClickListener(onClickListener);
     	}

     //BU OLAYI txtTutar	txtKisiSayisi VE txtElleGirilenYuzdeOrani ›«›N KULLANCA–IZ
     	private OnKeyListener mKeyListener = new OnKeyListener() {
     		@Override
     		public boolean onKey(View v, int keyCode, KeyEvent event) {
      
     			switch (v.getId()) {
     			case R.id.txtTutar:
     			case R.id.txtKisiSayisi:
     						btnHesapla.setEnabled(txtTutar.getText().length() > 0
     						&& txtKisiSayisi.getText().length() > 0);
     				break;
     			case R.id.txtElleGirilenYuzdeOrani:
     						btnHesapla.setEnabled(txtTutar.getText().length() > 0
     						&& txtKisiSayisi.getText().length() > 0
     						&& txtElleGirilenYuzdeOrani.getText().length() > 0);
     				break;
     			}
     			return false;
     		}

     	};

     	
     	
     	//HESAPLAMA VE TEM›ZLE D‹–MELER› ›«›N KULLANILACAK OLAY
     	private OnClickListener onClickListener = new OnClickListener() {

     		@Override
     		public void onClick(View v) {
     			if (v.getId() == R.id.btnHesapla) {
     				hesapla();
     			} else {
     				temizle();
     			}
     		}
     	};


     	//HESAPLAMA METODU
     	private void hesapla() {
     		Double kdvsizTutar = Double.parseDouble(txtTutar.getText().toString());
     		Double totalKisiSayisi = Double.parseDouble(txtKisiSayisi.getText().toString());
     		Double kdvOrani = null;
     		boolean hataVarmi = false;
     		if (kdvsizTutar < 1.0) {
     			hataAlertMesajiniGoster("GeÁerli Toplam Tutar girin.", txtTutar.getId());
     			hataVarmi = true;
     		}

     		if (totalKisiSayisi < 1.0) {
     			hataAlertMesajiniGoster("Ki˛i say˝s˝ iÁin geÁerli bir deer girin.", txtKisiSayisi.getId());
     			hataVarmi = true;
     		}

     		
     	//RADIO SE«›M DURUMLARI
     		if (radioSeciliDurumId == -1) {
     			radioSeciliDurumId = rdoGroupKdv.getCheckedRadioButtonId();
     		}
     		if (radioSeciliDurumId == R.id.radioOnBes) {
     			kdvOrani = 15.00;
     		} else if (radioSeciliDurumId == R.id.radioYirmi) {
     			kdvOrani = 20.00;
     		} else if (radioSeciliDurumId == R.id.radioBaska) {
     			kdvOrani = Double.parseDouble(txtElleGirilenYuzdeOrani.getText().toString());
     			if (kdvOrani < 1.0) {
     				hataAlertMesajiniGoster("Geçerli bir y¸zdelik oran˝ girin", txtElleGirilenYuzdeOrani.getId());
     				hataVarmi = true;
     			}
     		}
     	
     		//HATA DENET›M› VE HESAPLAMA
     		if (!hataVarmi) {
     			Double kdvTutarMiktari = ((kdvsizTutar * kdvOrani) / 100);
     			Double kdvliToplamTutar = kdvsizTutar + kdvTutarMiktari;
     			Double perPersonPays = kdvliToplamTutar / totalKisiSayisi;

     			txtKdv.setText(kdvTutarMiktari.toString());
     			txtToplamOdenecekTutar.setText(kdvliToplamTutar.toString());
     			txtKisiSayisiOdenecekMiktar.setText(perPersonPays.toString());
     		} 
     	}

     	
     	//TEM›ZLEME D‹–MES›
    	private void temizle() {
    		txtKdv.setText("");
    		txtToplamOdenecekTutar.setText("");
    		txtKisiSayisiOdenecekMiktar.setText("");
    		txtTutar.setText("");
    		txtKisiSayisi.setText("");
    		txtElleGirilenYuzdeOrani.setText("");
    		rdoGroupKdv.clearCheck();
    		rdoGroupKdv.check(R.id.radioOnBes);
    		txtTutar.requestFocus();
    	}

    	
    //HATA MESAJI OLURSA VER›LECEK ALERT MESAJI
    	private void hataAlertMesajiniGoster(String errorMessage, final int fieldId) {
    		new AlertDialog.Builder(this).setTitle("Hata Mesaj˝").setMessage(errorMessage).setNeutralButton("",new DialogInterface.OnClickListener() {
    							@Override
    							public void onClick(DialogInterface dialog,int which) {
    								findViewById(fieldId).requestFocus();
    							}
    						}).show();
    	}	
     	
     	
     	
     	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
