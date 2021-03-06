package com.dream.freightapp.app.ui.guide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.dream.freightapp.app.Preferences;
import com.dream.freightapp.app.R;
import com.dream.freightapp.app.ui.ActionBarActivity;
import com.dream.freightapp.app.ui.user.SignInActivity;

public class SplashActivity extends ActionBarActivity {
	// boolean isFirstIn = false;

	private static final int GO_HOME = 1000;
	private static final int GO_GUIDE = 1001;
	// 延迟3秒
	private static final long SPLASH_DELAY_MILLIS = 3000;

	@SuppressWarnings("unused")
	private static final String SHAREDPREFERENCES_NAME = "first_pref";

	/**
	 * Handler:跳转到不同界面
	 */
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();
				break;
			case GO_GUIDE:
				goGuide();
				break;
			}
			super.handleMessage(msg);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		init();
	}

	private void init() {
		// 读取SharedPreferences中需要的数据
		// 使用SharedPreferences来记录程序的使用次数
		// SharedPreferences preferences = getSharedPreferences(
		// SHAREDPREFERENCES_NAME, MODE_PRIVATE);

		// 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
		// isFirstIn = preferences.getBoolean("isFirstIn", true);
		// 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
		// if (!isFirstIn) {
		// 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
		// mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
		// } else {
		// mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
		// }

		if (!Preferences.isShowSplashPage()) {
			// 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
			mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
		} else {
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
		}

	}

	private void goHome() {
		Intent intent = new Intent(SplashActivity.this, SignInActivity.class);
		SplashActivity.this.startActivity(intent);
		SplashActivity.this.finish();
	}

	private void goGuide() {
		Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
		SplashActivity.this.startActivity(intent);
		SplashActivity.this.finish();
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
