package com.dream.freightapp.app;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

	private final static int PREFERENCES_MODE = Context.MODE_PRIVATE;
	public final static String PREFERENCES_USER = "user_preferences";// 用户级信息
	public final static String PREFERENCES_SYSTEM = "system_preferences";// 系统级信息

	private final static String SPLASH_PAGE = "splash_page";

	public static SharedPreferences getSharedPreferences(String name) {
		return FreightApplication.getInstance().getSharedPreferences(name,
				PREFERENCES_MODE);

	}

	public static SharedPreferences getSystemSharedPreferences() {
		return getSharedPreferences(PREFERENCES_SYSTEM);
	}

	public static SharedPreferences getUserSharedPreferences() {
		return getSharedPreferences(PREFERENCES_USER);
	}

	//控制欢迎界面
	public static boolean isShowSplashPage(){
		return getSystemSharedPreferences().getBoolean(SPLASH_PAGE, true);
	}
	
	public static void  setSplashPage(boolean isShow){
		getSystemSharedPreferences().edit().putBoolean(SPLASH_PAGE, isShow).commit();
	}
	
}
