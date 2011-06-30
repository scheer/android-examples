package de.scheer.android.template;

import android.app.Activity;
import android.os.Bundle;

/**
 * Demonstration of a simple android app:
 * - Switch between two activities with intent
 * - manage preferences
 * - populate menu
 * - get view per id in java class
 * 
 * @author michael
 */
public class TemplateActivity extends Activity {
    
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}