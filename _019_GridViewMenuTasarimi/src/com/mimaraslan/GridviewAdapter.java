package com.mimaraslan;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridviewAdapter extends BaseAdapter {

	private ArrayList<String> ulkeListesi;
	private ArrayList<Integer> ulkeBayragi;
	private Activity activity;
	
	public GridviewAdapter(Activity activity,  ArrayList<String> ulkeListesi ,ArrayList<Integer> ulkeBayragi){
		super();
		this.ulkeListesi = ulkeListesi;
		this.ulkeBayragi = ulkeBayragi;
		this.activity = activity ;
	}
	
	
	@Override
	public int getCount() {
		return ulkeListesi.size();
	}

	@Override
	public String getItem(int position) {
		return  ulkeListesi.get(position);
	}

	
	@Override
	public long getItemId(int position) {
		return 0;
	}
	

public static class ViewHolder{
	public ImageView imgViewFlag;
	public TextView txtViewTitle;
}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		LayoutInflater inflater = activity.getLayoutInflater();
		
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = inflater.inflate(R.layout.gridview_row, null);
			
			viewHolder.txtViewTitle = (TextView) convertView.findViewById(R.id.textView1);
			viewHolder.imgViewFlag = (ImageView) convertView.findViewById(R.id.imageView1);
			
			convertView.setTag(viewHolder);
			
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		
		viewHolder.txtViewTitle.setText(ulkeListesi.get(position));
		viewHolder.imgViewFlag.setImageResource(ulkeBayragi.get(position));
		
		return convertView;
	}

}
