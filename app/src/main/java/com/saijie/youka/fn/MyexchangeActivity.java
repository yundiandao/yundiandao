package com.saijie.youka.fn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.saijie.youka.R;
import com.saijie.youka.base.BaseActivity;

public class MyexchangeActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myexchange);
	}

	//跳转至我的积分
	public void showMyintegral(View view){
		Intent intent = new Intent(MyexchangeActivity.this, MyintegralActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
}
