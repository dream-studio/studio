package com.dream.freightapp.app.ui.main.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dream.freightapp.app.R;
import com.dream.freightapp.app.ui.BaseFragment;

public class IssuancePathFragment extends BaseFragment {
	private static final String tag = "IssuancePathFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i(tag, "onCreate");
		return inflater.inflate(R.layout.fragment_issuance_path, container,
				false);
	}
}
