package com.dream.freightapp.app.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class BaseFragmentActivity extends FragmentActivity {

	private static final String tag = "BaseFragmentActivity";
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		Log.i(tag, "onCreate");
		
	}
	
}
