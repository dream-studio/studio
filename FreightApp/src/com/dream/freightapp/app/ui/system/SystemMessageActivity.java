package com.dream.freightapp.app.ui.system;

import android.os.Bundle;
import android.util.Log;

import com.dream.freightapp.app.R;
import com.dream.freightapp.app.ui.ActionBarActivity;

public class SystemMessageActivity extends ActionBarActivity {
	private static final String tag = "SystemMessageActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i(tag, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_system);
	}

	@Override
	public boolean setDisplayShowHomeEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int setTitle() {
		// TODO Auto-generated method stub
		return R.string.title_system_message;
	}

	@Override
	public boolean setHomeButtonEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int setIcon() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isShowActionBar() {
		// TODO Auto-generated method stub
		return true;
	}

}
