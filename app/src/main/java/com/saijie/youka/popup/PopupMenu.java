package com.saijie.youka.popup;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

import com.saijie.youka.R;
import com.saijie.youka.fn.FqjcActivity;
import com.saijie.youka.qr.CaptureActivity;

/**
 * 
 * @描述: PopupMenu 弹出菜单
 * @time 2016年12月7日09:02:52
 * @version 0.0.1
 */
@SuppressLint("InflateParams")
public class PopupMenu extends PopupWindow implements OnClickListener {
	
	private Activity activity;
	private View popView;
	
	private View v_item1;
	private View v_item2;
	private View v_item3;
	private View v_item4;
	
	public PopupMenu(Activity activity) {
		//super(activity);
		this.activity = activity;
		//获取到LayoutInflater的实例,简写LayoutInflater layoutInflater = LayoutInflater.from(context); 
		LayoutInflater inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		popView = inflater.inflate(R.layout.popup_menu, null);//调用LayoutInflater的inflate()方法来加载布局
		this.setContentView(popView);// 把布局文件添加到popupwindow中
		this.setWidth(dp2px(activity, 130));//设置菜单的宽度和菜单于右边距的距离
		this.setHeight(LayoutParams.WRAP_CONTENT);
		this.setFocusable(true);//获取焦点
		this.setTouchable(true); //设置PopupWindow可触摸
		this.setOutsideTouchable(true); //设置非PopupWindow区域可触摸
		ColorDrawable dw = new ColorDrawable(0x00000000);
		this.setBackgroundDrawable(dw);
		// 获取选项卡
		v_item1 = popView.findViewById(R.id.start_dinner);
		v_item2 = popView.findViewById(R.id.scanning);
		v_item3 = popView.findViewById(R.id.payment);
		v_item4 = popView.findViewById(R.id.about);
		//添加监听器
		v_item1.setOnClickListener(this);
		v_item2.setOnClickListener(this);
		v_item3.setOnClickListener(this);
		v_item4.setOnClickListener(this);
	}
	
		//设置显示位置
	public void showLocation(int resourId) {
		showAsDropDown(activity.findViewById(resourId), dp2px(activity, 0),
				dp2px(activity, 0));
	}

	@Override
	public void onClick(View v) {
		
		Intent intent = new Intent();
		
		if (v == v_item1) {
			intent.setClass(v.getContext(),FqjcActivity.class);
			v.getContext().startActivity(intent);
			
		} else if (v == v_item2) { 
			intent.setClass(v.getContext(),CaptureActivity.class);
			v.getContext().startActivity(intent);
		} else if (v == v_item3) {
			
		} else if(v == v_item4){
			
		}
		
//		if (onItemClickListener != null) {
//			onItemClickListener.onClick(menuitem, str);
//		}
		dismiss();
	}

	//设置dp转换为px
	public int dp2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

//		//点击监听接口
//	public interface OnItemClickListener {
//		public void onClick(MENUITEM item, String str);
//	}
//		//设置监听
//	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
//	}

}
