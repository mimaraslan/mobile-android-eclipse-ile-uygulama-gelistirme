package com.mimaraslan;

import static com.mimaraslan.SabitDegerlerSinifi.BIRINCI_KOLON;
import static com.mimaraslan.SabitDegerlerSinifi.IKINCI_KOLON;
import static com.mimaraslan.SabitDegerlerSinifi.UCUNCU_KOLON;
import static com.mimaraslan.SabitDegerlerSinifi.DORDUNCU_KOLON;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class listviewAdapter extends BaseAdapter {
	public ArrayList<HashMap<String, String>> list;
	Activity activity;

	public listviewAdapter(Activity activity,ArrayList<HashMap<String, String>> list) {
		super();
		this.activity = activity;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	private class ViewHolder {
		TextView tvBirinci;
		TextView tvIkinci;
		TextView tvUcuncu;
		TextView tvDorduncu;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listview_row, null);
			holder = new ViewHolder();
			holder.tvBirinci = (TextView) convertView.findViewById(R.id.tvBirinci);
			holder.tvIkinci = (TextView) convertView.findViewById(R.id.tvIkinci);
			holder.tvUcuncu = (TextView) convertView.findViewById(R.id.tvUcuncu);
			holder.tvDorduncu = (TextView) convertView.findViewById(R.id.tvDorduncu);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		HashMap<String, String> map = list.get(position);
		
		holder.tvBirinci.setText(map.get(BIRINCI_KOLON));
		holder.tvIkinci.setText(map.get(IKINCI_KOLON));
		holder.tvUcuncu.setText(map.get(UCUNCU_KOLON));
		holder.tvDorduncu.setText(map.get(DORDUNCU_KOLON));

		return convertView;
	}
}
