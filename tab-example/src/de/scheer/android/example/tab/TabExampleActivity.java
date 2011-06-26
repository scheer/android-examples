package de.scheer.android.example.tab;


import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

/**
 * Simple tab example.
 * 
 * TODO: improvements: official android tab tutorial
 * http://developer.android.com/resources/tutorials/views/hello-tabwidget.html
 * - each tab has it´s own activity
 * - show distinct icons (disabled/enabled on each tab)
 * 
 * @author michael
 */
public class TabExampleActivity extends TabActivity {
   
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);
        final TabHost tabHost = getTabHost();
        
        LayoutInflater.from(this).inflate(R.layout.tabs, tabHost.getTabContentView(), true);

        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("tab1")
                .setContent(R.id.view1));
        
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("tab2")
                .setContent(R.id.view2));
        
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("tab3")
                .setContent(R.id.view3));
    }
}