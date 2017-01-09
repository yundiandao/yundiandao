package com.saijie.youka.details;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.base.BaseActivity;


public class SellerActivity extends BaseActivity{

	private CicleAddAndSubView addandsub;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seller);
		



//增加，减少
		addandsub=(CicleAddAndSubView)findViewById(R.id.btn);
		addandsub.setAutoChangeNumber(true);//设置是否自增长
		addandsub.setNum(1);//设置默认值
		addandsub.setOnNumChangeListener(new CicleAddAndSubView.OnNumChangeListener() {

			@Override
			public void onNumChange(View view, int stype, int num) {

				Toast.makeText(SellerActivity.this,""+ num, 1).show();
			}

		});



		//通过 RadioGroup 获取 RadioButton ：
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
				String result = radioButton.getText().toString();
			}
		});

		//通过点击button来控制linearlayout的显示隐藏
		Button button = (Button)findViewById(R.id.btn2);
		final LinearLayout llayout = (LinearLayout)findViewById(R.id.diancai_select);
		Button button2 = (Button)findViewById(R.id.btn1);
		final LinearLayout llayout2 = (LinearLayout)findViewById(R.id.taocan_select);
		final LinearLayout llayout3 = (LinearLayout)findViewById(R.id.bottom_seller_1);
		final LinearLayout llayout4 = (LinearLayout)findViewById(R.id.bottom_seller_2);

		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				if(llayout.getVisibility()==View.VISIBLE){
					llayout.setVisibility(View.GONE);
					llayout2.setVisibility(View.VISIBLE);
					llayout3.setVisibility(View.GONE);
					llayout4.setVisibility(View.VISIBLE);
				}else{
					llayout.setVisibility(View.VISIBLE);
					llayout2.setVisibility(View.GONE);
					llayout3.setVisibility(View.VISIBLE);
					llayout4.setVisibility(View.GONE);


				}
			}

		});

		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				if(llayout.getVisibility()==View.VISIBLE){
					llayout.setVisibility(View.GONE);
					llayout2.setVisibility(View.VISIBLE);
					llayout3.setVisibility(View.GONE);
					llayout4.setVisibility(View.VISIBLE);
				}else{
					llayout.setVisibility(View.VISIBLE);
					llayout2.setVisibility(View.GONE);
					llayout3.setVisibility(View.VISIBLE);
					llayout4.setVisibility(View.GONE);


				}
			}

		});

	}

	public  void showDialog (View view)
	{

	LayoutInflater inflater = getLayoutInflater();
	View layout = inflater.inflate(R.layout.dialog,(ViewGroup) findViewById(R.id.dialog));
	new AlertDialog.Builder(this).setTitle("自定义布局").setView(layout).setPositiveButton("", null).setNegativeButton("", null).show();

	}


	private DialogFragment setNegativeButton(String 取消, Object o) {
		return null;
	}

	private void setPositiveButton(String 确定, Object o) {
	}




	public void showSuborder(View view){
		Intent intent = new Intent(SellerActivity.this, SuborderActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}

	



}
