package com.dream.freightapp.app.ui.main.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dream.freightapp.app.R;
import com.dream.freightapp.app.ui.BaseFragment;
import com.dream.freightapp.app.ui.custom.PullToRefreshableView;
import com.dream.freightapp.app.ui.custom.PullToRefreshableView.PullToRefreshListener;

public class FindFragment extends BaseFragment {

	private static final String tag = "FindFragment";

	PullToRefreshableView refreshableView;
	ListView listView;
	// ArrayAdapter<String> adapter;
	// String[] items = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
	// "L" };

	SimpleAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i(tag, "onCreate");
		View view = inflater.inflate(R.layout.fragment_find, container, false);
		init(view);
		return view;
	}

	private void init(View view) {

		refreshableView = (PullToRefreshableView) view
				.findViewById(R.id.fragment_find_custom_pull_to_refresh_refreshable_view);
		listView = (ListView) view
				.findViewById(R.id.fragment_find_listview_datas);

		// adapter = new ArrayAdapter<String>(getActivity(),
		// android.R.layout.simple_list_item_1, items);

		adapter = new SimpleAdapter(getActivity(), getData(),
				R.layout.custom_listview_find, getFrom(), getTo());

		listView.setAdapter(adapter);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				refreshableView.finishRefreshing();
			}
		}, 0);

	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "珠海");
		map.put("custom_listview_find_textview_client", "黄先生");
		map.put("custom_listview_find_textview_phone", "13702331332");
		
		map.put("custom_listview_find_textview_amount", "¥5000.00");
		
		map.put("custom_listview_find_textview_from", "广东 珠海");
		map.put("custom_listview_find_textview_to", "吉林 长春");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-03-29 08:20");
		map.put("custom_listview_find_textview_arrive_date", "2014-04-04 21:30");
		
		map.put("custom_listview_find_textview_status", "抢单");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "广州");
		map.put("custom_listview_find_textview_client", "吴先生");
		map.put("custom_listview_find_textview_phone", "13901111332");
		
		map.put("custom_listview_find_textview_amount", "¥2500.00");
		
		map.put("custom_listview_find_textview_from", "广东 广州");
		map.put("custom_listview_find_textview_to", "湖南 长沙");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-02-26 09:30");
		map.put("custom_listview_find_textview_arrive_date", "2014-02-28 10:00");
		
		map.put("custom_listview_find_textview_status", "已抢单");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "东莞");
		map.put("custom_listview_find_textview_client", "张先生");
		map.put("custom_listview_find_textview_phone", "13302333333");
		
		map.put("custom_listview_find_textview_amount", "¥10000.00");
		
		map.put("custom_listview_find_textview_from", "广东 东莞");
		map.put("custom_listview_find_textview_to", "湖北 武汉");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-01-19 20:20");
		map.put("custom_listview_find_textview_arrive_date", "2014-01-21 21:30");
		
		map.put("custom_listview_find_textview_status", "已关闭");
		list.add(map);
		
		//TODO 重复数据
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "珠海");
		map.put("custom_listview_find_textview_client", "黄先生");
		map.put("custom_listview_find_textview_phone", "13702331332");
		
		map.put("custom_listview_find_textview_amount", "¥5000.00");
		
		map.put("custom_listview_find_textview_from", "广东 珠海");
		map.put("custom_listview_find_textview_to", "吉林 长春");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-03-29 08:20");
		map.put("custom_listview_find_textview_arrive_date", "2014-04-04 21:30");
		
		map.put("custom_listview_find_textview_status", "抢单");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "广州");
		map.put("custom_listview_find_textview_client", "吴先生");
		map.put("custom_listview_find_textview_phone", "13901111332");
		
		map.put("custom_listview_find_textview_amount", "¥2500.00");
		
		map.put("custom_listview_find_textview_from", "广东 广州");
		map.put("custom_listview_find_textview_to", "湖南 长沙");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-02-26 09:30");
		map.put("custom_listview_find_textview_arrive_date", "2014-02-28 10:00");
		
		map.put("custom_listview_find_textview_status", "已抢单");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "东莞");
		map.put("custom_listview_find_textview_client", "张先生");
		map.put("custom_listview_find_textview_phone", "13302333333");
		
		map.put("custom_listview_find_textview_amount", "¥10000.00");
		
		map.put("custom_listview_find_textview_from", "广东 东莞");
		map.put("custom_listview_find_textview_to", "湖北 武汉");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-01-19 20:20");
		map.put("custom_listview_find_textview_arrive_date", "2014-01-21 21:30");
		
		map.put("custom_listview_find_textview_status", "已关闭");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "珠海");
		map.put("custom_listview_find_textview_client", "黄先生");
		map.put("custom_listview_find_textview_phone", "13702331332");
		
		map.put("custom_listview_find_textview_amount", "¥5000.00");
		
		map.put("custom_listview_find_textview_from", "广东 珠海");
		map.put("custom_listview_find_textview_to", "吉林 长春");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-03-29 08:20");
		map.put("custom_listview_find_textview_arrive_date", "2014-04-04 21:30");
		
		map.put("custom_listview_find_textview_status", "抢单");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "广州");
		map.put("custom_listview_find_textview_client", "吴先生");
		map.put("custom_listview_find_textview_phone", "13901111332");
		
		map.put("custom_listview_find_textview_amount", "¥2500.00");
		
		map.put("custom_listview_find_textview_from", "广东 广州");
		map.put("custom_listview_find_textview_to", "湖南 长沙");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-02-26 09:30");
		map.put("custom_listview_find_textview_arrive_date", "2014-02-28 10:00");
		
		map.put("custom_listview_find_textview_status", "已抢单");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "东莞");
		map.put("custom_listview_find_textview_client", "张先生");
		map.put("custom_listview_find_textview_phone", "13302333333");
		
		map.put("custom_listview_find_textview_amount", "¥10000.00");
		
		map.put("custom_listview_find_textview_from", "广东 东莞");
		map.put("custom_listview_find_textview_to", "湖北 武汉");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-01-19 20:20");
		map.put("custom_listview_find_textview_arrive_date", "2014-01-21 21:30");
		
		map.put("custom_listview_find_textview_status", "已关闭");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "珠海");
		map.put("custom_listview_find_textview_client", "黄先生");
		map.put("custom_listview_find_textview_phone", "13702331332");
		
		map.put("custom_listview_find_textview_amount", "¥5000.00");
		
		map.put("custom_listview_find_textview_from", "广东 珠海");
		map.put("custom_listview_find_textview_to", "吉林 长春");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-03-29 08:20");
		map.put("custom_listview_find_textview_arrive_date", "2014-04-04 21:30");
		
		map.put("custom_listview_find_textview_status", "抢单");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "广州");
		map.put("custom_listview_find_textview_client", "吴先生");
		map.put("custom_listview_find_textview_phone", "13901111332");
		
		map.put("custom_listview_find_textview_amount", "¥2500.00");
		
		map.put("custom_listview_find_textview_from", "广东 广州");
		map.put("custom_listview_find_textview_to", "湖南 长沙");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-02-26 09:30");
		map.put("custom_listview_find_textview_arrive_date", "2014-02-28 10:00");
		
		map.put("custom_listview_find_textview_status", "已抢单");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("custom_listview_find_textview_location", "东莞");
		map.put("custom_listview_find_textview_client", "张先生");
		map.put("custom_listview_find_textview_phone", "13302333333");
		
		map.put("custom_listview_find_textview_amount", "¥10000.00");
		
		map.put("custom_listview_find_textview_from", "广东 东莞");
		map.put("custom_listview_find_textview_to", "湖北 武汉");
		
		map.put("custom_listview_find_textview_go_off_date", "2014-01-19 20:20");
		map.put("custom_listview_find_textview_arrive_date", "2014-01-21 21:30");
		
		map.put("custom_listview_find_textview_status", "已关闭");
		list.add(map);
		
		return list;
	}

	private String[] getFrom() {
		return new String[] { 
				"custom_listview_find_textview_location", 
				"custom_listview_find_textview_client", 
				"custom_listview_find_textview_phone",
				
				"custom_listview_find_textview_amount",
				
				"custom_listview_find_textview_from",
				"custom_listview_find_textview_to",
				
				"custom_listview_find_textview_go_off_date",
				"custom_listview_find_textview_arrive_date",
				
				"custom_listview_find_textview_status"
				};
	}

	private int[] getTo() {
		return new int[] {
				R.id.custom_listview_find_textview_location,
				R.id.custom_listview_find_textview_client,
				R.id.custom_listview_find_textview_phone,
				
				R.id.custom_listview_find_textview_amount,
				
				R.id.custom_listview_find_textview_from,
				R.id.custom_listview_find_textview_to,
				
				R.id.custom_listview_find_textview_go_off_date,
				R.id.custom_listview_find_textview_arrive_date,
				
				R.id.custom_listview_find_textview_status
		};
	}

}
