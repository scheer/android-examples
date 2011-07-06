package de.scheer.android.template;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Holds global application state.
 */
public class AppSingleton extends Application {
	
	private static final String LOG_TAG = "TempAppSingleton";
	
	private String somePreference;
	
	@Override
	public void onCreate() {
		if (Logging.isEnabled) { 		
    		Log.d(LOG_TAG, "onCreate()");
    	}
		super.onCreate();
		init();
		loadPreferences();
	}

	private void init() {
		// do something
	}
	
	private void loadPreferences() {
		if (Logging.isEnabled) { 		
    		Log.d(LOG_TAG, "loadPreferences()");
    	}
		final SharedPreferences pref = getSharedPreferences(this.getPackageName() +  "_preferences", MODE_PRIVATE);      
		somePreference = pref.getString("some_preference", "default");  
	}

	public String getSomePreference() {
		return somePreference;
	}

	public void setSomePreference(final String somePreference) {
		// TODO save here
		this.somePreference = somePreference;
	}
	
}
