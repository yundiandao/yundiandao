package com.saijie.youka.fn;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.saijie.youka.R;
import com.saijie.youka.base.BaseActivity;

public class AddressActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
    }

    //搜索按钮   getApplicationContext等同于this
    public void showSousuo(View view){
        Toast.makeText(getApplicationContext(), "您点击了'搜索'", Toast.LENGTH_SHORT).show();
    }


}

