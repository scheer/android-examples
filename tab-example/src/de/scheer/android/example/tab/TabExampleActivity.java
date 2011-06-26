package de.scheer.android.example.tab;


import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Simple tab example.
 *  - each tab has it´s own activity
 *  - inspired by official android tab tutorial
 *  http://developer.android.com/resources/tutorials/views/hello-tabwidget.html
 *  
 *  TODO: - different icons per tab
 * 
 * @author michael
 */
public class TabExampleActivity extends TabActivity {
   	
	@Override
	public void onCreate(final Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    final Resources res = getResources(); // Resource object to get Drawables
	    final TabHost tabHost = getTabHost();  // The activity TabHost
	   
	    addTabOne(tabHost, res);
	    addTabTwo(tabHost, res);
	    addTabThree(tabHost, res);

	    tabHost.setCurrentTab(1);
	}
	
	private void addTabOne(final TabHost tabHost, final Resources res) {
		 // Create an Intent to launch an Activity for the tab (to be reused)
	    final Intent intent = new Intent().setClass(this, TabOneActivity.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    final TabHost.TabSpec spec = tabHost.newTabSpec("one").setIndicator("Tab One",
	                      res.getDrawable(R.drawable.ic_tab_artists_grey))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	}
	
	private void addTabTwo(final TabHost tabHost, final Resources res) {
		 // Create an Intent to launch an Activity for the tab (to be reused)
	    final Intent intent = new Intent().setClass(this, TabTwoActivity.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    final TabHost.TabSpec spec = tabHost.newTabSpec("two").setIndicator("Tab Two",
	                      res.getDrawable(R.drawable.ic_tab_artists_grey))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	}
	
	private void addTabThree(final TabHost tabHost, final Resources res) {
		 // Create an Intent to launch an Activity for the tab (to be reused)
	    final Intent intent = new Intent().setClass(this, TabThreeActivity.class);
	    
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    final TabHost.TabSpec spec = tabHost.newTabSpec("three").setIndicator("Tab Three",
	                      res.getDrawable(R.drawable.ic_tab_artists_grey))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	}	
	
}