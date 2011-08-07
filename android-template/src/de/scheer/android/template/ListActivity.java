package de.scheer.android.template;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * Another nice Activity.<p>
 * 
 * @author michael
 */
public class ListActivity extends Activity {
	
	private static final String LOG_TAG = ListActivity.class.getSimpleName();
	
	private static final int MENU_BACK = 1;
	
	private AppSingleton application;
	
	private ListView listView;
    
    @Override
    public void onCreate(final Bundle savedInstanceState) {
    	if (Logging.isEnabled) { 		
    		Log.d(LOG_TAG, "onCreate()");
    	}
        super.onCreate(savedInstanceState);
        application = (AppSingleton) getApplication();
        setContentView(R.layout.list_activity);	    
	    listView = (ListView) findViewById(R.id.list);	    
	    populateList();	    	    
	    listView.setOnItemClickListener(
            new OnItemClickListener() {          
				@Override
				public void onItemClick(final AdapterView<?> parent, final View view,
						final int position, final long id) {
					
					// Do something on click
				}
            });
    }
    
    private void populateList() {
    	final List<ExampleBean> dummyExampleBeans = generateItems();
		listView.setAdapter(new ExampleBeanArrayAdapter(this,
				R.layout.list_entry, dummyExampleBeans));
	}
    
    private List<ExampleBean> generateItems() {
		final List<ExampleBean> result = new ArrayList<ExampleBean>();
		for (int i = 1; i < 50; i++) {
			final ExampleBean bean = new ExampleBean();
			bean.setName("item " + i);
			bean.setDescription("description");
			result.add(bean);
		}
		return result;
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