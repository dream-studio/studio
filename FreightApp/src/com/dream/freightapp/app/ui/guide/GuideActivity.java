package com.dream.freightapp.app.ui.guide;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dream.freightapp.app.R;
import com.dream.freightapp.app.adapter.guide.GuideViewPagerAdapter;
import com.dream.freightapp.app.ui.ActionBarActivity;

public class GuideActivity extends ActionBarActivity implements OnPageChangeListener {

	private ViewPager vp;
	private GuideViewPagerAdapter vpAdapter;
	private List<View> views;

	// 底部小点图片
	private ImageView[] dots;

	// 记录当前选中位置
	private int currentIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		// 初始化页面
		initViews();
		// 初始化底部小点
		initDots();
	}

	private void initViews() {
		LayoutInflater inflater = LayoutInflater.from(this);

		views = new ArrayList<View>();
		// 初始化引导图片列表
		views.add(inflater.inflate(R.layout.fragment_guide_page_one, null));
		views.add(inflater.inflate(R.layout.fragment_guide_page_two, null));
		views.add(inflater.inflate(R.layout.fragment_guide_page_three, null));
		views.add(inflater.inflate(R.layout.fragment_guide_page_four, null));

		// 初始化Adapter
		vpAdapter = new GuideViewPagerAdapter(views, this);

		vp = (ViewPager) findViewById(R.id.viewpager);
		vp.setAdapter(vpAdapter);
		// 绑定回调
		vp.setOnPageChangeListener(this);
	}

	private void initDots() {
		LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

		dots = new ImageView[views.size()];

		// 循环取得小点图片
		for (int i = 0; i < views.size(); i++) {
			dots[i] = (ImageView) ll.getChildAt(i);
			dots[i].setEnabled(true);// 都设为灰色
		}

		currentIndex = 0;
		dots[currentIndex].setEnabled(false);// 设置为白色，即选中状态
	}

	private void setCurrentDot(int position) {
		if (position < 0 || position > views.size() - 1
				|| currentIndex == position) {
			return;
		}

		dots[position].setEnabled(false);
		dots[currentIndex].setEnabled(true);

		currentIndex = position;
	}

	// 当滑动状态改变时调用
	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	// 当当前页面被滑动时调用
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	// 当新的页面被选中时调用
	@Override
	public void onPageSelected(int arg0) {
		// 设置底部小点选中状态
		setCurrentDot(arg0);
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