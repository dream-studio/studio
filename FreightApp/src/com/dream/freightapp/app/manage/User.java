package com.dream.freightapp.app.manage;

import android.content.ContentValues;
import android.database.Cursor;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.dream.freightapp.app.FreightApplication;
import com.dream.freightapp.app.db.UserTable;
import com.dream.freightapp.app.util.BaiduLocation;

public class User {
	public boolean validate(String account, String password) {

		boolean flag = false;
		
//		ContentValues contentValues = new ContentValues();
//		contentValues.put(UserTable.FIELD_ACCOUNT, account);
//		contentValues.put(UserTable.FIELD_PASSWORD, password);
//
		
//		UserTable userTable = new UserTable();
//		userTable.open();
//		Cursor cursor = userTable.fetch(contentValues);
//		userTable.close();
//		int IDIndex = cursor.getColumnIndex(UserTable.FIELD_PREMARY_KEY_ID);
//		System.out.println(cursor.getInt(IDIndex));

		if ("test".equals(account) && "123".equals(password)) {
			flag = true;

		}
		return flag;
	}

	public boolean create() {
//		ContentValues contentValues = new ContentValues();
//		contentValues.put(UserTable.FIELD_ACCOUNT, "goffee");
//		contentValues.put(UserTable.FIELD_PASSWORD, "123");
//		contentValues.put(UserTable.FIELD_PHONE, "12345679");
//
//		UserTable userTable = new UserTable();
//		userTable.open();
//		userTable.create(contentValues);
//		userTable.close();
		return false;
	}

	public void startLocation() {
		BaiduLocation baiduLocation = new BaiduLocation();
		baiduLocation.setListener(new BDLocationListener() {

			@Override
			public void onReceiveLocation(BDLocation location) {
				// TODO Auto-generated method stub

				if (location == null) {
					return;
				}

				StringBuffer sb = new StringBuffer(256);
				sb.append("Time(时间) : ");
				sb.append(location.getTime());
				sb.append("\nStatus Code(状态码) : ");
				sb.append(location.getLocType());
				sb.append("\nLatitude(纬度) : ");
				sb.append(location.getLatitude());
				sb.append("\nLontitude(经典) : ");
				sb.append(location.getLongitude());
				sb.append("\nRadius(半径) : ");
				sb.append(location.getRadius());
				if (location.getLocType() == BDLocation.TypeGpsLocation) {
					sb.append("\nSpeed(速度) : ");
					sb.append(location.getSpeed());
					sb.append("\nSatellite(卫星数) : ");
					sb.append(location.getSatelliteNumber());
				} else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
					sb.append("\nAddr(地址信息) : ");
					sb.append(location.getAddrStr());
				}

				Toast.makeText(
						FreightApplication.getInstance()
								.getApplicationContext(), sb,
						Toast.LENGTH_SHORT).show();

				System.out.println(sb);
			}

			public void onReceivePoi(BDLocation poiLocation) {
				// TODO Auto-generated method stub

				if (poiLocation == null) {
					return;
				}
				StringBuffer sb = new StringBuffer(256);
				sb.append("Poi time : ");
				sb.append(poiLocation.getTime());
				sb.append("\nerror code : ");
				sb.append(poiLocation.getLocType());
				sb.append("\nlatitude : ");
				sb.append(poiLocation.getLatitude());
				sb.append("\nlontitude : ");
				sb.append(poiLocation.getLongitude());
				sb.append("\nradius : ");
				sb.append(poiLocation.getRadius());
				if (poiLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
					sb.append("\naddr : ");
					sb.append(poiLocation.getAddrStr());
				}
				if (poiLocation.hasPoi()) {
					sb.append("\nPoi:");
					sb.append(poiLocation.getPoi());
				} else {
					sb.append("noPoi information");
				}

				Toast.makeText(
						FreightApplication.getInstance()
								.getApplicationContext(), sb,
						Toast.LENGTH_SHORT).show();
				System.out.println(sb);
			}

		});

		baiduLocation.start();
	}
}
