package com.dream.freightapp.app.ui.system;

import android.os.Bundle;
import android.util.Log;

import com.dream.freightapp.app.ui.ActionBarActivity;

public class SystemSettingActivity extends ActionBarActivity {

	private static final String tag = "SystemSettingActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(tag, "onCreate");

	}

	@Override
	public boolean isDisplayShowHomeEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int setTitle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isHomeButtonEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int setIcon() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isShowActionBar() {
		// TODO Auto-generated method stub
		return false;
	}
}
