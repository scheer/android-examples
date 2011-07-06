package de.scheer.android.template;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Showcase of a simple android app.<p>
 * 
 * demonstrates how to:<br>
 * <li>switch between two activities with explicit intent
 * <li>manage preferences
 * <li>i18n
 * <li>populate the menu
 * <li>build a dialog
 * <li>reference a view from java
 * <li>use logging the android way
 * 
 * @author michael
 */
public class TemplateActivity extends Activity {
	
	// each class should have a unique log tag
	private static final String LOG_TAG = "TemplateActivity";
	
	private AppSingleton application;
    
    @Override
    public void onCreate(final Bundle savedInstanceState) {
    	if (Logging.isEnabled) { 		
    		Log.d(LOG_TAG, "onCreate()");
    	}
        super.onCreate(savedInstanceState);
        application = (AppSingleton) getApplication();
        setContentView(R.layout.main);
    }
    
    // is also called after onCreate()
    @Override
	public void onResume() {
    	if (Logging.isEnabled) {    		
    		Log.d(LOG_TAG, "onResume()");	
    	}
		super.onResume();
		startSomeService();
		application.loadPreferences();
	}

    @Override
	public void onPause() {
    	if (Logging.isEnabled) {     		
    		Log.d(LOG_TAG, "onPause()");	
    	}
		super.onPause();
		stopSomeService();
	}
    
	private void startSomeService() {
		if (Logging.isEnabled) {			
			Log.d(LOG_TAG, "starting service");	
		}
		// implement if needed
	}
	
	private void stopSomeService() {
		if (Logging.isEnabled) {			
			Log.d(LOG_TAG, "stopping service");	
		}
		// implement if needed
	}	
	
}