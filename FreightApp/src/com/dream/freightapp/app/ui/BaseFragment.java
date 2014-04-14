package com.dream.freightapp.app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

public class BaseFragment extends Fragment {

	private static final String tag = "ProccessFragment";
	
	public void goActivity(Class<?> className, Bundle bundle) {
		Log.i(tag, "goActivity");
		Intent i = new Intent(getActivity(), className);
		if (bundle != null) {
			i.putExtras(bundle);
		}
		startActivity(i);
	}

	public void goActivity(Class<?> className) {
		this.goActivity(className, null);
	}

}
