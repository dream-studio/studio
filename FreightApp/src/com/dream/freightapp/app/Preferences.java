package com.dream.freightapp.app;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

	private static SharedPreferences instance = null;
//	private static SharedPreferences.Editor edit = null;
	
	private final static int PREFERENCES_MODE = Context.MODE_PRIVATE;
	private final static String PREFERENCES_SETTING_NAME = "preferences_setting";
//	private final static String SYSTEM_SETTING_NAME = "systems_setting";

	public static SharedPreferences getPreferences() {
		instance = FreightApplication.getInstance().getSharedPreferences(PREFERENCES_SETTING_NAME, PREFERENCES_MODE);
		return instance;
	}

}