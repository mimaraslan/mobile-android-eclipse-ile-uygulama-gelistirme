package com.mimaraslan;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class Web_Sayfasini_GosterFragment extends Fragment {
	private WebView viewer = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		viewer = (WebView) inflater.inflate(R.layout.web_sayfasini_goster,	container, false);
		return viewer;
	}

	public void updateUrl(String newUrl) {
		if (viewer != null) {
			viewer.loadUrl(newUrl);
		}
	}
}
