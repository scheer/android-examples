package de.scheer.android.template;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Another nice Activity.<p<
 * 
 * @author michael
 */
public class SecondaryActivity extends Activity {
	
	private static final String LOG_TAG = "SecondaryActivity";
	
	private static final int MENU_BACK = 1;
	
	private AppSingleton application;
    
    @Override
    public void onCreate(final Bundle savedInstanceState) {
    	if (Logging.isEnabled) { 		
    		Log.d(LOG_TAG, "onCreate()");
    	}
        super.onCreate(savedInstanceState);
        application = (AppSingleton) getApplication();
        setContentView(R.layout.secondary);
    }
    
    // is also called after onCreate()
    @Override
	public void onResume() {
    	if (Logging.isEnabled) {    		
    		Log.d(LOG_TAG, "onResume()");	
    	}
		super.onResume();
	}

    @Override
	public void onPause() {
    	if (Logging.isEnabled) {     		
    		Log.d(LOG_TAG, "onPause()");	
    	}
		super.onPause();
	}
    
    /**
     * Use the standard android icons for the menu at all times.<p>
     * For a good overview, which icons are available have a look at:<br>
     * http://androiddrawableexplorer.appspot.com/
     */
    @Override
	public boolean onCreateOptionsMenu(final Menu menu) {
    	if (Logging.isEnabled) {     		
    		Log.d(LOG_TAG, "onCreateOptionsMenu()");	
    	}
    	menu.add(Menu.NONE, MENU_BACK, Menu.NONE, "Back").setIcon(
    			android.R.drawable.ic_menu_directions);
		return true;
	}
    
    @Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		if (MENU_BACK == item.getItemId()) {			
			startActivity(new Intent(getApplicationContext(), MainActivity.class));
		}
		return false;
	}
	
}