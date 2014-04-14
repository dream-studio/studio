package com.dream.freightapp.app.ui.main.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.dream.freightapp.app.R;
import com.dream.freightapp.app.ui.BaseFragment;

public class PersonCenterFragment extends BaseFragment {

	private static final String tag = "PersonCenterFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i(tag, "onCreateView");
		View view = inflater.inflate(R.layout.fragment_person_center,
				container, false);
		init(view);
		return view;
	}

	private void init(View view) {

		// 车主信息
		RelativeLayout ownerInformation = (RelativeLayout) view
				.findViewById(R.id.fragment_person_center_relativeLayout_owner_information);
		ownerInformation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click owner information!");
			}
		});

		// 车辆信息
		RelativeLayout carInformation = (RelativeLayout) view
				.findViewById(R.id.fragment_person_center_relativeLayout_car_information);
		carInformation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click car information!");
			}
		});

		// 我的证件
		RelativeLayout myDocuments = (RelativeLayout) view
				.findViewById(R.id.fragment_person_center_relativeLayout_my_documents);
		myDocuments.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click my documents!");
			}
		});

		// 我的关注
		RelativeLayout myAttention = (RelativeLayout) view
				.findViewById(R.id.fragment_person_center_relativeLayout_my_attention);
		myAttention.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click my attention!");
			}
		});

		// 修改密码
		RelativeLayout editPassword = (RelativeLayout) view
				.findViewById(R.id.fragment_person_center_relativeLayout_edit_password);
		editPassword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click edit password!");
			}
		});

		// 系统设置
		RelativeLayout systemSetting = (RelativeLayout) view
				.findViewById(R.id.fragment_person_center_relativeLayout_system_setting);
		systemSetting.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click system setting!");
			}
		});

	}
}
