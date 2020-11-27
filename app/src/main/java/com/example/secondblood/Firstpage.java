package com.example.secondblood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Firstpage extends AppCompatActivity {

    private String[] data = {"计算", "小游戏", "一份礼物", "text1", "text2", "text3", "text4", "text5", "text6", "text7", "text8", "text9", "text10", "text11", "text12", "text13", "text14", "text15", "text16", "text17"};

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



}