package com.saijie.youka.reservation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.saijie.youka.R;
import com.saijie.youka.adapter.TextAdapter;

import java.util.ArrayList;
import java.util.LinkedList;


public class ViewMiddle extends LinearLayout implements ViewBaseAction {
	
	private ListView regionListView;
	private ListView plateListView;
	private ArrayList<String> groups = new ArrayList<String>();
	private LinkedList<String> childrenItem = new LinkedList<String>();
	private SparseArray<LinkedList<String>> children = new SparseArray<LinkedList<String>>();
	private TextAdapter plateListViewAdapter;
	private TextAdapter earaListViewAdapter;
	private OnSelectListener mOnSelectListener;
	private int tEaraPosition = 0;
	private int tBlockPosition = 0;
	private String showString = "不限";

	public ViewMiddle(Context context) {
		super(context);
		init(context);
	}

	public ViewMiddle(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public void updateShowText(String showArea, String showBlock) {
		if (showArea == null || showBlock == null) {
			return;
		}
		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).equals(showArea)) {
				earaListViewAdapter.setSelectedPosition(i);
				childrenItem.clear();
				if (i < children.size()) {
					childrenItem.addAll(children.get(i));
				}
				tEaraPosition = i;
				break;
			}
		}
		for (int j = 0; j < childrenItem.size(); j++) {
			if (childrenItem.get(j).replace("不限", "").equals(showBlock.trim())) {
				plateListViewAdapter.setSelectedPosition(j);
				tBlockPosition = j;
				break;
			}
		}
		setDefaultSelect();
	}

	private void init(Context context) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.view_region, this, true);
		regionListView = (ListView) findViewById(R.id.listView);
		plateListView = (ListView) findViewById(R.id.listView2);
		setBackgroundDrawable(getResources().getDrawable(
				R.mipmap.choosearea_bg_left));

		for(int i=0;i<10;i++){
			LinkedList<String> tItem = new LinkedList<String>();
			switch(i){
				case 0:{groups.add("附近");
					for(int j=0;j<6;j++){
						switch (j){
							case 0:{tItem.add("智能距离");}break;
							case 1:{tItem.add("1千米");}break;
							case 2:{tItem.add("3千米");}break;
							case 3:{tItem.add("5千米");}break;
							case 4:{tItem.add("10千米");}break;
							case 5:{tItem.add("全城");}break;
						}}}
				break;
				case 1:{groups.add("推荐商圈");
					for(int j=0;j<10;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("蓝田步行街");}break;
							case 2:{tItem.add("东方不夜城");}break;
							case 3:{tItem.add("火车站");}break;
							case 4:{tItem.add("人民广场");}break;
							case 5:{tItem.add("大学城");}break;
							case 6:{tItem.add("沂蒙路");}break;
							case 7:{tItem.add("汇通天下城");}break;
							case 8:{tItem.add("滨河大道");}break;
							case 9:{tItem.add("颐高上海街");}break;
						}}}break;
				case 2:{groups.add("兰山区");
					for(int j=0;j<21;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("蓝田步行街");}break;
							case 2:{tItem.add("东方不夜城");}break;
							case 3:{tItem.add("火车站");}break;
							case 4:{tItem.add("人民广场");}break;
							case 5:{tItem.add("大学城");}break;
							case 6:{tItem.add("沂蒙路");}break;
							case 7:{tItem.add("西街");}break;
							case 8:{tItem.add("育才路");}break;
							case 9:{tItem.add("金雀山路");}break;
							case 10:{tItem.add("通达路");}break;
							case 11:{tItem.add("北园路");}break;
							case 12:{tItem.add("滨河大道");}break;
							case 13:{tItem.add("临西五路");}break;
							case 14:{tItem.add("临西八路");}break;
							case 15:{tItem.add("涑河街");}break;
							case 16:{tItem.add("沂州路");}break;
							case 17:{tItem.add("砚池街");}break;
							case 18:{tItem.add("银雀山路");}break;
							case 19:{tItem.add("北城新区");}break;
							case 20:{tItem.add("颐高上海街");}break;
						}}}break;
				case 3:{groups.add("罗庄区");
					for(int j=0;j<7;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("龙潭路");}break;
							case 2:{tItem.add("罗四路");}break;
							case 3:{tItem.add("迎宾大道");}break;
							case 4:{tItem.add("新华路");}break;
							case 5:{tItem.add("麦德龙");}break;
							case 6:{tItem.add("龙潭尚街");}break;
						}}}break;
				case 4:{groups.add("河东区");
					for(int j=0;j<8;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("五金城");}break;
							case 2:{tItem.add("九州购物中心");}break;
							case 3:{tItem.add("凤凰大街");}break;
							case 4:{tItem.add("彭于埠");}break;
							case 5:{tItem.add("河东人民医院");}break;
							case 6:{tItem.add("豪森国际广场");}break;
							case 7:{tItem.add("东方城");}break;
						}}}break;
				case 5:{groups.add("沂水县");
					for(int j=0;j<12;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("沂蒙山路");}break;
							case 2:{tItem.add("新九州超市");}break;
							case 3:{tItem.add("龙家圈镇");}break;
							case 4:{tItem.add("徐家洼村");}break;
							case 5:{tItem.add("中心街");}break;
							case 6:{tItem.add("沂水县人民医院");}break;
							case 7:{tItem.add("临沂大学(沂水分校)");}break;
							case 8:{tItem.add("沂水汽车站");}break;
							case 9:{tItem.add("阳光新城");}break;
							case 10:{tItem.add("滨河东路");}break;
							case 11:{tItem.add("第二人民医院");}break;
						}}}break;
				case 6:{groups.add("郯城县");
					for(int j=0;j<2;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("商业广场");}break;
						}}}break;
				case 7:{groups.add("费县");
					for(int j=0;j<8;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("东方购物超市");}break;
							case 2:{tItem.add("费县河东");}break;
							case 3:{tItem.add("站前路");}break;
							case 4:{tItem.add("钟山路");}break;
							case 5:{tItem.add("南外环");}break;
							case 6:{tItem.add("沂蒙山路");}break;
							case 7:{tItem.add("费县政府");}break;
						}}}break;
				case 8:{groups.add("平邑县");
					for(int j=0;j<13;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("莲花山广场");}break;
							case 2:{tItem.add("浚河路");}break;
							case 3:{tItem.add("火车站");}break;
							case 4:{tItem.add("财源路");}break;
							case 5:{tItem.add("华百购物广场");}break;
							case 6:{tItem.add("蒙阳路");}break;
							case 7:{tItem.add("县人民医院");}break;
							case 8:{tItem.add("地方镇");}break;
							case 9:{tItem.add("西外环");}break;
							case 10:{tItem.add("蒙山景区");}break;
							case 11:{tItem.add("兴蒙学校");}break;
							case 12:{tItem.add("赛博初中部");}break;

						}}}break;
				case 9:{groups.add("兰陵县");
					for(int j=0;j<5;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("五岔路口");}break;
							case 2:{tItem.add("塔山公园");}break;
							case 3:{tItem.add("代村农展馆");}break;
							case 4:{tItem.add("水岸金街");}break;
						}}}break;
				case 10:{groups.add("蒙阴县");
					for(int j=0;j<6;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("云蒙路");}break;
							case 2:{tItem.add("垛庄镇");}break;
							case 3:{tItem.add("蒙阴购物中心");}break;
							case 4:{tItem.add("蒙山旅游区");}break;
							case 5:{tItem.add("百泉裕村");}break;
						}}}break;
				case 11:{groups.add("临沭县");
					for(int j=0;j<7;j++){
						switch (j){
							case 0:{tItem.add("全部");}break;
							case 1:{tItem.add("苍山北路");}break;
							case 2:{tItem.add("华诚购物中心");}break;
							case 3:{tItem.add("临沭汽车站");}break;
							case 4:{tItem.add("苍马山旅游区");}break;
							case 5:{tItem.add("县委党校");}break;
							case 6:{tItem.add("会展中心");}break;
						}}}break;
			}
			//				tItem.add(i+"行"+j+"列");
			children.put(i, tItem);
		}

		earaListViewAdapter = new TextAdapter(context, groups,
				R.mipmap.choose_item_selected,
				R.drawable.choose_eara_item_selector);
		earaListViewAdapter.setTextSize(17);
		earaListViewAdapter.setSelectedPositionNoNotify(tEaraPosition);
		regionListView.setAdapter(earaListViewAdapter);
		earaListViewAdapter
				.setOnItemClickListener(new TextAdapter.OnItemClickListener() {

					@Override
					public void onItemClick(View view, int position) {
						if (position < children.size()) {
							childrenItem.clear();
							childrenItem.addAll(children.get(position));
							plateListViewAdapter.notifyDataSetChanged();
						}
					}
				});
		if (tEaraPosition < children.size())
			childrenItem.addAll(children.get(tEaraPosition));
		plateListViewAdapter = new TextAdapter(context, childrenItem,
				R.mipmap.choose_item_right,
				R.drawable.choose_plate_item_selector);
		plateListViewAdapter.setTextSize(15);
		plateListViewAdapter.setSelectedPositionNoNotify(tBlockPosition);
		plateListView.setAdapter(plateListViewAdapter);
		plateListViewAdapter
				.setOnItemClickListener(new TextAdapter.OnItemClickListener() {

					@Override
					public void onItemClick(View view, final int position) {

						showString = childrenItem.get(position);
						if (mOnSelectListener != null) {

							mOnSelectListener.getValue(showString);
						}

					}
				});
		if (tBlockPosition < childrenItem.size())
			showString = childrenItem.get(tBlockPosition);
		if (showString.contains("不限")) {
			showString = showString.replace("不限", "");
		}
		setDefaultSelect();

	}

	public void setDefaultSelect() {
		regionListView.setSelection(tEaraPosition);
		plateListView.setSelection(tBlockPosition);
	}

	public String getShowText() {
		return showString;
	}

	public void setOnSelectListener(OnSelectListener onSelectListener) {
		mOnSelectListener = onSelectListener;
	}

	public interface OnSelectListener {
		public void getValue(String showText);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}
}
