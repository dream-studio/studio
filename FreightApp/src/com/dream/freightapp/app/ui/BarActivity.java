package com.dream.freightapp.app.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.dream.freightapp.app.R;

public class BarActivity extends SherlockActivity {

	private final static String tag = "BarActivity";
	private int actionBarTitle = R.string.title_not_set;
	public Dialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		Log.i(tag, "onCreate");
		getSupportActionBar().show();
		initActionBar();
		getSupportMenuInflater().inflate(R.menu.simple_menu, menu);
		return true;
	}

	/**
	 * Init ActionBar
	 */
	private void initActionBar() {
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setIcon(R.drawable.ic_back);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setTitle(this.actionBarTitle);
		getSupportActionBar().setDisplayShowCustomEnabled(false);
	}

	/**
	 * Set ActionBar Title
	 */
	public void setActionBarTitle(int parameter) {
		this.actionBarTitle = parameter;
	}

	/**
	 * Set Button OnClick listener
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}

		// else if (item.getItemId() == R.id.menu_item_custom_button) {
		// Log.i(tag, "OnClick custom button");
		// return true;
		// }
		return super.onOptionsItemSelected(item);
	}

	
//	@Override
//	protected Dialog onCreateDialog(int id) {
//		// TODO Auto-generated method stub
//		dialog = null;
//		switch (id) {
//		case Prompts.DIALOG_LOADING:
//			dialog = Prompts.simpleDialog(this, "Login", "Loading...");
//			break;
//		case Prompts.DIALOG_ERROR_MESSAGE:
//			// dialog = createListDialog();
//			break;
//		case Prompts.DIALOG_CONFIRM_MESSAGE:
//			dialog = Prompts.confirmDialog(this, "", "", "");
//		default:
//			break;
//		}
//
//		if (dialog != null) {
//			Log.i(tag, dialog.toString());
//		} else {
//			Log.i(tag, "dialog = null");
//		}
//		return dialog;
//	}
//
//	@Override
//	protected void onPrepareDialog(int id, Dialog dialog) {
//		// TODO Auto-generated method stub
//		super.onPrepareDialog(id, dialog);
//	}
}
