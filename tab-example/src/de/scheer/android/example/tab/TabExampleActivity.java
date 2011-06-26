package de.scheer.android.example.tab;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Simple tab example. - each tab has it´s own activity - inspired by official
 * android tab tutorial
 * http://developer.android.com/resources/tutorials/views/hello-tabwidget.html
 * 
 * @author michael
 */
public class TabExampleActivity extends TabActivity {

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		final Resources res = getResources(); // Resource object to get Drawables
		final TabHost tabHost = getTabHost(); // The activity TabHost

		addTabOne(tabHost, res);
		addTabTwo(tabHost, res);
		addTabThree(tabHost, res);

		tabHost.setCurrentTab(1);
	}

	private void addTabOne(final TabHost tabHost, final Resources res) {
		final TabHost.TabSpec spec = tabHost.newTabSpec("one");
		spec.setIndicator("Tab One", res.getDrawable(android.R.drawable.ic_dialog_map));
		final Intent intent = new Intent().setClass(this, TabOneActivity.class);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}

	private void addTabTwo(final TabHost tabHost, final Resources res) {
		final TabHost.TabSpec spec = tabHost.newTabSpec("two");
		spec.setIndicator("Tab Two", res.getDrawable(android.R.drawable.ic_dialog_alert));
		final Intent intent = new Intent().setClass(this, TabTwoActivity.class);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}

	private void addTabThree(final TabHost tabHost, final Resources res) {
		final TabHost.TabSpec spec = tabHost.newTabSpec("three");
		spec.setIndicator("Tab Three", res.getDrawable(android.R.drawable.ic_dialog_info));
		final Intent intent = new Intent().setClass(this, TabThreeActivity.class);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}

}