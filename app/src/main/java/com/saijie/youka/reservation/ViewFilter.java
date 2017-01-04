package com.saijie.youka.reservation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.saijie.youka.R;
import com.saijie.youka.adapter.TextAdapter;


public class ViewFilter extends RelativeLayout implements ViewBaseAction{


	private OnSelectListener mOnSelectListener;
	private TextAdapter adapter;
	private String mDistance;
	private String showText = "筛选";
	private Context mContext;

	public String getShowText() {
		return showText;
	}

	public ViewFilter(Context context) {
		super(context);
		init(context);
	}

	public ViewFilter(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public ViewFilter(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_filter, this, true);


//		final Button mButton = (Button)findViewById(R.id.filter_1);
//		mButton.setOnClickListener(new OnClickListener() {
//			public void onClick(View v) {
//				mButton.setBackgroundColor(Color.parseColor("#27bea0"));
//			}
//		});

        //获取焦点，通过 bg_button_filter_select.xml 设置点击之后保持颜色
		final Button mButton = (Button)findViewById(R.id.filter_1);
		final Button mButton2 = (Button)findViewById(R.id.filter_2);
		final Button mButton3 = (Button)findViewById(R.id.filter_3);
		final Button mButton4 = (Button)findViewById(R.id.filter_4);
		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.setFocusable(true);
				v.requestFocus();
				v.requestFocusFromTouch();
			}
		});
		mButton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.setFocusable(true);
				v.requestFocus();
				v.requestFocusFromTouch();
			}
		});
		mButton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.setFocusable(true);
				v.requestFocus();
				v.requestFocusFromTouch();
			}
		});
		mButton4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.setFocusable(true);
				v.requestFocus();
				v.requestFocusFromTouch();
			}
		});

	}

	public void setOnSelectListener(OnSelectListener onSelectListener) {
		mOnSelectListener = onSelectListener;
	}

	public interface OnSelectListener {
		public void getValue(String distance, String showText);
	}

	@Override
	public void hide() {

	}

	@Override
	public void show() {

	}






}
