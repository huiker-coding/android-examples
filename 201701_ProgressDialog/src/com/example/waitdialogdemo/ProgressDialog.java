package com.example.waitdialogdemo;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

public class ProgressDialog {
	private static final int DEFAULT_WAIT_TIME_OUT = 12888;
	private static final String COMMON_PROMPT = "正在卖力加载中";

	private static ProgressDialog progressHUD;
	private Context context;
	private Dialog progressDialog;
	private final Timer timer = new Timer();
	private TimerTask timerTask;

	private ProgressDialog(Context context) {
		this.context = context;
	}

	public static ProgressDialog getInstance(Context context) {

		if (progressHUD == null) {
			progressHUD = new ProgressDialog(context);
		}
		return progressHUD;
	}

	public void showWaitPrompt() {
		showWaitPrompt(COMMON_PROMPT);
	}

	public void showWaitPrompt(String prompt) {
		showWaitPrompt(prompt, true);
	}

	public void showWaitPrompt(String prompt, Boolean cancelAble) {
		showWaitPrompt(prompt, cancelAble, DEFAULT_WAIT_TIME_OUT);
	}

	public void showWaitPrompt(String prompt, Boolean cancelAble, int waitTime) {
		progressDialog = new Dialog(context, R.style.progress_dialog);
		progressDialog.setContentView(R.layout.dialog);
		progressDialog.setCancelable(cancelAble);
		progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		TextView msg = (TextView) progressDialog.findViewById(R.id.id_tv_loadingmsg);
		msg.setText("卖力加载中");
		progressDialog.show();

		timerTask = new TimerTask() {
			@Override
			public void run() {
				disMiss();
			}
		};
		timer.schedule(timerTask, waitTime);
	}

	public void disMiss() {
		progressDialog.dismiss();
	}

}
