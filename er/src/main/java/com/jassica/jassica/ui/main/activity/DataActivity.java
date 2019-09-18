package com.jassica.jassica.ui.main.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jassica.jassica.R;

public class DataActivity extends Activity  {
	private EmptyLayout mErrorLayout;
	private ListView mListView;
	
	private ArrayAdapter<String> adapter;
	private String[] data ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		initView();
		virtulHttp();
	}

	private void initData() {
		if(null!=adapter){
			mListView.setAdapter(adapter);
			mErrorLayout.setErrorType(EmptyLayout.HIDE_LAYOUT);
		} else if (0==data.length){
			if(EmptyLayout.isConnectivity(this)){//网络连接问题
				mErrorLayout.setErrorType(EmptyLayout.NODATA);
				return;
			}
			mErrorLayout.setErrorType(EmptyLayout.NETWORK_ERROR);
		}
		
	}

	private void initView() {
		mErrorLayout = (EmptyLayout) findViewById(R.id.empty_view);
		mListView = (ListView) findViewById(R.id.list);
		mErrorLayout.setOnLayoutClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                virtulHttp();
	            }
		 });
		
	}
	//模拟网络请求数据
	private  void virtulHttp(){
		mErrorLayout.setErrorType(EmptyLayout.NETWORK_LOADING);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					if(EmptyLayout.isConnectivity(DataActivity.this)){//有没有网
						data = new String[]{"啦","啦啦","啦啦啦"};
						adapter = new ArrayAdapter<String>(DataActivity.this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1,data );
					}else{
						data = new String[]{};
					}
					mHandler.sendEmptyMessage(0);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			initData();
		};
	};
	
}
