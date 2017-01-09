package com.saijie.youka.fn;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.base.BaseActivity;

public class MyordeActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myorde);

		final TextView button  =(TextView)findViewById(R.id.t1);
		final TextView button2 =(TextView)findViewById(R.id.t2);
		final TextView button3 =(TextView)findViewById(R.id.t3);
		final TextView button4 =(TextView)findViewById(R.id.t4);
		final TextView v  =(TextView)findViewById(R.id.v1);
		final TextView v2 =(TextView)findViewById(R.id.v2);
		final TextView v3 =(TextView)findViewById(R.id.v3);
		final TextView v4 =(TextView)findViewById(R.id.v4);

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
					v.setVisibility(View.VISIBLE);
			     	button.setTextColor(Color.parseColor("#fc6013"));
					button2.setTextColor(Color.parseColor("#333333"));
					button3.setTextColor(Color.parseColor("#333333"));
					button4.setTextColor(Color.parseColor("#333333"));
					v2.setVisibility(View.INVISIBLE);
					v3.setVisibility(View.INVISIBLE);
					v4.setVisibility(View.INVISIBLE);

			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
					v.setVisibility(View.INVISIBLE);
					v2.setVisibility(View.VISIBLE);
					button.setTextColor(Color.parseColor("#333333"));
					button2.setTextColor(Color.parseColor("#fc6013"));
					button3.setTextColor(Color.parseColor("#333333"));
					button4.setTextColor(Color.parseColor("#333333"));
					v3.setVisibility(View.INVISIBLE);
					v4.setVisibility(View.INVISIBLE);

			}
		});
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
					v.setVisibility(View.INVISIBLE);
					v2.setVisibility(View.INVISIBLE);
					v3.setVisibility(View.VISIBLE);
					button.setTextColor(Color.parseColor("#333333"));
					button2.setTextColor(Color.parseColor("#333333"));
					button3.setTextColor(Color.parseColor("#fc6013"));
					button4.setTextColor(Color.parseColor("#333333"));
					v4.setVisibility(View.INVISIBLE);

			}
		});
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

					v.setVisibility(View.INVISIBLE);
					v2.setVisibility(View.INVISIBLE);
					v3.setVisibility(View.INVISIBLE);
					v4.setVisibility(View.VISIBLE);
					button.setTextColor(Color.parseColor("#333333"));
					button2.setTextColor(Color.parseColor("#333333"));
					button3.setTextColor(Color.parseColor("#333333"));
					button4.setTextColor(Color.parseColor("#fc6013"));

			}
		});

	}



}
