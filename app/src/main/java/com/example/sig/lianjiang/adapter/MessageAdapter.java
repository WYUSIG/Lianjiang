package com.example.sig.lianjiang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sig.lianjiang.activity.R;

import java.util.List;

/**
 * Created by sig on 2018/7/11.
 */

public class MessageAdapter extends ArrayAdapter<Message>{
    private int resourceId;
    public MessageAdapter(Context context, int textViewResourceId, List<Message> object){
        super(context,textViewResourceId,object);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        Message message=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.userHead=(ImageView)view.findViewById(R.id.user_head);
            viewHolder.userName=(TextView)view.findViewById(R.id.user_name);
            viewHolder.mainMean=(TextView)view.findViewById(R.id.main_mean);
            viewHolder.time=(TextView)view.findViewById(R.id.message_time);
            viewHolder.messageNum=(TextView)view.findViewById(R.id.message_num);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.userHead.setImageResource(message.getImageId());
        viewHolder.userName.setText(message.getName());
        viewHolder.mainMean.setText(message.getMainMean());
        viewHolder.time.setText(message.getTime());
        viewHolder.messageNum.setText(Integer.toString(message.getMessageNum()));
        return view;
    }
    class ViewHolder{
        ImageView userHead;
        TextView userName;
        TextView mainMean;
        TextView time;
        TextView messageNum;
    }
}
