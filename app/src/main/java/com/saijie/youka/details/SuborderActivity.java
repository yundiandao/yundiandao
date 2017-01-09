package com.saijie.youka.details;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.base.BaseActivity;
import com.saijie.youka.details.CicleAddAndSubView.OnNumChangeListener;

import java.math.BigDecimal;

public class SuborderActivity extends BaseActivity {
	TextView tv_123,tvtv; //单价，总价
	EditText num_text_id; //数量


	private CicleAddAndSubView addandsub;

	@Override

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_suborder);

		addandsub=(CicleAddAndSubView)findViewById(R.id.btn);
		addandsub.setAutoChangeNumber(true);//设置是否自增长
		addandsub.setNum(1);//设置默认值
		addandsub.setOnNumChangeListener(new OnNumChangeListener() {

			@Override
			public void onNumChange(View view, int stype, int num) {

				Toast.makeText(SuborderActivity.this,""+ num, 1).show();
			}

		});

		//		计算总价
		tv_123 = (TextView)findViewById(R.id.tv_123);
		tvtv =(TextView)findViewById(R.id.tvtvtv);
		num_text_id = (EditText)findViewById(R.id.num_text_id);
		tv_123.addTextChangedListener(watcher);
		num_text_id.addTextChangedListener(watcher);
//		计算总价End
	}

	//监听文字变化
	private TextWatcher watcher = new TextWatcher() {
		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			updateMoney();
		}
		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
									  int arg3) {
		}
		@Override
		public void afterTextChanged(Editable arg0) {
			updateMoney();
		}
	};
	private void updateMoney(){
		String ed123=tv_123.getText().toString();
		String ed456=num_text_id.getText().toString();
		try {
			String tvtv1=(
					new BigDecimal(ed123).multiply(new BigDecimal(ed456)))+ "";           //multiply是“乘”的意思
			tvtv.setText(tvtv1);
		} catch (Exception e) {
			e.printStackTrace();

//ToastUtil.show(this, getString(R.string.may_error_nums));
		}
	}



	public void showPayorder(View view){
		Intent intent = new Intent(SuborderActivity.this, PayorderActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
		startActivity(intent);
	}
}
