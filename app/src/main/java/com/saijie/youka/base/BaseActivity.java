package com.saijie.youka.base;

import com.lidroid.xutils.ViewUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * 
 * @描述: BaseActivity 基础类
 * @time 2016年12月10日08:58:16
 * @version 0.0.1
 */

public class BaseActivity extends Activity {
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
	}
	
 
	@Override
	public void setContentView(int layoutResID){
		super.setContentView(layoutResID);
		ViewUtils.inject(this);
	}

	 /*		
	    public void setTitle(String title){
			TextView titleTv = (TextView)findViewById(R.id.title);
			titleTv.setText(title);
		}
		*/
	
	public void goback(View v){
		finish();
	}

}

