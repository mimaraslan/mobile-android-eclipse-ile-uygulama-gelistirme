package com.mimaraslan;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.widget.Toast;


public class MainActivity extends Activity implements ActionBar.TabListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        ActionBar bar = getActionBar();
        
        bar.addTab(bar.newTab().setIcon(R.drawable.box).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.calendar).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.cart).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.chat).setTabListener(this));        
        bar.addTab(bar.newTab().setIcon(R.drawable.gears).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.heart).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.home).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.ic_launcher).setTabListener(this));    
        bar.addTab(bar.newTab().setIcon(R.drawable.key).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.lock).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.mail).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.notepad).setTabListener(this));        
        bar.addTab(bar.newTab().setIcon(R.drawable.truck).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.user_female).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.user_male).setTabListener(this));
        bar.addTab(bar.newTab().setIcon(R.drawable.visa).setTabListener(this));
        
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_USE_LOGO );
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        bar.setDisplayShowHomeEnabled(true);
        bar.setDisplayShowTitleEnabled(true);
        
    }

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		
		Toast.makeText(getApplicationContext(), 
				"SIRASI : " +tab.getPosition(),
				Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

        
 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
