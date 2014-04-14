package com.dream.freightapp.app.ui.system;

import android.os.Bundle;
import android.util.Log;

import com.dream.freightapp.app.R;
import com.dream.freightapp.app.ui.BarActivity;

public class SystemMessageActivity extends BarActivity {
	private static final String tag = "SystemMessageActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(tag, "onCreate");
		setContentView(R.layout.activity_system);
		setActionBarTitle(R.string.title_system_message);
	}
}
