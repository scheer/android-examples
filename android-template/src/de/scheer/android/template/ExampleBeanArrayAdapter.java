package de.scheer.android.template;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExampleBeanArrayAdapter extends ArrayAdapter<ExampleBean> {
	
	private final int resource;
	
	private final LayoutInflater inflater;
	
	public ExampleBeanArrayAdapter(final Context context, final int resource,
			final List<ExampleBean> objects) {		
		super(context, resource, objects);
		this.resource = resource;
		inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		final LinearLayout newView;		
		if (convertView == null) {
			newView = new LinearLayout(getContext());
			inflater.inflate(resource, newView, true);
		} else {
			newView = (LinearLayout) convertView;
		}
		
		final ExampleBean bean = getItem(position);
		
		final TextView nameView = (TextView) newView.findViewById(R.id.name);
		nameView.setText(bean.getName());
		
		final TextView distanceView = (TextView) newView.findViewById(R.id.description);
		distanceView.setText(bean.getDescription());	
		
		return newView;
	}

}
