package com.mimaraslan;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ImageAdapter extends BaseAdapter {
	private Context _context = null;
	
	private final int[] imageIds = {
			R.drawable.murat_aslan_1,
			R.drawable.murat_aslan_2,
			R.drawable.murat_aslan_3,
			R.drawable.murat_aslan_4,
			R.drawable.murat_aslan_5,
			R.drawable.murat_aslan_6,
		R.drawable.kulliyat,
		R.drawable.box,
		R.drawable.calendar,
		R.drawable.cart,
		R.drawable.chat,
		R.drawable.civciv,
		R.drawable.gears,
		R.drawable.heart,
		R.drawable.home,
		R.drawable.ic_launcher,
		R.drawable.key,
		R.drawable.lock,
		R.drawable.mail,
		R.drawable.notepad,
		R.drawable.truck,
		R.drawable.user_female,
		R.drawable.user_male,
		R.drawable.visa	
	};

	public ImageAdapter (Context context){
		this._context = context;
	}
	
	@Override
	public int getCount() {
		return imageIds.length;
	}

	@Override
	public Object getItem(int index) {
		return imageIds[index];
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int position, View view, ViewGroup group) {
		ImageView imageView = new ImageView(_context);
		imageView.setImageResource(imageIds[position]);
		imageView.setScaleType(ScaleType.FIT_XY);
		imageView.setLayoutParams(new Gallery.LayoutParams(400, 400));
		return imageView;
	}

}
