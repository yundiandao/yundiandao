package com.saijie.youka.popup;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

import com.saijie.youka.R;

/**
 * 
 * @描述: QrCodePopupMenu 二维码弹出菜单
 * @author Hq
 * @time 2016年12月7日10:02:55
 * @version 0.0.1
 */
@SuppressLint("InflateParams")
public class QrCodePopupMenu extends PopupWindow implements OnClickListener{

	private Activity activity;
	private View popView;
	
	private View v_item1;
	private View v_item2;
	
	public QrCodePopupMenu(Activity activity) {
		//super(activity);
		this.activity = activity; 
		LayoutInflater inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		popView = inflater.inflate(R.layout.qr_code_popup_menu, null);
		this.setContentView(popView); 
		this.setWidth(dp2px(activity, 180)); 
		this.setHeight(LayoutParams.WRAP_CONTENT);
		this.setFocusable(true); 
		this.setTouchable(true);  
		this.setOutsideTouchable(true); 
		ColorDrawable dw = new ColorDrawable(0x00000000);
		this.setBackgroundDrawable(dw);
 
		v_item1 = popView.findViewById(R.id.scan_album);
		v_item2 = popView.findViewById(R.id.scan_desktop); 
		
		v_item1.setOnClickListener(this);
		v_item2.setOnClickListener(this); 
	}

	public void showLocation(int resourId) {
		showAsDropDown(activity.findViewById(resourId), dp2px(activity, 0),
				dp2px(activity, 0));
	}

	@Override
	public void onClick(View v) {
		
	//	 Intent intent = new Intent();
		
		if (v == v_item1) {

		} else if (v == v_item2) { 
//			intent.setClass(v.getContext(),CaptureActivity.class); 
//			v.getContext().startActivity(intent);
		}
		
//		if (onItemClickListener != null) {
//			onItemClickListener.onClick(menuitem, str);
//		}
		dismiss();
	}

	public int dp2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
	
}
