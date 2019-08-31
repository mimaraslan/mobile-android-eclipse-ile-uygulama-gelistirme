package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;


public class MainActivity extends Activity {

	private static final int Menu1_Secilen1 = 0;
	private static final int Menu1_Secilen2 = 1;
	private static final int Menu2_Secilen1 = 21, Menu2_Secilen2 = 22, Menu2_Secilen3 = 23, Menu2_Secilen4 = 24;
	private int GROUP_ID = 4;
	private int ITEM_ID =3;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

  /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
  */   
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
        SubMenu sub1 = menu.addSubMenu(GROUP_ID, ITEM_ID , Menu.CATEGORY_ALTERNATIVE, R.string.submenu_1);
        sub1.setHeaderIcon(R.drawable.ic_add);
        sub1.setIcon(R.drawable.ic_add);
       
        sub1.add(GROUP_ID, Menu1_Secilen1, 0, "Alt menu 1 - Seçilen 1");
        sub1.add(GROUP_ID, Menu1_Secilen2, 1, "Alt menu 1 - Seçilen 2");
        
        
        SubMenu sub2 = menu.addSubMenu(GROUP_ID, ITEM_ID , Menu.CATEGORY_ALTERNATIVE, R.string.submenu_2);
        sub2.setHeaderIcon(R.drawable.ic_delete);
        sub2.setIcon(R.drawable.ic_delete);
       
        sub2.add(GROUP_ID, Menu2_Secilen1, 21, "Alt menu 2 - Seçilen 1");
        sub2.add(GROUP_ID, Menu2_Secilen2, 22, "Alt menu 2 - Seçilen 2");
        sub2.add(GROUP_ID, Menu2_Secilen3, 23, "Alt menu 2 - Seçilen 3");
        sub2.add(GROUP_ID, Menu2_Secilen4, 24, "Alt menu 2 - Seçilen 4");
       
		return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Menu1_Secilen1: 
            	Toast.makeText(this, "Alt menu 1 - Seçilen 1", Toast.LENGTH_LONG).show();
                break;
            case Menu1_Secilen2:
            	Toast.makeText(this, "Alt menu 1 - Seçilen 2", Toast.LENGTH_LONG).show();
                break;
       
            case Menu2_Secilen1:
            	Toast.makeText(this, "Alt menu 2 - Seçilen 1", Toast.LENGTH_LONG).show();
                break;
            case Menu2_Secilen2:
            	Toast.makeText(this, "Alt menu 2 - Seçilen 2", Toast.LENGTH_LONG).show();
                break;
            case Menu2_Secilen3:
            	Toast.makeText(this, "Alt menu 2 - Seçilen 3", Toast.LENGTH_LONG).show();
                break;
            case Menu2_Secilen4:
            	Toast.makeText(this, "Alt menu 2 - Seçilen 4", Toast.LENGTH_LONG).show();
                break;
                
        }
        return true;
    }

    
}
