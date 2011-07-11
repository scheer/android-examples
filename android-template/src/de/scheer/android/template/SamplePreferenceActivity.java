package de.scheer.android.template;


import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;

/**
 * A Preference Activity.
 * 
 * @author michael
 */
public class SamplePreferenceActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener
{

	private final static String LOG_TAG = SamplePreferenceActivity.class.getSimpleName();

	@Override
	public void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.addPreferencesFromResource(R.xml.preferences);
		getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
	}

	@Override
	public void onSharedPreferenceChanged(final SharedPreferences sharedPreferences, final String key)
	{
		if (Logging.isEnabled)
		{
			Log.d(LOG_TAG, "preferences Change:" + key);
		}
		
		// Do something
		
	}

}