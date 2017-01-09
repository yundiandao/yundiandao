package com.saijie.youka.fn;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.saijie.youka.R;
import com.saijie.youka.base.BaseActivity;

public class FriendActivity extends BaseActivity {

	private EditText mEditText;
	private Button mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend);

		mEditText = (EditText) findViewById(R.id.edit_phone_number);
		mButton = (Button) findViewById(R.id.btn_send);

		mButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String phoneNumber = mEditText.getText().toString();
				if (!TextUtils.isEmpty(phoneNumber)) {
					sendSmsWithBody(FriendActivity.this,"", "欢迎1");
				}
			}
		});

	}

	/**
	 * 调用系统界面，给指定的号码发送短信
	 *
	 * @param context
	 * @param number
	 */
	public void sendSmsWithNumber(Context context, String number) {
		Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + number));
		context.startActivity(sendIntent);
	}

	/**
	 * 调用系统界面，给指定的号码发送短信，并附带短信内容
	 *
	 * @param context
	 * @param number
	 * @param body
	 */
	public void sendSmsWithBody(Context context, String number, String body) {
		Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
		sendIntent.setData(Uri.parse("smsto:" + number));
		sendIntent.putExtra("欢迎2", body);
		context.startActivity(sendIntent);
	}
}
