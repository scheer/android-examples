package de.scheer.android.template;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Holds global data.
 */
public class TemplateApplication extends Application {
	
	private String somePreference;
	
	@Override
	public void onCreate() {		
		super.onCreate();
		init();
		loadPreferences();
	}

	private void init() {
		// do something
	}
	
	public void loadPreferences() {
		final SharedPreferences pref = getSharedPreferences(this.getPackageName() +  "_preferences", MODE_PRIVATE);
        
		somePreference = pref.getString("some_preference", "default");  
	}

	public String getSomePreference() {
		return somePreference;
	}

	public void setSomePreference(final String somePreference) {
		this.somePreference = somePreference;
	}
	
}
