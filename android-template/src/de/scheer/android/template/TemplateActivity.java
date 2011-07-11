package de.scheer.android.template;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

/**
 * Showcase of a simple android app.<p>
 * 
 * demonstrates how to:<br>
 * <li>use logging the android way (DONE)
 * <li>populate the options menu (DONE)
 * <li>build a generic info dialog (DONE)
 * <li>reference a view from java (DONE)
 * <li>i18n
 * <li>switch between two activities with explicit intent
 * <li>manage preferences
 * <li>use list adapters
 * <li>how to use services
 * <p>
 * <br>
 * other ideas for sample apps:<br>
 * <li>location-aware app (Reto´s blog)
 * <li>widget example app
 * <li>live wallpaper example app
 * 
 * @author michael
 */
public class TemplateActivity extends Activity {
	
	// each class should have a unique log tag
	private static final String LOG_TAG = "TemplateActivity";
	
	private static final int MENU_NEXT = 1;
	
	private static final int MENU_PREFERENCES = 2;
	
	private static final int MENU_INFO = 3;
	
	private static final int DIALOG_INFO = 100;
	
	private AppSingleton application;
	
	private Button testButton;
    
    @Override
    public void onCreate(final Bundle savedInstanceState) {
    	if (Logging.isEnabled) { 		
    		Log.d(LOG_TAG, "onCreate()");
    	}
        super.onCreate(savedInstanceState);
        application = (AppSingleton) getApplication();
        setContentView(R.layout.main);
        testButton = (Button) findViewById(R.id.testButton);
    }
    
    // is also called after onCreate()
    @Override
	public void onResume() {
    	if (Logging.isEnabled) {    		
    		Log.d(LOG_TAG, "onResume()");	
    	}
		super.onResume();
		startSomeService();
	}

    @Override
	public void onPause() {
    	if (Logging.isEnabled) {     		
    		Log.d(LOG_TAG, "onPause()");	
    	}
		super.onPause();
		stopSomeService();
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
    	menu.add(Menu.NONE, MENU_NEXT, Menu.NONE, "Next").setIcon(
    			android.R.drawable.ic_menu_directions);
		menu.add(Menu.NONE, MENU_PREFERENCES, Menu.NONE, "Preferences")
				.setIcon(android.R.drawable.ic_menu_preferences);
		menu.add(Menu.NONE, MENU_INFO, Menu.NONE, "Info").setIcon(
				android.R.drawable.ic_menu_info_details);
		return true;
	}
    
    @Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		if (MENU_INFO == item.getItemId()) {
			showDialog(DIALOG_INFO);
			return true;
		}
		return false;
	}
    
	@Override
	protected Dialog onCreateDialog(final int id) {
		if (Logging.isEnabled) {
			Log.d(LOG_TAG, "onCreateDialog :" + id);
		}
		switch (id) {
		case (DIALOG_INFO):
			final AlertDialog.Builder builder = new AlertDialog.Builder(
					this);
			builder.setIcon(R.drawable.icon);
			builder.setTitle(getText(R.string.app_name) + " " + application.getVersionName());
			final LayoutInflater inflater = LayoutInflater.from(this);
			builder.setView(inflater.inflate(R.layout.dialog_info, null));
			builder.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
						@Override
						public final void onClick(final DialogInterface dialog,
								final int which) {
							dialog.dismiss();
						}
					});
			return builder.create();
		default:
			return null;
		}
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