package com.dream.freightapp.app.ui.main.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.dream.freightapp.app.R;
import com.dream.freightapp.app.ui.BaseFragment;
import com.dream.freightapp.app.ui.system.SystemMessageActivity;

public class HomeFragment extends BaseFragment {

	private static final String tag = "HomeFragment";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i(tag, "onCreate");
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		init(view);
		return view;
	}

	private void init(View view) {
		// 货源信息
		RelativeLayout goodsMessage = (RelativeLayout) view
				.findViewById(R.id.fragment_home_relativeLayout_goods_message);
		goodsMessage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click goods message!");
			}
		});

		// 积分信息
		RelativeLayout integralMessage = (RelativeLayout) view
				.findViewById(R.id.fragment_home_relativeLayout_integral_message);
		integralMessage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click integral message!");
			}
		});

		// 发布路径信息
		RelativeLayout issuancePathMessage = (RelativeLayout) view
				.findViewById(R.id.fragment_home_relativeLayout_issuance_path_message);
		issuancePathMessage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click issuance path message!");
			}
		});

		// 系统信息
		RelativeLayout systemMessage = (RelativeLayout) view
				.findViewById(R.id.fragment_home_relativeLayout_system_message);
		systemMessage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click system message!");
				Bundle bundle = new Bundle();
				bundle.putString("demo", "hello world");
				goActivity(SystemMessageActivity.class, bundle);
			}
		});

		// 交易信息
		RelativeLayout transactionMessage = (RelativeLayout) view
				.findViewById(R.id.fragment_home_relativeLayout_transaction_message);
		transactionMessage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click transaction message!");
			}
		});
	}

}
