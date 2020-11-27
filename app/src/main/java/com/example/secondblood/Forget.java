package com.example.secondblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Forget extends AppCompatActivity {
private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        Button button=(Button)findViewById(R.id.button2);//主键
        Button button2=(Button)findViewById(R.id.button5);//左键
        Button button3=(Button)findViewById(R.id.button3);//右键

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Forget.this,Getpasswordback.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Forget.this,MainActivity.class);
                intent.putExtra("data1","Trump");
                intent.putExtra("data2","20201122");
                setResult(RESULT_OK,intent);
                Toast.makeText(Forget.this,"好的懂王",Toast.LENGTH_LONG).show();
                finish();
                //startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Forget.this,MainActivity.class);
                intent.putExtra("data1","animal");
                intent.putExtra("data2","62437849");
                setResult(RESULT_CANCELED,intent);
                Toast.makeText(Forget.this,"不愧是你",Toast.LENGTH_LONG).show();
                finish();
                //startActivity(intent);
            }
        });
    }
    public void onBackPressed(){
        Intent intent=new Intent();
        intent.putExtra("data5"," ");
        setResult(RESULT_FIRST_USER,intent);
        finish();
    }
}