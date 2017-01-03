package com.saijie.youka;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.saijie.youka.base.ContentAdapter;
import com.saijie.youka.details.SellerActivity;
import com.saijie.youka.fn.AddressActivity;
import com.saijie.youka.fn.FqjcActivity;
import com.saijie.youka.fn.FriendActivity;
import com.saijie.youka.fn.LoginActivity;
import com.saijie.youka.fn.SearchActivity;
import com.saijie.youka.pop.ActionItem;
import com.saijie.youka.pop.TitlePopup;
import com.saijie.youka.pop.TitlePopup.OnItemOnClickListener;
import com.saijie.youka.qr.CaptureActivity;
import com.saijie.youka.reservation.ReservationActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

  //  private ImageView menu_icon;
  //  private PopupMenu popupMenu;
      private TitlePopup titlePopup;



    // 布局集合 实现主界面的左右滑动效果
    private List<ImageView> iconList; // 图标集合
    private List<TextView> textList; // 文字集合
    private LayoutInflater mInflater;

    private ImageView indexIconSelect;
    private ImageView indexIconNormal;
    private ImageView findIconSelect;
    private ImageView findIconNormal;
    private ImageView meIconSelect;
    private ImageView meIconNormal;

    private TextView indexTextSelect;
    private TextView indexTextNormal;
    private TextView findTextSelect;
    private TextView findTextNormal;
    private TextView meTextSelect;
    private TextView meTextNormal;

    private ArrayList<View> viewList;
    private ViewPager viewPager;

    private View indexView;
    private View findView;
    private View meView;
    private final int INDEX = 0; // 首页菜单索引
    private final int FIND_INDEX = 1; // 发现菜单索引
    private final int ME_INDEX = 2; // 我的菜单索引
    private int curIndex; // 当前菜单索引



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 初始化控件
        initView();

        //右上角二级菜单
        inint();
        /** // 实现右上角弹出菜单---弃用（因为出现Null Object ImageView OnClickListener）
          popupMenu = new PopupMenu(this);
          menu_icon = (ImageView) findViewById(R.id.menu_icon);
          menu_icon.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v){
               popupMenu.showLocation(R.id.menu_icon);//设置弹出菜单弹出的位置
           }
        });
       */
    }
    /**            二级菜单----Start                        */
    public void showPop(View v) {
        titlePopup.show(findViewById(R.id.iv_show_Pop));
    }
    private void inint() {
        // 实例化标题栏弹窗
        titlePopup = new TitlePopup(this, LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        titlePopup.setItemOnClickListener(onitemClick);
        // 给标题栏弹窗添加子类
        titlePopup.addAction(new ActionItem(this, R.string.groupchat,
                R.mipmap.icon_menu_group));
        titlePopup.addAction(new ActionItem(this, R.string.addfriend,
                R.mipmap.icon_menu_addfriend));
        titlePopup.addAction(new ActionItem(this, R.string.qrcode,
                R.mipmap.icon_menu_sao));
        titlePopup.addAction(new ActionItem(this, R.string.money,
                R.mipmap.abv));
    }
    private OnItemOnClickListener onitemClick = new OnItemOnClickListener() {
        @Override
        public void onItemClick(ActionItem item, int position) {
            // mLoadingDialog.show();
            switch (position) {
                case 0:// 发起群聊
                    Toast.makeText(MainActivity.this, "发起聚餐",1).show();
                    Intent intent = new Intent(MainActivity.this, FqjcActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                    startActivity(intent);
                    break;
                case 1:// 添加老友
                    Toast.makeText(MainActivity.this, " 添加老友",1).show();
                    intent = new Intent(MainActivity.this, FriendActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                    startActivity(intent);
                    break;
                case 2:// 扫一扫
                    Toast.makeText(MainActivity.this, "扫一扫",1).show();
                    intent = new Intent(MainActivity.this, CaptureActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                    startActivity(intent);

                    break;
                case 3:// 关于与帮助
                    Toast.makeText(MainActivity.this, "关于与帮助",1).show();
                    break;
                default:
                    break;
            }
        }
    };
    /**            二级菜单----End                        */


    //实现主界面的左右滑动效果
    @SuppressLint("InflateParams")
    private void initView() {
        mInflater = LayoutInflater.from(this);
        viewList = new ArrayList<View>();
        iconList = new ArrayList<ImageView>();
        textList = new ArrayList<TextView>();

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        indexIconSelect = (ImageView) findViewById(R.id.index_icon_select);
        indexIconNormal = (ImageView) findViewById(R.id.index_icon_normal);
        findIconSelect = (ImageView) findViewById(R.id.find_icon_select);
        findIconNormal = (ImageView) findViewById(R.id.find_icon_normal);
        meIconSelect = (ImageView) findViewById(R.id.me_icon_select);
        meIconNormal = (ImageView) findViewById(R.id.me_icon_normal);

        indexTextSelect = (TextView) findViewById(R.id.index_text_select);
        indexTextNormal = (TextView) findViewById(R.id.index_text_normal);
        findTextSelect = (TextView) findViewById(R.id.find_text_select);
        findTextNormal = (TextView) findViewById(R.id.find_text_normal);
        meTextSelect = (TextView) findViewById(R.id.me_text_select);
        meTextNormal = (TextView) findViewById(R.id.me_text_normal);

        indexView = mInflater.inflate(R.layout.page_01, null);
        findView = mInflater.inflate(R.layout.page_03, null);
        meView = mInflater.inflate(R.layout.page_04, null);

        viewList.add(indexView);
        viewList.add(findView);
        viewList.add(meView);

        iconList.add(indexIconNormal);
        iconList.add(indexIconSelect);
        iconList.add(findIconNormal);
        iconList.add(findIconSelect);
        iconList.add(meIconNormal);
        iconList.add(meIconSelect);

        textList.add(indexTextNormal);
        textList.add(indexTextSelect);
        textList.add(findTextNormal);
        textList.add(findTextSelect);
        textList.add(meTextNormal);
        textList.add(meTextSelect);

        viewPager.setAdapter(new ContentAdapter(viewList));
        viewPager.addOnPageChangeListener(pageListener);

        indexIconNormal.setAlpha(0f);
        indexTextNormal.setAlpha(0f);
        findIconSelect.setAlpha(0f);
        findTextSelect.setAlpha(0f);
        meIconSelect.setAlpha(0f);
        meTextSelect.setAlpha(0f);
    }

    OnPageChangeListener pageListener = new OnPageChangeListener() {
        @Override
        public void onPageSelected(int index) {
            curIndex = index;
        }

        @Override
        public void onPageScrolled(int index, float ratio, int offset) {
            if (ratio > 0) {
                colorChange(index, index + 1, ratio);
            }
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    /**
     * @param srcIndex  失去焦点的索引
     * @param destIndex 选中的索引
     * @param ratio     透明的比例
     */
    private void colorChange(int srcIndex, int destIndex, float ratio) {
        iconList.get(srcIndex * 2).setAlpha(ratio);
        iconList.get(srcIndex * 2 + 1).setAlpha(1 - ratio);

        iconList.get(destIndex * 2).setAlpha(1 - ratio);
        iconList.get(destIndex * 2 + 1).setAlpha(ratio);

        textList.get(srcIndex * 2).setAlpha(ratio);
        textList.get(srcIndex * 2 + 1).setAlpha(1 - ratio);

        textList.get(destIndex * 2).setAlpha(1 - ratio);
        textList.get(destIndex * 2 + 1).setAlpha(ratio);
    }

    public void showIndex(View view) {
        if (curIndex != INDEX) {
            colorChange(INDEX, curIndex, 0);
            viewPager.setCurrentItem(INDEX, false);
        }
    }

    public void showFind(View view) {
        if (curIndex != FIND_INDEX) {
            colorChange(FIND_INDEX, curIndex, 0);
            viewPager.setCurrentItem(FIND_INDEX, false);
        }
    }

    public void showMy(View view) {
        if (curIndex != ME_INDEX) {
            colorChange(ME_INDEX, curIndex, 0);
            viewPager.setCurrentItem(ME_INDEX, false);
        }
    }


    public void showSearch(View view){
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);

    }
    public void showAddress(View view){
         Intent intent = new Intent(MainActivity.this, AddressActivity.class);
         intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
         startActivity(intent);

    }
    public void showJingu(View view){
        Intent intent = new Intent(MainActivity.this, SellerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);

    }

    public void showLogin(View view){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);
    }

    public void showDingcan(View view){
        Intent intent = new Intent(MainActivity.this, ReservationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
        startActivity(intent);
    }




    //防止自己写的应用程序不小心点击退出键而直接退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            // 创建退出对话框
            AlertDialog isExit = new AlertDialog.Builder(this).create();
            // 设置对话框标题
            isExit.setTitle("系统提示");
            // 设置对话框消息
            isExit.setMessage("确定要退出吗");
            // 添加选择按钮并注册监听
            isExit.setButton("确定", listener);
            isExit.setButton2("取消", listener);
            // 显示对话框
            isExit.show();
        }
        return false;
    }
    /**监听对话框里面的button点击事件---onKeyDown*/
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which)
        {
            switch (which)
            {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}

