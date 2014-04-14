package com.dream.freightapp.app.util;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.dream.freightapp.app.FreightApplication;

public class BaiduLocation {

	private final String tag = "BaiduLocation";

	private LocationClient mLocationClient = null;
	private BDLocationListener listener = null;

	private final int SCAN_SPAN = 10000;// 设置发起定位请求的间隔时间为5000ms
	private final String COOR_TYPE = "bd09ll";// 返回的定位结果是百度经纬度，默认值gcj02
	private final boolean IS_NEED_ADDRESS = false;// 返回的定位结果包含地址信息
	private final boolean NEED_DEVICE_DIRECT = false;// 返回的定位结果包含手机机头的方向
	private final boolean IGNORE_CACHE_EXCEPTION = true;// 设置是否进行异常捕捉
	
	private final LocationMode LOCATION_MODE = LocationMode.Hight_Accuracy;// 高精度定位模式(WIFI + GRPS + GPS)
	//private final LocationMode LOCATION_MODE = LocationMode.Battery_Saving;// 低功耗定位模式(WIFI + GPRS)
	//private final LocationMode LOCATION_MODE = LocationMode.Device_Sensors;// 设备定位模式(GPS)
	
	public BaiduLocation() {
		// TODO Auto-generated constructor stub
	}

	public void start(){
		Log.i(tag, "Start Location");
		mLocationClient = new LocationClient(FreightApplication.getInstance()
				.getApplicationContext());

		mLocationClient.setLocOption(setting());
		
		if(listener != null){
			mLocationClient.registerLocationListener(listener);
			mLocationClient.start();
		}
	}

	public void stop() {
		if (mLocationClient != null) {
			mLocationClient.stop();
		}
	}
	
	public void setListener(BDLocationListener listener){
		this.listener = listener;
	}

	private LocationClientOption setting() {
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LOCATION_MODE);
		option.setCoorType(COOR_TYPE);
		option.setScanSpan(SCAN_SPAN);
		option.setIsNeedAddress(IS_NEED_ADDRESS);
		option.setNeedDeviceDirect(NEED_DEVICE_DIRECT);
		option.SetIgnoreCacheException(IGNORE_CACHE_EXCEPTION);
		return option;
	}

	/**
	 * 检查GPS是否开启
	 * 
	 * @return Boolean
	 */
	@SuppressWarnings("unused")
	private boolean isGPSEnable() {

		LocationManager locationManager = (LocationManager) FreightApplication
				.getInstance().getApplicationContext()
				.getSystemService(Context.LOCATION_SERVICE);
		return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

	/**
	 * 检查网络时否开启
	 * 
	 * @return Boolean
	 */
	@SuppressWarnings("unused")
	private boolean isNetworkEnable() {
		boolean flag = false;

		ConnectivityManager mag = (ConnectivityManager) FreightApplication
				.getInstance().getApplicationContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = mag.getActiveNetworkInfo();
		if (info != null) {
			flag = true;
		}

		/*
		 * info.getSubtype(); NETWORK_TYPE_CDMA 网络类型为CDMA; NETWORK_TYPE_EDGE
		 * 网络类型为EDGE; NETWORK_TYPE_EVDO_0 网络类型为EVDO0; NETWORK_TYPE_EVDO_A
		 * 网络类型为EVDOA; NETWORK_TYPE_GPRS 网络类型为GPRS; NETWORK_TYPE_HSDPA
		 * 网络类型为HSDPA; NETWORK_TYPE_HSPA 网络类型为HSPA; NETWORK_TYPE_HSUPA
		 * 网络类型为HSUPA; NETWORK_TYPE_UMTS 网络类型为UMTS;
		 * 联通的3G为UMTS或HSDPA，移动和联通的2G为GPRS或EDGE，电信的2G为CDMA，电信的3G为EVDO
		 */

		return flag;
	}

	/**
	 * 检查Wifi是否开启｀
	 * 
	 * @return Boolean
	 */
	@SuppressWarnings("unused")
	private boolean isWifiEnable() {
		WifiManager wifi = (WifiManager) FreightApplication.getInstance()
				.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
		return wifi.isWifiEnabled();
	}
}
