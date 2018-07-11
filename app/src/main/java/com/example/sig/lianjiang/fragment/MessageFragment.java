package com.example.sig.lianjiang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.example.sig.lianjiang.activity.R;
import com.example.sig.lianjiang.adapter.Message;
import com.example.sig.lianjiang.adapter.MessageAdapter;
import com.example.sig.lianjiang.utils.ListviewUtils;
import com.example.sig.lianjiang.view.MyListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sig on 2018/7/9.
 */

public class MessageFragment extends Fragment {
    private List<Message> lists = new ArrayList<>();
    private MyListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_message, container, false);
        init();
        listView = (MyListView) view.findViewById(R.id.list_view);
        MessageAdapter messageAdapter=new MessageAdapter(getActivity(),R.layout.message_item_view,lists);
        listView.setAdapter(messageAdapter);
        //setListViewHeightBasedOnChildren(listView);
        return view;
    }
    private void init(){
        for (int i=0;i<20;i++){
            Message message=new Message(R.mipmap.android,"SIG","最近怎么样？","21:45",1);
            lists.add(message);
        }
    }
    public static void setListViewHeightBasedOnChildren(MyListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        Log.e("222",Integer.toString(totalHeight));
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() *
                (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        Log.e("111",Integer.toString(params.height));
        listView.setLayoutParams(params);
        listView.invalidate();
    }
}
