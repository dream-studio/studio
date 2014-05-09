package com.dream.freightapp.app.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.LayoutParams;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.dream.freightapp.app.R;

public abstract class ActionBarActivity extends SherlockActivity {

	private final static String tag = "ActionBarActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(tag, "Start Create Activity!");

		if (isShowActionBar()) {
			initActionBar();
		}

		Log.i(tag, "Finish Init Action Bar!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflator = getSupportMenuInflater();
		inflator.inflate(R.menu.action_bar_menu, menu);
		return false;
	}

	/**
	 * Init ActionBar
	 */
	private void initActionBar() {
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		getSupportActionBar().setDisplayShowCustomEnabled(true);
		View customActionBarView = getLayoutInflater().inflate(
				R.layout.custom_action_bar, null);
		TextView actionBarTitle = (TextView) customActionBarView
				.findViewById(R.id.action_bar_title);

		actionBarTitle.setText(setTitle());

		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, Gravity.CENTER
						| Gravity.CENTER_VERTICAL);
		getSupportActionBar().setCustomView(customActionBarView, lp);
		getSupportActionBar().setDisplayShowHomeEnabled(
				setDisplayShowHomeEnabled());
		getSupportActionBar().setHomeButtonEnabled(setHomeButtonEnabled());

		if (setIcon() != 0) {
			getSupportActionBar().setIcon(setIcon());
		} else {
			getSupportActionBar().setIcon(R.drawable.ic_back);
		}

		getSupportActionBar().setDisplayShowCustomEnabled(true);
	}

	/**
	 * Set Button OnClick listener
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}

		// else if (item.getItemId() == R.id.menu_item_custom_button) {
		// Log.i(tag, "OnClick custom button");
		// return true;
		// }
		return super.onOptionsItemSelected(item);
	}

	@SuppressWarnings("unused")
	private void initApplication() {
		// 取消title
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// 设置全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// 竖屏
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		// 横屏
		// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	public abstract boolean setDisplayShowHomeEnabled();

	public abstract int setTitle();

	public abstract boolean setHomeButtonEnabled();

	public abstract int setIcon();

	public abstract boolean isShowActionBar();

}
