package com.dream.freightapp.app;

import android.app.Application;
import android.util.Log;

public class FreightApplication extends Application {

	private static final String tag = "application";
	
	private static FreightApplication instance;
	
	public static Application getInstance(){
		return instance;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		instance = this;
		Log.i(tag, "into Application");
		
	}
	
	
}
