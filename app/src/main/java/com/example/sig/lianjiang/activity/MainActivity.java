 package com.example.sig.lianjiang.activity;

 import android.os.Build;
 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.Window;
 import android.view.WindowManager;
 import android.widget.Toast;

 import com.example.sig.lianjiang.fragment.DynamicFragment;
 import com.example.sig.lianjiang.fragment.FriendFragment;
 import com.example.sig.lianjiang.fragment.MessageFragment;
 import com.example.sig.lianjiang.fragment.StarFragment;
 import com.example.sig.lianjiang.view.DragDeleteTextView;
 import com.example.sig.lianjiang.view.MainNavigateTabBar;


 public class MainActivity extends AppCompatActivity {

     private static final String TAG_PAGE_MESSAGE = "消息";
     private static final String TAG_PAGE_FRIEND = "联系人";
     private static final String TAG_PAGE_PUBLISH = "发布";
     private static final String TAG_PAGE_DYNAMIC = "广场";
     private static final String TAG_PAGE_STAR = "星球";
     private DragDeleteTextView messageNum;

     private MainNavigateTabBar mNavigateTabBar;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
             Window window = getWindow();
             // Translucent status bar
             window.setFlags(
                     WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                     WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
         }
         setContentView(R.layout.activity_main);

         mNavigateTabBar = (MainNavigateTabBar) findViewById(R.id.mainTabBar);
         //messageNum=(DragDeleteTextView)findViewById(R.id.message_num);
         mNavigateTabBar.onRestoreInstanceState(savedInstanceState);

         mNavigateTabBar.addTab(MessageFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.message, R.mipmap.message_select, TAG_PAGE_MESSAGE));
         mNavigateTabBar.addTab(FriendFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.friend, R.mipmap.friend_select, TAG_PAGE_FRIEND));
         mNavigateTabBar.addTab(null, new MainNavigateTabBar.TabParam(0, 0, TAG_PAGE_PUBLISH));
         mNavigateTabBar.addTab(DynamicFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.dynamic, R.mipmap.dynamic_select, TAG_PAGE_DYNAMIC));
         mNavigateTabBar.addTab(StarFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.star, R.mipmap.star_select, TAG_PAGE_STAR));
//         LayoutInflater inflater = getLayoutInflater();                             //先获取当前布局的填充器
//         View whichYouWantToUse_findViewById = inflater.inflate(R.layout.comui_tab_view, null);   //通过填充器获取另外一个布局的对象
         //widget = (WidgetClass) whichYouWantToUse_findViewById.findViewById(R.id.widgetID);
//         messageNum=(DragDeleteTextView) whichYouWantToUse_findViewById.findViewById(R.id.message_num);
//         messageNum.setVisibility(View.INVISIBLE);

     }


     @Override
     protected void onSaveInstanceState(Bundle outState) {
         super.onSaveInstanceState(outState);
         mNavigateTabBar.onSaveInstanceState(outState);
     }


     public void onClickPublish(View v) {
         Toast.makeText(this, "发布", Toast.LENGTH_LONG).show();
     }

 }

