package com.example.sig.lianjiang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.sig.lianjiang.activity.R;
import com.example.sig.lianjiang.adapter.FriendAdapter;
import com.example.sig.lianjiang.bean.ContactPerson;
import com.example.sig.lianjiang.utils.Utils;
import com.example.sig.lianjiang.view.QuickIndexBar;

import java.util.ArrayList;

/**
 * Created by sig on 2018/7/9.
 */

public class FriendFragment extends Fragment {
    private ExpandableListView mExpandableListView;
    ArrayList<ArrayList<ContactPerson>> contactPersonsList;
    private QuickIndexBar mQuickIndexBar;
    private TextView mTextDialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_friend, container, false);
        mExpandableListView = (ExpandableListView) view.findViewById(R.id.address_expandable_listview);
        mTextDialog = (TextView) view.findViewById(R.id.text_dialog);
        mQuickIndexBar = (QuickIndexBar) view.findViewById(R.id.quick_index_bar);
        initData();
        setListView();
        setIndexBar();
        return view;
    }



    /**
     * 初始化数据
     */
    private void initData() {
        contactPersonsList = Utils.getSortDataList(getActivity(),"person_name.txt");
    }

    /**
     * 设置ListView
     */
    private void setListView() {
        /**设置适配器*/
        mExpandableListView.setAdapter(new FriendAdapter(getActivity(), contactPersonsList));

        /**设置group不可点击*/
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;//注意：一定要返回true，返回true这个方法才有效。
            }
        });

        /**展开所有条目*/
        for (int i = 0; i < contactPersonsList.size(); i++){
            mExpandableListView.expandGroup(i);
        }
    }

    /**
     * 设置setIndexBar
     */
    private void setIndexBar() {
        mQuickIndexBar.setTextView(mTextDialog);//设置textDialog
        mQuickIndexBar.setPaddingTop(15);//设置顶部padding
        mQuickIndexBar.setPaddingBottom(15);//设置底部padding

        /**设置监听器*/
        mQuickIndexBar.setOnLetterChangedListener(new QuickIndexBar.OnLetterChangedListener() {
            @Override
            public void onLetterChanged(String letter) {
                for( int i = 0; i< contactPersonsList.size();i++){
                    if(letter.equals(contactPersonsList.get(i).get(0).firstLetter)){
                        mExpandableListView.setSelectedGroup(i);
                    }
                }
            }
            @Override
            public void onLetterGone() {}
        });
    }
}
