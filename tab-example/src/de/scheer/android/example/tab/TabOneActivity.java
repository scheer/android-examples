package de.scheer.android.example.tab;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class TabOneActivity extends Activity {

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		final TextView textview = new TextView(this);
		textview.setText("this is tab one");
		setContentView(textview);
	}
}
