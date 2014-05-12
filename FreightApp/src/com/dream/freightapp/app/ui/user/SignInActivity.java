package com.dream.freightapp.app.ui.user;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.dream.freightapp.app.R;
import com.dream.freightapp.app.manage.User;
import com.dream.freightapp.app.ui.ActionBarActivity;
import com.dream.freightapp.app.ui.main.MainActivity;

public class SignInActivity extends ActionBarActivity {
	private static final String tag = "SignInActivity";

	EditText account;
	EditText password;
	Button signIn;
	Button signUp;
	CheckBox rememberAccount;
	User signInManage = new User();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(tag, "onCreate");
		setContentView(R.layout.activity_sign_in);

		account = (EditText) findViewById(R.id.activity_sign_in_edittext_account);
		account.setText("test");
		password = (EditText) findViewById(R.id.activity_sign_in_edittext_password);
		password.setText("123");

		signIn = (Button) findViewById(R.id.activity_sign_in_button_sign_in);
		signUp = (Button) findViewById(R.id.activity_sign_in_button_sign_up);

		rememberAccount = (CheckBox) findViewById(R.id.activity_sign_in_checkbox_remember_account);

		signIn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click sgin in");
				SignInTask task = new SignInTask();
				task.execute();

			}
		});

		signUp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i(tag, "Click Sign on");
				Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
				startActivity(i);
			}
		});
	}

	private class SignInTask extends AsyncTask<Void, Integer, Boolean> {

		User sginInManage = new User();

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO Auto-generated method stub

			return sginInManage.validate(account.getText().toString(), password
					.getText().toString());
		}

		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			if (result) {

				sginInManage.startLocation();

				Intent i = new Intent(SignInActivity.this, MainActivity.class);
				startActivity(i);

			} else {
				Toast.makeText(
						SignInActivity.this,
						getResources().getText(
								R.string.task_user_signin_task_login_error),
						Toast.LENGTH_SHORT).show();
			}
		}
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
