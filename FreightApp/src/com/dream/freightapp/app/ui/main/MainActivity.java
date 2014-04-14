package com.dream.freightapp.app.ui.main;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.dream.freightapp.app.R;
import com.dream.freightapp.app.ui.main.fragment.FindFragment;
import com.dream.freightapp.app.ui.main.fragment.HomeFragment;
import com.dream.freightapp.app.ui.main.fragment.IssuancePathFragment;
import com.dream.freightapp.app.ui.main.fragment.PersonCenterFragment;
import com.dream.freightapp.app.ui.tool.TabManager;

public class MainActivity extends FragmentActivity {
	public static final String tag = "MainActiviy";
	public TabHost tabHost;
	public TabManager tabManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(tag, "onCreate");
		// set application title display none;
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);
				
		tabHost = (TabHost) findViewById(R.id.main_tabhost);
		tabHost.setup();

		tabManager = new TabManager(this, tabHost, android.R.id.tabcontent);

		tabManager.addTab(
				tabHost.newTabSpec(getString(R.string.activity_main_tab_home))
						.setIndicator(buildTabHostView(R.string.activity_main_tab_home, R.drawable.ic_home)),
				HomeFragment.class, null);

		tabManager.addTab(
				tabHost.newTabSpec(getString(R.string.activity_main_tab_find))
						.setIndicator(buildTabHostView(R.string.activity_main_tab_find, R.drawable.ic_search)),
				FindFragment.class, null);

		tabManager.addTab(
				tabHost.newTabSpec(
						getString(R.string.activity_main_tab_issuance_path))
						.setIndicator(buildTabHostView(R.string.activity_main_tab_issuance_path, R.drawable.ic_home)),
				IssuancePathFragment.class, null);

		tabManager.addTab(
				tabHost.newTabSpec(
						getString(R.string.activity_main_tab_person_center))
						.setIndicator(buildTabHostView(R.string.activity_main_tab_person_center, R.drawable.ic_settings)),
				PersonCenterFragment.class, null);

		tabHost.setCurrentTab(0);
	}
	
	private View buildTabHostView(int label, int iconId) {
		View tabIndicator = LayoutInflater.from(this).inflate(
				R.layout.custom_tab_indicator, tabHost.getTabWidget(), false);
		TextView title = (TextView) tabIndicator
				.findViewById(R.id.custom_tab_indicator_title);
		title.setText(label);
		ImageView icon = (ImageView) tabIndicator
				.findViewById(R.id.custom_tab_indicator_icon);
		icon.setImageResource(iconId);
		return tabIndicator;
	}

}
