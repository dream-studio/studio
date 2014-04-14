package com.dream.freightapp.app.ui.tool;

import android.content.SharedPreferences;


public class PreferencesTool {

	private static PreferencesTool instance = null;
	private SharedPreferences preferences;
	
	public static PreferencesTool getInstance() {
		// TODO Auto-generated constructor stub
		if (instance == null) {
			instance = new PreferencesTool();
		}
		return instance;
	}
	
	
	
}
