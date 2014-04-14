package com.dream.freightapp.app.ui.tool;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

public class PromptTool {

	public static final int DIALOG_LOADING = 0;
	public static final int DIALOG_ERROR_MESSAGE = 1;
	public static final int DIALOG_CONFIRM_MESSAGE = 2;

	public PromptTool() {
		// TODO Auto-generated constructor stub
	}
	
	public static ProgressDialog simpleDialog(Context context, String content,
			String title) {
		ProgressDialog dialog = ProgressDialog.show(context, title, content);
		return dialog;
	}

	public static Dialog confirmDialog(Context context, String content,
			String pButtonVal, String nButtonVal) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(content)
				.setCancelable(false)
				.setPositiveButton(pButtonVal,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						})
				.setNegativeButton(nButtonVal,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
		return builder.create();
	}
	
}
