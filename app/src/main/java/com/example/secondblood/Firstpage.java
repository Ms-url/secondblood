package com.example.secondblood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Firstpage extends AppCompatActivity {

    private String[] data = {"计算", "小游戏", "一份礼物", "text1", "text2", "text3", "text4", "text5", "text6", "text7", "text8", "text9", "text10", "text11", "text12", "text13", "text14", "text15", "text16", "text17"};
    protected boolean useThemestatusBarColor = false;
    protected boolean useStatusBarColor = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);


        ListView listView = (ListView) findViewById(R.id.list_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Firstpage.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1) {
                    Intent intent = new Intent(Firstpage.this, game.class);
                    startActivity(intent);
                    Toast.makeText(Firstpage.this, "你点了" + position + "号按钮", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Intent intent = new Intent(Firstpage.this, gift.class);
                    startActivity(intent);
                    Toast.makeText(Firstpage.this, "你点了" + position + "号按钮", Toast.LENGTH_SHORT).show();
                } else if (position == 0) {
                    Toast.makeText(Firstpage.this, "暂无此功能", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Firstpage.this, "你点了" + position + "号按钮", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menufristpage,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(Firstpage.this, "什么也没发生", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //根据上面设置是否对状态栏单独设置颜色
            if (useThemestatusBarColor) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.color_theme));//设置状态栏背景色
            } else {
                getWindow().setStatusBarColor(Color.TRANSPARENT);//透明
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        } else {
            Toast.makeText(this, "低于4.4的android系统版本不存在沉浸式状态栏", Toast.LENGTH_SHORT).show();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && useStatusBarColor) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }}

}