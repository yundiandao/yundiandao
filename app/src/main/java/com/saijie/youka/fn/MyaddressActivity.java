package com.saijie.youka.fn;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.saijie.youka.R;
import com.saijie.youka.base.BaseActivity;

public class MyaddressActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_myaddress);

		final ImageView un =(ImageView)findViewById(R.id.unselect);
		final ImageView select =(ImageView)findViewById(R.id.select);
		final ImageView un2 =(ImageView)findViewById(R.id.unselect2);
		final ImageView select2 =(ImageView)findViewById(R.id.select2);
		final ImageView un3 =(ImageView)findViewById(R.id.unselect3);
		final ImageView select3 =(ImageView)findViewById(R.id.select3);

		un.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view) {
					un.setVisibility(View.GONE);
					select.setVisibility(View.VISIBLE);
					un2.setVisibility(View.VISIBLE);
					select2.setVisibility(View.GONE);
					un3.setVisibility(View.VISIBLE);
					select3.setVisibility(View.GONE);

			}
		});

		un2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view) {
				un2.setVisibility(View.GONE);
				select2.setVisibility(View.VISIBLE);
				un.setVisibility(View.VISIBLE);
				select.setVisibility(View.GONE);
				un3.setVisibility(View.VISIBLE);
				select3.setVisibility(View.GONE);

			}
		});

		un3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view) {
				un3.setVisibility(View.GONE);
				select3.setVisibility(View.VISIBLE);
				un.setVisibility(View.VISIBLE);
				select.setVisibility(View.GONE);
				un2.setVisibility(View.VISIBLE);
				select2.setVisibility(View.GONE);


			}
		});





	}
}
